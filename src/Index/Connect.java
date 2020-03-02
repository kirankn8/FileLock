package Index;

import java.sql.*;

public class Connect {
    Connection conn = null;
    public static Connection ConnectDB() throws ClassNotFoundException, SQLException
    {
        try
        {
            Class.forName("org.sqlite.JDBC");
            Connection conn = DriverManager.getConnection("jdbc:sqlite:filelock.sqlite");
            return conn;
        }
        catch(Exception e)
        {
            return null;
        }
    }
}
