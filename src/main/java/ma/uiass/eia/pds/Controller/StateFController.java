package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Model.StateF;
import ma.uiass.eia.pds.Service.IStateAMBService;
import ma.uiass.eia.pds.Service.StateFService;

import java.util.List;

@Path("/stateF")
public class StateFController {
    IStateAMBService state=new StateFService();
    @GET
    @Path("/getstateF")
    @Produces(MediaType.APPLICATION_JSON)
    public List<StateF> getStatesF(){
        return state.afficherTout();
    }

    @POST
    @Path("/addsatetF")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStateF(StateF s){
        state.ajouter(s);
    }


}
