package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.StateF;
import ma.uiass.eia.pds.Model.StateNFCD;
import ma.uiass.eia.pds.Service.IStateAMBService;
import ma.uiass.eia.pds.Service.StateNFCDService;

import java.util.List;

@Path("/stateNFCD")
public class StateNFCDController {
    IStateAMBService state=new StateNFCDService();
    @GET
    @Path("/getstateNFCD")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StateNFCD> getStatesNFCD(){
        return state.afficherTout();
    }

    @POST
    @Path("/addsatetNFCD")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStateNFCD(StateNFCD s){
        state.ajouter(s);
    }


}