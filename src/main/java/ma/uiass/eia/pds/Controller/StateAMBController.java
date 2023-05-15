package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.*;

import java.util.ArrayList;
import java.util.List;


@Path("stateAMB")

public class StateAMBController {
    IStateAMBService<StateF> stateF=new StateFService();
    IStateAMBService<StateNFCD> stateNFCD=new StateNFCDService();
    IStateAMBService<StateNFLD> stateNFLD=new StateNFLDService();

    @GET
    @Path("/getstates")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StateAMB> getStates(){
        List<StateAMB> states = new ArrayList<>();
        List<StateF> statesF= stateF.afficherTout();
        List<StateNFCD> statesNFCD= stateNFCD.afficherTout();
        List<StateNFLD> statesNFLD= stateNFLD.afficherTout();
        states.addAll( statesF);
        states.addAll(statesNFCD);
        states.addAll(statesNFLD);
        return states;
    }


}
