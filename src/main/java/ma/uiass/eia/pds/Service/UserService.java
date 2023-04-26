package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.User;
import ma.uiass.eia.pds.Repository.IUserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IService<User> {
    private IUserRepository IUserRepository;
    @Override
    public void ajouter(User user) {
        IUserRepository.saveAndFlush(user);
    }

    @Override
    public List<User> afficherTout() {
        return IUserRepository.findAll();
    }

    @Override
    public User trouverId(int id) {
        return IUserRepository.getById(id);
    }
}
