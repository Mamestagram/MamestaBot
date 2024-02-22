package net.mamesosu.Utils;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public abstract class Log {

    private static String getLogInfo(int level) {

        LocalDateTime nowDate = LocalDateTime.now();
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");

        switch (level) {
            case 0 -> {
                return "[" + dtf.format(nowDate) + ": Normal] ";
            }
            case 1 -> {
                return "[" + dtf.format(nowDate) + ": Warning] ";
            }
            default -> {
                return "[" + dtf.format(nowDate) + ": Error] ";
            }
        }
    }

    public static void setLogger(String msg, int level) {

        System.out.println(getLogInfo(level) + msg);
    }
}
