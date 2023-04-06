package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Lit;

import java.util.List;

public interface ILitService extends IService<Lit>{
    List<Lit> afficherToutL(String nomService, String typeEspace);




}
