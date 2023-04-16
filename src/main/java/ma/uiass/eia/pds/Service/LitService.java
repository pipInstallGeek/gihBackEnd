    package ma.uiass.eia.pds.Service;
    import ma.uiass.eia.pds.Dao.*;
    import ma.uiass.eia.pds.Model.*;

    import java.util.List;
    import java.util.Map;

    public class LitService implements ILitService{
        private ILitDao litDao = new LitDao();
        private IEspaceDao<Chambre> chambreDao = new ChambreDao();
        private IEspaceDao<Salle> salleDao = new SalleDao();
        private LitDao littDao1=new LitDao();

        @Override
        public void ajouter(Lit lit) {
            litDao.add(lit);

        }

        @Override
        public List<Lit> afficherTout() {
            return litDao.getAll();
        }
        @Override
        public Lit trouverId(int id) {return litDao.getById(id);}

        @Override
        public Long countOccupation(boolean occupation) {
            Long mycount = litDao.countOccupation(occupation);
            return mycount;
        }

        @Override
        public Long countOccupationInEspace(int idEspace, boolean occupation) {
            Espace espace = chambreDao.getById(idEspace);
            if (espace== null){
                espace = salleDao.getById(idEspace);
            }
            return litDao.countOccupationInEspace(espace, occupation);
        }

        @Override
        public void deleteLit(int idLit) {
            Lit lit = litDao.getById(idLit);
            if (lit != null){
                litDao.deleteLit(lit);
            }

        }

        @Override
        public void update(int idLit, boolean occupee, int espacecode, EtatLit etatLit) {
            Lit lit = litDao.getById(idLit);
            Espace espace = chambreDao.getById(espacecode);
            if (espace == null){
                espace = salleDao.getById(espacecode);
            }
            litDao.update(lit,occupee, espace, etatLit);
        }



        public List<Lit> afficherToutL(String nomService){return litDao.getAvailableLit( nomService);}
        public Lit findbycode(String codeLit){
            return litDao.findbyCode(codeLit);
}
        public Map<String, Integer> getNLDB(){return littDao1.getNLDB();}
        public Map<String, Integer> getNLO(){return littDao1.getNLO();}

    }
