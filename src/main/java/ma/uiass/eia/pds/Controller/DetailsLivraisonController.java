package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.Consumes;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Service.DetailsLivraisonService;
import ma.uiass.eia.pds.Service.IDetailsLivraisonService;

import java.util.List;

@Path("/detailslivraison")
public class DetailsLivraisonController {

    private IDetailsLivraisonService detailsLivraisonService= new DetailsLivraisonService();
    @GET
    @Path("/getdetailslivraison")
    public List<ma.uiass.eia.pds.Model.DetailsLivraison> getAll(){
        return detailsLivraisonService.afficherTout();
    }

    @POST
    @Path("/adddetailslivraison")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetailsLivraison(DetailsLivraison detailsLivraison){

        detailsLivraisonService.ajouter(detailsLivraison);
    }
}
