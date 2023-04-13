package ma.uiass.eia.pds.Dao;

import jakarta.persistence.EntityManager;
import ma.uiass.eia.pds.Model.Livraison;

import java.util.List;

public class LivraisonFournisseurDao implements ILivraisonFournisseur {
    private EntityManager entityManager ;

    @Override
    public List<Livraison> getAll() {
        return null;
    }

    @Override
    public void add(Livraison livraison) {

    }

    @Override
    public Livraison getById(int id) {
        return entityManager.find(Livraison.class, id);
    }
}
