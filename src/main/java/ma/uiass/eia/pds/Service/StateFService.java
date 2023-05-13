package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IStateAMBDao;
import ma.uiass.eia.pds.Dao.StateFDao;
import ma.uiass.eia.pds.Model.StateF;

import java.util.List;

public class StateFService implements IStateAMBService<StateF> {
    IStateAMBDao<StateF> state=new StateFDao();

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

    @Override
    public void addEtat(String nomEtat) {

    }
}
