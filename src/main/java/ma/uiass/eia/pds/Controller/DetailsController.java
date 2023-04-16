package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Service.DetailsLivraisonService;
import ma.uiass.eia.pds.Service.IDetailsService;

import java.util.List;

@Path("/detailsCommande")
public class DetailsController {
    IDetailsService detailsLivraisonService= new DetailsLivraisonService();

    @GET
    @Path("/getdetails")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailsLivraison> getdetails(){
        return detailsLivraisonService.afficherTout();
    }

    @POST
    @Path("/addDetails")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetails( DetailsLivraison details){
        detailsLivraisonService.ajouter(details);
    }
}
