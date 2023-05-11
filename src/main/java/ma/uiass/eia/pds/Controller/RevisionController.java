package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Marque;
import ma.uiass.eia.pds.Model.Revision;
import ma.uiass.eia.pds.Service.IMarqueService;
import ma.uiass.eia.pds.Service.IRevisionService;
import ma.uiass.eia.pds.Service.MarqueService;
import ma.uiass.eia.pds.Service.RevisionService;

import java.util.List;
@Path("/revision")
public class RevisionController {
   IRevisionService revisionService = new RevisionService();

    @GET
    @Path("/getrevision")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Revision> getrevision(){
        return revisionService.afficherTout();
    }

    @POST
    @Path("/addrevision")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addRevision(Revision revision){
        revisionService.ajouter(revision);
    }
}
