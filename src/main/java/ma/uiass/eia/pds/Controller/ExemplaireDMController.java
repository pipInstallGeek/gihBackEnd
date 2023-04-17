package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Dao.DescriptionDMDao;
import ma.uiass.eia.pds.Dao.IDescriptionDMDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.ExemplaireDM;
import ma.uiass.eia.pds.Service.DescriptionDMService;
import ma.uiass.eia.pds.Service.ExemplaireDMService;
import ma.uiass.eia.pds.Service.IDescriptionDMService;
import ma.uiass.eia.pds.Service.IExemplaireDMService;

import java.util.List;

@Path("/exemplaire")


public class ExemplaireDMController {
    IDescriptionDMService descriptionservice=new DescriptionDMService();
    IExemplaireDMService exemplaireDMService=new ExemplaireDMService();
    @POST
    @Path("/addEx/{codedescription}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addExDM(
            @PathParam("codedescription") String codedescription)

    {
        DescriptionDM descriptionDM= descriptionservice.trouverId(Integer.parseInt(codedescription));
        descriptionservice.ajouter(descriptionDM);
    }
    @GET
    @Path("/getexemplaires")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExemplaireDM> getAdmission(){
        return exemplaireDMService.afficherTout();
    }
    @GET
    @Path("/getExByDMType/{nomDm}/{nomTypeDm}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ExemplaireDM> getExBYDMTypeDM(@PathParam(("nomDm"))String nomDM){ return exemplaireDMService.trouvezExemplaireByDMetTypeDm(nomDM);}


}
