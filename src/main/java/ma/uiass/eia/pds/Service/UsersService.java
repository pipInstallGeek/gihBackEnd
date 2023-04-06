package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IUsersDao;
import ma.uiass.eia.pds.Dao.UsersDao;
import ma.uiass.eia.pds.Model.Users;
import java.util.List;
public class UsersService  implements IUsersService{
    IUsersDao usersDao = new UsersDao();
    @Override
    public void ajouter(Users user) {
        usersDao .add(user);
    }
    @Override
    public List<Users> afficherTout() {
        return usersDao .getAll();
    }
    @Override
    public Users trouverId(int id) {
        return usersDao .getById(id);
    }
}
