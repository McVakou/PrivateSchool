package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 *
 * @author mcvakou
 */
public class DbUtils {

    private static final String MYSQLURL
            = "jdbc:mysql://localhost:3306/project_private_school?"
            + "zeroDateTimeBehavior=CONVERT_TO_NULL"
            + "&useUnicode=true"
            + "&useJDBCCompliantTimezoneShift=true"
            + "&useLegacyDatetimeCode=false"
            + "&serverTimezone=UTC"
            + "&allowPublicKeyRetrieval=true"
            + "&useSSL=false";

    private static String username = "root";
    private static String password = "root";

    public static Connection getConnection() throws SQLException {
        Connection con = null;
        con = DriverManager.getConnection(MYSQLURL, username, password);
        //System.out.println("Connected!");
        return (con);
    }
}
