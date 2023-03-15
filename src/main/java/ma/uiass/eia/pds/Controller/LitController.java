package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Service.ILitService;
import ma.uiass.eia.pds.Service.LitService;

import java.util.List;

@Path("/lit")
public class LitController {

    ILitService service = new LitService();
    @GET
    @Path("/getlits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLit(){
        return service.afficherLits();
    }


    @POST
    @Path("addlit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLit(Lit lit){
        service.ajouterLit(lit);
    }
}
