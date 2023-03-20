package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Batiment;
import ma.uiass.eia.pds.Service.BatimentService;
import ma.uiass.eia.pds.Service.IBatimentService;

import java.util.List;

@Path("/batiment")
public class BatimentController {
    IBatimentService batimentService = new BatimentService();
    @GET
    @Path("/getbatiments")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Batiment> getBatiments(){
     return batimentService.afficherTout();
    }

}
