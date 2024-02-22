package net.mamesosu.Utils;

import java.awt.*;

public abstract class Discord {

    public static Color getMessageColor(String grade) {

        switch (grade) {
            case "XH", "SH" -> {
                return Color.WHITE;
            }
            case "X", "S" -> {
                return Color.YELLOW;
            }
            case "A" -> {
                return Color.GREEN;
            }
            case "B" -> {
                return Color.CYAN;
            }
            case "C" -> {
                return Color.PINK;
            }
            default -> {
                return Color.RED;
            }
        }
    }
}
