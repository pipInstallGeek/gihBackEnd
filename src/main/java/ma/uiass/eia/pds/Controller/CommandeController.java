package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.Model.Commande;
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
    public List<Commande> getReservation(){
        return commandeService.afficherTout();
    }


    @POST
    @Path("/addcommande")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addCommande(Commande commande){
        commandeService.ajouter(commande);
    }
    @Path("/modifiercommande")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifierCommande(@QueryParam("idCommande") int idCommande,
                                        @QueryParam("dateLivraison") Date dateLivraison,
                                        @QueryParam("confirmation") boolean confirmation){
        Commande commandeToUpdate = commandeService.trouverId(idCommande);
        commandeToUpdate.setDateLivraison(dateLivraison);
        commandeToUpdate.setConfirmation(confirmation);
        commandeService.modifier(commandeToUpdate, dateLivraison, confirmation);
        return Response.ok().build();
    }
}
