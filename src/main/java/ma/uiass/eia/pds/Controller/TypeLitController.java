package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.TypeLit;
import ma.uiass.eia.pds.Service.ITypeLitService;
import ma.uiass.eia.pds.Service.TypeLitService;

import java.util.List;

@Path("/typelit")

public class TypeLitController {
    ITypeLitService typeLitService = new TypeLitService();

    @GET
    @Path("/gettypelits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<TypeLit> getTypeLits(){
        return typeLitService.afficherTout();
    }

    @POST
    @Path("/ajoutertypelit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addTypeLit(TypeLit typeLit){
        typeLitService.ajouter(typeLit);
    }
}