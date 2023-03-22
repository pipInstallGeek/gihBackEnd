package ma.uiass.eia.pds.Dao;

        import jakarta.persistence.EntityManager;
        import jakarta.persistence.EntityTransaction;
        import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
        import ma.uiass.eia.pds.Model.Reservation;

        import java.time.LocalDate;
        import java.util.Date;
        import java.util.List;

public class ReservationDao implements IReservationDao{
    private EntityManager entityManager ;
    public ReservationDao(){
        entityManager = HibernateUtil.getEntityManger();
    }
    @Override
    public List<Reservation> getAll() {
        return entityManager.createQuery("select r from Reservation r ").getResultList();
    }

    @Override
    public void add(Reservation reservation) {
        EntityTransaction transaction = entityManager.getTransaction();
        try {
            transaction.begin();
            entityManager.persist(reservation);
            transaction.commit();
        }catch (Exception e){
            if (transaction != null){
                transaction.rollback();
            }
            e.printStackTrace();
        }
    }
    @Override
    public Reservation getById(int id) {
        return entityManager.find(Reservation.class, id);
    }
    public void update(Reservation s, Date dateFin, boolean estannulée) {
        EntityTransaction et = entityManager.getTransaction();;
        s.setDateFin(dateFin);
        s.setEstAnnulée(estannulée);
        try {
            if (!et.isActive()) {
                et.begin();
            }
            entityManager.merge(s);
            et.commit();
        }catch(Exception e){
            if (et != null) {
                et.rollback();
            }
            e.printStackTrace();
        }

    }


}
