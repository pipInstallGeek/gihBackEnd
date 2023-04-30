package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Service.DispoMedicalServiceImp;
import ma.uiass.eia.pds.Service.IDispoMedicalService;

import java.util.List;

@Path("/dispoMed")
public class DispositifMedicalController {

    IDispoMedicalService dispoMedicalService=new DispoMedicalServiceImp();

    @GET
    @Path("/getDispoMed")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispositifMedical> getDispositifMed(){
        return dispoMedicalService.afficherDispoMedical();
    }


    @Path("/addDispoMed")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDispositifMed(DispositifMedical dispositifMedical){
        dispoMedicalService.ajouterDispoMed(dispositifMedical);
    }


    @Path("/getbytypedm/{idTypeDm}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public List<DispositifMedical> getbytype(
            @PathParam("idTypeDm") int typeDM1){
        return dispoMedicalService.getbytype(typeDM1);
    }

}














