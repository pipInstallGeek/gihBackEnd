package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Marque;

public interface IMarqueService extends IService<Marque> {
    Marque trouverCode(String codeMarque);
}
