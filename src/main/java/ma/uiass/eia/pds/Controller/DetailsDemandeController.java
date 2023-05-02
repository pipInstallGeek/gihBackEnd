package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsDemande;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Service.DetailsDemandeService;
import ma.uiass.eia.pds.Service.IDetailsDemandeService;

import java.util.List;

@Path("/detailsDemande")
public class DetailsDemandeController {
    IDetailsDemandeService detailsDemandeService= new DetailsDemandeService();

    @GET
    @Path("/getdetailsdemande")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailsDemande> getdetailsdemande(){
        return detailsDemandeService.afficherTout();
    }

    @POST
    @Path("/addDetailsdemande")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetailsDemande( DetailsDemande detailsDemande){
        detailsDemandeService.ajouter(detailsDemande);
    }
}

