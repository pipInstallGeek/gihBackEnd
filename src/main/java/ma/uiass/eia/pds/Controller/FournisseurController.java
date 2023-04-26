package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Etage;
import ma.uiass.eia.pds.Model.Fournisseur;
import ma.uiass.eia.pds.Service.FournisseurService;
import ma.uiass.eia.pds.Service.IFournisseurService;

import java.util.List;

@Path("/fournisseur")
public class FournisseurController {

    IFournisseurService fournisseurService = new FournisseurService();

    @GET
    @Path("/getfournisseurs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Fournisseur> getEtages(){
        return fournisseurService.afficherTout();
    }

    @GET
    @Path("/getbyid/{id}")
    public Fournisseur getbyid(
            @PathParam("id") int id
    ){
        return fournisseurService.trouverId(id);
    }

    @POST
    @Path("/addfournisseur")
    @Consumes(MediaType.APPLICATION_JSON)
    public void add(Fournisseur fournisseur){
        fournisseurService.ajouter(fournisseur);
    }
}
