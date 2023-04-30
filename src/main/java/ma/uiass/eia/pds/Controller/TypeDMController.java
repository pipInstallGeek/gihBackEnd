package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
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
    @Path("/addtypeDM/{NomTypeDM}/{codeTypeDM}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTypeDM(
            @PathParam("NomTypeDM") String NomTypeDM,
           @PathParam("codeTypeDM") String codeTypeDM)
    {
        type.addTypeDM(codeTypeDM,NomTypeDM);
    }
   @GET
    @Path("/gettypeDMByIdDM/{NomDM}")
    @Produces(MediaType.APPLICATION_JSON)
    public TypeDM getTypeDmByNomDm(@PathParam(("NomTypeDM")) String  NomTypeDM){return type.trouverbyNom(NomTypeDM);  }
    @PUT
    @Path("createT/{nomTypeDM}/{codeTypeDM}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDescription(
            @PathParam("nomTypeDM") String  nomTypeDM,
            @PathParam("codeTypeDM") String codeTypeDM)
    {
        type.createT(codeTypeDM,nomTypeDM);
    }
    @DELETE
    @Path("/deleteTypeDM{nomTypeDM}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void removeTypeDM(
            @PathParam("nomTypeDM") String nomTypeDM){
        type.supprimerTypeDM(nomTypeDM);
    }
}
