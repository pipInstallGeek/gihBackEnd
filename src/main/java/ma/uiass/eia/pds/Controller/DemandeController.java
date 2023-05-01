package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.EtatDemande;
import ma.uiass.eia.pds.Service.DemandeService;
import ma.uiass.eia.pds.Service.IDemandeService;


import java.util.List;

@Path("/Demande")
public class DemandeController {
    IDemandeService demandeservice = new DemandeService();
    @GET
    @Path("/getDemandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Demande> getDemandes(){
        return demandeservice.afficherTout();
    }

    @POST
    @Path("/updateEtat{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@PathParam("code") String code){
        demandeservice.modifier(code);
    }

    @POST
    @Path("/updateEtat3{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update3(@PathParam("code") String code){
        demandeservice.modifier(code);
    }

    @POST
    @Path("/updateEtat2{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update2(@PathParam("code") String code){
        demandeservice.modifier2(code);
    }

    @DELETE
    @Path("/deleteDemande{numDemande}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void removeDemande(
            @PathParam("numDemande") String numDemande){
        demandeservice.supprimerDemande(numDemande);
    }
    @POST
    @Path("/addDemande")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addCommande(@FormParam("numDemande") String numDemande,
                            @FormParam("quantite") int quantite,
                            @FormParam("dateDemande") String dateDemande,
                            @FormParam("dateLivraison") String dateLivraison,
                            @FormParam("typelit") String typelit,
                            @FormParam("marque") String marque ,
                            @FormParam("etat") EtatDemande etat,
                            @FormParam("service") String service) {
        demandeservice.ajouter(numDemande, quantite, dateDemande, dateLivraison, typelit, marque, etat, service);
    }
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/addDemande")
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addDemande(@FormParam("dateDemande") String dateDemande,
                            @FormParam("etat") EtatDemande etat,
                            @FormParam("service") String service) {
        demandeservice.ajouter(dateDemande, etat, service);
        System.out.println("commqnde controller hereeeee");
    }
}
