package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DispoMedicalDao;
import ma.uiass.eia.pds.Dao.IDispoMedicalDao;
import ma.uiass.eia.pds.Model.DispoMedical;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class DispoMedicalServiceImp implements IDispoMedicalService{

    private IDispoMedicalDao dispoMedicalDao=new DispoMedicalDao();

    @Override
    public void ajouterDispoMed(DispoMedical dispoMedical) {
        dispoMedicalDao.add(dispoMedical);
    }

    @Override
    public List<DispoMedical> afficherDispoMedical() {
        return dispoMedicalDao.getAll();
    }

   @Override
    public DispoMedical findDMbyID(int id){
        return dispoMedicalDao.getById(id);
    }




}
