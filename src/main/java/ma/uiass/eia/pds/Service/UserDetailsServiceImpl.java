package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.User;
import ma.uiass.eia.pds.Repository.UserRepository;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {
    private UserRepository userRepository;
    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("Username " +username + " not Found");
        }
        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(), getGrantedAuthority(user));
    }
    private Collection<GrantedAuthority> getGrantedAuthority(User user){
        Collection<GrantedAuthority> authorities = new ArrayList<>();
        if (user.getRole().name().equalsIgnoreCase("admin")){
            authorities.add(new SimpleGrantedAuthority("ROlE_ADMIN"));
        }
        authorities.add(new SimpleGrantedAuthority("ROLE_USER"));
        return authorities;
    }
}
