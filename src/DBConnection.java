import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {

    static Connection con;

    public static Connection getConnection() throws Exception{
        String url = "jdbc:mysql://localhost:3306/library_system";
        String username = "root";
        String password = "Shaikali@270";
//        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(url, username, password);
        return con;
    }
}
