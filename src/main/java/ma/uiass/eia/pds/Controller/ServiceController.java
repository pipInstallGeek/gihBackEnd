package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Service;
import ma.uiass.eia.pds.Service.*;

import java.util.List;

@Path("/service")
public class  ServiceController {
    IServiceService serviceService = new ServiceService();

    @GET
    @Path("/getservices")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Service> getServices(){return serviceService.afficherTout();}

    @POST
    @Path("/addservice")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addService(Service service){
        serviceService.ajouter(service);
    }


}