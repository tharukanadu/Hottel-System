package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {

    private static DBUtil dbUtil;
    private Connection con;
    private DBUtil() throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.cj.jdbc.Driver");
        con = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/hottel_system",
                "root",
                "12345"
        );
    }
    public static DBUtil getInstance() throws SQLException, ClassNotFoundException {
        if (dbUtil==null){
            dbUtil=new DBUtil();
        }
        return dbUtil;
    }
    public Connection getCon(){
        return this.con;
    }
}
