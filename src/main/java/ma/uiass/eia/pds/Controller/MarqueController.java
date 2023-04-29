package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Marque;
import ma.uiass.eia.pds.Service.ChambreService;
import ma.uiass.eia.pds.Service.IEspaceService;
import ma.uiass.eia.pds.Service.IMarqueService;
import ma.uiass.eia.pds.Service.MarqueService;

import java.util.List;

@Path("/marque")
public class MarqueController {

    IMarqueService marqueService = new MarqueService();

    @GET
    @Path("/getmarques")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Marque> getmarques(){
        return marqueService.afficherTout();
    }

    @POST
    @Path("/addmarque")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addChambre(Marque marque){
        marqueService.ajouter(marque);
    }
}