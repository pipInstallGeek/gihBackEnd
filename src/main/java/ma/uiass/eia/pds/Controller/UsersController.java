package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Users;
import ma.uiass.eia.pds.Service.IUsersService;
import ma.uiass.eia.pds.Service.UsersService;

import java.util.List;
@Path("/user")
public class UsersController {
    IUsersService usersService = new UsersService();
    @GET
    @Path("/getusers")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Users> getUsers(){
        return usersService.afficherTout();
    }
    @POST
    @Path("/adduser")
    @Consumes(MediaType.APPLICATION_JSON)
    public void adduser(Users user){
        usersService.ajouter(user);
    }
}
