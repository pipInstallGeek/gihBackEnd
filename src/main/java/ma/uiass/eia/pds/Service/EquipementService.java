package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.EquipementDao;
import ma.uiass.eia.pds.Model.DescriptionDM;
import ma.uiass.eia.pds.Model.Equipement;

import java.util.List;

public class EquipementService implements IEquipementService{
    private EquipementDao equipementDao;

    public EquipementDao getEquipementDao() {
        return equipementDao;
    }


    @Override
    public void ajouter(Equipement equipement) {
        equipementDao.add(equipement);
    }

    @Override
    public List<Equipement> afficherTout() {

        return equipementDao.getAll();
    }

    @Override
    public Equipement trouverId(int id) {

        return equipementDao.getById(id);
    }
}
