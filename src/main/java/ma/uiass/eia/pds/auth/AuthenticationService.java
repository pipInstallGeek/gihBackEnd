package ma.uiass.eia.pds.auth;

import lombok.RequiredArgsConstructor;
import lombok.var;
import ma.uiass.eia.pds.Config.JwtService;
import ma.uiass.eia.pds.Model.Role;
import ma.uiass.eia.pds.Model.User;
import ma.uiass.eia.pds.Repository.IUserRepository;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private IUserRepository IUserRepository;
    private PasswordEncoder passwordEncoder;
    private JwtService jwtService;
    private AuthenticationManager authenticationManager;

    public String authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        var user = IUserRepository.findByUsername(authenticationRequest.getUsername());
        var jwt = jwtService.generateToken(user);
        return jwt;
    }



    public String register(RegisterRequest registerRequest) {
        var user = User.builder().username(registerRequest.getFullname())
                .fullName(registerRequest.getFullname())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .role(Role.valueOf(registerRequest.getRole()))
                .build();
        IUserRepository.saveAndFlush(user);
        var jwt = jwtService.generateToken(user);
        return jwt;
    }
}
