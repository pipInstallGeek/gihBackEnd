package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;
import ma.uiass.eia.pds.Service.DetailsLivraisonService;
import ma.uiass.eia.pds.Service.IDetailsLivraisonService;

import java.util.List;

@Path("/detailslivraisons")
public class DetailsLivraisonController {

    private IDetailsLivraisonService detailsLivraisonService= new DetailsLivraisonService();
    @GET
    @Path("/getdetailslivraison")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailsLivraison> getAll(){
        return detailsLivraisonService.afficherTout();
    }

    @POST
    @Path("/adddetailslivraison")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetailsLivraison(DetailsLivraison detailsLivraison){

        detailsLivraisonService.ajouter(detailsLivraison);
    }
    @GET
    @Path("getbylivraisonfournisseur/{idLivraison}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailsLivraison> getbyLivraison(
            @PathParam("idLivraison") int idLivraisonFournisseur){
            return detailsLivraisonService.getbyLivraison(idLivraisonFournisseur);
    }

}
