package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.StocksDetails;
import ma.uiass.eia.pds.Service.IStocksDetailsService;
import ma.uiass.eia.pds.Service.StocksDetailsService;

import java.util.List;

@Path("/detailsstock")
public class StocksDetailsController {

    IStocksDetailsService stocksDetailsService = new StocksDetailsService();
    @Path("/getdetailsbystock/{id}")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StocksDetails> getdetailsbystock(
            @PathParam("id") int id
    ){
       return stocksDetailsService.getByStock(id);
    }
    @Path("/getall")
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<StocksDetails> getall(){
        return stocksDetailsService.afficherTout();
    }

}
