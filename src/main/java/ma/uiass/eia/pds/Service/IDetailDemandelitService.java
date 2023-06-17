package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.DemandeLitFormat;
import ma.uiass.eia.pds.Model.DetailDemandeLit;

import java.util.List;

public interface IDetailDemandelitService {

    void create(String code, int quantite, String typelit, String marque);

    void deleteBycode(String code);

    void update(String codeDD, String codeD);

    DetailDemandeLit getByCode(String code);

    void updateqt(String code, int q);

    List<DetailDemandeLit> listDetailDemande(String code);
}
