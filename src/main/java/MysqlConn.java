import org.apache.log4j.Logger;
import java.sql.*;

public class MysqlConn {

    final static Logger log = Logger.getLogger(MysqlConn.class.getName());

    public static Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/dsa", "root", "DSA2019");
        } catch (Exception e) {
            log.error("Error exception");
            e.printStackTrace();
            throw e;
        }
    }

    public static void getUsers(Connection conn) throws Exception {
        Statement stmt = conn.createStatement();
        ResultSet rs = stmt.executeQuery("SELECT * FROM User");
        while (rs.next()) log.info("ID: " + rs.getString(1) + " Username: " + rs.getString(2) + " Password: " + rs.getString(3));
        stmt.close();
    }

    public static void insertUsers(Connection conn) throws Exception {
        Statement stmt = conn.createStatement();
        stmt.execute("INSERT INTO User (id, Nombre, Apellido) VALUES ('hola','Adria', 'Navarrete')");
        stmt.close();
    }

    public static void main(String[] args) throws Exception {
        Connection conn = null;
        try {
            conn = getConnection();
            System.out.println("OK");
            insertUsers(conn);
            getUsers(conn);
        }
        catch (Exception e) {
            e.printStackTrace();
        }
        finally {
            if (conn!=null) conn.close();
        }
    }
}