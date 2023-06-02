package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.DispoMedicItem;
import ma.uiass.eia.pds.Model.EtatsAmbulance;
import ma.uiass.eia.pds.Model.Marque;
import ma.uiass.eia.pds.Service.AmbulanceService;
import ma.uiass.eia.pds.Service.IAmbulanceService;

import java.util.List;

@Path("/ambulanceController")
public class AmbulanceController {
   IAmbulanceService ambulanceService = new AmbulanceService();

    @GET
    @Path("/getambulances")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ambulance> getambulances(){
        return ambulanceService.afficherTout();
    }

    @Path("/addambulane")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addAmbulance(Ambulance ambulance){
        ambulanceService.ajouter(ambulance);
    }

    @GET
    @Path("/getAmbulancePerType/{etatsAmbulance}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ambulance> ambulancePerType(
            @PathParam("etatsAmbulance") String etatsAmbulance){return ambulanceService.afficherAmbulanceEtat(etatsAmbulance);}


    @PUT
    @Path("/updatestate")
    @Consumes(MediaType.APPLICATION_JSON)
     public void updateState(Ambulance amb){
  ambulanceService.Changertat(amb);
 }


}
