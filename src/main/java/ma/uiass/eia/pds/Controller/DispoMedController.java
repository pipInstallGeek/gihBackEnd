package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Dao.IDispoMedicalDao;
import ma.uiass.eia.pds.Model.DispoMedical;
import ma.uiass.eia.pds.Service.DispoMedicalServiceImp;
import ma.uiass.eia.pds.Service.IDispoMedicalService;

import java.util.List;

@Path("/dispoMed")
public class DispoMedController {

    IDispoMedicalService dispoMedicalService=new DispoMedicalServiceImp();

    @GET
    @Path("/getDispoMed")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispoMedical> getDispositifMed(){
        return dispoMedicalService.afficherDispoMedical();
    }


    @Path("/addDispoMed")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDispositifMed(DispoMedical dispoMedical){
        dispoMedicalService.ajouterDispoMed(dispoMedical);
    }




}














