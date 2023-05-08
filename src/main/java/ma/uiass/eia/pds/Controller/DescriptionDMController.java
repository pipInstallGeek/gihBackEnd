package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.*;

import java.util.List;

@Path("/dispositif")

public class DescriptionDMController {
    IEspaceService<Chambre> chambreService = new ChambreService();
    IEspaceService<Salle> salleService = new SalleService();
    IDescriptionDMService Idm = new DescriptionDMService();
    DescriptionDMService dms = new DescriptionDMService();
    ITypeDMService tt = new TypeDMService();

    @GET
    @Path("/getdispositifs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispositifMedical> getDispo() {
        return Idm.afficherTout();
    }

    @PUT
    @Path("/addDispo/{nomDM}/{quantité}/{nomTypeDM}/{codeespace}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDescription(
            @PathParam("nomDM") String nomDM,
            @PathParam("quantité") int quantité,
            @PathParam("nomTypeDM") String nomTypeDM,
            @PathParam("codeespace") String codeespace) {
        Idm.addDescriptionDM(nomDM, quantité, nomTypeDM, codeespace);
    }

    @GET
    @Path("/getDMByTypeDM/{TypeDM}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispositifMedical> getTypeDmByNomDm(@PathParam(("TypeDM")) String TypeDM) {
        return dms.trouverDMByTypeDM(TypeDM);
    }

    @PUT
    @Path("createD/{nomDM}/{quantité}/{nomTypeDM}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDescription(
            @PathParam("nomDM") String nomDM,
            @PathParam("quantité") int quantité,
            @PathParam("nomTypeDM") String nomTypeDM) {
        Idm.create(nomDM, quantité, nomTypeDM);
    }

    @GET
    @Path("/getQuantitéByDM/{nomDM}")
    @Produces(MediaType.APPLICATION_JSON)
    public int getQuantitéByDM(@PathParam(("nomDM")) String nomDM) {
        return dms.trouverQuantitéByDM(nomDM);
    }
    @DELETE
    @Path("/deleteDM{nomDM}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void removeDM(
            @PathParam("nomDM") String nomDM){
        dms.supprimerDM(nomDM);
    }
    @PUT
    @Path("/updateDM/{ancienNomDM}/{nouveauNomDM}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateDM(
            @PathParam("ancienNomDM") String ancienNomDM,
            @PathParam("nouveauNomDM") String nouveauNomDM) {
        dms.modifier(ancienNomDM, nouveauNomDM);
    }
    @GET
    @Path("/getAllByService{nomService}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispositifMedical> getAllByService(@PathParam(("nomService")) String nomService) {
        return Idm.afficherToutParService(nomService);
    }

    public static void main(String[] args) {
        DescriptionDMController d=new DescriptionDMController();
        d.updateDM("gants","gggg");
    }
    @POST
    @Path("/updateQuantiteDM")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateqt(@FormParam("nomDM") String nomDM,@FormParam("q")int  q){
        Idm.updateqt(nomDM,q);

    }
}


