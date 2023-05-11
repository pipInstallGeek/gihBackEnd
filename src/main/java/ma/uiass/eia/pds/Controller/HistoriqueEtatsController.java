package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.HistoriqueEtats;
import ma.uiass.eia.pds.Model.Marque;
import ma.uiass.eia.pds.Service.HistoriqueEtatService;
import ma.uiass.eia.pds.Service.IHistoriqueEtatService;

import java.util.List;
@Path("/historiqueEtats")
public class HistoriqueEtatsController {
   IHistoriqueEtatService historiqueEtatService = new HistoriqueEtatService();

    @GET
    @Path("/getHistorique")
    @Produces(MediaType.APPLICATION_JSON)
    public List<HistoriqueEtats> gethistoriquesetat(){
        return historiqueEtatService.afficherTout();
    }

    @POST
    @Path("/addHistorique")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addHistorique(HistoriqueEtats historiqueEtats){
        historiqueEtatService.ajouter(historiqueEtats);
    }
}
