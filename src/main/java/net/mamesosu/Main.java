package net.mamesosu;

import net.mamesosu.Load.Bot;
import net.mamesosu.Utils.Log;

public class Main {

    //APP Field
    public static Setting APP_SETTINGS;

    public static void main(String[] args) {

        APP_SETTINGS = new Setting();

        //Start up Discord bot
        APP_SETTINGS.setJda(Bot.buildBot(APP_SETTINGS.getDISCORD_TOKEN()));

        Log.setLogger("Start to listen any request..", 0);
    }
}