package net.mamesosu.Load;

import net.mamesosu.Utils.Log;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class MySQL {

    public static Connection getConnection(String HOST, String HOST_NAME, String USER, String PASS) throws SQLException {

        Log.setLogger("Trying to connect to MySQL Server", 0);

        return DriverManager.getConnection(
                "jdbc:mysql://" + HOST + "/" + HOST_NAME + "?autoReconnect=true",
                USER,
                PASS
        );
    }
}
