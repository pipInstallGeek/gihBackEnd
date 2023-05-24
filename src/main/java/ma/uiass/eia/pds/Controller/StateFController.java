package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Dao.IStateAMBDao;
import ma.uiass.eia.pds.Dao.StateFDao;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.IStateAMBService;
import ma.uiass.eia.pds.Service.StateFService;

import java.util.List;

@Path("/stateF")
public class StateFController {
    IStateAMBService state=new StateFService();
    IStateAMBDao<StateF> statedao=new StateFDao();
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
    @GET
    @Path("/getStateByNom/{nomState}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public StateAMB getStateByNom(
            @PathParam("nomState") String nomState){
        return statedao.findbyNom(nomState);
    }


}
