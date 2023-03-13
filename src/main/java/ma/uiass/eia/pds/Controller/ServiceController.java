package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Service;
import ma.uiass.eia.pds.Service.*;

import java.util.List;

@Path("/service")
public class  ServiceController {
    ILitService service = new LitService();
    IChambreService chambreService = new ChambreService();
    IServiceService serviceService = new ServiceService();

    @GET
    @Path("/getservices")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> getServices(){return serviceService.afficherServices();}
    @GET
    @Path("/Lits")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Lit> getLit(){
        return service.afficherLits();
    }

    @GET
    @Path("/here")
    @Produces(MediaType.TEXT_PLAIN)
    public String here(){
        return "we are heere !!!!";
    }

    @GET
    @Path("/chambres")
    @Produces({MediaType.APPLICATION_JSON})
    public List<Chambre> getChambre(){
        return chambreService.afficheChambres();
    }


    @POST
    @Path("/addService")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public String addService(Service service){
        serviceService.ajouterService(service);
        return "Success !!!!";
    }


}
