public class UsersDAOImpl implements UsersDAO {
    public void addUser(String name, String apellido) throws Exception {
        try  {
            Session a = Factoria.getSession();
            Usuario u = new Usuario(name, apellido);
            a.save(u);

            }catch (Exception e){
              throw e;
            }
    }
 }

