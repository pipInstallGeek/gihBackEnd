package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
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
    public List<Etage> getEtages(){
        return etageService.afficherTout();
    }

}
