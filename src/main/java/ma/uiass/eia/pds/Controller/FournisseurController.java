package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Fournisseur;
import ma.uiass.eia.pds.Service.FournisseurServiceImp;
import ma.uiass.eia.pds.Service.IFournisseurService;

import java.util.List;

@Path("/fournisseurController")
public class FournisseurController {

    IFournisseurService fournisseurService=new FournisseurServiceImp();

    @GET
    @Path("/getFournisseur")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fournisseur> getFournisseurController(){return fournisseurService.afficherTout();}

    @Path("/addFournisseur")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addFournisseurController(Fournisseur fournisseur){fournisseurService.ajouter(fournisseur);}

    @GET
    @Path("/getFournisseurById/{codeFournisseur}")
    @Produces(MediaType.APPLICATION_JSON)
    public Fournisseur getFournisseurByIdController(
            @PathParam("codeFournisseur") int id){return fournisseurService.trouverId(id);}

    @PUT
    @Path("/updateFournisseur/{codeFournisseur}/{nomFournisseur}/{emailFournisseur}/{telephoneFournisseur}/{localisationFournisseur}")
    @Produces(MediaType.APPLICATION_JSON)
    public void updateFournisseurCred(@PathParam("codeFournisseur")int codeFournisseur,
            @PathParam("nomFournisseur")String nomFournisseur,
            @PathParam("emailFournisseur")String emailFournisseur,
            @PathParam("telephoneFournisseur")String telephoneFournisseur,
            @PathParam("localisationFournisseur")String localisationFournisseur){

        fournisseurService.updateFournisseurService(codeFournisseur,nomFournisseur,emailFournisseur,telephoneFournisseur,localisationFournisseur);

    }

}
