package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.*;

import java.util.List;

@Path("/dispositif")

public class DescriptionDMController {
    IEspaceService<Chambre> chambreService = new ChambreService();
    IEspaceService<Salle> salleService = new SalleService();
    IDescriptionDMService Idm=new DescriptionDMService();
    DescriptionDMService dms=new DescriptionDMService();
    @GET
    @Path("/getdispositifs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DescriptionDM> getAdmission(){
        return Idm.afficherTout();
    }
    @POST
    @Path("/addDispo2/{nomDM}/{quantité}/{codeespace}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDescription(
            @PathParam("nomDM") String nomDM,
            @PathParam("quantité") int quantité,
            @PathParam("codeespace") String codeespace)
            {
        Espace espace = salleService.trouverId(Integer.parseInt(codeespace));
        if (espace== null){
            espace = chambreService.trouverId(Integer.parseInt(codeespace));
        }

        DescriptionDM dm = new DescriptionDM( nomDM, quantité,espace);
        Idm.ajouter(dm);
    }
}
