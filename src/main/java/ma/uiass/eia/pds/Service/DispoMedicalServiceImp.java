package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.DispoMedicalDao;
import ma.uiass.eia.pds.Dao.ITypeDMDao;
import ma.uiass.eia.pds.Dao.TypeDMDao;
import ma.uiass.eia.pds.Model.DispositifMedical;
import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public class DispoMedicalServiceImp implements IDispoMedicalService{
    private DispoMedicalDao dispoMedicalDao=new DispoMedicalDao();
    private ITypeDMDao typeDMDao = new TypeDMDao();
    @Override
    public void ajouterDispoMed(DispositifMedical dispositifMedical) {
        dispoMedicalDao.add(dispositifMedical);

    }

    @Override
    public List<DispositifMedical> afficherDispoMedical() {
        return dispoMedicalDao.getAll();
    }

    @Override
    public List<DispositifMedical> getbytype(int idTypeDm) {
        TypeDM typeDM =typeDMDao.getById(idTypeDm);
        return dispoMedicalDao.getbytype(typeDM);
    }


}
