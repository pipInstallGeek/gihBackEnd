package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailDemande;
import ma.uiass.eia.pds.Service.DetailDemandeService;

import java.util.List;
@Path("/DetailDemande")
public class DetailDemandeController {
    private DetailDemandeService detaildemande = new DetailDemandeService();

    @GET
    @Path("/DetailDemandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailDemande> getMyLists() {
        return detaildemande.afficherTout();
    }

    @POST
    @Path("/addDetail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDetail(@FormParam("DM") String DM, @FormParam("quantite") int q) {
        detaildemande.ajouter(DM,q);
    }

    @POST
    @Path("/updateDetail")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@FormParam("codeDD") String codeDD, @FormParam("codeD") String codeD) {
        detaildemande.update(codeDD, codeD);

    }
    @DELETE
    @Path("/deleteDetail/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void removeDetail(
            @PathParam("code") String code){
        detaildemande.supprimer(code);
    }

}
