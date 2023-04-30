package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Demande;
import ma.uiass.eia.pds.Model.DetailDemande;

import java.util.List;

public interface IDetailDemandeDao {
    void add(DetailDemande detailDemande);

    void delete(DetailDemande o);

    DetailDemande findById(int id);

    List<DetailDemande> getAll();

    void update(DetailDemande d, Demande dem);

    DetailDemande findByCode(String code);
}
