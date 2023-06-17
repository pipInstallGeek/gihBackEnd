package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Dao.ServiceDao;
import ma.uiass.eia.pds.Model.*;
import ma.uiass.eia.pds.Service.DemandeDMService;
import ma.uiass.eia.pds.Service.DemandelitService;
import ma.uiass.eia.pds.Service.IDemandelitService;


import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Path("/demandelit")
public class DemandelitController {
    private DemandelitService metierDemande = new DemandelitService();
    private ServiceDao serviceS = new ServiceDao();
    @POST
    @Path("/addDemandelit")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDemande(@FormParam("code")String code, @FormParam("nomS") String nomS){
        metierDemande.create(code,nomS);
    }

    @GET
    @Path("/Demandeslit")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemandeLitFormat> getDemandes() {
        List<DemandeLit> lst = metierDemande.getAll();
        List<DemandeLitFormat> newlst = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (DemandeLit d : lst) {
            String date = sdf.format(d.getDateDemande());
            DemandeLitFormat df = new DemandeLitFormat(d.getDemandelit_id(), d.getCode(), date,d.getEtat(), d.getService());
            df.setLst(d.getList());
            newlst.add(df);

        }
        return newlst;
    }

    @GET
    @Path("/DemandesLitByService/{service}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemandeLitFormat> getDemandesByService(@PathParam("service") String service) {
        List<DemandeLit> lst = metierDemande.getAllByService(serviceS.findByName(service));
        List<DemandeLitFormat> newlst = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (DemandeLit d : lst) {
            String date = sdf.format(d.getDateDemande());
            DemandeLitFormat df = new DemandeLitFormat(d.getDemandelit_id(), d.getCode(), date,d.getEtat(), d.getService());
            df.setLst(d.getList());
            newlst.add(df);

        }
        return newlst;
    }
    @GET
    @Path("/uneDemandelit/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public DemandeLitFormat getDemande(@PathParam("code") String codeD){
        DemandeLit d = metierDemande.findBycode(codeD);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d.getDateDemande());
        DemandeLitFormat dm = new DemandeLitFormat(d.getDemandelit_id(),d.getCode(),date,d.getEtat(),d.getService());
        dm.setLst(d.getList());
        return dm;
    }
    @POST
    @Path("/updateEtatRlit{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateR(@PathParam("code") String code){
        metierDemande.modifierR(code);
    }

    @POST
    @Path("/updateEtatAlit{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateA(@PathParam("code") String code){
        metierDemande.modifierT(code);
    }

}
