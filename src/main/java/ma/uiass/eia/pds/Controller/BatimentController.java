package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Batiment;
import ma.uiass.eia.pds.Service.BatimentService;
import ma.uiass.eia.pds.Service.IBatimentService;

import java.util.List;

@Path("/batiment")
public class BatimentController {
    IBatimentService batimentService = new BatimentService();

    @Path("/addbatiment")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBatiment(Batiment batiment){
        batimentService.ajouter(batiment);
    }

    @GET
    @Path("/getbatiments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Batiment> getBatiments(){
     return batimentService.afficherTout();
    }

}
