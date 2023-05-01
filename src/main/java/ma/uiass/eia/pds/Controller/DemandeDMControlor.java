package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Dao.ServiceDao;
import ma.uiass.eia.pds.Model.DemandeDM;
import ma.uiass.eia.pds.Model.DemandeDMFormat;
import ma.uiass.eia.pds.Service.DemandeDMService;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;
@Path("/demande")
public class DemandeDMControlor {
    private DemandeDMService metierDemande = new DemandeDMService();
    private ServiceDao serviceS = new ServiceDao();
    @POST
    @Path("/addDemande")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDemande(@FormParam("code")String code, @FormParam("nomS") String nomS){
        metierDemande.create(code,nomS);
    }

    @GET
    @Path("Demandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemandeDMFormat> getDemandes() {
        List<DemandeDM> lst = metierDemande.getAll();
        List<DemandeDMFormat> newlst = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (DemandeDM d : lst) {
            String date = sdf.format(d.getDateDemande());
            DemandeDMFormat df = new DemandeDMFormat(d.getDemandeDM_id(), d.getCode(), date,d.getEtat(), d.getService());
            df.setLst(d.getList());
            newlst.add(df);

        }
        return newlst;
    }

    @GET
    @Path("DemandesByService/{service}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<DemandeDMFormat> getDemandesByService(@PathParam("service") String service) {
        List<DemandeDM> lst = metierDemande.getAllByService(serviceS.findByName(service));
        List<DemandeDMFormat> newlst = new ArrayList<>();
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        for (DemandeDM d : lst) {
            String date = sdf.format(d.getDateDemande());
            DemandeDMFormat df = new DemandeDMFormat(d.getDemandeDM_id(), d.getCode(), date,d.getEtat(), d.getService());
            df.setLst(d.getList());
            newlst.add(df);

        }
        return newlst;
    }
    @GET
    @Path("uneDemandeDm/{code}")
    @Produces(MediaType.APPLICATION_JSON)
    public DemandeDMFormat getDemande(@PathParam("code") String codeD){
        DemandeDM d = metierDemande.findBycode(codeD);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        String date = sdf.format(d.getDateDemande());
        DemandeDMFormat dm = new DemandeDMFormat(d.getDemandeDM_id(),d.getCode(),date,d.getEtat(),d.getService());
        dm.setLst(d.getList());
        return dm;
    }
    @POST
    @Path("/updateEtatR{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateR(@PathParam("code") String code){
        metierDemande.modifierR(code);
    }

    @POST
    @Path("/updateEtatA{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void updateA(@PathParam("code") String code){
        metierDemande.modifierT(code);
    }

}

