package net.mamesosu.osu;

import java.lang.reflect.Member;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import net.mamesosu.Load.MySQL;
import net.mamesosu.Main;
import net.mamesosu.Setting;

public abstract class User {

    private static Setting APP = Main.APP_SETTINGS;

    public static ResultSet getUser(String name, Member m, int mode) throws SQLException {

        List<String> d = new ArrayList<>();
        Connection connection = MySQL.getConnection(APP.getDB_HOST(), APP.getDB_NAME(), APP.getDB_USER(), APP.getDB_PASSWORD());

        PreparedStatement ps;
        ResultSet result;

        ps = connection.prepareStatement("select * from users u join stats s where s.id = u.id and u.name in (?, ?)");
        ps.setString(1, name);
        ps.setString(2, m.getName());

        result = ps.executeQuery();

        connection.close();

        return result;
    }

    public static int getCountryRank(int id, int mode) throws SQLException {

        Connection connection = MySQL.getConnection(APP.getDB_HOST(), APP.getDB_NAME(), APP.getDB_USER(), APP.getDB_PASSWORD());

        PreparedStatement ps;
        ResultSet result;

        ps = connection.prepareStatement("SELECT COUNT(*) + 1 AS 'cranking' " +
                "FROM stats " +
                "JOIN users " +
                "ON stats.id = users.id " +
                "WHERE pp > ( " +
                "    SELECT pp " +
                "    FROM stats " +
                "    WHERE id = ? " +
                "    AND mode = ? " +
                "    AND country = ( " +
                "        SELECT country " +
                "        FROM users " +
                "        WHERE id = ? " +
                "        AND mode = ? " +
                "    ) " +
                ") " +
                "AND mode = ? " +
                "AND users.priv != 2");
        ps.setInt(1, id);
        ps.setInt(2, mode);
        ps.setInt(3, id);
        ps.setInt(4, mode);
        ps.setInt(5, mode);

        result = ps.executeQuery();

        if(result.next()) {
            return result.getInt("cranking");
        } else {
            return 0;
        }
    }
}
