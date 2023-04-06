    package ma.uiass.eia.pds.Service;
    import ma.uiass.eia.pds.Dao.ILitDao;
    import ma.uiass.eia.pds.Dao.LitDao;
    import ma.uiass.eia.pds.Model.Espace;
    import ma.uiass.eia.pds.Model.EtatLit;
    import ma.uiass.eia.pds.Model.Lit;

    import java.util.List;
    public class LitService implements ILitService{
        private ILitDao litDao = new LitDao();
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
        //public List<Lit> afficherAvailableLit(){return littDao1.getAvailableLit();}
        public List<Lit> afficherToutL(String nomService, String typeEspace){return litDao.getAvailableLit( nomService,typeEspace);}

        public Lit findbycode(String codeLit){
            return litDao.findbyCode(codeLit);
}
    }
