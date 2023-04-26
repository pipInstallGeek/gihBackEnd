package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Etage;
import ma.uiass.eia.pds.Model.TypeDM;
import ma.uiass.eia.pds.Service.ITypeDmService;
import ma.uiass.eia.pds.Service.TypeDmServiceImp;

import java.util.List;

@Path("/typeDM")
public class TypeDmController {
    ITypeDmService typeDmService=new TypeDmServiceImp();

    @GET
    @Path("/gettypeDM")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeDM> getTypeDM(){
        return typeDmService.afficherTypeDm();
    }

    @Path("/addtypeDM")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTypeDM(TypeDM typeDM){
        typeDmService.ajouterTypeDm(typeDM);
    }



}
