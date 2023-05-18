package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DispositifMedical;
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
    @Path("/addRévision/{dateR}/{kilométrage}/{dateSortie}/{codeAMB}/{dateProRévision}/{typeR}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addRévision(@PathParam("dateR") String dateR,@PathParam("kilométrage") double kilométrage,@PathParam("dateSortie") String dateSortie,@PathParam("codeAMB") String codeAMB,@PathParam("dateProRévision") String dateProRévision,@PathParam("typeR") TypeRévision typeR){
        révisionService.addR(dateR,dateSortie,kilométrage,codeAMB,dateProRévision,typeR);
    }
    @GET
    @Path("/getAllCodeAMB{codeAMB}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Révision> getAllByCodeAMB(@PathParam(("codeAMB")) String codeAMB) {
        return révisionService.trouverbyCode(codeAMB);
    }
    @POST
    @Path("/updateDateS")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateKilo(@FormParam("codeR") String codeR,@FormParam("dateS")String dateS){
        révisionService.modifierDateS(codeR,dateS);

    }
    @POST
    @Path("/updateState")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateState(@FormParam("codeR") String codeR,@FormParam("newState")String newState){
        révisionService.modifierDateS(codeR,newState    );

    }
    @PUT
    @Path("/addRévisionSansDateS/{dateR}/{kilométrage}/{codeAMB}/{typeR}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addRSansDateS(@PathParam("dateR") String dateR,@PathParam("kilométrage") double kilométrage,@PathParam("codeAMB") String codeAMB,@PathParam("typeR") TypeRévision typeR){
        révisionService.addRSansDateS(dateR,kilométrage,codeAMB,typeR);
    }
    @GET
    @Path("/getAllByDateSNull/{codeAMB}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Révision> getAllByDateSNull(@PathParam(("codeAMB")) String codeAMB) {
        return révisionService.trouverbyDateSNull(codeAMB);
    }


}