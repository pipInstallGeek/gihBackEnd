package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Commande;

import java.time.LocalDate;
import java.util.Date;

public interface ICommandeService extends IService<Commande> {
    void modifier(Commande commande, Date dlc, boolean confirmation);
}

