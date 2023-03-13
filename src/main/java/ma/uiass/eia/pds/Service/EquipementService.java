package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.EquipementDao;
import ma.uiass.eia.pds.Model.Equipement;

import java.util.List;

public class EquipementService implements IEquipementService{
    private EquipementDao equipementDao;

    public EquipementDao getEquipementDao() {
        return equipementDao;
    }


    @Override
    public void ajouterEquipement(Equipement equipement) {
        equipementDao.add(equipement);
    }

    @Override
    public List<Equipement> afficherEquipements() {

        return equipementDao.getAll();
    }

    @Override
    public Equipement trouverChambreId(int id) {

        return equipementDao.getById(id);
    }
}
