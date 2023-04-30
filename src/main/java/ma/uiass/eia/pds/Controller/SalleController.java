package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Service.IEspaceService;
import ma.uiass.eia.pds.Service.SalleService;

import java.util.List;
@Path("/salle")

public class SalleController {
    IEspaceService service = new SalleService();

    @GET
    @Path("/getsalles")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Chambre> getChambres(){
        return service.afficherTout();
    }

    @POST
    @Path("/addsalle")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addChambre(Salle salle){
        service.ajouter(salle);
    }


}
