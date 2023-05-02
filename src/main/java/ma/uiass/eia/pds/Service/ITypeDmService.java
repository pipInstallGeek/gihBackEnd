package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.TypeDM;

import java.util.List;

public interface ITypeDmService {
    void ajouterTypeDm(TypeDM typeDM);

    List<TypeDM> afficherTypeDm();

    public void supprimerTypeDm(TypeDM typeDm);
}
