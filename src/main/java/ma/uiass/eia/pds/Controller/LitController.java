package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.*;
import org.hibernate.annotations.Parameter;

import java.util.Date;
import java.util.List;

@Path("/lit")
public class LitController {

    ILitService service = new LitService();
    IMarqueService marqueService = new MarqueService();
    ITypeLitService typeLitService = new TypeLitService();
    IEspaceService salleService = new SalleService();
    IEspaceService chambreService = new ChambreService();


    @GET
    @Path("/getlits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLit(){
        return service.afficherTout();
    }


    @POST
    @Path("/addlit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addLit(Lit lit){
        service.ajouter(lit);
    }

    @Path("/modifierlit")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifierLit(@QueryParam("idLit") int idLit, @QueryParam("etatLit") EtatLit etatLit, @QueryParam("occupe") boolean occupe, @QueryParam("espace") Espace espace){
        Lit litToUpdate = service.trouverId(idLit);
        litToUpdate.setEtatLit(etatLit);
        litToUpdate.setOccupe(occupe);
        litToUpdate.setEspace(espace);
        service.modifier(litToUpdate, etatLit, occupe,espace);
        return Response.ok().build();
    }



}
