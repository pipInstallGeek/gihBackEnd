package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.IStateAMBDao;
import ma.uiass.eia.pds.Dao.StateNFLDDao;
import ma.uiass.eia.pds.Model.StateNFLD;

import java.util.List;

public class StateNFLDService implements IStateAMBService<StateNFLD> {
    IStateAMBDao state=new StateNFLDDao();

    @Override
    public void ajouter(StateNFLD stateNFLD) {
        state.add(stateNFLD);


    }

    @Override
    public List<StateNFLD> afficherTout() {
        return state.getAll();
    }

    @Override
    public StateNFLD trouverId(int id) {

        return (StateNFLD) state.getById(id);
    }

    @Override
    public void addEtat(String nomEtat) {

    }
}
