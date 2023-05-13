package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IStateAMBDao;
import ma.uiass.eia.pds.Dao.StateNFCDDao;
import ma.uiass.eia.pds.Model.StateAMB;
import ma.uiass.eia.pds.Model.StateNFCD;

import java.util.List;

public class StateNFCDService implements IStateAMBService<StateNFCD> {
    IStateAMBDao state=new StateNFCDDao();

    @Override
    public void ajouter(StateNFCD stateNFCD) {
        state.add(stateNFCD);

    }

    @Override
    public List<StateNFCD> afficherTout() {
        return state.getAll();
    }

    @Override
    public StateNFCD trouverId(int id) {
        return (StateNFCD) state.getById(id);
    }

    @Override
    public void addEtat(String nomEtat) {

    }
}
