package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DetailsDemande;
import ma.uiass.eia.pds.Model.ReapprovisionnementLit;
import ma.uiass.eia.pds.Service.DetailsDemandeService;
import ma.uiass.eia.pds.Service.IDetailsDemandeService;
import ma.uiass.eia.pds.Service.IReappLitService;
import ma.uiass.eia.pds.Service.ReappLitService;

import java.util.List;

@Path("/ReappLit")
public class ReappLitController {
    IReappLitService reappLitService = new ReappLitService();

    @GET
    @Path("/getReappLit")
    @Produces(MediaType.APPLICATION_JSON)
    public List<ReapprovisionnementLit> getdetailsReapp(){
        return reappLitService.afficherTout();
    }

    @POST
    @Path("/addReappLit")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReappLit(ReapprovisionnementLit reapprovisionnementLit){
        reappLitService.ajouter(reapprovisionnementLit);
    }
}
