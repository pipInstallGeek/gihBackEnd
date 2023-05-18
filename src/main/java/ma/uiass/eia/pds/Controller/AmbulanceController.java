package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Service.AmbulanceService;
import ma.uiass.eia.pds.Service.IAmbulanceService;

import java.util.List;

@Path("/ambulance")
public class AmbulanceController {
    IAmbulanceService ambulanceService=new AmbulanceService();

    @GET
    @Path("/getAmbulances")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Ambulance> getAmbulance() {
        return ambulanceService.afficherTout();
    }
    @PUT
    @Path("/addAMB/{dateCirculation}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addAMB(@PathParam("dateCirculation") String dateCirculation) {
        ambulanceService.addAMB(dateCirculation);
    }
    @POST
    @Path("/updateState")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateState(@FormParam("codeAMB") String codeAMB,@FormParam("NewState")String NewState){
       ambulanceService.modifierS(codeAMB, NewState);

    }
    @POST
    @Path("/updateKilo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateKilo(@FormParam("codeAMB") String codeAMB,@FormParam("NewKilo")double NewKilo){
        ambulanceService.modifierK(codeAMB, NewKilo);

    }
    @GET
    @Path("/getAMBByCode/{codeAMB}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Ambulance getAMBByCode(
            @PathParam("codeAMB") String codeAMB){
        return ambulanceService.trouverByCode(codeAMB);
    }

}
