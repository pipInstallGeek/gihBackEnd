package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public interface ILitService {

    void ajouterLit(Lit lit );

    List<Lit> afficherLits();

    Lit trouverChambreID(int id);

}
