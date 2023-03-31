package ma.uiass.eia.pds.auth;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {


    private String username;
    private String fullname;
    private String Role;
    private String password;

}
