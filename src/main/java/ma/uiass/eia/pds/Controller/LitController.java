package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.*;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.List;

@Path("/lit")
public class LitController {

    ILitService service = new LitService();


    @GET
    @Path("/getlits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLit(){
        return service.afficherTout();
    }


    @POST
    @Path("/addlit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLit(Lit lit){
        System.out.println(lit);
        service.ajouter(lit);
    }

    @GET
    @Path("/count/{occupation}")
    @Produces(MediaType.APPLICATION_JSON)
    public Long countOccupation(
     @PathParam("occupation") String occupation){

        return  service.countOccupation(Boolean.parseBoolean(occupation));
    }

}
