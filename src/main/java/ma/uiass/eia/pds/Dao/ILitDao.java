package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Reservation;

import java.util.Date;
import java.util.List;

public interface ILitDao extends IDao<Lit> {
    public List<Lit> getAll2() ;
    public void addLitInStock(Lit lit);

}