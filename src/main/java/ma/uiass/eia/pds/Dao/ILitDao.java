package ma.uiass.eia.pds.Dao;

import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.EtatLit;
import ma.uiass.eia.pds.Model.Lit;
import ma.uiass.eia.pds.Model.Reservation;

import java.util.Date;

public interface ILitDao extends IDao<Lit> {
    default void update(Lit l, EtatLit etatLit, boolean occupe, Espace espace) {
    }
}