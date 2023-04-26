package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Stock;
import ma.uiass.eia.pds.Service.IStockService;
import ma.uiass.eia.pds.Service.StockService;

import java.util.List;

@Path("/stock")
public class StockController {
    IStockService stockService = new StockService();

    @GET
    @Path("/getstocks")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Stock> getAll(){
        return stockService.afficherTout();
    }

    @GET
    @Path("getstock/{idStock}")
    @Produces(MediaType.APPLICATION_JSON)
    public Stock getStockById(
            @PathParam("idStock") int idStock
    ){
        return stockService.trouverId(idStock);
    }

}
