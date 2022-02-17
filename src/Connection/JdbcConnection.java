package Connection;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcConnection {
    private static final String url = "jdbc:mysql://localhost:3306/hotel";
    private static final String user = "";
    private static final String password = "";

    public static Connection getConnection() {
        Connection con;
        try {
            con = DriverManager.getConnection(url, user, password);
            return con;
        } catch (Exception e) {
            System.out.println("Connect Your Database Properly");
            System.exit(0);
        }
        return null;
    }
}
