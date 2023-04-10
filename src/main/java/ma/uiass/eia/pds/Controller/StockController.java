package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Salle;
import ma.uiass.eia.pds.Model.Stock;
import ma.uiass.eia.pds.Service.IEspaceService;
import ma.uiass.eia.pds.Service.SalleService;
import ma.uiass.eia.pds.Service.StockService;

import java.util.List;

public class StockController {
    IEspaceService service = new StockService();

    @GET
    @Path("/getstock")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stock> getStock() {
        return service.afficherTout();
    }

    @POST
    @Path("/addstock")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addStock(Stock stock) {
        service.ajouter(stock);
    }
}
