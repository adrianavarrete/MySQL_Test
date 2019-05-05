public class Main {

    public static void main (String[] args) throws Exception{

        UsersDAO dao = new UsersDAOImpl();

        dao.addUser("adri","pardo");

    }
}
