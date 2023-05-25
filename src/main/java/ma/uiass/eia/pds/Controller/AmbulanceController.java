package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.EtatsAmbulance;
import ma.uiass.eia.pds.Model.Marque;
import ma.uiass.eia.pds.Model.Revision;
import ma.uiass.eia.pds.Service.AmbulanceService;
import ma.uiass.eia.pds.Service.IAmbulanceService;

import java.util.List;

@Path("/Ambulance")
public class AmbulanceController {
   IAmbulanceService ambulanceService = new AmbulanceService();

    @GET
    @Path("/getAmbulances")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ambulance> getambulances(){
        return ambulanceService.afficherTout();
    }

    @POST
    @Path("/addambulane")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAmbulance(Ambulance ambulance){
        ambulanceService.ajouter(ambulance);
    }

    @POST
    @Path("/updateState")
    @Consumes(MediaType.APPLICATION_JSON)
    public void updateState(Ambulance amb){
        ambulanceService.Changertat(amb);
    }

}
