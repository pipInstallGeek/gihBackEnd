package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Dao.IStocksDetailsDao;
import ma.uiass.eia.pds.Dao.StocksDetailsDao;
import ma.uiass.eia.pds.Model.StocksDetails;
import ma.uiass.eia.pds.Service.IStocksDetailsService;
import ma.uiass.eia.pds.Service.StocksDetailsService;
import org.python.antlr.ast.Str;

import java.util.List;

@Path("/detailsstock")
public class StocksDetailsController {

    IStocksDetailsService stocksDetailsService = new StocksDetailsService();
    IStocksDetailsDao stocksDetailsDao=new StocksDetailsDao();
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
    @GET
    @Path("/getIdByStock/{idStock}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public List<StocksDetails> getIdByStock(@PathParam("idStock") int idStock){
        List<StocksDetails> lstStock=stocksDetailsDao.getIdByStock(idStock);
        return lstStock;
    }
    @GET
    @Path("/getDeviceStockQuantity/{nomDM}/{nomService}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public int getDeviceStockQuantity(@PathParam("nomDM")  String nomDM,@PathParam("nomService")  String nomService){
        return stocksDetailsService.getDeviceStockQuantity(nomDM,nomService);
    }
    @GET
    @Path("/getStockDetailsByNomDMANdS/{nomDM}/{nomService}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public  StocksDetails getStockDetailsByNomDMAndS(@PathParam("nomDM") String  nomDM,@PathParam("nomService") String  nomService){
        return stocksDetailsService.getStockDetailsByNomDMAndService(nomDM,nomService);

    }
    @PUT
    @Path("/addStock/{TypeDM}/{nomDM}/{stock}/{quantity}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addStock(@PathParam("TypeDM") String TypeDM,@PathParam("nomDM") String nomDM, @PathParam("stock") String stock, @PathParam("quantity") int quantity){
        stocksDetailsService.ajouterStock(TypeDM,nomDM,stock,quantity);
    }



}
