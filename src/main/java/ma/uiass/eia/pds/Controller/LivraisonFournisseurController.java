package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.LivraisonFournisseur;
import ma.uiass.eia.pds.Service.IDetailsLivraisonService;
import ma.uiass.eia.pds.Service.ILivraisonFournisseurService;
import ma.uiass.eia.pds.Service.LivraisonFournisseurServiceImp;

import java.util.List;

@Path("/livraisonFournisseurController")
public class LivraisonFournisseurController {
    private ILivraisonFournisseurService livraisonFournisseurService=new LivraisonFournisseurServiceImp();

    @GET
    @Path("/getLivraisonFournisseur")
    @Produces(MediaType.APPLICATION_JSON)
    public List<LivraisonFournisseur> getLivraisonFournisseurController(){return livraisonFournisseurService.afficherTout();}

    @Path("/addLivraisonFournisseur")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLivraisonFournisseurController(LivraisonFournisseur livraisonFournisseur){livraisonFournisseurService.ajouter(livraisonFournisseur);}


    @GET
    @Path("/getByIdLivraisonFournisseur")
    @Produces(MediaType.APPLICATION_JSON)
    public LivraisonFournisseur getByIdLivraisonFournisseurController(int id){return livraisonFournisseurService.trouverId(id);}
}
