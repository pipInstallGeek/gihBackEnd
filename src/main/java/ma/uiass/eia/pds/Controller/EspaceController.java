package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Service.ChambreService;
import ma.uiass.eia.pds.Service.IEspaceService;
import ma.uiass.eia.pds.Service.SalleService;

import java.util.ArrayList;
import java.util.List;
@Path("espace")
public class EspaceController {
    private IEspaceService<Salle> salleService = new SalleService();
    private IEspaceService<Chambre> chambreService = new ChambreService();

    @GET
    @Path("/getespaces")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Espace> getChambres(){
        List<Espace> espaces = new ArrayList<>();
        List<Chambre> chambres = chambreService.afficherTout();
        List<Salle> salles = salleService.afficherTout();
        espaces.addAll(chambres);
        espaces.addAll(salles);
        return espaces;
    }



}