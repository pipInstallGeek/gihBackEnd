package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;;
import ma.uiass.eia.pds.Service.ILivraisonService;
import ma.uiass.eia.pds.Service.LivraisonFourniseurService;

import java.util.List;

@Path("/livraisonFournisseur")
public class LivraisonController {
    ILivraisonService livraisonService = new LivraisonFourniseurService();

    @GET
    @Path("/getlivraisons")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LivraisonFournisseur> getLivraison(){
        return livraisonService.afficherTout();
    }

    @POST
    @Path("/addlivraison")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLivraison(LivraisonFournisseur livraisonFournisseur){
        livraisonService.ajouter(livraisonFournisseur);
    }
}
