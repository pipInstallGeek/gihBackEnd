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
    ITypeDMService tt=new TypeDMService();
    @GET
    @Path("/getdispositifs")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DescriptionDM> getAdmission(){
        return Idm.afficherTout();
    }
    @POST
    @Path("/addDispo2/{nomDM}/{quantité}/{codeTypeDM}/{codeespace}")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDescription(
            @PathParam("nomDM") String nomDM,
                @PathParam("quantité") int quantité,
            @PathParam("codeTypeDM") String  codeTypeDM,
            @PathParam("codeespace") String codeespace)
            {
        Espace espace = salleService.trouverId(Integer.parseInt(codeespace));
        if (espace== null){
            espace = chambreService.trouverId(Integer.parseInt(codeespace));
        }
        TypeDM t=tt.trouverId(Integer.parseInt(codeTypeDM));

        DescriptionDM dm = new DescriptionDM( nomDM, quantité,t,espace);
        Idm.ajouter(dm);
    }
    @GET
    @Path("/getDMByTypeDM/{TypeDM}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DescriptionDM> getTypeDmByNomDm(@PathParam(("TypeDM")) String  TypeDM){
        return dms.trouverDMByTypeDM(TypeDM) ;  }
}
