package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Batiment;
import ma.uiass.eia.pds.Model.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

public interface IReservationDao extends IDao<Reservation> {
    void update(Reservation s, Date dateFin, boolean estannulée);
}
