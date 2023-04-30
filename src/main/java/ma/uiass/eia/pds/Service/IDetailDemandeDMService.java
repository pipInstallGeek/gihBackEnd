package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DetailDemandeDM;

import java.util.List;

public interface IDetailDemandeDMService {
    void create(String code, String nom, int quantite);

    void deleteBycode(String code);

    void update(String codeDD, String codeD);

    DetailDemandeDM getByCode(String code);

    void updateqt(String code, int q);

    List<DetailDemandeDM> listDetailDemande(String code);
}
