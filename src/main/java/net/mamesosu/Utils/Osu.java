package net.mamesosu.Utils;

import java.util.ArrayList;

public abstract class Osu {

    public static String getMapStatus(int status) {
        switch (status) {
            case 2 -> {
                return "<:ranked:1143570271974989914> **Ranked**";
            }
            case 3 -> {
                return "<:ranked:1143570271974989914> **Approved**";
            }
            case 4 -> {
                return "<:ranked:1143570271974989914> **Qualified**";
            }
            default -> {
                return "<:loved:1100846331418914857> **Loved**";
            }
        }
    }

    public static String getModsName(int n) {

        ArrayList<String> mod = new ArrayList<>();
        final String[] mods = {"NF", "EZ", "TS", "HD", "HR", "SD", "DT", "RX", "HT", "NC", "FL", "", "SO", "AP", "PF", "4K", "5K", "6K", "7K", "8K", "FD", "RD", "CM", "TG", "9K", "KC", "1K", "3K", "2K", "V2", "MR"};
        StringBuilder rMods = new StringBuilder();

        for (int i = 30; i >= 0; i--) {
            if (i != 2 && i != 11 && n >= Math.pow(2, i)) {
                switch (i) {
                    case 14 -> n -= Math.pow(2, 5);
                    case 9 -> n -= Math.pow(2, 6);
                }
                mod.add(mods[i]);
                n -= Math.pow(2, i);
            }
        }

        for (String s : mod) {
            rMods.append(s);
        }

        if(!rMods.toString().equals("")) {
            return rMods.toString();
        } else {
            return "NM";
        }
    }

    public static int getModeNumber(String mode) {
        switch (mode) {
            case "vn!std" -> {
                return  0;
            }
            case "vn!taiko" -> {
                return 1;
            }
            case "vn!ctb" -> {
                return 2;
            }
            case "vn!mania" -> {
                return 3;
            }
            case "rx!std" -> {
                return 4;
            }
            case "rx!taiko" -> {
                return 5;
            }
            case "rx!ctb" -> {
                return 6;
            }
            case "ap!std" -> {
                return 8;
            }
            default -> {
                return 7; //not happen (rx!mania num)
            }
        }
    }

    public static String getModeName (int mode) {
        switch (mode) {
            case 0 -> {
                return "vn!std";
            }
            case 1 -> {
                return "vn!taiko";
            }
            case 2 -> {
                return "vn!ctb";
            }
            case 3 -> {
                return "vn!mania";
            }
            case 4 -> {
                return "rx!std";
            }
            case 5 -> {
                return "rx!taiko";
            }
            case 6 -> {
                return "rx!ctb";
            }
            case 8 -> {
                return "ap!std";
            }
            default -> {
                return "Unknown";
            }
        }
    }

    public static String getModeEmoji(int mode) {
        switch (mode) {
            case 0, 4, 8 -> {
                return "<:osu:1100702517119168562>";
            }
            case 1, 5 -> {
                return "<:taiko:1100702510152429588>";
            }
            case 2, 6 -> {
                return "<:fruits:1100702512681599089>";
            }
            case 3 -> {
                return "<:mania:1100702514501910630>";
            }
            default -> {
                return null;
            }
        }
    }
}
