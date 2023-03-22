    package ma.uiass.eia.pds.Dao;

    import jakarta.persistence.EntityManager;
    import jakarta.persistence.EntityTransaction;
    import ma.uiass.eia.pds.HibernateUtility.HibernateUtil;
    import ma.uiass.eia.pds.Model.Commande;

    import java.time.LocalDate;
    import java.util.Date;
    import java.util.List;

    public class CommandeDao implements ICommandeDao {

        private EntityManager entityManager;
        public CommandeDao() {
            entityManager = HibernateUtil.getEntityManger();
        }
        @Override
        public List<Commande> getAll() {
            return entityManager.createQuery("select r from Commande r", Commande.class).getResultList();
        }
        @Override
        public void add(Commande commande) {
            EntityTransaction et = entityManager.getTransaction();
            try {
                et.begin();
                entityManager.persist(commande);
                et.commit();
            } catch (Exception e) {
                if (et != null) {
                    et.rollback();
                }
                e.printStackTrace();
            }
        }
        @Override
        public Commande getById(int idCommande) {

            return entityManager.find(Commande.class, idCommande);
        }
        @Override
        public void update(Commande commande, Date dlc, boolean comfirmation) {
            EntityTransaction et = entityManager.getTransaction();
            commande.setDateLivraison(dlc);
            commande.setConfirmation(comfirmation);
            try {
                if (!et.isActive()) {
                    et.begin();
                }
                entityManager.merge(commande);
                et.commit();
            } catch (Exception e) {
                if (et != null) {
                    et.rollback();
                }
                e.printStackTrace();
            }

        }
    }

