package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.StateNFLD;
import ma.uiass.eia.pds.Service.IStateAMBService;
import ma.uiass.eia.pds.Service.StateFService;

import java.util.List;

@Path("/stateNFLD")
public class StateNFLDController {
    IStateAMBService state=new StateFService();
    @GET
    @Path("/getstateNFLD")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StateNFLD> getStatesNFLD(){
        return state.afficherTout();
    }

    @POST
    @Path("/addsatetNFLD")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStateNFLD(StateNFLD s){
        state.ajouter(s);
    }


}