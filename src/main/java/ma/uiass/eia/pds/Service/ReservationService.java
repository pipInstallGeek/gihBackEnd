package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IReservationDao;
import ma.uiass.eia.pds.Dao.ReservationDao;
import ma.uiass.eia.pds.Model.Reservation;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;
public class ReservationService  implements IReservationService{
    IReservationDao reservationDao = new ReservationDao();
    @Override
    public void ajouter(Reservation reservation) {
        reservationDao.add(reservation);
    }
    @Override
    public List<Reservation> afficherTout() {
        return reservationDao.getAll();
    }

    @Override
    public Reservation trouverId(int id) {
        return reservationDao.getById(id);
    }
    public void modifier(Reservation s, Date dateFin, boolean estannulée) {
        reservationDao.update(s,dateFin,estannulée);
    }
    /*@Override
    public List<Reservation> afficheHistorique(String numPatient) {
        return reservationDao.afficheHistorique(numPatient);
    }*/


}
