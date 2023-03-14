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
    IServiceService serviceService = new ServiceService();

    @GET
    @Path("/getservices")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> getServices(){return serviceService.afficherServices();}

    @POST
    @Path("/addService")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addService(Service service){
        serviceService.ajouterService(service);
    }


}
