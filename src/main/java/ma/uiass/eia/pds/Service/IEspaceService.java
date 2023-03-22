package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Chambre;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Lit;

public interface IEspaceService<T extends Espace> extends IService<T>{
    void retirerLit(Lit l);


}
