package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.Model.Etage;
import ma.uiass.eia.pds.Service.EtageService;
import ma.uiass.eia.pds.Service.IEtageService;

import java.util.List;
@Path("etage")
public class EtageController {
    IEtageService etageService = new EtageService();


    @GET
    @Path("/getetages")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Etage> getEtages() {
        return etageService.afficherTout();
    }

    @Path("/addetage")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addBatiment(Etage etage) {
        etageService.ajouter(etage);
    }

}
