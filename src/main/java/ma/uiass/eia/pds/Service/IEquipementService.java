package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Equipement;

import java.util.List;

public interface IEquipementService {
    void ajouterEquipement(Equipement equipement);
    List<Equipement> afficherEquipements();
    Equipement trouverChambreId(int id);
}
