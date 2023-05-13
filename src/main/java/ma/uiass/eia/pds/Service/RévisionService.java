package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.AmbulanceDao;
import ma.uiass.eia.pds.Dao.IAmbulanceDao;
import ma.uiass.eia.pds.Dao.IRévisionDao;
import ma.uiass.eia.pds.Dao.RévisionDao;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.Révision;
import ma.uiass.eia.pds.Model.TypeRévision;

import java.util.List;

public class RévisionService implements IRévisionService{
    IRévisionDao révisionDao=new RévisionDao();
    IAmbulanceDao ambulanceDao=new AmbulanceDao();
IAmbulanceService ambulanceService=new AmbulanceService();

    @Override
    public void ajouter(Révision révision) {
        révisionDao.add(révision);

    }

    @Override
    public List<Révision> afficherTout() {
        return révisionDao.getAll();
    }

    @Override
    public Révision trouverId(int id) {
        return révisionDao.getById(id);
    }
    @Override
    public void addR(String dateR, String codeAMB, String dateProRévision, TypeRévision typeR) {
        Ambulance ambulance=ambulanceService.trouverByCode(codeAMB);
        System.out.println(ambulance);
        String desc="L'ambulance "+codeAMB+"a été soumise à une "+typeR;
        Révision r=new Révision(dateR,dateProRévision,desc,typeR,ambulance);
        révisionDao.add(r);
        //r.setCodeRévision("REV"+r.getIdRévision());
    }
}
