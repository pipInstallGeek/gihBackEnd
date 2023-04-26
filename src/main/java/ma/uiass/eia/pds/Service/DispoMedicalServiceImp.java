package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DispoMedicalDao;
import ma.uiass.eia.pds.Model.DispositifMedical;

import java.util.List;

public class DispoMedicalServiceImp implements IDispoMedicalService{
    private DispoMedicalDao dispoMedicalDao=new DispoMedicalDao();
    @Override
    public void ajouterDispoMed(DispositifMedical dispositifMedical) {
        dispoMedicalDao.add(dispositifMedical);

    }

    @Override
    public List<DispositifMedical> afficherDispoMedical() {
        return dispoMedicalDao.getAll();
    }



}
