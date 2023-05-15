package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.AmbulanceDao;
import ma.uiass.eia.pds.Dao.IAmbulanceDao;
import ma.uiass.eia.pds.Dao.IStateAMBDao;
import ma.uiass.eia.pds.Dao.StateFDao;
import ma.uiass.eia.pds.Model.Ambulance;
import ma.uiass.eia.pds.Model.StateF;

import java.util.List;

public class StateFService implements IStateAMBService<StateF> {
    IStateAMBDao<StateF> state=new StateFDao();
    IAmbulanceDao ambulanceDao=new AmbulanceDao();

    @Override
    public void ajouter(StateF stateF) {
        state.add(stateF);
    }

    @Override
    public List<StateF> afficherTout() {
            return state.getAll();    }

    @Override
    public StateF trouverId(int id) {
           return state.getById(id);    }



}
