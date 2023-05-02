package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.DetailsDemande;
import ma.uiass.eia.pds.Service.DemandeService;
import ma.uiass.eia.pds.Service.IDemandeService;

import java.util.List;

@Path("/demande")
public class DemandeController {
    private IDemandeService demandeService = new DemandeService();

    @GET
    @Path("/getdemande")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Demande> getdetailsdemande(){
        return demandeService.afficherTout();
    }

    @POST
    @Path("/addDemande")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDemande( Demande demande){
        demandeService.ajouter(demande);
    }
}

