package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Service.ChambreService;
import ma.uiass.eia.pds.Service.IEspaceService;

import java.util.List;

@Path("/chambre")
public class ChambreController {
    IEspaceService service = new ChambreService();

    @GET
    @Path("/getchambres")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chambre> getChambres(){
        return service.afficherTout();
    }

    @POST
    @Path("/addchambre")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addChambre(Chambre chambre){
        service.ajouter(chambre);
    }


}