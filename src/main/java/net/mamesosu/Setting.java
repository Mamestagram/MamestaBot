package net.mamesosu;

import io.github.cdimascio.dotenv.Dotenv;
import net.dv8tion.jda.api.JDA;

public class Setting {

    private JDA jda;
    private final String DB_HOST;
    private final String DB_NAME;
    private final int DB_PORT;
    private final String DB_USER;
    private final String DB_PASSWORD;
    private final String OSU_API_KEY;
    private final String DISCORD_TOKEN;

    public Setting() {

        //file needs to set .env
        Dotenv dotenv = Dotenv.configure()
                .load();

        DB_HOST = dotenv.get("DB_HOST");
        DB_NAME = dotenv.get("DB_NAME");
        DB_PORT = Integer.parseInt(dotenv.get("DB_PORT"));
        DB_USER = dotenv.get("DB_USER");
        DB_PASSWORD = dotenv.get("DB_PASSWORD");
        OSU_API_KEY = dotenv.get("OSU_API_KEY");
        DISCORD_TOKEN = dotenv.get("DISCORD_TOKEN");
    }

    public String getDB_HOST() {
        return DB_HOST;
    }

    public String getDB_NAME() {
        return DB_NAME;
    }

    public int getDB_PORT() {
        return DB_PORT;
    }

    public String getDB_USER() {
        return DB_USER;
    }

    public String getDB_PASSWORD() {
        return DB_PASSWORD;
    }

    public String getOSU_API_KEY() {
        return OSU_API_KEY;
    }

    public String getDISCORD_TOKEN() {
        return DISCORD_TOKEN;
    }

    public void setJda(JDA jda) {
        this.jda = jda;
    }

    public JDA getJda() {
        return jda;
    }
}
