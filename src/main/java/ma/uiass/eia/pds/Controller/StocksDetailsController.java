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


/*########################################################################################*/


    @POST
    @Path("/addDetailStock")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDetailStock(@FormParam("dispositifMedical") String dispositifMedical, @FormParam("stock") String stock, @FormParam("quantity") int quantity){
        stocksDetailsService.ajouterS(dispositifMedical,stock,quantity);
    }

    @GET
    @Path("/DetailStock/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public StocksDetails getStockdetail(@PathParam("code") int idStocksDetails){
        StocksDetails detail = stocksDetailsService.getByCode(idStocksDetails);
        return detail;
    }
    @POST
    @Path("/updateQuantiteDetailstock/{code}/{q}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateqt2(@PathParam("code") int id,@PathParam("q") int  q){
        stocksDetailsService.updateqtS(id,q);

    }


}
