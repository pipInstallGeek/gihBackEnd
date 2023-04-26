package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.TypeDM;
import ma.uiass.eia.pds.Service.DescriptionDMService;
import ma.uiass.eia.pds.Service.IDescriptionDMService;
import ma.uiass.eia.pds.Service.ITypeDMService;
import ma.uiass.eia.pds.Service.TypeDMService;

import java.util.List;
@Path("/typeDM")

public class TypeDMController {
    ITypeDMService type= new TypeDMService();
    IDescriptionDMService descriptionservice=new DescriptionDMService();
    @GET
    @Path("/gettypesDM")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeDM> getTypeDM(){
        return type.afficherTout();
    }
   @POST
    @Path("/addtypeDM/{NomTypeDM}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTypeDM(
            @PathParam("NomTypeDM") String NomTypeDM)
    {
        //DescriptionDM descriptionDM= descriptionservice.trouverId(Integer.parseInt(codedescription));
       // TypeDM typed=new TypeDM(NomTypeDM);
        type.addTypeDM(NomTypeDM);
    }
   @GET
    @Path("/gettypeDMByIdDM/{NomDM}")
    @Produces(MediaType.APPLICATION_JSON)
    public TypeDM getTypeDmByNomDm(@PathParam(("NomTypeDM")) String  NomTypeDM){return type.trouverbyNom(NomTypeDM);  }
    @PUT
    @Path("createT/{nomTypeDM}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDescription(
            @PathParam("nomTypeDM") String  nomTypeDM)
    {
        type.createT(nomTypeDM);
    }
}
