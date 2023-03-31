package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.User;
import ma.uiass.eia.pds.Repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserService implements IService<User> {
    private UserRepository userRepository;
    @Override
    public void ajouter(User user) {
        userRepository.saveAndFlush(user);
    }

    @Override
    public List<User> afficherTout() {
        return userRepository.findAll();
    }

    @Override
    public User trouverId(int id) {
        return userRepository.getById(id);
    }
}
