package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.*;
import org.hibernate.annotations.Parameter;

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








}
