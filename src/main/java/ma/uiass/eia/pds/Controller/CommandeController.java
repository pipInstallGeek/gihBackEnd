package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.EtatCommande;
import ma.uiass.eia.pds.Service.CommandeService;
import ma.uiass.eia.pds.Service.ICommandeService;


import java.util.Date;
import java.util.List;

@Path("/commande")

public class CommandeController {
    ICommandeService commandeService = new CommandeService();
    @GET
    @Path("/getcommandes")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Commande> getCommandes(){
        return commandeService.afficherTout();
    }

    @POST
    @Path("/updateEtat{code}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void update(@PathParam("code") String code){
        commandeService.modifier(code);
    }

    @DELETE
    @Path("/deletecommande{numCommande}")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void removeCommande(
            @PathParam("numCommande") String numCommande){
        commandeService.supprimerCommande(numCommande);
    }
    @POST
    @Path("/addcommande")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_FORM_URLENCODED)
    public void addCommande(@FormParam("numCommande") String numCommande,
                            @FormParam("quantite") int quantite,
                            @FormParam("dateCommande") String dateCommande,
                            @FormParam("dateLivraison") String dateLivraison,
                            @FormParam("typelit") String typelit,
                            @FormParam("marque") String marque ,
                            @FormParam("etat") EtatCommande etat,
                            @FormParam("service") String service){
        commandeService.ajouter(numCommande,quantite,dateCommande,dateLivraison,typelit,marque,etat,service);
        System.out.println("commqnde controller hereeeee");
    }
}
