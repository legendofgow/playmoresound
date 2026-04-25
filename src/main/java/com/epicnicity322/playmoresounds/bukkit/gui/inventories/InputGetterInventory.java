package com.epicnicity322.playmoresounds.bukkit.gui.inventories;

import com.epicnicity322.playmoresounds.bukkit.PlayMoreSounds;
import com.epicnicity322.playmoresounds.bukkit.gui.InventoryUtils;
import net.kyori.adventure.text.Component;
import org.bukkit.Bukkit;
import org.bukkit.entity.HumanEntity;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.HandlerList;
import org.bukkit.event.Listener;
import org.bukkit.event.inventory.InventoryClickEvent;
import org.bukkit.event.inventory.InventoryCloseEvent;
import org.bukkit.event.inventory.InventoryType;
import org.bukkit.inventory.Inventory;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.view.AnvilView;
import org.jetbrains.annotations.NotNull;

import java.util.UUID;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

public final class InputGetterInventory implements Listener {

    private final @NotNull UUID playerId;
    private final @NotNull String title;
    private final @NotNull Consumer<String> inputConsumer;
    private final @NotNull AtomicBoolean open = new AtomicBoolean(false);
    private Inventory anvilInventory;

    public InputGetterInventory(@NotNull Player player, @NotNull String title, @NotNull Consumer<String> inputConsumer) {
        this.playerId = player.getUniqueId();
        this.title = title;
        this.inputConsumer = inputConsumer;
    }

    public void openInventory() {
        if (PlayMoreSounds.getInstance() == null)
            throw new IllegalStateException("PlayMoreSounds is not loaded.");

        Player player = Bukkit.getPlayer(playerId);
        if (player == null || !player.isOnline()) {
            open.set(false);
            return;
        }
        if (open.get()) return;

        open.set(true);

        if (player.getOpenInventory().getTopInventory().getType() != InventoryType.CRAFTING) {
            player.closeInventory();
        }

        // Nowe Paper API - otwiera okno kowadła bez NMS
        AnvilView view = (AnvilView) player.openAnvil(null, true);

        if (view == null) {
            open.set(false);
            return;
        }

        // Ustawienie tytułu
        view.setTitle(title);

        anvilInventory = view.getTopInventory();
        anvilInventory.setItem(0, InventoryUtils.getItemStack("Input Getter Inventory.Input Item"));

        Bukkit.getPluginManager().registerEvents(this, PlayMoreSounds.getInstance());
    }

    public void closeInventory() {
        Player player = Bukkit.getPlayer(playerId);
        if (player == null || !player.isOnline()) {
            HandlerList.unregisterAll(this);
            open.set(false);
        } else {
            player.closeInventory();
        }
    }

    public boolean isOpen() {
        return open.get();
    }

    @SuppressWarnings("deprecation")
    @EventHandler(priority = EventPriority.LOWEST)
    private void onInventoryClick(InventoryClickEvent event) {
        HumanEntity player = event.getWhoClicked();
        if (!player.getUniqueId().equals(playerId)) return;

        event.setCancelled(true);

        if (event.getRawSlot() != 2) return;
        ItemStack clicked = event.getCurrentItem();
        if (clicked == null || !clicked.hasItemMeta()) return;

        // Pobieramy tekst wpisany przez gracza z AnvilView
        if (event.getView() instanceof AnvilView anvilView) {
            String input = anvilView.getRenameText();
            player.closeInventory();
            inputConsumer.accept(input.isEmpty()
                    ? clicked.getItemMeta().getDisplayName()
                    : input);
        }
    }

    @EventHandler
    private void onInventoryClose(InventoryCloseEvent event) {
        if (!event.getPlayer().getUniqueId().equals(playerId)) return;
        HandlerList.unregisterAll(this);
        open.set(false);
    }
}