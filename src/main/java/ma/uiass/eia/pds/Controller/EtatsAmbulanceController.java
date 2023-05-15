package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Service.EtatsAmbulanceService;
import ma.uiass.eia.pds.Service.IEtatsAmbulanceService;

import java.util.List;

@Path("/etatambulance")
public class EtatsAmbulanceController {
    IEtatsAmbulanceService etatsAmbulanceService = new EtatsAmbulanceService();

    @GET
    @Path("/getetats")
    @Produces(MediaType.APPLICATION_JSON)
    public List<EtatsAmbulance> getetatsambulance(){
        return etatsAmbulanceService.afficherTout();
    }

    @POST
    @Path("/addetatambulance")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addEtatAmbulance(EtatsAmbulance etatsAmbulance){
        etatsAmbulanceService.ajouter(etatsAmbulance);
    }
}
