/*
 * PlayMoreSounds - A bukkit plugin that manages and plays sounds.
 * Copyright (C) 2022 Christiano Rangel
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <https://www.gnu.org/licenses/>.
 */

package com.epicnicity322.playmoresounds.core.config;

import com.epicnicity322.epicpluginlib.core.EpicPluginLib;
import com.epicnicity322.epicpluginlib.core.config.ConfigurationHolder;
import com.epicnicity322.epicpluginlib.core.config.ConfigurationLoader;
import com.epicnicity322.epicpluginlib.core.tools.Version;
import com.epicnicity322.playmoresounds.core.PlayMoreSoundsCore;
import com.epicnicity322.playmoresounds.core.PlayMoreSoundsVersion;
import com.epicnicity322.playmoresounds.core.util.PMSHelper;
import org.jetbrains.annotations.NotNull;

import java.nio.file.Path;

public enum Configurations {
    //100 chars per line for organization
    BIOMES(StaticFields.sounds.resolve("biomes.yml"), "# Set a sound to play when you enter, leave or stand on a specific biome.\n" +
            "#\n" +
            "# To set a sound, just create a configuration section with the name of the biome or just copy the\n" +
            "# sample below.\n" +
            "# Biome list: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/block/Biome.html\n" +
            "#\n" +
            "# Sample:\n" +
            "#\n" +
            "#world: # The world name, replace 'world' with the name of the world you want to play the sound.\n" +
            "#  PLAINS: # The biome name.\n" +
            "#    Enter: # When a player enters this biome.\n" +
            "#      Cancellable: true\n" +
            "#      Enabled: true\n" +
            "#      Stop On Exit:\n" +
            "#        Enabled: true # If enabled, the sound will be stopped when the player leaves the biome.\n" +
            "#        Delay: 20 # The time to wait before stopping the sound.\n" +
            "#      Sounds:\n" +
            "#        '1':\n" +
            "#          Delay: 0\n" +
            "#          Options:\n" +
            "#            Ignores Disabled: false\n" +
            "#            Permission Required: ''\n" +
            "#            Permission To Listen: ''\n" +
            "#            Radius: 0.0\n" +
            "#          Pitch: 1.0\n" +
            "#          Sound: BLOCK_NOTE_BLOCK_PLING\n" +
            "#          Volume: 10.0\n" +
            "#\n" +
            "#    Leave: # When a player exits this biome.\n" +
            "#      Cancellable: true\n" +
            "#      Enabled: true\n" +
            "#      Sounds:\n" +
            "#        '1':\n" +
            "#          Delay: 0\n" +
            "#          Options:\n" +
            "#            Ignores Disabled: false\n" +
            "#            Permission Required: ''\n" +
            "#            Permission To Listen: ''\n" +
            "#            Radius: 0.0\n" +
            "#          Pitch: 1.0\n" +
            "#          Sound: BLOCK_NOTE_BLOCK_BASS\n" +
            "#          Volume: 10.0\n" +
            "#\n" +
            "#    Loop: # When a player enters the biome, a loop will be triggered and play.\n" +
            "#      Cancellable: true\n" +
            "#      Delay: 0 # Time in ticks to wait to start the loop once triggered.\n" +
            "#      Enabled: true\n" +
            "#      Period: 100 # Time in ticks to wait before playing these sounds again.\n" +
            "#      Stop On Exit:\n" +
            "#        Enabled: true\n" +
            "#        Delay: 20\n" +
            "#      Prevent Enter Sound: true # Makes so Enter sound is not played when Loop is enabled.\n" +
            "#      Sounds:\n" +
            "#        '1':\n" +
            "#          Delay: 0\n" +
            "#          Options:\n" +
            "#            Ignores Disabled: false\n" +
            "#            Permission Required: ''\n" +
            "#            Permission To Listen: ''\n" +
            "#            Radius: 0.0\n" +
            "#          Pitch: 1.0\n" +
            "#          Sound: BLOCK_NOTE_BLOCK_BASS\n" +
            "#          Volume: 10.0\n" +
            "#\n" +
            "# This is a small sample. You can add more biomes, worlds and more options to the sound options.\n" +
            "# More information about sounds on sounds.yml.\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_2_0),
    CHAT_SOUNDS(StaticFields.sounds.resolve("chat sounds.yml"), "# Set a sound to play when a player type a sentence in chat.\n" +
            "#\n" +
            "#  There are five filters to choose:\n" +
            "#\n" +
            "#  -> Contains:\n" +
            "#  Use this section to play a sound to every message that contains the word you specify.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Contains:\n" +
            "#  hello:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#      Other Filters: true # If the message match other filters, this will make so this is the only filter that will play a sound.\n" +
            "#\n" +
            "#  -> Contains SubString:\n" +
            "#  Use this section to play a sound to every message that contains the following string you specify.\n" +
            "#  This is different than Contains because Contains check for words, this checks for any part of the message.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Contains SubString:\n" +
            "#  pling:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#      Other Filters: true # If the command match other filters, this will make so this is the only filter that will play a sound.\n" +
            "#\n" +
            "#  -> Ends With:\n" +
            "#  Self explanatory. If a message ends with the sentence specified, the sound will play.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Ends With:\n" +
            "#  something:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '0':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 1.0\n" +
            "#        Sound: 'ENTITY_CREEPER_PRIMED'\n" +
            "#        Volume: 10.0\n" +
            "#\n" +
            "#  -> Equals Exactly:\n" +
            "#  When a message equals exactly like the specified here. (Case sensitive)\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Equals Exactly:\n" +
            "#  play BLOCK_PORTAL_TRAVEL sound:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '0':\n" +
            "#        Delay: 1\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 2.0\n" +
            "#        Sound: 'BLOCK_PORTAL_TRAVEL'\n" +
            "#        Volume: 0.4\n" +
            "#\n" +
            "#  -> Equals Ignore Case:\n" +
            "#  When a message is equals to the specified but, it doesn't matter if it's on lower case or\n" +
            "# upper case.\n" +
            "#  If a player accidentally toggled upper case on it's keyboard and typed SOMETHING and you want\n" +
            "# to set a sound for the message \"something\", put it in this section so the sound will be played\n" +
            "# even if its on upper case.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Equals Ignore Case:\n" +
            "#  something:\n" +
            "#    Cancellable: false\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '1':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 2.0\n" +
            "#        Sound: 'BLOCK_PORTAL_TRAVEL'\n" +
            "#        Volume: 0.4\n" +
            "#\n" +
            "#  -> Starts With:\n" +
            "#  Plays a sound when a message starts with the sentence you specify.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Starts With:\n" +
            "#  hello:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '1':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 2.0\n" +
            "#        Sound: 'BLOCK_PORTAL_TRAVEL'\n" +
            "#        Volume: 0.4\n" +
            "#\n" +
            "# More information about sounds on sounds.yml\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_2_0),
    COMMANDS(StaticFields.sounds.resolve("commands.yml"), "# Set a sound to play when a player type a specific command.\n" +
            "#\n" +
            "#  There are five filters to choose:\n" +
            "#\n" +
            "#  -> Contains:\n" +
            "#  Use this section to play a sound to every command that contains the word you specify.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Contains:\n" +
            "#  play:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#      Other Filters: true # If the command match other filters, this will make so this is the only filter that will play a sound.\n" +
            "#\n" +
            "#  -> Contains SubString:\n" +
            "#  Use this section to play a sound to every command that contains the following string you specify.\n" +
            "#  This is different than Contains because Contains check for words, this checks for any part of the command.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Contains SubString:\n" +
            "#  set:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#      Other Filters: true # If the command match other filters, this will make so this is the only filter that will play a sound.\n" +
            "#\n" +
            "#  -> Ends With:\n" +
            "#  Self explanatory. If a command ends with the sentence specified, the sound will play.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Ends With:\n" +
            "#  -force:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '0':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 1.0\n" +
            "#        Sound: 'ENTITY_CREEPER_PRIMED'\n" +
            "#        Volume: 10.0\n" +
            "#\n" +
            "#  -> Equals Exactly:\n" +
            "#  When a command equals exactly like the specified here. (Case sensitive)\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Equals Exactly:\n" +
            "#  /warp MALL:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '0':\n" +
            "#        Delay: 1\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 2.0\n" +
            "#        Sound: 'BLOCK_PORTAL_TRAVEL'\n" +
            "#        Volume: 0.4\n" +
            "#\n" +
            "#  -> Equals Ignore Case:\n" +
            "#  When a command is equals to the specified but, it doesn't matter if it's on lower case or\n" +
            "# upper case.\n" +
            "#  If a player accidentally toggled upper case on it's keyboard and typed /SPAWN and you want\n" +
            "# to set a sound for the command \"/spawn\", put him in this section so the sound will be played\n" +
            "# even if is on upper case.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Equals Ignore Case:\n" +
            "#  /spawn:\n" +
            "#    Cancellable: false\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '1':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 2.0\n" +
            "#        Sound: 'BLOCK_PORTAL_TRAVEL'\n" +
            "#        Volume: 0.4\n" +
            "#\n" +
            "#  -> Starts With:\n" +
            "#  This is the most used of them all. Plays a sound when a command starts with the sentence\n" +
            "# you specify.\n" +
            "#  Sample:\n" +
            "#\n" +
            "#Starts With:\n" +
            "#  /teleport:\n" +
            "#    Cancellable: true\n" +
            "#    Enabled: true\n" +
            "#    Prevent Other Sounds:\n" +
            "#      Default Sound: true\n" +
            "#      Other Filters: true\n" +
            "#    Sounds:\n" +
            "#      '1':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: 0.0\n" +
            "#        Pitch: 2.0\n" +
            "#        Sound: 'BLOCK_PORTAL_TRAVEL'\n" +
            "#        Volume: 0.4\n" +
            "#\n" +
            "# More information about sounds on sounds.yml\n" +
            "# The following sounds are here just to prevent the default sound on sounds.yml from playing.\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'\n" +
            "\n" +
            "Starts With:\n" +
            "  /tp:\n" +
            "    Cancellable: false\n" +
            "    Enabled: true\n" +
            "    Prevent Other Sounds:\n" +
            "      Default Sound: true\n" +
            "      Other Filters: true\n" +
            "  /warp:\n" +
            "    Cancellable: false\n" +
            "    Enabled: true\n" +
            "    Prevent Other Sounds:\n" +
            "      Default Sound: true\n" +
            "      Other Filters: true\n" +
            "  /spawn:\n" +
            "    Cancellable: false\n" +
            "    Enabled: true\n" +
            "    Prevent Other Sounds:\n" +
            "      Default Sound: true\n" +
            "      Other Filters: true\n" +
            "  /gamemode:\n" +
            "    Cancellable: false\n" +
            "    Enabled: true\n" +
            "    Prevent Other Sounds:\n" +
            "      Default Sound: true\n" +
            "      Other Filters: true\n" +
            "\n" +
            "Contains SubString:\n" +
            "  play:\n" +
            "    Cancellable: false\n" +
            "    Enabled: true\n" +
            "    Prevent Other Sounds:\n" +
            "      Default Sound: true\n" +
            "      Other Filters: true", StaticFields.version3_2_0),
    CONFIG(PlayMoreSoundsCore.getFolder().resolve("config.yml"), "####################################################################################################\n" +
            "##  PlayMoreSounds Configuration v" + PlayMoreSoundsVersion.version + "\n" +
            "##\n" +
            "## PlayMoreSounds configuration about general stuff like commands and regions, if you are looking\n" +
            "##for event sounds, check sounds.yml. If you are looking for situational sounds, check the folder\n" +
            "##'Sounds'.\n" +
            "##\n" +
            "## If you have any questions about PlayMoreSounds join the discord: https://discord.gg/eAHPbc3\n" +
            "####################################################################################################\n" +
            "\n" +
            "# The version of this configuration, each configuration has one of this. If the version is too old\n" +
            "#the configuration will be renamed to \"outdated config.yml\" and a new one will be generated so you\n" +
            "#don't lose your properties and can update each property manually.\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'\n" +
            "\n" +
            "# Available languages: EN_US, ES_LA, PT_BR, ZH_CN\n" +
            "Language: EN_US\n" +
            "\n" +
            "# A simple halloween event, disable if you find it annoying.\n" +
            "Halloween Event: true\n" +
            "\n" +
            "Resource Packs:\n" +
            "  # Request player to download a resource pack on join.\n" +
            "  # This will also make so Region and Biome sounds wait until the resource pack loads, before playing. So\n" +
            "  #players can hear the custom region enter or biome enter sounds.\n" +
            "  # Enable this if you use another resource packer anyway.\n" +
            "  Request: false\n" +
            "  # The URL of the resource pack. Must be a direct link.\n" +
            "  URL: ''\n" +
            "  # The sha1 hash sum of the resource pack. This is optional, but it makes so players download the resource only the first\n" +
            "  #time they join the server, increasing resource pack load time.\n" +
            "  # To generate a sha1 hash sum, drop your pack at http://onlinemd5.com/ and select \"SHA1\" then paste the checksum here.\n" +
            "  Hash: ''\n" +
            "  # If a player denies the download, this player will be kicked immediately.\n" +
            "  # Players with the permission 'playmoresounds.resourcepacker.force.bypass' will be able to join even if Force is enabled.\n" +
            "  Force:\n" +
            "    Enabled: true\n" +
            "    # Should the player be kicked even if the download of the resource pack is accepted but fails?\n" +
            "    Even If Download Fail: true\n" +
            "\n" +
            "# Sound Regions configuration:\n" +
            "Sound Regions:\n" +
            "  # The border particles of \"/pms region info\"\n" +
            "  Border:\n" +
            "    # A limit of how many players can see borders at once, for performance.\n" +
            "    Max Showing Borders: 10\n" +
            "    # The time in ticks of how long the border should be shown.\n" +
            "    Showing Time: 140\n" +
            "  # The max area in m³ a region can have.\n" +
            "  # Use permission 'playmoresounds.region.create.unlimited.area' to bypass.\n" +
            "  Max Area: 15625\n" +
            "  # The max characters a region name can have.\n" +
            "  Max Name Characters: 20\n" +
            "  # The max amount of regions a single player can have.\n" +
            "  # Use permission 'playmoresounds.region.create.unlimited.regions' to bypass.\n" +
            "  Max Regions: 5\n" +
            "  # The region selection tool properties.\n" +
            "  Wand:\n" +
            "    Name: '&6&l&nRegion Selection Tool'\n" +
            "    Glowing: true\n" +
            "    Material: FEATHER\n" +
            "\n" +
            "# Update scheduler\n" +
            "Updater:\n" +
            "  Enabled: true\n" +
            "  # If false updater messages will only be logged when an update is available.\n" +
            "  Log: false\n" +
            "  # Updates will be checked every 144000 ticks or 1 hour.\n" +
            "  Period: 144000\n" +
            "\n" +
            "# Properties of \"/pms list\" command.\n" +
            "List:\n" +
            "  # Properties for chat list.\n" +
            "  Chat:\n" +
            "    Max Per Page: 10\n" +
            "  # Properties for sound list GUI.\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Next Page:\n" +
            "        Material: SPECTRAL_ARROW\n" +
            "        Glowing: false\n" +
            "      Stop Sound:\n" +
            "        Material: BARRIER\n" +
            "        Glowing: true\n" +
            "      Previous Page:\n" +
            "        Material: SPECTRAL_ARROW\n" +
            "        Glowing: false\n" +
            "      Sound:\n" +
            "        # The item will be picked sequentially from this list for each sound.\n" +
            "        Material:\n" +
            "        - MUSIC_DISC_13\n" +
            "        - MUSIC_DISC_CAT\n" +
            "        - MUSIC_DISC_CHIRP\n" +
            "        - MUSIC_DISC_BLOCKS\n" +
            "        - MUSIC_DISC_FAR\n" +
            "        - MUSIC_DISC_MALL\n" +
            "        - MUSIC_DISC_MELLOHI\n" +
            "        - MUSIC_DISC_STAL\n" +
            "        - MUSIC_DISC_STRAD\n" +
            "        - MUSIC_DISC_WARD\n" +
            "        - MUSIC_DISC_WAIT\n" +
            "        Glowing: false\n" +
            "    # How many rows of sounds should the inventory have per page.\n" +
            "    Rows Per Page: 4\n" +
            "\n" +
            "Addons:\n" +
            "  # Configuration for addon management and installer inventories.\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Addon:\n" +
            "        Material: IRON_BLOCK\n" +
            "        Glowing: false\n" +
            "      Done:\n" +
            "        Material: GREEN_WOOL\n" +
            "        Glowing: false\n" +
            "      Info:\n" +
            "        Material: PAPER\n" +
            "        Glowing: false\n" +
            "      Install:\n" +
            "        Material: EMERALD_BLOCK\n" +
            "        Glowing: true\n" +
            "      Next Page:\n" +
            "        Material: ARROW\n" +
            "        Glowing: false\n" +
            "      Previous Page:\n" +
            "        Material: ARROW\n" +
            "        Glowing: false\n" +
            "\n" +
            "Confirm:\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Cancel:\n" +
            "        Material: RED_WOOL\n" +
            "        Glowing: false\n" +
            "      Confirm:\n" +
            "        Material: GREEN_WOOL\n" +
            "        Glowing: false\n" +
            "\n" +
            "Editor Inventory:\n" +
            "  Items:\n" +
            "    Next Page:\n" +
            "      Material: SPECTRAL_ARROW\n" +
            "      Glowing: false\n" +
            "    Previous Page:\n" +
            "      Material: SPECTRAL_ARROW\n" +
            "      Glowing: false\n" +
            "    Rich Sound:\n" +
            "      Material: JUKEBOX\n" +
            "      Glowing: false\n" +
            "\n" +
            "Rich Sound Inventory:\n" +
            "  Items:\n" +
            "    Status:\n" +
            "      Enabled:\n" +
            "        Material: LIME_CONCRETE\n" +
            "        Glowing: false\n" +
            "      Disabled:\n" +
            "        Material: RED_CONCRETE\n" +
            "        Glowing: false\n" +
            "    Info:\n" +
            "      Material: PAPER\n" +
            "      Glowing: false\n" +
            "    Cancellable:\n" +
            "      Material: BARRIER\n" +
            "      Glowing: false\n" +
            "    Previous Page:\n" +
            "      Material: SPECTRAL_ARROW\n" +
            "      Glowing: false\n" +
            "    Add Sound:\n" +
            "      Material: END_CRYSTAL\n" +
            "      Glowing: false\n" +
            "    Next Page:\n" +
            "      Material: SPECTRAL_ARROW\n" +
            "      Glowing: false\n" +
            "    Sound:\n" +
            "      Materials:\n" +
            "      - MUSIC_DISC_13\n" +
            "      - MUSIC_DISC_CAT\n" +
            "      - MUSIC_DISC_CHIRP\n" +
            "      - MUSIC_DISC_BLOCKS\n" +
            "      - MUSIC_DISC_FAR\n" +
            "      - MUSIC_DISC_MALL\n" +
            "      - MUSIC_DISC_MELLOHI\n" +
            "      - MUSIC_DISC_STAL\n" +
            "      - MUSIC_DISC_STRAD\n" +
            "      - MUSIC_DISC_WARD\n" +
            "      - MUSIC_DISC_WAIT\n" +
            "      Glowing: false\n" +
            "    Save:\n" +
            "      Material: GREEN_CONCRETE\n" +
            "      Glowing: false\n" +
            "\n" +
            "Sound Inventory:\n" +
            "  Items:\n" +
            "    Sound:\n" +
            "      Material: NOTE_BLOCK\n" +
            "      Glowing: false\n" +
            "    Volume:\n" +
            "      Material: GUNPOWDER\n" +
            "      Glowing: false\n" +
            "    Pitch:\n" +
            "      Material: REDSTONE\n" +
            "      Glowing: false\n" +
            "    Category:\n" +
            "      Material: MOJANG_BANNER_PATTERN\n" +
            "      Glowing: false\n" +
            "    Delay:\n" +
            "      Material: REPEATER\n" +
            "      Glowing: false\n" +
            "    Radius:\n" +
            "      Material: COMPASS\n" +
            "      Glowing: false\n" +
            "    Ignores Toggle:\n" +
            "      Enabled:\n" +
            "        Material: BLUE_CONCRETE\n" +
            "        Glowing: false\n" +
            "      Disabled:\n" +
            "        Material: LIGHT_GRAY_CONCRETE\n" +
            "        Glowing: false\n" +
            "    Permission Required:\n" +
            "      Material: WRITABLE_BOOK\n" +
            "      Glowing: false\n" +
            "    Permission To Listen:\n" +
            "      Material: WRITABLE_BOOK\n" +
            "      Glowing: false\n" +
            "    Remove:\n" +
            "      Material: RED_CONCRETE\n" +
            "      Glowing: false\n" +
            "    Play:\n" +
            "      Material: MUSIC_DISC_13\n" +
            "      Glowing: false\n" +
            "    Done:\n" +
            "      Default:\n" +
            "        Material: GREEN_CONCRETE\n" +
            "        Glowing: false\n" +
            "      Parent:\n" +
            "        Material: GREEN_CONCRETE\n" +
            "        Glowing: false\n" +
            "\n" +
            "Input Getter Inventory:\n" +
            "  Input Item:\n" +
            "    Material: NETHER_STAR\n" +
            "    Glowing: false", StaticFields.version5_0),
    DEATH_TYPES(StaticFields.sounds.resolve("death types.yml"), "# Set a sound to play when a player die for a specific cause of death.\n" +
            "#\n" +
            "# To set a sound, just create a configuration section with the name of the cause of\n" +
            "# death or just copy the sample below.\n" +
            "# Causes of death: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/event/entity/EntityDamageEvent.DamageCause.html\n" +
            "#\n" +
            "# Sample:\n" +
            "#\n" +
            "#MAGIC:\n" +
            "#  Enabled: true\n" +
            "#  #This should stop the sound set in sounds.yml\n" +
            "#  Prevent Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#  Sounds:\n" +
            "#    #This should play for players who has a specific vip perm.\n" +
            "#    '0':\n" +
            "#      Delay: 0\n" +
            "#      Options:\n" +
            "#        Permission Required: 'vip.customdeathsound.magic'\n" +
            "#        Radius: 5.5\n" +
            "#      Pitch: 1.0\n" +
            "#      Sound: ENTITY_WITHER_DEATH\n" +
            "#      Volume: 1.0\n" +
            "#    #Since this event should stop the regular death sound for whoever dies by magic,\n" +
            "#    #another sound need to be set so players that aren't vip can hear the regular.\n" +
            "#    '0':\n" +
            "#      Delay: 0\n" +
            "#      Options:\n" +
            "#        Permission Required: 'player.everyplayerexceptvipshavethispermission'\n" +
            "#        Radius: 0.0\n" +
            "#      Pitch: 1.0\n" +
            "#      Sound: ENTITY_WITHER_SPAWN\n" +
            "#      Volume: 1.0\n" +
            "#\n" +
            "# More information about sounds on sounds.yml\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_2_0),
    GAME_MODES(StaticFields.sounds.resolve("game modes.yml"), "# Set a sound to play when you change your gamemode.\n" +
            "#\n" +
            "# To set a sound, just create a configuration section with the name of the game mode\n" +
            "# or just copy the sample below.\n" +
            "# Game mode list: https://hub.spigotmc.org/javadocs/spigot/org/bukkit/GameMode.html\n" +
            "#\n" +
            "# Sample:\n" +
            "#\n" +
            "#CREATIVE: # The gamemode that you changed to.\n" +
            "#  Cancellable: true\n" +
            "#  Enabled: true\n" +
            "#  Prevent Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#  Sounds:\n" +
            "#    '0':\n" +
            "#      Delay: 0\n" +
            "#      Options:\n" +
            "#        Radius: 0\n" +
            "#      Pitch: 1\n" +
            "#      Sound: BLOCK_NOTE_BLOCK_PLING\n" +
            "#      Volume: 10\n" +
            "#\n" +
            "# This is a small sample. You can add more gamemodes and more options\n" +
            "# to the sound options.\n" +
            "# More information about sounds on sounds.yml.\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_2_0),
    HIT_SOUNDS(StaticFields.sounds.resolve("hit sounds.yml"), "# Set a sound to play when an entity hits another entity with a specific item on hand.\n" +
            "#\n" +
            "# Bukkit entity names: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/entity/EntityType.html\n" +
            "# Bukkit item names: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html\n" +
            "#\n" +
            "# You need to write when the sound will be played. To do that you need to respect the following pattern:\n" +
            "# <damager> hit <victim> holding <item>\n" +
            "# The sound will be played when the damager hit the victim with the item.\n" +
            "#\n" +
            "# After you've chosen the entities and items and put them into the pattern, create a section with your\n" +
            "#condition like the one below.\n" +
            "#\n" +
            "#PLAYER hit ZOMBIE holding IRON_SWORD: # This sound will play when a player hits a zombie holding an iron sword.\n" +
            "#  Enabled: true\n" +
            "#  Cancellable: true\n" +
            "#  Prevent Other Sounds:\n" +
            "#    Default Sound: true # This will prevent the default sound set on sounds.yml from playing.\n" +
            "#    Other Conditions: true # If the hit event matches more than one condition, this will make so this is the only condition that will play a sound.\n" +
            "#  Sounds:\n" +
            "#    '0':\n" +
            "#      Delay: 10\n" +
            "#      Options:\n" +
            "#        Radius: 16.0\n" +
            "#      Pitch: 2.0\n" +
            "#      Sound: 'ENTITY_ZOMBIE_ATTACK_IRON_DOOR'\n" +
            "#      Volume: 1.0\n" +
            "#\n" +
            "# The pattern also supports criteria, like the ones found on commands.yml, chat sounds.yml, item clicked.yml, items held.yml and items swung.yml.\n" +
            "# You have the following criteria: Any, Contains[], EndsWith[], Equals[], and StartsWith[].\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play a sound when any kind of zombie hits any entity with any item, I would use the condition:\n" +
            "#   Contains[ZOMBIE] hit Any holding Any\n" +
            "#\n" +
            "#   If I want to play a sound when a player hits any entity with any kind of sword, I would use the condition:\n" +
            "#   PLAYER hit Any holding EndsWith[SWORD]\n" +
            "#\n" +
            "#   If I want to play a sound when a player hits any entity with any diamond item, I would use the condition:\n" +
            "#   PLAYER hit Any holding StartsWith[DIAMOND]\n" +
            "#\n" +
            "# You can also use commas if you want to play the same sound for many criteria.\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play the same sound when a player OR a zombie hits any entity with any item, I would use the condition:\n" +
            "#   Equals[PLAYER,ZOMBIE] hit Any holding Any\n" +
            "#\n" +
            "#   If I want to play the same sound when any entity hits any kind of cow (Mushroom or not) or any kind of pig (Zombie or not) with any item, I would use the condition:\n" +
            "#   Any hit Contains[COW,PIG] holding Any\n" +
            "#\n" +
            "#   If I want to play the same sound when a player hits any entity with any kind of sword, shovel or pickaxe, I would use the condition:\n" +
            "#   PLAYER hit Any EndsWith[SWORD,SHOVEL,PICKAXE]\n" +
            "#\n" +
            "# Hope everything is clear, if you have any doubts of a condition that you wanna use but can't find how, contact me on discord:\n" +
            "# https://discord.gg/eAHPbc3\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_3_0),
    ITEMS_CLICKED(StaticFields.sounds.resolve("items clicked.yml"), "# Set a sound to play when a player clicks on a specific item in an inventory.\n" +
            "#\n" +
            "# To set a sound create a section with the name of the item.\n" +
            "# Bukkit item names: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html\n" +
            "#\n" +
            "#IRON_SWORD: # This sound will play when a player clicks on an iron sword.\n" +
            "#  Enabled: true\n" +
            "#  Cancellable: true\n" +
            "#  Prevent Other Sounds:\n" +
            "#    Default Sound: true # This will prevent the default Inventory Click sound set on sounds.yml from playing.\n" +
            "#    Other Criteria: true # If the click event matches more than one criteria, this will prevent the others from playing.\n" +
            "#  Sounds:\n" +
            "#    '0':\n" +
            "#      Delay: 0\n" +
            "#      Options:\n" +
            "#        Radius: 0.0\n" +
            "#      Pitch: 2.0\n" +
            "#      Sound: 'ENTITY_ZOMBIE_ATTACK_IRON_DOOR'\n" +
            "#      Volume: 1.0\n" +
            "#\n" +
            "# Items support criteria, like the ones found on commands.yml, chat sounds.yml, hit sounds.yml, items held.yml and items swung.yml.\n" +
            "# You have the following criteria: Contains[], EndsWith[], Equals[], and StartsWith[].\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play a sound for any kind of coral:\n" +
            "#   Contains[CORAL]\n" +
            "#\n" +
            "#   If I want to play a sound for any kind of sword:\n" +
            "#   EndsWith[SWORD]\n" +
            "#\n" +
            "#   If I want to play a sound for any diamond item:\n" +
            "#   StartsWith[DIAMOND]\n" +
            "#\n" +
            "# You can also use commas if you want to play the same sound for many criteria.\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play the same sound wools and carpets:\n" +
            "#   Contains[WOOL,CARPET]\n" +
            "#\n" +
            "#   If I want to play the same sound for glass and glass panes:\n" +
            "#   EndsWith[GLASS,GLASS_PANE]\n" +
            "#\n" +
            "#   If I want to play the same sound for furnaces and blast furnaces:\n" +
            "#   Equals[FURNACE,BLAST_FURNACE]\n" +
            "#\n" +
            "#   If I want to play the same sound for iron and diamond items:\n" +
            "#   StartsWith[IRON,DIAMOND]\n" +
            "#\n" +
            "# Hope everything is clear, if you have any doubts of a criteria that you wanna use but can't find how, contact me on discord:\n" +
            "# https://discord.gg/eAHPbc3\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_3_0),
    ITEMS_HELD(StaticFields.sounds.resolve("items held.yml"), "# Set a sound to play when a player holds a specific item in their hand.\n" +
            "#\n" +
            "# To set a sound create a section with the name of the item.\n" +
            "# Bukkit item names: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html\n" +
            "#\n" +
            "#IRON_SWORD: # This sound will play when a player holds an iron sword.\n" +
            "#  Enabled: true\n" +
            "#  Cancellable: true\n" +
            "#  Prevent Other Sounds:\n" +
            "#    Default Sound: true # This will prevent the default Change Held Item sound set on sounds.yml from playing.\n" +
            "#    Other Criteria: true # If the item held event matches more than one criteria, this will prevent the others from playing.\n" +
            "#  Sounds:\n" +
            "#    '0':\n" +
            "#      Delay: 0\n" +
            "#      Options:\n" +
            "#        Radius: 0.0\n" +
            "#      Pitch: 2.0\n" +
            "#      Sound: 'ENTITY_ZOMBIE_ATTACK_IRON_DOOR'\n" +
            "#      Volume: 1.0\n" +
            "#\n" +
            "# Items support criteria, like the ones found on commands.yml, chat sounds.yml, hit sounds.yml, items clicked.yml and items swung.yml.\n" +
            "# You have the following criteria: Contains[], EndsWith[], Equals[], and StartsWith[].\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play a sound for any kind of coral:\n" +
            "#   Contains[DIAMOND]\n" +
            "#\n" +
            "#   If I want to play a sound for any kind of sword:\n" +
            "#   EndsWith[SWORD]\n" +
            "#\n" +
            "#   If I want to play a sound for any diamond item:\n" +
            "#   StartsWith[DIAMOND]\n" +
            "#\n" +
            "# You can also use commas if you want to play the same sound for many criteria.\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play the same sound wools and carpets:\n" +
            "#   Contains[WOOL,CARPET]\n" +
            "#\n" +
            "#   If I want to play the same sound for glass and glass panes:\n" +
            "#   EndsWith[GLASS,GLASS_PANE]\n" +
            "#\n" +
            "#   If I want to play the same sound for furnaces and blast furnaces:\n" +
            "#   Equals[FURNACE,BLAST_FURNACE]\n" +
            "#\n" +
            "#   If I want to play the same sound for iron and diamond items:\n" +
            "#   StartsWith[IRON,DIAMOND]\n" +
            "#\n" +
            "# Hope everything is clear, if you have any doubts of a criteria that you wanna use but can't find how, contact me on discord:\n" +
            "# https://discord.gg/eAHPbc3\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_3_0),
    ITEMS_SWUNG(StaticFields.sounds.resolve("items swung.yml"), "# Set a sound to play when a player swings a specific item with their hand.\n" +
            "#\n" +
            "# To set a sound create a section with the name of the item.\n" +
            "# Bukkit item names: https://hub.spigotmc.org/javadocs/bukkit/org/bukkit/Material.html\n" +
            "#\n" +
            "#IRON_SWORD: # This sound will play when a player swings an iron sword.\n" +
            "#  Enabled: true\n" +
            "#  Cancellable: true\n" +
            "#  Prevent Other Sounds:\n" +
            "#    Default Sound: true # This will prevent the default Player Swing sound set on sounds.yml from playing.\n" +
            "#    Other Criteria: true # If the hand swing event matches more than one criteria, this will prevent the others from playing.\n" +
            "#  Sounds:\n" +
            "#    '0':\n" +
            "#      Delay: 0\n" +
            "#      Options:\n" +
            "#        Radius: 0.0\n" +
            "#      Pitch: 2.0\n" +
            "#      Sound: 'ENTITY_ZOMBIE_ATTACK_IRON_DOOR'\n" +
            "#      Volume: 1.0\n" +
            "#\n" +
            "# Items support criteria, like the ones found on commands.yml, chat sounds.yml, hit sounds.yml, items clicked.yml and items held.yml.\n" +
            "# You have the following criteria: Contains[], EndsWith[], Equals[], and StartsWith[].\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play a sound for any kind of coral:\n" +
            "#   Contains[DIAMOND]\n" +
            "#\n" +
            "#   If I want to play a sound for any kind of sword:\n" +
            "#   EndsWith[SWORD]\n" +
            "#\n" +
            "#   If I want to play a sound for any diamond item:\n" +
            "#   StartsWith[DIAMOND]\n" +
            "#\n" +
            "# You can also use commas if you want to play the same sound for many criteria.\n" +
            "#\n" +
            "# Examples:\n" +
            "#\n" +
            "#   If I want to play the same sound wools and carpets:\n" +
            "#   Contains[WOOL,CARPET]\n" +
            "#\n" +
            "#   If I want to play the same sound for glass and glass panes:\n" +
            "#   EndsWith[GLASS,GLASS_PANE]\n" +
            "#\n" +
            "#   If I want to play the same sound for furnaces and blast furnaces:\n" +
            "#   Equals[FURNACE,BLAST_FURNACE]\n" +
            "#\n" +
            "#   If I want to play the same sound for iron and diamond items:\n" +
            "#   StartsWith[IRON,DIAMOND]\n" +
            "#\n" +
            "# Hope everything is clear, if you have any doubts of a criteria that you wanna use but can't find how, contact me on discord:\n" +
            "# https://discord.gg/eAHPbc3\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_3_0),
    LANGUAGE_EN_US(StaticFields.lang.resolve("Language EN-US.yml"), "#Language EN-US\n" +
            "#By Epicnicity322\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'\n" +
            "\n" +
            "Addons:\n" +
            "  Download:\n" +
            "    Error:\n" +
            "      Not Found: '&cAddons for PlayMoreSounds v<version> were not found.'\n" +
            "      Subtitle: '&7Something went wrong'\n" +
            "      Title: '&4&lError'\n" +
            "      Unknown: '&cAn unknown error occurred when downloading addons.'\n" +
            "    Downloading:\n" +
            "      Already Exists: '&7An addons zip was found and deleted from temp folder. Downloading latest one...'\n" +
            "      Subtitle:\n" +
            "        Files: '&6Addons files...'\n" +
            "        Info: '&6Info about addons...'\n" +
            "      Title: '&cDownloading'\n" +
            "      Unsupported Version: '&7The latest addons were downloaded, but they don''t support the PlayMoreSounds version you''re running, trying to download addons made for the current PlayMoreSounds version...'\n" +
            "    Success:\n" +
            "      Subtitle: '&7Latest addons were downloaded'\n" +
            "      Title: '&2Success'\n" +
            "  Error:\n" +
            "    Blocked: '&cAddons are currently being installed, wait until the installation process finishes to open the addon management inventory.'\n" +
            "    Not Found: '&cAddon with the name &f<addon>&c was not found. Use &7&n/<label> addon list&c to list all addons.'\n" +
            "  Install:\n" +
            "    Error: '&cSomething went wrong while installing the addon &4<addon>&c.'\n" +
            "    Installed: '&7<addon>&7 was installed.'\n" +
            "    Success: '&aAddon <addon>&a was installed successfully, restart your server so it can be loaded.'\n" +
            "  Inventory:\n" +
            "    Title:\n" +
            "      Default: '&9&lInstalled Addons:'\n" +
            "      Empty: '&c&lNo addons found'\n" +
            "      Installer: '&2&lInstall Addons:'\n" +
            "    Items:\n" +
            "      Addon:\n" +
            "        Display Name: '&a&l<name>'\n" +
            "        Lore: >-\n" +
            "          &7Author(s):&8 <authors>\n" +
            "          <line>&7Description:&8 <description>\n" +
            "          <line>&7Version:&8 <version>\n" +
            "          <line>&cClick to &4&n&luninstall&c.\n" +
            "        To be uninstalled lore: >-\n" +
            "          &7Author(s):&8 <authors>\n" +
            "          <line>&7Description:&8 <description>\n" +
            "          <line>&7Version:&8 <version>\n" +
            "          <line>&fClick to &7&n&lcancel uninstallation&f.\n" +
            "      Done:\n" +
            "        Display Name: '&2&lDone'\n" +
            "        Lore: '&7Click to exit.'\n" +
            "      Info:\n" +
            "        Display Name: '&d&lInfo'\n" +
            "        Lore: '&7You have <addons> addons installed.'\n" +
            "      Install:\n" +
            "        Display Name: '&2&lInstall Addons'\n" +
            "        Lore: ' &7Click to download latest addons from<line>&7PlayMoreSounds'' GitHub.'\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&lNext Page'\n" +
            "        Lore: '&7Click to go to page <to>.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&lPrevious Page'\n" +
            "        Lore: '&7Click to go to page <to>.'\n" +
            "  List:\n" +
            "    Header: '&7Addons installed for PlayMoreSounds:'\n" +
            "    Separator: '&f, '\n" +
            "  Start:\n" +
            "    Error:\n" +
            "      Already Started: '&cAddon <addon> was already started.'\n" +
            "    Success: '&aAddon <addon> was started successfully.'\n" +
            "  Stop:\n" +
            "    Error:\n" +
            "      Already Stopped: '&cAddon <addon> was already stopped.'\n" +
            "    Success: '&aAddon <addon> was stopped successfully.'\n" +
            "  Uninstall:\n" +
            "    Cancel: '&aAddon <addon> &7&nwill no longer&a be uninstalled.'\n" +
            "    Confirmation:\n" +
            "      Chat: '&7Type &f/<label> confirm&7 to confirm uninstallation of <addon> addon.'\n" +
            "      Description: 'Uninstall <addon> addon'\n" +
            "      Title: '&9&lUninstall &9<addon>&l?'\n" +
            "    Error:\n" +
            "      Dependants:\n" +
            "        Plural: '&cAddon <addon> can''t be uninstalled because it''s a dependency of the addons &f<dependants>&c. Uninstall those addons before this one.'\n" +
            "        Singular: '&cAddon <addon> can''t be uninstalled because it''s a dependency of the addon &f<dependants>&c. Uninstall that addon before this one.'\n" +
            "    Success: '&aAddon <addon> &4&nwill be&a uninstalled when the server stops or restarts.'\n" +
            "\n" +
            "Confirm:\n" +
            "  Error:\n" +
            "    Nothing Pending: '&cThere is nothing pending to confirm.'\n" +
            "    Not Found: '&cA confirmation with id &7<id>&c was not found. Use &7&n/<label> list&c to see confirmations available.'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Cancel:\n" +
            "        Display Name: '&4&lCancel'\n" +
            "        Lore: '&cClick to cancel operation.'\n" +
            "      Confirm:\n" +
            "        Display Name: '&2&lConfirm'\n" +
            "        Lore: '&aClick to confirm operation.'\n" +
            "  List:\n" +
            "    Confirmation: ' &f<id> &7- <description>'\n" +
            "    Header: '&8List of pending confirmations:'\n" +
            "\n" +
            "Description:\n" +
            "  Header: '&6&m------------&6[&9PlayMoreSounds v<version>&6]&m------------'\n" +
            "  Help: '&6Type \"&7&n/<label> help&6\" to see the list of commands.'\n" +
            "  No Permission: '&6You don''t have permission to use any commands.'\n" +
            "\n" +
            "Disc:\n" +
            "  Error:\n" +
            "    Not Found: '&cA disc with the ID \"&7<id>&c\" was not found.'\n" +
            "  Success: '&7Giving the disc &f<id>&7 to &f<target>&7.'\n" +
            "\n" +
            "General:\n" +
            "  And: and\n" +
            "  Description: description\n" +
            "  Everyone: Everyone\n" +
            "  Id: id\n" +
            "  Invalid Arguments: '&cIncorrect command syntax! Use \"&7/&n<label> <label2> <args>&c\".'\n" +
            "  Name: name\n" +
            "  No Permission: '&4You don''t have permission to do this!'\n" +
            "  Nobody Online: '&cThere are no online players on the server.'\n" +
            "  Not A Number: '&cThe value \"&7<number>&c\" is not a valid number!'\n" +
            "  Not A Player: '&cYou must be a player to do this.'\n" +
            "  Player: player\n" +
            "  Player Not Found: '&cThe player \"&7<player>&c\" was not found.'\n" +
            "  Prefix: '&6[&9PlayMoreSounds&6] '\n" +
            "  Target: target\n" +
            "  Unknown Command: '&cUnknown command. Use \"&7&n/<label> help&c\" to see the list of commands available to you.'\n" +
            "  World: world\n" +
            "  You: You\n" +
            "\n" +
            "Help:\n" +
            "  Addons: |-\n" +
            "    &e/<label> addons\n" +
            "    &7 > Opens a GUI that helps you install addons.\n" +
            "  Check: |-\n" +
            "    &e/<label> check [target]\n" +
            "    &7 > Checks if sounds are enabled.\n" +
            "  Confirm: |-\n" +
            "    &e/<label> confirm [id|page]\n" +
            "    &7 > Confirms something.\n" +
            "  Disc: |-\n" +
            "    &e/<label> disc <id> [target]\n" +
            "    &7 > Gives a configured custom disc.\n" +
            "  Editor: |-\n" +
            "    &e/<label> editor\n" +
            "    &7 > Opens a GUI that allows you to edit sounds in sounds.yml\n" +
            "  Footer: 'View more commands with &7&n/<label> help <next>'\n" +
            "  Header: 'PlayMoreSounds commands (Page <page> of <totalPages>):'\n" +
            "  Help: |-\n" +
            "    &e/<label> help\n" +
            "    &7 > Shows the description of commands.\n" +
            "  List: |-\n" +
            "    &e/<label> list [page] [--gui]\n" +
            "    &7 > Shows the sounds available on your version.\n" +
            "  Play: |-\n" +
            "    &e/<label> play <sound> [target] [vol] [pitch]\n" +
            "    &7 > Plays a sound.\n" +
            "  Region: |-\n" +
            "    &e/<label> region <create|info|list|remove|rename|set|teleport|wand>\n" +
            "    &7 > Regions command.\n" +
            "  Reload: |-\n" +
            "    &e/<label> reload\n" +
            "    &7 > Reloads configurations and events.\n" +
            "  Stop Sound: |-\n" +
            "    &e/<label> stopsound [target] [sounds]\n" +
            "    &7 > Stops sounds from playing.\n" +
            "  Toggle: |-\n" +
            "    &e/<label> toggle [target] [on|off]\n" +
            "    &7 > Enables or disables sounds from playing.\n" +
            "  Update: |-\n" +
            "    &e/<label> update [download] [--force]\n" +
            "    &7 > Checks and downloads updates.\n" +
            "\n" +
            "Input Getter Inventory:\n" +
            "  Input Item:\n" +
            "    Display Name: 'Input'\n" +
            "    Lore: 'Type in the input.'\n" +
            "\n" +
            "List:\n" +
            "  Chat:\n" +
            "    Alternate Color: '&8'\n" +
            "    Color: '&e'\n" +
            "    Error:\n" +
            "      Not Exists: '&cThe page &7<page>&c doesn''t exist! Max: <totalpages>.'\n" +
            "    Footer: '&f&l - &aView more sounds with \"&f/&n<label> list <page>&a\"'\n" +
            "    Header: '&aList of available sounds [Page <page> of <totalpages>]:'\n" +
            "    Separator: '&f, '\n" +
            "    Sound Tooltip: '&5Click to play the sound &d<sound>'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&lNext page'\n" +
            "        Lore: ' Click to go to the next page.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&lPrevious page'\n" +
            "        Lore: ' Click to go to the previous page.'\n" +
            "      Sound:\n" +
            "        Display Name: '&d&n<sound>'\n" +
            "        Lore: ' Click to play this sound.'\n" +
            "      Stop Sound:\n" +
            "        Display Name: '&6&lStop Sounds'\n" +
            "        Lore: ' Stop all currently playing sounds.'\n" +
            "    Title: '&8List of sounds, page &c<page>&8 of &c<totalpages>&8'\n" +
            "  Page: page\n" +
            "\n" +
            "Play:\n" +
            "  Error:\n" +
            "    Invalid Sound: '&cThe value \"&7<sound>&c\" has invalid sound characters.'\n" +
            "    Not A Section: '&cThe section \"&7<section>&c\" in the file &7<file>&c is not a valid sound!'\n" +
            "    Unauthorized: '&cYou can''t go in that folder!'\n" +
            "    Unavailable: '&cThe sound <sound> is not available in this minecraft version.'\n" +
            "  Pitch: pitch\n" +
            "  Sound: sound\n" +
            "  Success:\n" +
            "    Config: '&7Playing the sound &f<sound>&7 of the file &f<file>&7 to &f<player>&7.'\n" +
            "    Default: '&7Playing the sound &f<sound>&7 with volume &f<volume>&7 and pitch &f<pitch>&7 to &f<player>&7.'\n" +
            "  Volume: volume\n" +
            "\n" +
            "Region:\n" +
            "  Create:\n" +
            "    Default Description: A sound playing region.\n" +
            "    Error:\n" +
            "      Already Exists: '&cThis name was already taken, choose another.'\n" +
            "      Default: '&cSomething went wrong while creating the region \"&7<name>&c\".'\n" +
            "      Different Worlds: '&cYour selections are in different worlds!'\n" +
            "      Max Area: '&cThe selected area exceeds the maximum of <max> blocks.'\n" +
            "      Max Regions: '&cYou cannot create more than <max> regions.'\n" +
            "      Not Selected: '&cYou did not select positions, type &7&n/<label> <label2> wand&c to get the region selection tool.'\n" +
            "    Success: '&aThe region &7<name>&a was created successfully. Use &e&n/<label> <label2> set sounds&a to add sounds to this region.'\n" +
            "  General:\n" +
            "    Error:\n" +
            "      Illegal Characters: '&cRegion names can only have alpha-numeric characters.'\n" +
            "      Max Name Characters: '&cRegion names cannot be longer than <max> characters.'\n" +
            "      Not Found:\n" +
            "        Name: '&cNo region with that name was found. Type &7/<label> <label2> list&c to see the list of regions.'\n" +
            "        UUID: '&cNo region with that UUID was found. Type &7/<label> <label2> list&c to see the list of regions.'\n" +
            "      Save: '&cSomething went wrong while saving <name> region.'\n" +
            "  Info:\n" +
            "    Creation Date: '&7Creation Date:&f <date>'\n" +
            "    Description: '&7Description:&f <description>'\n" +
            "    Error:\n" +
            "      No Regions: '&7There are no regions on this location.'\n" +
            "    Header: '&8Information of the region &f<name>&8:'\n" +
            "    Id: '&7UUID:&f <uuid>'\n" +
            "    Owner: '&7Owner:&f <owner>'\n" +
            "    World: '&7World:&f <world>'\n" +
            "  List:\n" +
            "    Error:\n" +
            "      No Regions: '&c<targets> have no regions.'\n" +
            "      Not Exists: '&cThe page &7<page>&c doesn''t exist! Max: <totalPages>.'\n" +
            "      Others: '&4You can not list regions made by other players.'\n" +
            "    Footer: '&8Type &7/<label> <label2> <label3> <label4> <next>&8 to see more regions.'\n" +
            "    Header:\n" +
            "      Default: '&8Your regions [Page <page> of <totalPages>]:'\n" +
            "      Player: '&8Regions of <targets> [Page <page> of <totalPages>]:'\n" +
            "    Region: '&7- <name>: &f<uuid>'\n" +
            "  Region: region\n" +
            "  Remove:\n" +
            "    Confirm: '&aType &7/<label> confirm&a to confirm the removal of the region &7<region>&a.'\n" +
            "    Description: Delete the region <region>\n" +
            "    Success: '&aThe region &7<region>&a was deleted successfully.'\n" +
            "  Rename:\n" +
            "    Error:\n" +
            "      Already Exists: '&cThe new name was already taken, chose another.'\n" +
            "      Same: '&cThe new name is not different than the previous.'\n" +
            "    New Name: new name\n" +
            "    Success: '&aThe region <region> was renamed to &7<newName>&a.'\n" +
            "  Select:\n" +
            "    Error:\n" +
            "      Overlap: '&cAn already existing region is on that location!'\n" +
            "  Set:\n" +
            "    Description:\n" +
            "      Error:\n" +
            "        Max Characters: '&cRegion descriptions cannot be longer than 100 characters.'\n" +
            "      Success: '&aDescription of <region> region was set to &7<description>&a.'\n" +
            "    Select:\n" +
            "      Error:\n" +
            "        Not A World: '&cThe value &7<value>&c is not a valid world.'\n" +
            "      Position:\n" +
            "        First: '&6First position selected! World: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "        Second: '&6Second position selected! World: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "    Sounds:\n" +
            "      Editing:\n" +
            "        Default: '&7Editing sounds of region: &f<region>&7.'\n" +
            "        Multiple: '&7Editing sounds of first region found at your location: &f<region>&7.'\n" +
            "      Error:\n" +
            "        No Regions: '&cNo regions found at this location. Use &7/<label> <label2> set <label4> <region>&c to edit sounds of a specific region.'\n" +
            "        No Owning Regions: '&cYou don''t own any regions at this location.'\n" +
            "      Inventory:\n" +
            "        Items:\n" +
            "          Enter Sound:\n" +
            "            Display Name: '&a&lEnter Sound'\n" +
            "            Lore: >-\n" +
            "              &7 The sound that plays when someone\n" +
            "              <line>&7enters &f<region>&7 region.\n" +
            "          Loop Sound:\n" +
            "            Display Name: '&8&lLoop Sound'\n" +
            "            Lore: >-\n" +
            "              &7 The sound that plays repeatedly\n" +
            "              <line>&7when someone is in &f<region>&7\n" +
            "              <line>&7region.\n" +
            "          Leave Sound:\n" +
            "            Display Name: '&c&lLeave Sound'\n" +
            "            Lore: >-\n" +
            "              &7 The sound that plays when someone\n" +
            "              <line>&7leaves &f<region>&7 region.\n" +
            "          Edit:\n" +
            "            Display Name: '&9&lEdit'\n" +
            "            Lore: '&7Edit <sound>&7.'\n" +
            "          Remove:\n" +
            "            Display Name: '&9&lEdit'\n" +
            "            Lore: '&7Edit <sound>&7.'\n" +
            "  Teleport:\n" +
            "    Success: '&aYou were teleported to region <region>.'\n" +
            "  Wand:\n" +
            "    Error:\n" +
            "      Config: '&cYou are missing settings on your configuration. Wand could not be given.'\n" +
            "    Success: '&6Selection tool: Left-click selects first position and Right-click selects second position.'\n" +
            "\n" +
            "Reload:\n" +
            "  Error: '&cSomething went wrong while reloading config. PlayMoreSounds must be shut down immediately.'\n" +
            "  Success: '&7Configuration reloaded.'\n" +
            "\n" +
            "Resource Packs:\n" +
            "  Failed Notice: '&cResource Pack download failed. If you want this server''s full experience, please re-join to try the download again. If this error persists, please contact an administrator.'\n" +
            "  Kick Message:\n" +
            "    Declined: \"&cYou must accept the resource pack to play on this server.\"\n" +
            "    Download Fail: \"&cSomething went wrong while downloading the resource pack. Please try joining again.\"\n" +
            "  Request Message: '&ePlease download the resource pack to continue.'\n" +
            "\n" +
            "Editor Inventory:\n" +
            "  Items:\n" +
            "    Next Page:\n" +
            "      Display Name: '&e&lNext page'\n" +
            "      Lore: '&7Click to go to page <value>.'\n" +
            "    Previous Page:\n" +
            "      Display Name: '&e&lPrevious page'\n" +
            "      Lore: '&7Click to go to page <value>.'\n" +
            "    Rich Sound:\n" +
            "      Display Name: '&5&l<value>'\n" +
            "      Lore: '&7Click to edit this rich sound.'\n" +
            "  Title:\n" +
            "    Default: '&5Sounds in &dsounds.yml'\n" +
            "    Empty: '&4No sounds found'\n" +
            "\n" +
            "Rich Sound Inventory:\n" +
            "  Items:\n" +
            "    Status:\n" +
            "      Enabled:\n" +
            "        Display Name: '&a&lEnabled'\n" +
            "        Lore: '&7This sound is enabled and will<line>&7play normally.'\n" +
            "      Disabled:\n" +
            "        Display Name: '&4&lDisabled'\n" +
            "        Lore: >-\n" +
            "          &7 This sound is disabled and will\n" +
            "          <line>&7not play. Events that play this\n" +
            "          <line>&7sound will be unregistered on\n" +
            "          <line>&7plugin reload.\n" +
            "    Info:\n" +
            "      Display Name: '&8&lInfo'\n" +
            "      Lore: >-\n" +
            "        &7Name:&f <name>\n" +
            "        <line>&7Config:&f <config>\n" +
            "        <line>&7Child Sounds:&f <child-amount>\n" +
            "    Cancellable:\n" +
            "      Display Name: '&c&lCancellable'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7Cancellable helps add compatibility\n" +
            "        <line>&7with other plugins.\n" +
            "    Previous Page:\n" +
            "      Display Name: '&e&lPrevious page'\n" +
            "      Lore: '&7Click to go to page <value>.'\n" +
            "    Add Sound:\n" +
            "      Display Name: '&2&lChild Sounds'\n" +
            "      Lore: >-\n" +
            "        &7Current page: &f<value>\n" +
            "        <line>&8Click to add a new child sound.\n" +
            "    Next Page:\n" +
            "      Display Name: '&e&lNext page'\n" +
            "      Lore: '&7Click to go to page <value>.'\n" +
            "    Sound:\n" +
            "      Display Name: '&5&lSound <id>'\n" +
            "      Lore: >-\n" +
            "        &7Sound:&f <sound>\n" +
            "        <line>&7Volume:&f <volume>\n" +
            "        <line>&7Pitch:&f <pitch>\n" +
            "        <line>&8Click to edit or remove.\n" +
            "    Save:\n" +
            "      Error: '&cFailed to save the sound <richsound> to <config>.'\n" +
            "      Display Name: '&2&lSave'\n" +
            "      Lore: >-\n" +
            "        &7Click to save this sound to the\n" +
            "        <line>&7configuration <value>.\n" +
            "  Title: '&1Rich Sound: &9<richsound>'\n" +
            "\n" +
            "Sound Inventory:\n" +
            "  Items:\n" +
            "    Sound:\n" +
            "      Display Name: '&5&lSound'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7The sound that will play. Can either be a\n" +
            "        <line>&7sound from &n/pms list&7 or a custom sound.\n" +
            "      Input:\n" +
            "        Invalid: '&cThe sound input is not a valid namespaced key!'\n" +
            "        Title: '&5Input new sound'\n" +
            "    Volume:\n" +
            "      Display Name: '&8&lVolume'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7The volume of this sound, it's\n" +
            "        <line>&7noticeable only when it's a decimal.\n" +
            "        <line>&7A big volume is recommended if this\n" +
            "        <line>&7is a region sound.\n" +
            "      Input:\n" +
            "        Invalid: '&cThe volume input is not a valid float number!'\n" +
            "        Title: '&8Input new volume'\n" +
            "    Pitch:\n" +
            "      Display Name: '&4&lPitch'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7The pitch of this sound. Values\n" +
            "        <line>&7greater than 2 have no difference.\n" +
            "      Input:\n" +
            "        Invalid: '&cThe pitch input is not a valid float number!'\n" +
            "        Title: '&4Input new pitch'\n" +
            "    Category:\n" +
            "      Display Name: '&e&lCategory'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7The music category this sound is\n" +
            "        <line>&7gonna play. Available categories:\n" +
            "        <line>&fAMBIENT&7, &fBLOCK&7, &fHOSTILE&7, &fMASTER&7,\n" +
            "        <line>&fMUSIC&7, &fNEUTRAL&7, &fPLAYER&7, &fRECORD&7,\n" +
            "        <line>&fVOICE&7 and &fWEATHER&7.\n" +
            "      Input:\n" +
            "        Invalid: '&cThe category input was not found! Check available sounds.txt file to see available categories.'\n" +
            "        Title: '&eInput new category'\n" +
            "    Delay:\n" +
            "      Display Name: '&c&lDelay'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7Time in ticks to wait before playing\n" +
            "        <line>&7the sound.\n" +
            "      Input:\n" +
            "        Invalid: '&cThe delay input is not a valid ''long'' number!'\n" +
            "        Title: '&cInput new delay'\n" +
            "    Radius:\n" +
            "      Display Name: '&3&lRadius'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7Radius in blocks the sound can be heard\n" +
            "        <line>&f-&7 Use 0 for no radius.\n" +
            "        <line>&f-&7 Use -1 for everyone online.\n" +
            "        <line>&f-&7 Use -2 for everyone in the world.\n" +
            "      Input:\n" +
            "        Invalid: '&cThe radius input is not a valid ''double'' number!'\n" +
            "        Title: '&3Input new radius'\n" +
            "    Ignores Toggle:\n" +
            "      Enabled:\n" +
            "        Display Name: '&f&lIgnoring Toggle'\n" +
            "        Lore: >-\n" +
            "          &7This sound will play even when players\n" +
            "          <line>&7disabled their sounds with command\n" +
            "          <line>&7&n/pms toggle&7.\n" +
            "      Disabled:\n" +
            "        Display Name: '&f&lNot Ignoring Toggle'\n" +
            "        Lore: >-\n" +
            "          &7This sound will respect players that\n" +
            "          <line>&7disabled their sounds with command\n" +
            "          <line>&7&n/pms toggle&7.\n" +
            "    Permission Required:\n" +
            "      Display Name: '&9&lPermission Required'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7The permission required to play this\n" +
            "        <line>&7sound.\n" +
            "        <line>&7Input 'null' for no permission.\n" +
            "      Input:\n" +
            "        Title: '&9Permission required'\n" +
            "    Permission To Listen:\n" +
            "      Display Name: '&9&lPermission To Listen'\n" +
            "      Lore: >-\n" +
            "        &7Current:&f <value>\n" +
            "        <line>&7The permission other players need in\n" +
            "        <line>&7order to hear the sound.\n" +
            "        <line>&7Input 'null' for no permission.\n" +
            "      Input:\n" +
            "        Title: '&9Permission to listen'\n" +
            "    Remove:\n" +
            "      Display Name: '&4&lRemove'\n" +
            "      Lore: '&7Remove this sound from <value>.'\n" +
            "    Play:\n" +
            "      Display Name: '&6&lPlay'\n" +
            "      Lore: '&7Click to play &f<value>&7.'\n" +
            "    Done:\n" +
            "      Default:\n" +
            "        Display Name: '&2&lDone'\n" +
            "        Lore: '&7Click to finish editing this sound.'\n" +
            "      Parent:\n" +
            "        Display Name: '&2&lDone'\n" +
            "        Lore: '&7Click to save and go back to &f<value>&7.'\n" +
            "  Title:\n" +
            "    Default: '&1Editing sound &9<id>'\n" +
            "    Parent: '&1Sound &9<id>&1 of <richsound>'\n" +
            "\n" +
            "Stop Sound:\n" +
            "  Success:\n" +
            "    All: '&7Stopped all sounds playing to &f<target>&7.'\n" +
            "    Default: '&7Stopped &f<sounds>&7 sounds playing to &f<target>&7.'\n" +
            "\n" +
            "Toggle:\n" +
            "  Check:\n" +
            "    Disabled:\n" +
            "      Default: '&cYour sounds are disabled.'\n" +
            "      Player: '&cSounds of &f<target>&c are disabled.'\n" +
            "    Enabled:\n" +
            "      Default: '&aYour sounds are enabled.'\n" +
            "      Player: '&aSounds of &f<target>&a are enabled.'\n" +
            "  Disabled:\n" +
            "    Default: '&cYour sounds were toggled to off!'\n" +
            "    Player: '&cToggled the sounds of &f<target>&c to off!'\n" +
            "  Enabled:\n" +
            "    Default: '&aYour sounds were toggled to on!'\n" +
            "    Player: '&aToggled the sounds of &f<target>&a to on!'\n" +
            "\n" +
            "Update:\n" +
            "  Available: '&2PlayMoreSounds v<version> is available. Download the latest version using &7&n/pms update download&a.'\n" +
            "  Check: '&eChecking for updates...'\n" +
            "  Download:\n" +
            "    Checking: '&7Checking if an update is available for download...'\n" +
            "    Confirmation:\n" +
            "      Not Latest:\n" +
            "        Deleted: '&aOlder downloaded version of PlayMoreSounds was deleted.'\n" +
            "        Description: 'Delete the downloaded update with older version.'\n" +
            "      Not Supported:\n" +
            "        Deleted: '&aUnsupported downloaded version of PlayMoreSounds was deleted.'\n" +
            "        Description: 'Delete the unsupported update.'\n" +
            "    Deleted Downloaded: '&7A download of an update was already found. Deleting it and downloading again.'\n" +
            "    Downloading:\n" +
            "      Default: '&7An update was found and is being downloaded.'\n" +
            "      Forcefully: '&7Downloading latest version available of PlayMoreSounds...'\n" +
            "    Error:\n" +
            "      Not Latest: '&cYou downloaded PlayMoreSounds version &f<downloaded>&c which is older than the current installed version: &f<current>&c. Type &f&n/pms confirm&c to delete the older version.'\n" +
            "      Not Supported: '&cThe downloaded update was made for Spigot &f<apiversion>&c and you are currently using Spigot &f<current>&c. If you proceed to install this version, PlayMoreSounds will stop working on your server. Type &f&n/pms confirm&c to delete the unsupported version.'\n" +
            "    Success: '&aPlayMoreSounds v<version> was downloaded successfully and will be installed the next time you restart your server.'\n" +
            "  Error:\n" +
            "    Default: '&cSomething went wrong while using updater.'\n" +
            "    Offline: '&cYou are offline or spigotmc.org is down.'\n" +
            "    Timeout: '&cTook too long to establish a connection.'\n" +
            "  Not Available: '&eNo updates available.'", StaticFields.version5_0),
    LANGUAGE_ES_LA(StaticFields.lang.resolve("Language ES-LA.yml"), "#Idioma ES-LA\n" +
            "#Traductor: Epicnicity322\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'\n" +
            "\n" +
            "Addons:\n" +
            "  Download:\n" +
            "    Error:\n" +
            "      Not Found: '&cNo se encontraron addons para PlayMoreSounds v<version>.'\n" +
            "      Subtitle: '&7Algo salió mal'\n" +
            "      Title: '&4&lError'\n" +
            "      Unknown: '&cSe produjo un error desconocido al descargar addons.'\n" +
            "    Downloading:\n" +
            "      Already Exists: '&7Ya se ha descargado un zip de addons antes, eliminando y descargando el más reciente.'\n" +
            "      Subtitle:\n" +
            "        Files: '&6Archivos de addons...'\n" +
            "        Info: '&6Información de addons...'\n" +
            "      Title: '&cDescargando'\n" +
            "      Unsupported Version: '&7Se han descargado los últimos addons, pero parece que no son compatibles con la versión actual de PlayMoreSounds, descargando addons hechos para la versión actual...'\n" +
            "    Success:\n" +
            "      Subtitle: '&7Últimos addons descargados'\n" +
            "      Title: '&2Éxito'\n" +
            "  Error:\n" +
            "    Blocked: '&cSe están instalando addons, espere hasta que finalice el proceso de instalación antes de abrir el inventario de administración de addons.'\n" +
            "    Not Found: '&cAddon llamado &f<addon>&c no encontrado. Use &7&n/<label> addon list&c para enumerar todos los addons.'\n" +
            "  Install:\n" +
            "    Error: '&cAlgo salió mal al instalar el addon &4<addon>&c.'\n" +
            "    Installed: '&7<addon>&7 fue instalado.'\n" +
            "    Success: '&aAddon <addon>&a se ha instalado correctamente, reinicie su servidor para que se cargue.'\n" +
            "  Inventory:\n" +
            "    Title:\n" +
            "      Default: '&9&lAddons Instalados:'\n" +
            "      Empty: '&c&lAddons no encontrados'\n" +
            "      Installer: '&2&lInstalar Addons:'\n" +
            "    Items:\n" +
            "      Addon:\n" +
            "        Display Name: '&a&l<name>'\n" +
            "        Lore: >-\n" +
            "          &7Autor(es):&8 <authors>\n" +
            "          <line>&7Descripción:&8 <description>\n" +
            "          <line>&7Versión:&8 <version>\n" +
            "          <line>&cHaga clic para &4&n&ldesinstalar&c.\n" +
            "        To be uninstalled lore: >-\n" +
            "          &7Autor(es):&8 <authors>\n" +
            "          <line>&7Descripción:&8 <description>\n" +
            "          <line>&7Versión:&8 <version>\n" +
            "          <line>&fHaga clic para &7&n&lcancelar la desinstalación&f.\n" +
            "      Done:\n" +
            "        Display Name: '&2&lHecho'\n" +
            "        Lore: '&7Haga clic para salir.'\n" +
            "      Info:\n" +
            "        Display Name: '&d&lInformación'\n" +
            "        Lore: '&7Tiene <addons> addons instalados.'\n" +
            "      Install:\n" +
            "        Display Name: '&2&lInstalar Addons'\n" +
            "        Lore: ' &7Haga clic para descargar los últimos addons<line>de GitHub de PlayMoreSounds.'\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&lPágina Siguiente'\n" +
            "        Lore: '&7Haga clic para ir a la página <to>.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&lPágina Anterior'\n" +
            "        Lore: '&7Haga clic para ir a la página <to>.'\n" +
            "  List:\n" +
            "    Header: '&7Addons instalados en PlayMoreSounds:'\n" +
            "    Separator: '&f, '\n" +
            "  Start:\n" +
            "    Error:\n" +
            "      Already Started: '&cAddon <addon> ya se ha iniciado.'\n" +
            "    Success: '&aAddon <addon> inició con éxito.'\n" +
            "  Stop:\n" +
            "    Error:\n" +
            "      Already Stopped: '&cAddon <addon> ya ha sido detenido.'\n" +
            "    Success: '&aAddon <addon> se detuvo con éxito.'\n" +
            "  Uninstall:\n" +
            "    Cancel: '&aAddon <addon> &7&nya no&a se desinstalará.'\n" +
            "    Confirmation:\n" +
            "      Chat: '&Escriba &f/<label> confirm&7 para confirmar la desinstalación del addon <addon>.'\n" +
            "      Description: 'Desinstalar addon <addon>'\n" +
            "      Title: '&9&l¿Desinstalar &9<addon>&l?'\n" +
            "    Error:\n" +
            "      Dependants:\n" +
            "        Plural: '&cAddon <addon> no se puede desinstalar porque es una dependencia de los addons &f<dependants>&c. Desinstale esos complementos antes de este.'\n" +
            "        Singular: '&cAddon <addon> no se puede desinstalar porque es una dependencia del addon &f<dependants>&c. Desinstala ese complemento antes de este.'\n" +
            "    Success: '&aAddon <addon> &4&nserá&a desinstalado cuando el servidor se apaga o se reinicia.'\n" +
            "\n" +
            "Confirm:\n" +
            "  Error:\n" +
            "    Nothing Pending: '&cNo hay nada pendiente de confirmar.'\n" +
            "    Not Found: '&cNo se encontró una confirmación con id &7<id>&c. Use &7&n/<label> list&c para ver las confirmaciones pendientes.'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Cancel:\n" +
            "        Display Name: '&4&lCancelar'\n" +
            "        Lore: '&cHaga clic para cancelar la operación.'\n" +
            "      Confirm:\n" +
            "        Display Name: '&2&lConfirmar'\n" +
            "        Lore: '&aHaga clic para confirmar la operación.'\n" +
            "  List:\n" +
            "    Confirmation: ' &f<id> &7- <description>'\n" +
            "    Header: '&8Lista de confirmaciones pendientes:'\n" +
            "\n" +
            "Description:\n" +
            "  Header: '&6&m------------&6[&9PlayMoreSounds v<version>&6]&m------------'\n" +
            "  Help: '&6Use \"&7&n/<label> help&6\" para ver la lista de comandos.'\n" +
            "  No Permission: '&6No tiene permiso para usar ningún comando.'\n" +
            "\n" +
            "Disc:\n" +
            "  Error:\n" +
            "    Not Found: '&cNo se encontró un disco con el ID \"&7<id>&c\".'\n" +
            "  Success: '&7Dando el disco &f<id>&7 a &f<target>&7.'\n" +
            "\n" +
            "General:\n" +
            "  And: y\n" +
            "  Description: descripción\n" +
            "  Everyone: Todos\n" +
            "  Id: id\n" +
            "  Invalid Arguments: '&c¡Sintaxis de comando incorrecta! Use \"&7/&n<label> <label2> <args>&c\".'\n" +
            "  Name: nombre\n" +
            "  No Permission: '&4¡No tienes permiso para hacer esto!'\n" +
            "  Nobody Online: '&cNo hay jugadores en línea en el servidor.'\n" +
            "  Not A Number: '&c¡El valor \"&7<number>&c\" no es un número válido!'\n" +
            "  Not A Player: '&cDebes ser un jugador para hacer esto.'\n" +
            "  Player: jugador\n" +
            "  Player Not Found: '&cEl jugador \"&7<player>&c\" no fue encontrado.'\n" +
            "  Prefix: '&6[&9PlayMoreSounds&6] '\n" +
            "  Target: objetivo\n" +
            "  Unknown Command: '&cComando desconocido. Use \"&7&n/<label> help&c\" para ver la lista de comandos disponibles para usted.'\n" +
            "  World: mundo\n" +
            "  You: Tú\n" +
            "\n" +
            "Help:\n" +
            "  Addons: |-\n" +
            "    &e/<label> addons\n" +
            "    &7 > Abre una GUI que le ayuda a instalar addons.\n" +
            "  Check: |-\n" +
            "    &e/<label> check [objetivo]\n" +
            "    &7 > Comprueba se sonidos están activados.\n" +
            "  Confirm: |-\n" +
            "    &e/<label> confirm [id|page]\n" +
            "    &7 > Confirma algo.\n" +
            "  Disc: |-\n" +
            "    &e/<label> disc <id> [objetivo]\n" +
            "    &7 > Da un disco personalizado configurado.\n" +
            "  Footer: 'Ver más comandos con &7&n/<label> help <next>'\n" +
            "  Header: 'Comandos de PlayMoreSounds (Página <page> de <totalPages>):'\n" +
            "  Help: |-\n" +
            "    &e/<label> help [comando]\n" +
            "    &7 > Muestra la descripción de los comandos.\n" +
            "  List: |-\n" +
            "    &e/<label> list [página] [--gui]\n" +
            "    &7 > Muestra los sonidos disponibles en su versión.\n" +
            "  Play: |-\n" +
            "    &e/<label> play <sonido> [objetivo] [vol] [tom]\n" +
            "    &7 > Reproduce un sonido.\n" +
            "  Region: |-\n" +
            "    &e/<label> region <create|info|list|remove|rename|set|teleport|wand>\n" +
            "    &7 > Comando de regiones.\n" +
            "  Reload: |-\n" +
            "    &e/<label> reload\n" +
            "    &7 > Recargar configuraciones y eventos.\n" +
            "  Stop Sound: |-\n" +
            "    &e/<label> stopsound [objetivo] [sonidos]\n" +
            "    &7 > Detiene los sonidos que están reproduciendo.\n" +
            "  Toggle: |-\n" +
            "    &e/<label> toggle [objetivo] [on|off]\n" +
            "    &7 > Habilita o deshabilita la reproducción de sonidos.\n" +
            "  Update: |-\n" +
            "    &e/<label> update [download] [--force]\n" +
            "    &7 > Comprueba y descarga actualizaciones.\n" +
            "\n" +
            "List:\n" +
            "  Chat:\n" +
            "    Alternate Color: '&8'\n" +
            "    Color: '&e'\n" +
            "    Error:\n" +
            "      Not Exists: '&c¡La página &7<page>&c no existe! Max: <totalpages>.'\n" +
            "    Footer: '&f&l - &aVer más sonidos con \"&f/&n<label> list <page>&a\"'\n" +
            "    Header: '&aLista de sonidos disponibles [Página <page> de <totalpages>]:'\n" +
            "    Separator: '&f, '\n" +
            "    Sound Tooltip: '&5Haz clic para reproducir<line> el sonido &d<sound>'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&lPágina siguiente'\n" +
            "        Lore: ' Haga clic para ir a la página siguiente.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&lPágina anterior'\n" +
            "        Lore: ' Haga clic para volver a la página anterior.'\n" +
            "      Sound:\n" +
            "        Display Name: '&d&n<sound>'\n" +
            "        Lore: ' Haga clic para reproducir ese sonido.'\n" +
            "      Stop Sound:\n" +
            "        Display Name: '&6&lDetener Sonidos'\n" +
            "        Lore: ' Detiene todos los sonidos que se<line> están reproduciendo actualmente.'\n" +
            "    Title: '&8Lista de sonidos, página &c<page>&8 de &c<totalpages>&8'\n" +
            "  Page: página\n" +
            "\n" +
            "Play:\n" +
            "  Error:\n" +
            "    Invalid Sound: '&cEl valor \"&7<sound>&c\" tiene caracteres de sonido no válidos.'\n" +
            "    Not A Section: '&c¡La sección \"&7<section>&c\" en el archivo &7<file>&c no es un sonido valido!'\n" +
            "    Unauthorized: '&c¡No puedes ingresar a esa carpeta!'\n" +
            "    Unavailable: '&cEl sonido <sound> no está disponible en esta versión de Minecraft.'\n" +
            "  Pitch: tono\n" +
            "  Sound: sonido\n" +
            "  Success:\n" +
            "    Config: '&7Tocando el sonido &f<sound>&7 del archivo &f<file>&7 a &f<player>&7.'\n" +
            "    Default: '&7Tocando el sonido &f<sound>&7 con volumen &f<volume>&7 y tono &f<pitch>&7 a &f<player>&7.'\n" +
            "  Volume: volumen\n" +
            "\n" +
            "Region:\n" +
            "  Create:\n" +
            "    Default Description: Una región de reproducción de sonido.\n" +
            "    Error:\n" +
            "      Already Exists: '&cEste nombre ya se ha utilizado, elija otro.'\n" +
            "      Default: '&cAlgo salió mal al crear la región \"&7<name>&c\".'\n" +
            "      Different Worlds: '&c¡Tus selecciones están en mundos diferentes!'\n" +
            "      Max Area: '&cEl área seleccionada excede el máximo de <max> bloques.'\n" +
            "      Max Regions: '&cNo puede crear más de <max> regiones.'\n" +
            "      Not Selected: '&cNo ha seleccionado ninguna posición, use &7&n/<label> <label2> wand&c para obtener la herramienta de selección.'\n" +
            "    Success: '&aLa región &7<name>&a se creó con éxito.'\n" +
            "  General:\n" +
            "    Error:\n" +
            "      Illegal Characters: '&cLos nombres de región solo pueden tener caracteres alfanuméricos.'\n" +
            "      Max Name Characters: '&cLos nombres de región no pueden tener más de <max> caracteres.'\n" +
            "      Not Found:\n" +
            "        Name: '&cNo se encontró ninguna región con ese nombre. Use &7/<label> <label2> list&c para ver la lista de regiones.'\n" +
            "        UUID: '&cNo se encontró ninguna región con este UUID. Use &7/<label> <label2> list&c para ver la lista de regiones.'\n" +
            "      Save: '&cAlgo salió mal al guardar la región <name>.'\n" +
            "  Info:\n" +
            "    Creation Date: '&7Fecha de creación:&f <date>'\n" +
            "    Description: '&7Descripción:&f <description>'\n" +
            "    Error:\n" +
            "      No Regions: '&7No hay regiones en esa ubicación.'\n" +
            "    Header: '&8Información de la región &f<name>&8:'\n" +
            "    Id: '&7UUID:&f <uuid>'\n" +
            "    Owner: '&7Propietario:&f <owner>'\n" +
            "    World: '&7Mundo:&f <world>'\n" +
            "  List:\n" +
            "    Error:\n" +
            "      No Regions: '&c<targets> no tiene regiones.'\n" +
            "      Not Exists: '&c¡La página &7<page>&c no existe! Max: <totalPages>.'\n" +
            "    Footer: '&8Use &7/<label> <label2> <label3> <label4> <next>&8 para ver más regiones.'\n" +
            "    Header:\n" +
            "      Default: '&8Sus regiones [Página <page> de <totalPages>]:'\n" +
            "      Player: '&8Regiones de <targets> [Página <page> de <totalPages>]:'\n" +
            "    Region: '&7- <name>: &f<uuid>'\n" +
            "  Region: región\n" +
            "  Remove:\n" +
            "    Confirm: '&aUse &7/<label> confirm&a para confirmar la eliminación de la región &7<region>&a.'\n" +
            "    Description: Eliminar la región <region>\n" +
            "    Success: '&aLa región &7<region>&a ha sido eliminado exitosamente.'\n" +
            "  Rename:\n" +
            "    Error:\n" +
            "      Already Exists: '&cEl nuevo nombre ya se ha utilizado, elija otro.'\n" +
            "      Same: '&cEl nuevo nombre no es diferente del anterior.'\n" +
            "    New Name: nuevo nombre\n" +
            "    Success: '&aLa región <region> ha sido renombrado a &7<newName>&a.'\n" +
            "  Select:\n" +
            "    Error:\n" +
            "      Overlap: '&c¡Una región ya existente está en esa ubicación!'\n" +
            "  Set:\n" +
            "    Description:\n" +
            "      Error:\n" +
            "        Max Characters: '&cLas descripciones de región no pueden tener más de 100 caracteres.'\n" +
            "      Success: '&aDescripción de la región <region> se estableció en &7<description>&a.'\n" +
            "    Select:\n" +
            "      Error:\n" +
            "        Not A World: '&cEl valor &7<value>&c no es un mundo válido.'\n" +
            "      Position:\n" +
            "        First: '&6¡Primera posición seleccionada! Mundo: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "        Second: '&6¡Segunda posición seleccionada! Mundo: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "  Teleport:\n" +
            "    Success: '&aHas sido teletransportado a la región <region>.'\n" +
            "  Wand:\n" +
            "    Error:\n" +
            "      Config: '&cLe faltan configuraciones en su configuración. No se pudo crear la herramienta de selección.'\n" +
            "    Success: '&6Herramienta de selección: Clic-izquierdo selecciona la primera posición y clic-derecho selecciona la segunda posición.'\n" +
            "\n" +
            "Reload:\n" +
            "  Error: '&cAlgo salió mal al recargar la configuración. PlayMoreSounds debe desactivarse de inmediato.'\n" +
            "  Success: '&7Configuración recargada.'\n" +
            "\n" +
            "Resource Packs:\n" +
            "  Error: '&cAlgo salió mal al preguntarle al jugador <player> que descargue el paquete de texturas. Por favor, intente con otra URL.'\n" +
            "  Download Failed:\n" +
            "    Failed: '&cLa descarga de la textura falló. Si desea la experiencia completa de este servidor, vuelva a iniciar sesión para intentar la descarga nuevamente. Si el error persiste, póngase en contacto con un administrador.'\n" +
            "    Administrator: '&cEl jugador <player> intentó unirse pero no pudo descargar la textura. Escriba &7&n/pms confirm&c para permitir que este jugador se una sin una textura.'\n" +
            "    Confirmation: 'Permitir que <player> se una'\n" +
            "  Kick Message:\n" +
            "    Declined: '&cDebes estar usando una textura para jugar en ese servidor.'\n" +
            "    Download Fail: '&cAlgo salió mal al descargar la textura. Intente descargar iniciando sesión nuevamente.'\n" +
            "  Request Message: '&eDescargue la textura para continuar.'\n" +
            "\n" +
            "Stop Sound:\n" +
            "  Success:\n" +
            "    All: '&7Se han detenido todos los sonidos de &f<target>&7.'\n" +
            "    Default: '&7Se detuvieron los sonidos de &f<sounds>&7 para &f<target>&7.'\n" +
            "\n" +
            "Toggle:\n" +
            "  Check:\n" +
            "    Disabled:\n" +
            "      Default: '&cTus sonidos están desactivados.'\n" +
            "      Player: '&cLos sonidos de &f<target>&c están desactivados.'\n" +
            "    Enabled:\n" +
            "      Default: '&aTus sonidos están activados.'\n" +
            "      Player: '&aLos sonidos de &f<target>&c están activados.'\n" +
            "  Disabled:\n" +
            "    Default: '&c¡Tus sonidos han sido desactivados!'\n" +
            "    Player: '&c¡Los sonidos de &f<target>&c han sido desactivados!'\n" +
            "  Enabled:\n" +
            "    Default: '&a¡Tus sonidos han sido activados!'\n" +
            "    Player: '&a¡Los sonidos de &f<target>&a han sido desactivados!'\n" +
            "\n" +
            "Update:\n" +
            "  Available: '&2PlayMoreSounds v<version> está disponible. Descargue la última versión en spigotmc.org.'\n" +
            "  Check: '&eBuscando actualizaciones...'\n" +
            "  Download:\n" +
            "    Checking: '&7Verificando si existe alguna actualización disponible para descargar...'\n" +
            "    Confirmation:\n" +
            "      Not Latest:\n" +
            "        Deleted: '&aLa versión inferior que fue descargada ha sido eliminada.'\n" +
            "        Description: 'Eliminar la actualización que tiene una versión inferior.'\n" +
            "      Not Supported:\n" +
            "        Deleted: '&aLa actualización no compatible de PlayMoreSounds fue eliminada.'\n" +
            "        Description: 'Eliminar la actualización no compatible.'\n" +
            "    Deleted Downloaded: '&7Ya se encontró una descarga de una actualización. Borrándolo y volviendo a descargar.'\n" +
            "    Downloading:\n" +
            "      Default: '&7Se ha encontrado una actualización y se está descargando.'\n" +
            "      Forcefully: '&7Descargando la última versión de PlayMoreSounds...'\n" +
            "    Error:\n" +
            "      Not Latest: '&cHa descargado PlayMoreSounds de versión &f<downloaded>&c, que es anterior a la versión instalada actualmente: &f<current>&c. Use &f&n/pms confirm&c para eliminar la versión anterior.'\n" +
            "      Not Supported: '&cLa actualización descargada fue desarrollada para Spigot &f<apiversion>&c y estás usando &f<current>&c. Si continúa con la instalación de esta versión, PlayMoreSounds dejará de funcionar en su servidor. Use &f&n/pms confirm&c para eliminar la versión no compatible.'\n" +
            "    Success: '&aPlayMoreSounds v<version> se ha descargado con éxito y se instalará la próxima vez que reinicie su servidor.'\n" +
            "  Error:\n" +
            "    Default: '&cAlgo salió mal al usar el actualizador.'\n" +
            "    Offline: '&cEstá desconectado o spigot.org está caído.'\n" +
            "    Timeout: '&cTomó demasiado tiempo para establecer una conexión.'\n" +
            "  Not Available: '&eNo hay actualizaciones disponibles.'", StaticFields.version5_0),
    LANGUAGE_PT_BR(StaticFields.lang.resolve("Language PT-BR.yml"), "#Linguagem PT-BR\n" +
            "#Tradutor: Epicnicity322\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'\n" +
            "\n" +
            "Addons:\n" +
            "  Download:\n" +
            "    Error:\n" +
            "      Not Found: '&cAddons para PlayMoreSounds v<version> não foram encontrados.'\n" +
            "      Subtitle: '&7Aconteceu algo de errado'\n" +
            "      Title: '&4&lErro'\n" +
            "      Unknown: '&cUm erro desconhecido ocorreu ao baixar os addons.'\n" +
            "    Downloading:\n" +
            "      Already Exists: '&7Um zip de addons já foi baixado anteriormente, deletando e baixando o mais recente.'\n" +
            "      Subtitle:\n" +
            "        Files: '&6Arquivos de addons...'\n" +
            "        Info: '&6Informação de addons...'\n" +
            "      Title: '&cBaixando'\n" +
            "      Unsupported Version: '&7Os addons mais recentes foram baixados, mas parece que eles não suportam a versão atual do PlayMoreSounds, baixando addons feitos para a versão atual...'\n" +
            "    Success:\n" +
            "      Subtitle: '&7Addons mais recentes baixados'\n" +
            "      Title: '&2Sucesso'\n" +
            "  Error:\n" +
            "    Blocked: '&cAddons estão sendo instalados, espere até que o processo de instalação termine antes de abrir o inventário de gerenciamento de addons.'\n" +
            "    Not Found: '&cAddon de nome &f<addon>&c não foi encontrado. Use &7&n/<label> addon list&c para listar todos os addons.'\n" +
            "  Install:\n" +
            "    Error: '&cAlgo de errado ocorreu ao instalar o addon &4<addon>&c.'\n" +
            "    Installed: '&7<addon>&7 foi instalado.'\n" +
            "    Success: '&aAddon <addon>&a foi instalado com sucesso, reinicie seu servidor para que seja carregado.'\n" +
            "  Inventory:\n" +
            "    Title:\n" +
            "      Default: '&9&lAddons Instalados:'\n" +
            "      Empty: '&c&lAddons não encontrados'\n" +
            "      Installer: '&2&lInstalar Addons:'\n" +
            "    Items:\n" +
            "      Addon:\n" +
            "        Display Name: '&a&l<name>'\n" +
            "        Lore: >-\n" +
            "          &7Autor(es):&8 <authors>\n" +
            "          <line>&7Descrição:&8 <description>\n" +
            "          <line>&7Versão:&8 <version>\n" +
            "          <line>&cClique para &4&n&ldesinstalar&c.\n" +
            "        To be uninstalled lore: >-\n" +
            "          &7Autor(es):&8 <authors>\n" +
            "          <line>&7Descrição:&8 <description>\n" +
            "          <line>&7Versão:&8 <version>\n" +
            "          <line>&fClique para &7&n&lcancelar desinstalação&f.\n" +
            "      Done:\n" +
            "        Display Name: '&2&lPronto'\n" +
            "        Lore: '&7Clique para sair.'\n" +
            "      Info:\n" +
            "        Display Name: '&d&lInformação'\n" +
            "        Lore: '&7Você tem <addons> addons instalados.'\n" +
            "      Install:\n" +
            "        Display Name: '&2&lInstalar Addons'\n" +
            "        Lore: ' &7Clique para baixar os addons mais recentes do<line>&7GitHub do PlayMoreSounds.'\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&lPróxima Página'\n" +
            "        Lore: '&7Clique para ir à página <to>.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&lPágina Anterior'\n" +
            "        Lore: '&7Clique para ir à página <to>.'\n" +
            "  List:\n" +
            "    Header: '&7Addons instalados no PlayMoreSounds:'\n" +
            "    Separator: '&f, '\n" +
            "  Start:\n" +
            "    Error:\n" +
            "      Already Started: '&cAddon <addon> já foi iniciado.'\n" +
            "    Success: '&aAddon <addon> foi iniciado com sucesso.'\n" +
            "  Stop:\n" +
            "    Error:\n" +
            "      Already Stopped: '&cAddon <addon> já foi parado.'\n" +
            "    Success: '&aAddon <addon> foi parado com sucesso.'\n" +
            "  Uninstall:\n" +
            "    Cancel: '&aAddon <addon> &7&nnão vai mais&a ser desinstalado.'\n" +
            "    Confirmation:\n" +
            "      Chat: '&7Digite &f/<label> confirm&7 para confirmar desinstalação do addon <addon>.'\n" +
            "      Description: 'Desinstalar addon <addon>'\n" +
            "      Title: '&9&lDesinstalar &9<addon>&l?'\n" +
            "    Error:\n" +
            "      Dependants:\n" +
            "        Plural: '&cAddon <addon> não pode ser desinstalado porque é uma dependência dos addons &f<dependants>&c. Desinstale esses addons antes deste.'\n" +
            "        Singular: '&cAddon <addon> não pode ser desinstalado porque é uma dependência do addon &f<dependants>&c. Desinstale esse addon antes deste.'\n" +
            "    Success: '&aAddon <addon> &4&nvai ser&a desinstalado quando o servidor desligar ou reiniciar.'\n" +
            "\n" +
            "Confirm:\n" +
            "  Error:\n" +
            "    Nothing Pending: '&cNão há nada pendente para confirmar.'\n" +
            "    Not Found: '&cUma confirmação de id &7<id>&c não foi encontrada. Use &7&n/<label> list&c para ver confirmações pendentes.'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Cancel:\n" +
            "        Display Name: '&4&lCancelar'\n" +
            "        Lore: '&cClique para cancelar a operação.'\n" +
            "      Confirm:\n" +
            "        Display Name: '&2&lConfirmar'\n" +
            "        Lore: '&aClique para confirmar a operação.'\n" +
            "  List:\n" +
            "    Confirmation: ' &f<id> &7- <description>'\n" +
            "    Header: '&8Lista de confirmações pendentes:'\n" +
            "\n" +
            "Description:\n" +
            "  Header: '&6&m------------&6[&9PlayMoreSounds v<version>&6]&m------------'\n" +
            "  Help: '&6Digite \"&7&n/<label> help&6\" para ver a lista de comandos.'\n" +
            "  No Permission: '&6Você não tem permissão para usar nenhum comando.'\n" +
            "\n" +
            "Disc:\n" +
            "  Error:\n" +
            "    Not Found: '&cNão foi encontrado um disco com o ID \"&7<id>&c\".'\n" +
            "  Success: '&7Dando o disco &f<id>&7 a &f<target>&7.'\n" +
            "\n" +
            "General:\n" +
            "  And: e\n" +
            "  Description: descrição\n" +
            "  Everyone: Todos\n" +
            "  Id: id\n" +
            "  Invalid Arguments: '&cSintaxe de comando incorreta! Use \"&7/&n<label> <label2> <args>&c\".'\n" +
            "  Name: nome\n" +
            "  No Permission: '&4Você não tem permissão para fazer isso!'\n" +
            "  Nobody Online: '&cNão há jogadores online no servidor.'\n" +
            "  Not A Number: '&cO valor \"&7<number>&c\" não é um número válido!'\n" +
            "  Not A Player: '&cVocê deve ser um jogador para fazer isso.'\n" +
            "  Player: jogador\n" +
            "  Player Not Found: '&cO jogador \"&7<player>&c\" não foi encontrado.'\n" +
            "  Prefix: '&6[&9PlayMoreSounds&6] '\n" +
            "  Target: alvo\n" +
            "  Unknown Command: '&cComando desconhecido. Use \"&7&n/<label> help&c\" para ver a lista de comandos disponíveis para você.'\n" +
            "  World: mundo\n" +
            "  You: Você\n" +
            "\n" +
            "Help:\n" +
            "  Addons: |-\n" +
            "    &e/<label> addons\n" +
            "    &7 > Abre uma GUI que ajuda a instalar addons.\n" +
            "  Check: |-\n" +
            "    &e/<label> check [alvo]\n" +
            "    &7 > Checa se sons estão ativados.\n" +
            "  Confirm: |-\n" +
            "    &e/<label> confirm [id|page]\n" +
            "    &7 > Confirma algo\n" +
            "  Disc: |-\n" +
            "    &e/<label> disc <id> [objetivo]\n" +
            "    &7 > Da um disco personalizado configurado.\n" +
            "  Footer: 'Veja mais comandos com &7&n/<label> help <next>'\n" +
            "  Header: 'Comandos do PlayMoreSounds (Página <page> de <totalPages>):'\n" +
            "  Help: |-\n" +
            "    &e/<label> help [comando]\n" +
            "    &7 > Mostra a descrição de comandos\n" +
            "  List: |-\n" +
            "    &e/<label> list [página] [--gui]\n" +
            "    &7 > Mostra os sons disponíveis em sua versão.\n" +
            "  Play: |-\n" +
            "    &e/<label> play <som> [alvo] [vol] [tom]\n" +
            "    &7 > Toca um som.\n" +
            "  Region: |-\n" +
            "    &e/<label> region <create|info|list|remove|rename|set|teleport|wand>\n" +
            "    &7 > Comando de região.\n" +
            "  Reload: |-\n" +
            "    &e/<label> reload\n" +
            "    &7 > Recarrega configurações e eventos.\n" +
            "  Stop Sound: |-\n" +
            "    &e/<label> stopsound [alvo] [sons]\n" +
            "    &7 > Para os sons que estão tocando.\n" +
            "  Toggle: |-\n" +
            "    &e/<label> toggle [alvo] [on|off]\n" +
            "    &7 > Ativa ou desativa a reprodução de sons.\n" +
            "  Update: |-\n" +
            "    &e/<label> update [download] [--force]\n" +
            "    &7 > Verifica e baixa atualizações.\n" +
            "\n" +
            "List:\n" +
            "  Chat:\n" +
            "    Alternate Color: '&8'\n" +
            "    Color: '&e'\n" +
            "    Error:\n" +
            "      Not Exists: '&cA página &7<page>&c não existe! Max: <totalpages>.'\n" +
            "    Footer: '&f&l - &aVeja mais sons com \"&f/&n<label> list <page>&a\"'\n" +
            "    Header: '&aLista de sons disponíveis [Página <page> de <totalpages>]:'\n" +
            "    Separator: '&f, '\n" +
            "    Sound Tooltip: '&5Clique para tocar o som &d<sound>'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&lPróxima página'\n" +
            "        Lore: ' Clique para ir à próxima página.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&lPágina anterior'\n" +
            "        Lore: ' Clique para voltar à página anterior.'\n" +
            "      Sound:\n" +
            "        Display Name: '&d&n<sound>'\n" +
            "        Lore: ' Clique para tocar esse som.'\n" +
            "      Stop Sound:\n" +
            "        Display Name: '&6&lParar Sons'\n" +
            "        Lore: ' Parar todos sons tocando no momento.'\n" +
            "    Title: '&8Lista de sons, página &c<page>&8 de &c<totalpages>&8'\n" +
            "  Page: página\n" +
            "\n" +
            "Play:\n" +
            "  Error:\n" +
            "    Invalid Sound: '&cO valor \"&7<sound>&c\" tem caracteres de som inválidos.'\n" +
            "    Not A Section: '&cA seção \"&7<section>&c\" no arquivo &7<file>&c não é um som válido!'\n" +
            "    Unauthorized: '&cVocê não pode entrar nessa pasta!'\n" +
            "    Unavailable: '&cO som <sound> não está disponível nessa versão do Minecraft.'\n" +
            "  Pitch: tom\n" +
            "  Sound: som\n" +
            "  Success:\n" +
            "    Config: '&7Tocando o som &f<sound>&7 do arquivo &f<file>&7 para &f<player>&7.'\n" +
            "    Default: '&7Tocando o som &f<sound>&7 com volume &f<volume>&7 e tom &f<pitch>&7 para &f<player>&7.'\n" +
            "  Volume: volume\n" +
            "\n" +
            "Region:\n" +
            "  Create:\n" +
            "    Default Description: Uma região de reprodução de som.\n" +
            "    Error:\n" +
            "      Already Exists: '&cEste nome já foi usado, escolha outro.'\n" +
            "      Default: '&cAlgo de errado ocorreu ao criar a região \"&7<name>&c\".'\n" +
            "      Different Worlds: '&cSuas seleções estão em mundos diferentes!'\n" +
            "      Max Area: '&cA área selecionada excede o máximo de <max> blocos.'\n" +
            "      Max Regions: '&cVocê não pode criar mais de <max> regiões.'\n" +
            "      Not Selected: '&cVocê não selecionou nenhuma posição, digite &7&n/<label> <label2> wand&c para pegar a ferramenta de seleção.'\n" +
            "    Success: '&aA região &7<name>&a foi criada com sucesso.'\n" +
            "  General:\n" +
            "    Error:\n" +
            "      Illegal Characters: '&cNomes de regiões só podem ter caracteres alfa-numéricos.'\n" +
            "      Max Name Characters: '&cNomes de regiões não podem ser maior que <max> caracteres.'\n" +
            "      Not Found:\n" +
            "        Name: '&cNenhuma região com esse nome foi encontrada. Digite &7/<label> <label2> list&c para ver a lista de regiões.'\n" +
            "        UUID: '&cNenhuma região com essa uuid foi encontrada. Digite &7/<label> <label2> list&c para ver a lista de regiões.'\n" +
            "      Save: '&cAlgo de errado ocorreu ao salvar a região <name>.'\n" +
            "  Info:\n" +
            "    Creation Date: '&7Data de Criação:&f <date>'\n" +
            "    Description: '&7Descrição:&f <description>'\n" +
            "    Error:\n" +
            "      No Regions: '&7Não há regiões nessa localização.'\n" +
            "    Header: '&8Informações da região &f<name>&8:'\n" +
            "    Id: '&7UUID:&f <uuid>'\n" +
            "    Owner: '&7Dono:&f <owner>'\n" +
            "    World: '&7Mundo:&f <world>'\n" +
            "  List:\n" +
            "    Error:\n" +
            "      No Regions: '&c<targets> não possui regiões.'\n" +
            "      Not Exists: '&cA página &7<page>&c não existe! Max: <totalPages>.'\n" +
            "    Footer: '&8Digite &7/<label> <label2> <label3> <label4> <next>&8 para ver mais regiões.'\n" +
            "    Header:\n" +
            "      Default: '&8Suas regiões [Página <page> de <totalPages>]:'\n" +
            "      Player: '&8Regiões de <targets> [Página <page> de <totalPages>]:'\n" +
            "    Region: '&7- <name>: &f<uuid>'\n" +
            "  Region: região\n" +
            "  Remove:\n" +
            "    Confirm: '&aDigite &7/<label> confirm&a para confirmar a remoção da região &7<region>&a.'\n" +
            "    Description: Deletar a região <region>\n" +
            "    Success: '&aA região &7<region>&a foi deletada com sucesso.'\n" +
            "  Rename:\n" +
            "    Error:\n" +
            "      Already Exists: '&cO novo nome já foi usado, escolha outro.'\n" +
            "      Same: '&cO novo nome não é diferente do anterior.'\n" +
            "    New Name: novo nome\n" +
            "    Success: '&aA região <region> foi renomeada para &7<newName>&a.'\n" +
            "  Select:\n" +
            "    Error:\n" +
            "      Overlap: '&cUma região já existente está nesse local!'\n" +
            "  Set:\n" +
            "    Description:\n" +
            "      Error:\n" +
            "        Max Characters: '&cDescrições de regiões não podem ser maior que 100 caracteres.'\n" +
            "      Success: '&aDescrição da região <region> foi definida para &7<description>&a.'\n" +
            "    Select:\n" +
            "      Error:\n" +
            "        Not A World: '&cO valor &7<value>&c não é um mundo válido.'\n" +
            "      Position:\n" +
            "        First: '&6Primeira posição selecionada! Mundo: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "        Second: '&6Segunda posição selecionada! Mundo: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "  Teleport:\n" +
            "    Success: '&aVocê foi teleportado para a região <region>.'\n" +
            "  Wand:\n" +
            "    Error:\n" +
            "      Config: '&cFaltam configurações na sua configuração. Ferramenta de seleção não pode ser dada.'\n" +
            "    Success: '&6Ferramenta de seleção: Clique-esquerdo seleciona primeira posição e Clique-direito seleciona segunda posição.'\n" +
            "\n" +
            "Reload:\n" +
            "  Error: '&cAlgo de errado ocorreu ao recarregar as configurações. PlayMoreSounds deve ser desativado imediatamente.'\n" +
            "  Success: '&7Configuração recarregada.'\n" +
            "\n" +
            "Resource Packs:\n" +
            "  Error: '&cAlgo de errado ocorreu ao pedir o jogador <player> para baixar o pacote de texturas. Por favor tente outra URL.'\n" +
            "  Download Failed:\n" +
            "    Failed: '&cDownload de textura falhou. Se você deseja a experiência completa deste servidor, entre novamente para tentar o download novamente. Se o erro persistir, entre em contato com um administrador.'\n" +
            "    Administrator: '&cO jogador <player> tentou entrar mas falhou ao baixar a textura. Digite &7&n/pms confirm&c para permitir esse jogador entrar sem uma textura.'\n" +
            "    Confirmation: 'Permitir jogador <player> entrar'\n" +
            "  Kick Message:\n" +
            "    Declined: '&cVocê deve aceitar a textura para jogar nesse servidor.'\n" +
            "    Download Fail: '&cAlgo de errado ocorreu ao baixar a textura. Por favor tente baixar entrando novamente.'\n" +
            "  Request Message: '&ePor favor baixe a textura para continuar.'\n" +
            "\n" +
            "Stop Sound:\n" +
            "  Success:\n" +
            "    All: '&7Todos sons tocando para &f<target>&7 foram parados.'\n" +
            "    Default: '&7Sons de &f<sounds>&7 tocando para &f<target>&7 foram parados.'\n" +
            "\n" +
            "Toggle:\n" +
            "  Check:\n" +
            "    Disabled:\n" +
            "      Default: '&cSeus sons estão desativados.'\n" +
            "      Player: '&cOs sons de &f<target>&c estão desativados.'\n" +
            "    Enabled:\n" +
            "      Default: '&aSeus sons estão ativados.'\n" +
            "      Player: '&aOs sons de &f<target>&c estão ativados.'\n" +
            "  Disabled:\n" +
            "    Default: '&cSeus sons foram desativados!'\n" +
            "    Player: '&cOs sons de &f<target>&c foram desativados!'\n" +
            "  Enabled:\n" +
            "    Default: '&aSeus sons foram ativados!'\n" +
            "    Player: '&aOs sons de &f<target>&a foram ativados!'\n" +
            "\n" +
            "Update:\n" +
            "  Available: '&2PlayMoreSounds v<version> está disponível. Baixe a última versão usando &7&n/pms update download&2.'\n" +
            "  Check: '&eProcurando por atualizações...'\n" +
            "  Download:\n" +
            "    Checking: '&7Vendo se uma atualização está disponível para download...'\n" +
            "    Confirmation:\n" +
            "      Not Latest:\n" +
            "        Deleted: '&aA versão antiga que foi baixada foi deletada.'\n" +
            "        Description: 'Deletar a atualização baixada que tem versão inferior.'\n" +
            "      Not Supported:\n" +
            "        Deleted: '&aA versão não suportada baixada do PlayMoreSounds foi deletada.'\n" +
            "        Description: 'Deletar a atualização não suportada.'\n" +
            "    Deleted Downloaded: '&7Um arquivo de atualização foi encontrado. Apagando-o e baixando de novo.'\n" +
            "    Downloading:\n" +
            "      Default: '&7Uma atualização foi encontrada e está sendo baixada.'\n" +
            "      Forcefully: '&7Baixando a versão mais recente do PlayMoreSounds...'\n" +
            "    Error:\n" +
            "      Not Latest: '&cVocê baixou o PlayMoreSounds versão &f<downloaded>&c que é mais antigo que a versão atualmente instalada: &f<current>&c. Use &f&n/pms confirm&c para apagar a versão antiga.'\n" +
            "      Not Supported: '&cA atualização baixada foi feita para o Spigot &f<apiversion>&c e você está usando o Spigot &f<current>&c. Se você prosseguir com a instalação dessa versão, o PlayMoreSounds vai parar de funcionar no seu servidor. Use &f&n/pms confirm&c para apagar a versão não suportada.'\n" +
            "    Success: '&aPlayMoreSounds v<version> foi baixado com sucesso e será instalado na próxima vez que você reiniciar seu servidor.'\n" +
            "  Error:\n" +
            "    Default: '&cAlgo de errado ocorreu ao usar o atualizador.'\n" +
            "    Offline: '&cVocê está offline ou spigot.org caiu.'\n" +
            "    Timeout: '&cLevou tempo demais para estabelecer uma conexão.'\n" +
            "  Not Available: '&eNenhuma atualização disponível.'", StaticFields.version5_0),
    LANGUAGE_ZH_CN(StaticFields.lang.resolve("Language ZH-CN.yml"), "#语言ZH-CN\n" +
            "#译者：秋风残叶\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'\n" +
            "\n" +
            "Addons:\n" +
            "  Download:\n" +
            "    Error:\n" +
            "      Not Found: '&cPlayMoreSounds v<version> 的附属未找到'\n" +
            "      Subtitle: '&7出现错误'\n" +
            "      Title: '&4&l警告！'\n" +
            "      Unknown: '&c下载附属包时出现未知错误！'\n" +
            "    Downloading:\n" +
            "      Already Exists: '&7已找到一个附属包，将其从临时文件夹中删除并下载最新版本...'\n" +
            "      Subtitle:\n" +
            "        Files: '&6附属文件...'\n" +
            "        Info: '&6附属信息...'\n" +
            "      Title: '&c下载中'\n" +
            "      Unsupported Version: '&7最新版本附属已经下载，但貌似并不支持你当前版本的 PlayMoreSounds ，尝试下载适用你当前版本的附属...'\n" +
            "    Success:\n" +
            "      Subtitle: '&7最新版附属已下载'\n" +
            "      Title: '&2成功'\n" +
            "  Error:\n" +
            "    Blocked: '&c附属正在安装, 请等待安装结束以打开附属管理菜单'\n" +
            "    Not Found: '&c附属 &f<addon>&c 未找到，请使用 &7&n/<label> addon list&c 列出所有可用附属'\n" +
            "  Install:\n" +
            "    Error: '&c安装附属 &4<addon>&c 时出现未知错误.'\n" +
            "    Installed: '&7<addon>&7 已安装'\n" +
            "    Success: '&a附属 <addon>&a 已成功安装，请重启服务器'\n" +
            "  Inventory:\n" +
            "    Title:\n" +
            "      Default: '&9&l已安装附属:'\n" +
            "      Empty: '&c&l未找到附属'\n" +
            "      Installer: '&2&l安装附属:'\n" +
            "    Items:\n" +
            "      Addon:\n" +
            "        Display Name: '&a&l<name>'\n" +
            "        Lore: >-\n" +
            "          &7作者:&8 <authors>\n" +
            "          <line>&7描述:&8 <description>\n" +
            "          <line>&7版本:&8 <version>\n" +
            "          <line>&c点击将其&4&n&l卸载&c.\n" +
            "        To be uninstalled lore: >-\n" +
            "          &7作者:&8 <authors>\n" +
            "          <line>&7描述:&8 <description>\n" +
            "          <line>&7版本:&8 <version>\n" +
            "          <line>&f点击&7&n&l取消卸载&f.\n" +
            "      Done:\n" +
            "        Display Name: '&2&l完成'\n" +
            "        Lore: '&7点击退出'\n" +
            "      Info:\n" +
            "        Display Name: '&d&l信息'\n" +
            "        Lore: '&7已安装 <addons> 附属'\n" +
            "      Install:\n" +
            "        Display Name: '&2&l安装附属'\n" +
            "        Lore: ' &7点击此处从<line>&7PlayMoreSounds'' 的GitHub上下载最新附属'\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&l下一页'\n" +
            "        Lore: '&7点击传送至页 <to>.'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&l上一页'\n" +
            "        Lore: '&7点击传送至页 <to>.'\n" +
            "  List:\n" +
            "    Header: '&7PlayMoreSounds 已安装附属:'\n" +
            "    Separator: '&f, '\n" +
            "  Start:\n" +
            "    Error:\n" +
            "      Already Started: '&c附属 <addon> 已启用'\n" +
            "    Success: '&a附属 <addon> 已成功启用'\n" +
            "  Stop:\n" +
            "    Error:\n" +
            "      Already Stopped: '&c附属 <addon> 已停用'\n" +
            "    Success: '&a附属 <addon> 已成功停用'\n" +
            "  Uninstall:\n" +
            "    Cancel: '&a附属 <addon> 的卸载已被取消'\n" +
            "    Confirmation:\n" +
            "      Chat: '&7请输入 &f/<label> confirm&7 确认卸载 <addon> 附属'\n" +
            "      Description: '卸载 <addon> 附属'\n" +
            "      Title: '&9&l卸载 &9<addon>&l?'\n" +
            "    Error:\n" +
            "      Dependants:\n" +
            "        Plural: '&c附属 <addon> 无法被卸载，因为其为附属 &f<dependants>&c 的前置，你需要首先把这些附属卸载掉'\n" +
            "        Singular: '&c附属 <addon> 无法被卸载，因为其为附属 &f<dependants>&c 的前置，你需要首先把这个附属卸载掉'\n" +
            "    Success: '&a附属 <addon> 在下次关服重启时将被卸载'\n" +
            "\n" +
            "Confirm:\n" +
            "  Error:\n" +
            "    Nothing Pending: '&c无待确认项目'\n" +
            "    Not Found: '&cID为 &7<id>&c 的确认信息未找到，请输入 &7&n/<label> list&c 查看所有可用确认信息'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Cancel:\n" +
            "        Display Name: '&4&l取消'\n" +
            "        Lore: '&c点击取消'\n" +
            "      Confirm:\n" +
            "        Display Name: '&2&l确认'\n" +
            "        Lore: '&a点击确认'\n" +
            "  List:\n" +
            "    Confirmation: ' &f<id> &7- <description>'\n" +
            "    Header: '&8待确认列表:'\n" +
            "\n" +
            "Description:\n" +
            "  Header: '&6&m------------&6[&9PlayMoreSounds v<version>&6]&m------------'\n" +
            "  Help: '&6请输入 \"&7&n/<label> help&6\" 查看指令列表'\n" +
            "  No Permission: '&6你没有权限'\n" +
            "\n" +
            "Disc:\n" +
            "  Error:\n" +
            "    Not Found: '&c找不到ID为 \"&7<id>&c\" 的光盘'\n" +
            "  Success: '&7将光盘 &f<id>&7 赋予 &f<target>'\n" +
            "\n" +
            "General:\n" +
            "  And: 和\n" +
            "  Description: 描述\n" +
            "  Everyone: 所有人\n" +
            "  Id: id\n" +
            "  Invalid Arguments: '&c错误的指令参数! 请输入 \"&7/&n<label> <label2> <args>&c\".'\n" +
            "  Name: 名称\n" +
            "  No Permission: '&4你没有权限'\n" +
            "  Nobody Online: '&c没有在线玩家'\n" +
            "  Not A Number: '&c输入值 \"&7<number>&c\" 不是一个合法数字'\n" +
            "  Not A Player: '&c只有玩家可以这么做'\n" +
            "  Player: 玩家\n" +
            "  Player Not Found: '&c玩家 \"&7<player>&c\" 未找到'\n" +
            "  Prefix: '&6[&9PlayMoreSounds&6] '\n" +
            "  Target: 目标\n" +
            "  Unknown Command: '&c未知指令，请使用 \"&7&n/<label> help&c\" 获得帮助'\n" +
            "  World: 世界\n" +
            "  You: 你\n" +
            "\n" +
            "Help:\n" +
            "  Addons: |-\n" +
            "    &e/<label> addons\n" +
            "    &7 > 打开GUI并显示附属安装相关信息\n" +
            "  Check: |-\n" +
            "    &e/<label> check [目标]\n" +
            "    &7 > 检查声音的开启/关闭状态\n" +
            "  Confirm: |-\n" +
            "    &e/<label> confirm [数|页]\n" +
            "    &7 > 确认\n" +
            "  Disc: |-\n" +
            "    &e/<label> disc <ID> [目标]\n" +
            "    &7 > 提供配置的自定义光盘\n" +
            "  Footer: '查看更多帮助请输入 &7&n/<label> help <next>'\n" +
            "  Header: 'PlayMoreSounds 指令列表 (页 <page> / <totalPages>):'\n" +
            "  Help: |-\n" +
            "    &e/<label> help [指令]\n" +
            "    &7 > 指令描述\n" +
            "  List: |-\n" +
            "    &e/<label> list [页] [--gui]\n" +
            "    &7 > 此版本允许的音效列表\n" +
            "  Play: |-\n" +
            "    &e/<label> play <音效> [目标] [音量] [音调]\n" +
            "    &7 > 播放音效\n" +
            "  Region: |-\n" +
            "    &e/<label> region <create|info|list|remove|rename|set|teleport|wand>\n" +
            "    &7 > 区域相关指令\n" +
            "  Reload: |-\n" +
            "    &e/<label> reload\n" +
            "    &7 > 重载插件\n" +
            "  Stop Sound: |-\n" +
            "    &e/<label> stopsound [目标] [音效]\n" +
            "    &7 > 停止当前播放的声音\n" +
            "  Toggle: |-\n" +
            "    &e/<label> toggle [目标] [on|off]\n" +
            "    &7 > 启用/禁用音效\n" +
            "  Update: |-\n" +
            "    &e/<label> update [download] [--force]\n" +
            "    &7 > 点击下载更新\n" +
            "\n" +
            "List:\n" +
            "  Chat:\n" +
            "    Alternate Color: '&8'\n" +
            "    Color: '&e'\n" +
            "    Error:\n" +
            "      Not Exists: '&c页码 &7<page>&c 不存在，最大页码: <totalpages>.'\n" +
            "    Footer: '&f&l - &a查看更多音效请使用 \"&f/&n<label> list <page>&a\"'\n" +
            "    Header: '&a所有可用音效列表 [页 <page> / <totalpages>]:'\n" +
            "    Separator: '&f, '\n" +
            "    Sound Tooltip: '&5点击播放 &d<sound>'\n" +
            "  Inventory:\n" +
            "    Items:\n" +
            "      Next Page:\n" +
            "        Display Name: '&7&l下一页'\n" +
            "        Lore: ' 点击翻页'\n" +
            "      Previous Page:\n" +
            "        Display Name: '&7&l上一页'\n" +
            "        Lore: ' 点击翻页'\n" +
            "      Sound:\n" +
            "        Display Name: '&d&n<sound>'\n" +
            "        Lore: ' 点击播放'\n" +
            "      Stop Sound:\n" +
            "        Display Name: '&6&l停止音效'\n" +
            "        Lore: ' 停止当前播放'\n" +
            "    Title: '&8音效列表 页 &c<page>&8 / &c<totalpages>&8'\n" +
            "  Page: 页\n" +
            "\n" +
            "Play:\n" +
            "  Error:\n" +
            "    Invalid Sound: '&c声音名 \"&7<sound>&c\" 名称不合法'\n" +
            "    Not A Section: '&c文件 &7<file>&c &c里的设置项 \"&7<section>&c\" 不是一个合法音效名称'\n" +
            "    Unauthorized: '&c无法打开此文件夹'\n" +
            "    Unavailable: '&c声音名 <sound> 不适用于当前Minecraft版本'\n" +
            "  Pitch: 音调\n" +
            "  Sound: 音效\n" +
            "  Success:\n" +
            "    Config: '&7播放音效： &f<sound>&7 来自文件： &f<file>&7 对应玩家： &f<player>&7.'\n" +
            "    Default: '&7播放音效： &f<sound>&7 音量： &f<volume>&7 音调： &f<pitch>&7 对应玩家： &f<player>&7.'\n" +
            "  Volume: 音量\n" +
            "\n" +
            "Region:\n" +
            "  Create:\n" +
            "    Default Description: 声音播放区域\n" +
            "    Error:\n" +
            "      Already Exists: '&c此名称已被占用'\n" +
            "      Default: '&c创建区域 \"&7<name>&c\" 时失败.'\n" +
            "      Different Worlds: '&c选区不在同一个世界内'\n" +
            "      Max Area: '&c选区过大，边长不得超过 <max> 方块'\n" +
            "      Max Regions: '&c无法创建超过 <max> 个区域'\n" +
            "      Not Selected: '&c您尚未选择坐标！请输入 &7&n/<label> <label2> wand&c 来获得区域选择工具！'\n" +
            "    Success: '&a区域 &7<name>&a 已创建'\n" +
            "  General:\n" +
            "    Error:\n" +
            "      Illegal Characters: '&c区域名称只支持英文+数字组合.'\n" +
            "      Max Name Characters: '&c区域名称不得超过 <max> 个字符'\n" +
            "      Not Found:\n" +
            "        Name: '&c区域未找到，请使用 &7/<label> <label2> list&c 查询区域列表'\n" +
            "        UUID: '&c区域UUID未找到，请使用 &7/<label> <label2> list&c 查询区域列表'\n" +
            "      Save: '&c保存区域 <name> 时出现错误，请联系管理员'\n" +
            "  Info:\n" +
            "    Creation Date: '&7创建日期:&f <date>'\n" +
            "    Description: '&7描述:&f <description>'\n" +
            "    Error:\n" +
            "      No Regions: '&7这里没有音效区域'\n" +
            "    Header: '&8区域信息 &f<name>&8:'\n" +
            "    Id: '&7UUID:&f <uuid>'\n" +
            "    Owner: '&7创建者:&f <owner>'\n" +
            "    World: '&7世界:&f <world>'\n" +
            "  List:\n" +
            "    Error:\n" +
            "      No Regions: '&c<targets> 没有区域'\n" +
            "      Not Exists: '&c页码 &7<page>&c 不存在，最大页码: <totalPages>.'\n" +
            "    Footer: '&8请输入 &7/<label> <label2> <label3> <label4> <next>&8 查看其它区域'\n" +
            "    Header:\n" +
            "      Default: '&8你的区域 [页 <page> / <totalPages>]:'\n" +
            "      Player: '&8<targets>的区域 [页 <page> / <totalPages>]:'\n" +
            "    Region: '&7- <name>: &f<uuid>'\n" +
            "  Region: 区域\n" +
            "  Remove:\n" +
            "    Confirm: '&a请输入 &7/<label> confirm&a 确认删除区域 &7<region>&a.'\n" +
            "    Description: 删除区域 <region>\n" +
            "    Success: '&a区域 &7<region>&a 已删除'\n" +
            "  Rename:\n" +
            "    Error:\n" +
            "      Already Exists: '&c该名字已被占用'\n" +
            "      Same: '&c新名字需要与原名字不同'\n" +
            "    New Name: 新名字\n" +
            "    Success: '&a区域 <region> 已更名为 &7<newName>&a.'\n" +
            "  Select:\n" +
            "    Error:\n" +
            "      Overlap: '&c选区内已经有区域了！请检查选区！'\n" +
            "  Set:\n" +
            "    Description:\n" +
            "      Error:\n" +
            "        Max Characters: '&c区域描述不可以超过 100 字符'\n" +
            "      Success: '&a区域 <region> 的描述已设置为 &7<description>&a.'\n" +
            "    Select:\n" +
            "      Error:\n" +
            "        Not A World: '&c输入参数 &7<value>&c 不是一个合法世界名'\n" +
            "      Position:\n" +
            "        First: '&6第一个点已选择! 世界: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "        Second: '&6第二个点已选择! 世界: &e<w>&6, X: &e<x>&6, Y: &e<y>&6, Z: &e<z>&6.'\n" +
            "  Teleport:\n" +
            "    Success: '&a已传送至区域 <region>.'\n" +
            "  Wand:\n" +
            "    Error:\n" +
            "      Config: '&c配置文件没有设定完成，无法获得区域选择工具，请检查配置文件'\n" +
            "    Success: '&6区域选择工具: 左键点击选择第一个点，右键选择第二个点'\n" +
            "\n" +
            "Reload:\n" +
            "  Error: '&c加载配置时出现错误，更多音效插件已强制关闭，请检查配置'\n" +
            "  Success: '&a插件已重载 汉化 by 秋风残叶'\n" +
            "\n" +
            "Resource Packs:\n" +
            "  Error: '&c请求 <player> 下载材质包时出现错误'\n" +
            "  Download Failed:\n" +
            "    Failed: '&c材质包下载失败，想体验本服务器全部玩法请尝试重新登录并重新下载该材质包，若还是无法下载，请联系服务器管理员。'\n" +
            "    Administrator: '&c玩家 <player> 尝试进入服务器但下载材质包失败，可输入 &7&n/pms confirm&c 来让玩家跳过材质包下载环节进入服务器'\n" +
            "    Confirmation: '允许 <player> 进服'\n" +
            "  Kick Message:\n" +
            "    Declined: '&c你必须下载材质包才能进服游戏'\n" +
            "    Download Fail: '&c材质包下载失败，请尝试重新登录'\n" +
            "  Request Message: '&e请下载材质包后继续'\n" +
            "\n" +
            "Stop Sound:\n" +
            "  Success:\n" +
            "    All: '&7停止所有正在播放到 &f<target>&7 的声音'\n" +
            "    Default: '&7停止从 &f<sounds>&7 到 &f<target>&7 播放声音'\n" +
            "\n" +
            "Toggle:\n" +
            "  Check:\n" +
            "    Disabled:\n" +
            "      Default: '&c该音效已禁用'\n" +
            "      Player: '&c玩家 &f<player>&c 已禁用'\n" +
            "    Enabled:\n" +
            "      Default: '&a该音效已启用'\n" +
            "      Player: '&a玩家 &f<player>&a 的音效已启用'\n" +
            "  Disabled:\n" +
            "    Default: '&c音效已关闭'\n" +
            "    Player: '&c已将 &f<target>&c 的音效关闭!'\n" +
            "  Enabled:\n" +
            "    Default: '&a音效已打开!'\n" +
            "    Player: '&a已将 &f<target>&a 的音效打开!'\n" +
            "\n" +
            "Update:\n" +
            "  Available: '&2PlayMoreSounds v<version> 新版本已可用，建议输入 &7/<label> update download&2 来下载新版本'\n" +
            "  Check: '&e检查更新...'\n" +
            "  Download:\n" +
            "    Checking: '&7检查插件更新...'\n" +
            "    Confirmation:\n" +
            "      Not Latest:\n" +
            "        Deleted: '&a旧下载版本的 PlayMoreSounds 已删除'\n" +
            "        Description: '删除旧版本的插件更新下载文件'\n" +
            "      Not Supported:\n" +
            "        Deleted: '&a不支持版本的 PlayMoreSounds 已删除'\n" +
            "        Description: '删除不支持版本的插件更新下载文件'\n" +
            "    Deleted Downloaded: '&7已找到一个已下载的更新，正在删除它并重新下载'\n" +
            "    Downloading:\n" +
            "      Default: '&7插件更新可用，正在下载...'\n" +
            "      Forcefully: '&7正在下载最新版本的 PlayMoreSounds...'\n" +
            "    Error:\n" +
            "      Not Latest: '&c你已下载的 PlayMoreSounds 插件版本 &f<downloaded>&c 比当前安装的版本: &f<current>&c 还要旧，请输入 &f&n/pms confirm&c 将此旧版本删除'\n" +
            "      Not Supported: '&c你已下载的插件版本是为 Spigot &f<apiversion>&c 准备的，而你运行的是 Spigot &f<current>&c. 如果你坚持安装, PlayMoreSounds 将停止运行，请输入 &f&n/pms confirm&c 来将不支持版本的插件删除'\n" +
            "    Success: '&aPlayMoreSounds v<version> 已成功下载，将在下次关服重启时自动安装'\n" +
            "  Error:\n" +
            "    Default: '&c更新失败，请检查网络'\n" +
            "    Offline: '&c您当前未连接网络，或者您的防火墙拦截了联网请求，更新失败'\n" +
            "    Timeout: '&c连接超时，请检查网络'\n" +
            "  Not Available: '&e没有可用更新'", StaticFields.version5_0),
    REGIONS(PlayMoreSoundsCore.getFolder().resolve("regions.yml"), "# PlayMoreSounds regions data file.\n" +
            "# Do not edit this file manually.\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_0_0),
    SOUNDS(PlayMoreSoundsCore.getFolder().resolve("sounds.yml"), "###########################################################################################################\n" +
            "# Set a sound to play when an event is triggered.                                                         #\n" +
            "#                                                                                                         #\n" +
            "# Create a section with the name of the event you want to play a sound, for example:                      #\n" +
            "#                                                                                                         #\n" +
            "Teleport: # The event that when triggered, a sound will be played.                                        #\n" +
            "  # Cancellable prevents the sound from playing if another plugin cancelled the event. This boolean helps #\n" +
            "  #sounds be compatible with other plugins.                                                               #\n" +
            "  Cancellable: true                                                                                       #\n" +
            "  # Enables or disables a sound. In sounds.yml when this boolean is set to false the event is unregistered#\n" +
            "  #as well, so you can use this plugin if you want to play sounds just for one event and don't worry about#\n" +
            "  #performance being spent on things you don't use.                                                       #\n" +
            "  Enabled: true                                                                                           #\n" +
            "  # This is a list of sounds that will be played. You can copy and paste the options below to play        #\n" +
            "  #multiple sounds, each section must have a different name, here I numbered them just for organization.  #\n" +
            "  Sounds:                                                                                                 #\n" +
            "    '1':                                                                                                  #\n" +
            "      # The category this sound will be played. You can find available categories in file                 #\n" +
            "      #'available sounds.txt'.                                                                            #\n" +
            "      Category: MASTER                                                                                    #\n" +
            "      # This is a delay in ticks the sound will wait before playing. Set to 0 for no delay.               #\n" +
            "      Delay: 0                                                                                            #\n" +
            "      # Sounds can have multiple options, all of them are optional.                                       #\n" +
            "      Options:                                                                                            #\n" +
            //"        # Global location makes so the sound location is always the player who's hearing it, instead of   #\n" +
            //"        #the location the event was triggered. This makes so sounds with Radius -2 for example, are heard #\n" +
            //"        #by all players in the world, no matter their distance. (Radius -1 always has Global Location on.)#\n" +
            //"        Global Location: false                                                                            #\n" +
            "        # Even if a player has toggled their sounds off using \"/pms toggle\", the sound will be played.    #\n" +
            "        Ignores Disabled: false                                                                           #\n" +
            "        # The sound will be only played if the player has this permission.                                #\n" +
            "        # In case the event is not triggered by a player, this option is ignored.                         #\n" +
            "        Permission Required: 'playmoresounds.reproduce.teleport'                                          #\n" +
            "        # The sound will be only listened by who have this permission.                                    #\n" +
            "        # In case this is a Radius sound and the player has the Permission Required and not               #\n" +
            "        #Permission To Listen, the sound will be played anyway, but only those in the Radius with the     #\n" +
            "        #Permission To Listen will hear.                                                                  #\n" +
            "        Permission To Listen: 'playmoresounds.listen.teleport'                                            #\n" +
            "        # A range of blocks the sound will be hearable.                                                   #\n" +
            "        # A distance in blocks is calculated to every player in the world if the value is greater than 0. #\n" +
            "        # If you want the sound to play only to the player who triggered the event, set this to 0.        #\n" +
            "        # If you want the sound to play to everyone online in the server, set this to -1.                 #\n" +
            "        # If you want the sound to play to everyone in the event's world, set this to -2.                 #\n" +
            "        Radius: 15.2                                                                                      #\n" +
            "      # What the sound pitch is, values greater than 2 have no difference.                                #\n" +
            "      Pitch: 1.0                                                                                          #\n" +
            "      # You can set this to either a Sound Type or a Custom Sound.                                        #\n" +
            "      # Custom sounds do not need to be listed anywhere in the plugin, just set this value to the name of #\n" +
            "      #custom sound you set in your resource pack's sounds.json.                                          #\n" +
            "      # PlayMoreSounds' sound types are different than bukkit's sound types, PlayMoreSounds' sound types  #\n" +
            "      #are always the same no matter which version of the server you are running, so sounds have the same #\n" +
            "      #names in all versions.                                                                             #\n" +
            "      # You can find a list of available sounds for the version " + EpicPluginLib.Platform.getVersion() + " in the file 'available sounds.txt'." + PMSHelper.repeatChar(' ', 6 - EpicPluginLib.Platform.getVersion().toString().length()) + "#\n" +
            "      Sound: ENTITY_ENDERMAN_TELEPORT                                                                     #\n" +
            "      # The volume of the sound. The way minecraft does it is by distance, volume 1 = ~15 blocks.         #\n" +
            "      # If you are playing region sounds you might want to set this to a big number so it plays with the  #\n" +
            "      #same volume the whole region.                                                                      #\n" +
            "      # You will notice the volume go lower if you set it to a decimal lower than 1.                      #\n" +
            //"      # Set to -1 to use the maximum possible volume.                                                     #\n" +
            "      Volume: 0.9                                                                                         #\n" +
            "#                                                                                                         #\n" +
            "# Any of the above options are optional, here's an example of a sound that doesn't need to use all of     #\n" +
            "#these options:                                                                                           #\n" +
            "Player Death:                                                                                             #\n" +
            "  Enabled: true                                                                                           #\n" +
            "  Sounds:                                                                                                 #\n" +
            "    '1':                                                                                                  #\n" +
            "      Sound: ENTITY_WITHER_SPAWN                                                                          #\n" +
            "#                                                                                                         #\n" +
            "# If you don't want to use a sound, you can either completely remove it from this configuration or set    #\n" +
            "#'Enabled' to false, like this:                                                                           #\n" +
            "Bed Leave:                                                                                                #\n" +
            "  Enabled: false # Disabled sounds will be unregistered and not affect server performance.                #\n" +
            "#                                                                                                         #\n" +
            "# If you have any other doubts on how to set this configuration up, feel free to ask in PlayMoreSounds'   #\n" +
            "#Discord: https://discord.gg/eAHPbc3                                                                      #\n" +
            "###########################################################################################################\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "' # Configuration version, don't change if you don't want your configuration reset.\n" +
            "\n" +
            "# When a player lies in bed.\n" +
            "# This sound is cancellable.\n" +
            "Bed Enter:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 15.0\n" +
            "      Pitch: 0.65\n" +
            "      Sound: ENTITY_VILLAGER_AMBIENT\n" +
            "      Volume: 0.5\n" +
            "\n" +
            "# When a player changes the item slot of the hotbar.\n" +
            "# This sound is cancellable.\n" +
            "Change Held Item:\n" +
            "  Enabled: true\n" +
            "  Cancellable: false\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Pitch: 2.0\n" +
            "      Sound: BLOCK_NOTE_BLOCK_HAT\n" +
            "\n" +
            "# When a player changes their level of experience.\n" +
            "# This sound is disabled by default. To enable it, copy the options from the sound above and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is not cancellable.\n" +
            "Change Level:\n" +
            "  Enabled: false\n" +
            "\n" +
            "# When a player crafts an item.\n" +
            "# This sound is disabled by default. To enable it, copy the options from another sound and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Craft Item:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a player drops an item.\n" +
            "# This sound is cancellable.\n" +
            "Drop Item:\n" +
            "  Enabled: true\n" +
            "  Cancellable: false\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 15.0\n" +
            "      Sound: ENTITY_EGG_THROW\n" +
            "      Volume: 0.5\n" +
            "\n" +
            "# When a player edits or creates a book using a book and quill.\n" +
            "# This sound is cancellable.\n" +
            "Edit Book:\n" +
            "  Enabled: true\n" +
            "  Cancellable: false\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 10.0\n" +
            "      Pitch: 2.0\n" +
            "      Sound: ITEM_ARMOR_EQUIP_LEATHER\n" +
            "      Volume: 0.4\n" +
            "\n" +
            "# When an entity is hit by another entity.\n" +
            "# This sound is cancellable.\n" +
            "Entity Hit:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 16.0\n" +
            "      Pitch: 2.0\n" +
            "      Sound: ENTITY_GENERIC_HURT\n" +
            "      Volume: 0.9\n" +
            "\n" +
            "# When any entity jumps.\n" +
            "# This sound only plays if you are running PaperMC.\n" +
            "# This sound is disabled by default. To enable it, copy the options from the sound\n" +
            "#above and set 'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Entity Jump:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a player joins the server for the first time.\n" +
            "# This sound is not cancellable.\n" +
            "First Join:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -1.0\n" +
            "      Pitch: 2.0\n" +
            "      Sound: BLOCK_NOTE_BLOCK_PLING\n" +
            "\n" +
            "# When a player extracts something from a furnace.\n" +
            "# This sound is not cancellable.\n" +
            "Furnace Extract:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 15.0\n" +
            "      Pitch: 1.3\n" +
            "      Sound: ENTITY_GENERIC_EXTINGUISH_FIRE\n" +
            "      Volume: 0.5\n" +
            "\n" +
            "# When a player changes their game mode.\n" +
            "# This sound is cancellable.\n" +
            "Game Mode Change:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Sound: BLOCK_ANVIL_LAND\n" +
            "      Volume: 0.4\n" +
            "\n" +
            "# When a player clicks on an inventory.\n" +
            "# This sound is cancellable.\n" +
            "Inventory Click:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Pitch: 1.5\n" +
            "      Sound: BLOCK_COMPARATOR_CLICK\n" +
            "      Volume: 0.4\n" +
            "\n" +
            "# When a player closes an inventory.\n" +
            "# This sound is not cancellable.\n" +
            "Inventory Close:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Pitch: 2.0\n" +
            "      Sound: UI_TOAST_OUT\n" +
            "\n" +
            "# When a player joins the server.\n" +
            "# This sound is not cancellable.\n" +
            "Join Server:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -1.0\n" +
            "      Sound: BLOCK_NOTE_BLOCK_PLING\n" +
            "\n" +
            "# When a player leaves the server.\n" +
            "# This sound is not cancellable.\n" +
            "Leave Server:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -1.0\n" +
            "      Sound: BLOCK_NOTE_BLOCK_BASS\n" +
            "\n" +
            "# When a player bans another player from the server.\n" +
            "# This sound is not cancellable.\n" +
            "Player Ban:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -1.0\n" +
            "      Pitch: 1.3\n" +
            "      Sound: ENTITY_ENDER_DRAGON_DEATH\n" +
            "\n" +
            "# When a player sends a message on chat.\n" +
            "# This sound is cancellable.\n" +
            "Player Chat:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -1.0\n" +
            "      Sound: ENTITY_ITEM_PICKUP\n" +
            "\n" +
            "# When a player is kicked from the server.\n" +
            "# This sound is cancellable.\n" +
            "Player Kicked:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -1.0\n" +
            "      Pitch: 1.3\n" +
            "      Sound: ENTITY_ENDER_DRAGON_HURT\n" +
            "\n" +
            "# When a player kills another player. (Damager)\n" +
            "# This sound is disabled by default. To enable it, copy the options from the sound above and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is not cancellable.\n" +
            "Player Kill:\n" +
            "  Enabled: false\n" +
            "\n" +
            "# When a player is killed by another player. (Victim)\n" +
            "# This sound is disabled by default. To enable it, copy the options from another sound and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is not cancellable.\n" +
            "Player Killed:\n" +
            "  Enabled: false\n" +
            "  # Prevents the default 'Player Death' and sounds from 'death types.yml' from playing.\n" +
            "  Prevent Death Sounds: true\n" +
            "\n" +
            "# When a player jumps.\n" +
            "# This sound only plays if you are running PaperMC.\n" +
            "# This sound is disabled by default. To enable it, copy the options from another sound and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Player Jump:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a player swings their hand.\n" +
            "# This sound is disabled by default. To enable it, copy the options from another sound and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Player Swing:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a nether portal is opened.\n" +
            "# This sound is cancellable.\n" +
            "Portal Create:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 15.0\n" +
            "      Pitch: 0.8\n" +
            "      Sound: BLOCK_END_PORTAL_SPAWN\n" +
            "      Volume: 0.8\n" +
            "\n" +
            "# When a player enters a PlayMoreSounds region.\n" +
            "# This sound can also be played when entering another plugin's region. To do that you need to\n" +
            "#install addons.\n" +
            "# This sound is disabled by default. To enable it, copy the options from the sound above and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Region Enter:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "  # This sound can be stopped when the player leaves the region.\n" +
            "  Stop On Exit:\n" +
            "    Enabled: true\n" +
            "    Delay: 20 # The time in ticks to wait before stopping the sound\n" +
            "\n" +
            "# When a player leaves a PlayMoreSounds region.\n" +
            "# This sound can also be played when leaving another plugin's region. To do that you need to\n" +
            "#install addons.\n" +
            "# This sound is disabled by default. To enable it, copy the options from another sound and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Region Leave:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a player respawns.\n" +
            "# This sound is disabled by default. To enable it, copy the options from another sound and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is not cancellable.\n" +
            "Respawn:\n" +
            "  Enabled: false\n" +
            "\n" +
            "# When a player sends a command.\n" +
            "# This sound is cancellable.\n" +
            "Send Command:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Pitch: 2.0\n" +
            "      Sound: ENTITY_ITEM_PICKUP\n" +
            "\n" +
            "# When a player starts flying.\n" +
            "# This sound is cancellable.\n" +
            "Start Flying:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 12.0\n" +
            "      Sound: BLOCK_PISTON_EXTEND\n" +
            "      Volume: 0.5\n" +
            "\n" +
            "# When a player stops flying.\n" +
            "# This sound is cancellable.\n" +
            "Stop Flying:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 12.0\n" +
            "      Sound: BLOCK_PISTON_CONTRACT\n" +
            "      Volume: 0.5\n" +
            "\n" +
            "# When the player moves their current item to their off hand.\n" +
            "# This sound is cancellable.\n" +
            "Swap Hands:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Pitch: 1.3\n" +
            "      Sound: ITEM_ARMOR_EQUIP_GENERIC\n" +
            "\n" +
            "# When a player crouches.\n" +
            "# This sound is disabled by default. To enable it, copy the options from the sound above and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Toggle Sneak:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a player gets out of bed and is morning.\n" +
            "# This sound is not cancellable.\n" +
            "Wake Up:\n" +
            "  Enabled: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Sound: ENTITY_CHICKEN_HURT\n" +
            "      Volume: 0.4\n" +
            "\n" +
            "# When it starts raining on the world.\n" +
            "# This sound is cancellable.\n" +
            "Weather Rain:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: -2.0 # This sound is played in the world's spawn if the radius is greater than 0.\n" +
            "      Sound: ITEM_ELYTRA_FLYING\n" +
            "      Volume: 0.3\n" +
            "\n" +
            "# When it stops raining on the world.\n" +
            "# This sound is disabled by default. To enable it, copy the options from the sound above and set\n" +
            "#'Enabled' to true.\n" +
            "# This sound is cancellable.\n" +
            "Weather Rain End:\n" +
            "  Enabled: false\n" +
            "  Cancellable: true\n" +
            "\n" +
            "# When a player teleports to a different world.\n" +
            "# This sound is cancellable.\n" +
            "World Change:\n" +
            "  Enabled: true\n" +
            "  Cancellable: true\n" +
            "  # Makes so when the player teleports to a different world, the default sound of 'Teleport' does\n" +
            "  #not play.\n" +
            "  Prevent Teleport Sound: true\n" +
            "  Sounds:\n" +
            "    '1':\n" +
            "      Options:\n" +
            "        Radius: 15.2\n" +
            "      Pitch: 2.0\n" +
            "      Sound: BLOCK_PORTAL_TRAVEL\n" +
            "      Volume: 0.6", StaticFields.version4_0_0),
    WORLD_TIME_TRIGGERS(StaticFields.sounds.resolve("world time triggers.yml"), "# Set a sound to play when a world reaches a specific time of the day.\n" +
            "#\n" +
            "#world: # The name of the world that you want to track time.\n" +
            "#  '13000': # The time that you want to play a sound.\n" +
            "#    Enabled: true\n" +
            "#    Sounds:\n" +
            "#      '0':\n" +
            "#        Delay: 0\n" +
            "#        Options:\n" +
            "#          Radius: -2.0 # The radius is counted by the world's spawn location. Set to -2 so everyone in the world can hear it.\n" +
            "#        Pitch: 1.0\n" +
            "#        Sound: 'AMBIENT_CAVE'\n" +
            "#        Volume: 10.0\n" +
            "#\n" +
            "# More information about sounds on sounds.yml\n" +
            "\n" +
            "Version: '" + PlayMoreSoundsVersion.version + "'", StaticFields.version3_0_0);

    private static final @NotNull ConfigurationLoader configurationLoader = new ConfigurationLoader();

    static {
        for (var configuration : Configurations.values()) {
            configurationLoader.registerConfiguration(configuration.configurationHolder, configuration.minVersion, PlayMoreSoundsVersion.getVersion());
        }
    }

    private final @NotNull ConfigurationHolder configurationHolder;
    private final @NotNull Version minVersion;

    Configurations(@NotNull Path path, @NotNull String contents, @NotNull Version minVersion) {
        this.configurationHolder = new ConfigurationHolder(path, contents);
        this.minVersion = minVersion;
    }

    public static @NotNull ConfigurationLoader getConfigurationLoader() {
        return configurationLoader;
    }

    public @NotNull ConfigurationHolder getConfigurationHolder() {
        return configurationHolder;
    }

    private static class StaticFields {
        private static final @NotNull Path sounds = PlayMoreSoundsCore.getFolder().resolve("Sounds");
        private static final @NotNull Path lang = PlayMoreSoundsCore.getFolder().resolve("Language");
        // These versions are used to set the configurations' minimum versions.
        private static final @NotNull Version version3_0_0 = new Version("3.0.0");
        private static final @NotNull Version version3_2_0 = new Version("3.2.0");
        private static final @NotNull Version version3_3_0 = new Version("3.3.0");
        private static final @NotNull Version version4_0_0 = new Version("4.0.0");
        private static final @NotNull Version version5_0 = new Version("5.0");
    }
}
