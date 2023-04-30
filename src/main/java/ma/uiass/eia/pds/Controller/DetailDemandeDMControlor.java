package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailDemandeDM;
import ma.uiass.eia.pds.Service.DetailDemandeDMService;

import java.util.List;

@Path("/detailDemandedm")
public class DetailDemandeDMControlor {
    private DetailDemandeDMService DetailDemande = new DetailDemandeDMService();

    @POST
    @Path("/addDetailDM")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDetail(@FormParam("code") String code, @FormParam("nom") String nom, @FormParam("quantite") int q){
        DetailDemande.create(code,nom,q);
    }


    @DELETE
    @Path("/deleteDetail{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("code") String code){
        DetailDemande.deleteBycode(code);
    }


    @POST
    @Path("/updateDetailDM")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@FormParam("codeDD") String codeDD,@FormParam("codeD") String codeD){
        DetailDemande.update(codeDD,codeD);

    }

    @POST
    @Path("/updateQuantiteDetailDM")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateqt(@FormParam("code") String code,@FormParam("q")int  q){
        DetailDemande.updateqt(code,q);

    }

    @GET
    @Path("/Detaildemande/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public DetailDemandeDM getDetaildemande(@PathParam("code") String code){
        DetailDemandeDM detail = DetailDemande.getByCode(code);
        return detail;
    }
    @GET
    @Path("/DetailsDemande/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailDemandeDM> getDetailsDemande(@PathParam("code") String code) {
        return DetailDemande.listDetailDemande(code);
    }

}

