package ma.uiass.eia.pds.Controller;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Reservation;
import ma.uiass.eia.pds.Service.ILitService;
import ma.uiass.eia.pds.Service.*;
import ma.uiass.eia.pds.Service.LitService;
import java.time.LocalDate;


import java.time.LocalDate;
import java.util.Date;
import java.util.List;
@Path("/reservation")

public class ReservationController {
    IReservationService reservationService = new ReservationService();
    @GET
    @Path("/getreservations")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> getReservation(){
        return reservationService.afficherTout();
    }


    @POST
    @Path("/addreservation")
    @Consumes(MediaType.APPLICATION_JSON)
    public void addReservation(Reservation reservation){
        reservationService.ajouter(reservation);
    }
    @Path("/modifierreservation")
    @Consumes(MediaType.APPLICATION_JSON)
    public Response modifierReservation(@QueryParam("idReservation") int idReservation,
                                        @QueryParam("dateFin") Date dateFin,
                                        @QueryParam("estAnnulee") boolean estAnnulee){
        Reservation reservationToUpdate = reservationService.trouverId(idReservation);
        reservationToUpdate.setDateFin(dateFin);
        reservationToUpdate.setEstAnnulée(estAnnulee);
        reservationService.modifier(reservationToUpdate, dateFin, estAnnulee);
        return Response.ok().build();
    }
    /*@PUT
    @Path("/modifierreservation")
    @Consumes(MediaType.APPLICATION_JSON)
    public void modifierReservation(Reservation s, LocalDate dateFin,boolean estannulée){
        Reservation reservationToUpdate = reservationService.trouverId(s.getIdReservation());
        reservationToUpdate.setDateFin(s.getDateFin());
        reservationService.modifier( s,dateFin,estannulée);
    }*/
    /*@GET
    @Path("/historique/{numPatient}")
    @Produces(MediaType.APPLICATION_JSON)
    public List<Reservation> afficheHistorique(@PathParam("numPatient") String numPatient){
        return reservationService.afficheHistorique(numPatient);
    }*/






}
