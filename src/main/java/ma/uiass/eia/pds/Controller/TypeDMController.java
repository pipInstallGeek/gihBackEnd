package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.TypeDM;
import ma.uiass.eia.pds.Service.DescriptionDMService;
import ma.uiass.eia.pds.Service.IDescriptionDMService;
import ma.uiass.eia.pds.Service.ITypeDMService;
import ma.uiass.eia.pds.Service.TypeDMService;

import java.util.List;

public class TypeDMController {
    ITypeDMService type= new TypeDMService();
    IDescriptionDMService descriptionservice=new DescriptionDMService();
    @GET
    @Path("/gettypesDM")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeDM> getAdmission(){
        return type.afficherTout();
    }
    @POST
    @Path("/addtypeDM/{codedescription}/{NomTypeDM}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTypeDM(
            @PathParam("codedescription") String codedescription,
            @PathParam("NomTypeDM") String NomTypeDM)
    {
        DescriptionDM descriptionDM= descriptionservice.trouverId(Integer.parseInt(codedescription));



        TypeDM typed=new TypeDM(descriptionDM,NomTypeDM);
        type.ajouter(typed);
    }
}
