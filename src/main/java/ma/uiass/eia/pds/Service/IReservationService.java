package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationService extends IService<Reservation>  {
    void modifier(Reservation s, Date dateFin, boolean estannulée);
    //List<Reservation> afficheHistorique(String numPatient);
}
