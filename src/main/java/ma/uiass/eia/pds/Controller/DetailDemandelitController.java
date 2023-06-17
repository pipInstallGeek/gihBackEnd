package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailDemandeLit;
import ma.uiass.eia.pds.Service.DetailDemandelitService;

import java.util.List;

@Path("/DetailDemandelit")
public class DetailDemandelitController {
    private DetailDemandelitService DetailDemande = new DetailDemandelitService();

    @POST
    @Path("/addDetaillit")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDetail(@FormParam("code") String code, @FormParam("quantite") int q,@FormParam("marque") String marque,@FormParam("typelit") String typelit){
        DetailDemande.create(code,q,marque,typelit);
    }


    @DELETE
    @Path("/deleteDetaillit{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public void delete(@PathParam("code") String code){
        DetailDemande.deleteBycode(code);
    }


    @POST
    @Path("/updateDetaillit")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@FormParam("codeDD") String codeDD,@FormParam("codeD") String codeD){
        DetailDemande.update(codeDD,codeD);

    }

    @POST
    @Path("/updateQuantiteDetaillit")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateqt(@FormParam("code") String code,@FormParam("q")int  q){
        DetailDemande.updateqt(code,q);

    }

    @GET
    @Path("/Detaildemandelit/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public DetailDemandeLit getDetaildemande(@PathParam("code") String code){
        DetailDemandeLit detail = DetailDemande.getByCode(code);
        return detail;
    }
    @GET
    @Path("/DetailsDemandelit/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DetailDemandeLit> getDetailsDemande(@PathParam("code") String code) {
        return DetailDemande.listDetailDemande(code);
    }


}
