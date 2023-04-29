package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.TypeDM;
import ma.uiass.eia.pds.Service.ITypeDMSerivce;
import ma.uiass.eia.pds.Service.TypeDMService;

import java.util.List;

@Path("/typedm")
public class TypeDMController {

    private ITypeDMSerivce typeDMSerivce = new TypeDMService();

    @Path("/gettypedm")
    @Produces(MediaType.APPLICATION_JSON)
    @GET
    public List<TypeDM> getall(){
        return typeDMSerivce.afficherTout();
    }
}
