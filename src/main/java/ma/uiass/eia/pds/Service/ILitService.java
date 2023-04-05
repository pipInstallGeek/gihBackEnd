package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Commande;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;

import java.util.Date;
import java.util.List;

public interface ILitService extends IService<Lit>{


    Long countOccupation(boolean occupation);

}
