package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Révision;

import ma.uiass.eia.pds.Model.TypeRévision;
import ma.uiass.eia.pds.Service.IRévisionService;
import ma.uiass.eia.pds.Service.RévisionService;

import java.util.List;

@Path("/revision")
public class RévisionController {
IRévisionService révisionService=new RévisionService();
    @GET
    @Path("/getRévisions")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Révision> getAmbulance() {
        return révisionService.afficherTout();
    }
    @PUT
    @Path("/addRévision/{dateR}/{codeAMB}/{dateProRévision}/{typeR}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addHistorique(@PathParam("dateR") String dateR,@PathParam("codeAMB") String codeAMB,@PathParam("dateProRévision") String dateProRévision,@PathParam("typeR") TypeRévision typeR){
        révisionService.addR(dateR,codeAMB,dateProRévision,typeR);
    }


}