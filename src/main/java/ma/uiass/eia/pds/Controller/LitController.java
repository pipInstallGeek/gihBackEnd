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

    @GET
    @Path("/getstock")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getStock(){
        return service.afficherToutStock();
    }
   /* @POST
    @Path("/addlitenstock/{etatLit}/{occupe}/{espace}/{typeLit}/{marque}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addLitEnStock(@PathParam("etatLit") EtatLit etatLit,
                              @PathParam("occupe") Boolean occupe,
                              @PathParam("espace") int idespace,
                              @PathParam("typeLit") TypeLit typeLit,
                              @PathParam("marque") int idmarque){
        service.ajouterlitStock(etatLit,occupe,idespace,typeLit, idmarque);
    }*/






}
