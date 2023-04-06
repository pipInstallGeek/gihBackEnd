package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.*;

import java.util.Date;
import java.util.List;

public interface ILitService extends IService<Lit>{

     void ajouterlitStock(EtatLit etatLit, Boolean occupe, Espace espace, TypeLit typeLit, Marque marque);
    List<Lit> afficherToutStock();
}
