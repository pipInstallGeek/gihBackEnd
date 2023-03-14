package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Service.ILitService;
import ma.uiass.eia.pds.Service.LitService;

import java.util.List;
@Path("/bed")

public class LitController {

    ILitService service = new LitService();
    @GET
    @Path("/getbeds")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLit(){
        return service.afficherLits();
    }

    @POST
    @Path("addbed")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addBed(Lit lit){
        service.ajouterLit(lit);
        return "Bed added successfully ";
    }

}

