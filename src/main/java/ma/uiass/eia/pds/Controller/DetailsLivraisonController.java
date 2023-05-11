package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsLivraison;
import ma.uiass.eia.pds.Service.DetailsLivraisonServiceImp;
import ma.uiass.eia.pds.Service.IDetailsLivraisonService;

import java.util.List;

@Path("/detailsLivraisonController")
public class DetailsLivraisonController {
    IDetailsLivraisonService detailsLivraisonService=new DetailsLivraisonServiceImp();

    @GET
    @Path("/getDetailslivraison")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailsLivraison> getDetailslivraisonController(){return detailsLivraisonService.afficherTout();}


    @Path("/addDetailsLivraison")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDetailsLivraisonController(DetailsLivraison detailsLivraison){detailsLivraisonService.ajouter(detailsLivraison);}

    @GET
    @Path("/getByIdDetailslivraison")
    @Produces(MediaType.APPLICATION_JSON)
    public DetailsLivraison getByIdDetailslivraisonController(int id){return detailsLivraisonService.trouverId(id);}
}
