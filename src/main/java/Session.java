import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.*;

public class Session {

    Connection session = null;
    Statement statement = null;
    PreparedStatement preparedStatement = null;
    ResultSet resultSet = null;

    protected Session(){

        try{
            this.session = getConnection();
        }catch (Exception e){
            e.printStackTrace();
        }

    }

    public void save (Object o) throws SQLException {
        statement = session.createStatement();

        String a = o.getClass().getSimpleName();
        Field[] fields = o.getClass().getDeclaredFields();



    }





    private Connection getConnection() throws Exception {
        try {
            Class.forName("com.mysql.jdbc.Driver").newInstance();
            return DriverManager.getConnection("jdbc:mysql://localhost/dsa", "root", "DSA2019");
        } catch (Exception e) {

            throw e;
        }
    }
}
