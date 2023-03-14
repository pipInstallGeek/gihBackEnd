package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Service.ChambreService;
import ma.uiass.eia.pds.Service.IChambreService;

import java.util.List;

@Path("/chambre")
public class ChambreController {
    IChambreService service = new ChambreService();

    @GET
    @Path("/getChambres")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chambre> getChambres(){
        return service.afficheChambres();
    }

    @POST
    @Path("/addChambre")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addChambre(Chambre chambre){
        service.ajouterChambre(chambre);
    }
}
