package ma.uiass.eia.pds.Controller;


import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.DispoMedicItem;
import ma.uiass.eia.pds.Model.DispoMedical;
import ma.uiass.eia.pds.Service.DispoMedicItemService;
import ma.uiass.eia.pds.Service.IDispoMedicItemService;

import java.util.List;

@Path("/dispoMedItem")
public class DispoMedicItemController {
    IDispoMedicItemService dispoMedicItemService=new DispoMedicItemService();
    @GET
    @Path("/getDispoMedItem")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DispoMedicItem> getDispositifMedItem(){
        return dispoMedicItemService.afficherTout();
    }

    @Path("/addDispoMedItem")
    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    public void addDispositifMed(DispoMedicItem dispoMedical){
        dispoMedicItemService.ajouter(dispoMedical);
    }

    @GET
    @Path("/getByIdDispoMedItem")
    @Produces(MediaType.APPLICATION_JSON)
    public DispoMedicItem getByIdDispositifMedItem(int id){
        return dispoMedicItemService.trouverId(id);
    }

    @DELETE
    @Path("/deleteItem/{codeDispoMedicItem}")
    public void deleteDMITEM(@PathParam("codeDispoMedicItem") int codeItem){
        dispoMedicItemService.deleteItem(codeItem);
    }

}
