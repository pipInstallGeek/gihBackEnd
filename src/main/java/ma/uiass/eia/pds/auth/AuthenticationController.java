package ma.uiass.eia.pds.auth;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import org.springframework.web.bind.annotation.RestController;

@Path("/auth")
@RestController
public class AuthenticationController {

    private final AuthenticationService service;

    public AuthenticationController(AuthenticationService service) {
        this.service = service;
    }

    @POST
    @Path("/authentication")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response authenticate(AuthenticationRequest authenticationRequest){

        return Response.ok(service.authenticate(authenticationRequest)).build();
    }
    @POST
    @Path("/register")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response register(RegisterRequest registerRequest){

        return Response.ok(service.register(registerRequest)).build();
    }
}
