package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;
import ma.uiass.eia.pds.Service.ILivraisonFournisseurService;
import ma.uiass.eia.pds.Service.LivraisonFournisseurService;

import java.util.List;

@Path("livraisonfournisseur")
public class LivraisonFournisseurController {
    private ILivraisonFournisseurService livraisonFournisseurService = new LivraisonFournisseurService();
    @GET
    @Path("/getdetailslivraison")
    public List<LivraisonFournisseur> getAll(){
        return livraisonFournisseurService.afficherTout();
    }

    @POST
    @Path("/addlivraisonfournisseur")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetailsLivraison(LivraisonFournisseur livraisonFournisseur){

        livraisonFournisseurService.ajouter(livraisonFournisseur);
    }
}
