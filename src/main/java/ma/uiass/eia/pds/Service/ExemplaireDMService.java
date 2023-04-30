package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Dao.ExemplaireDMDao;
import ma.uiass.eia.pds.Dao.IExemplaireDMDao;
import ma.uiass.eia.pds.Model.ExemplaireDM;

import java.util.List;

public class ExemplaireDMService implements IExemplaireDMService{
    IExemplaireDMDao ex=new ExemplaireDMDao();
    @Override
    public void ajouter(ExemplaireDM exemplaireDM) {ex.add(exemplaireDM);}

    @Override
    public List<ExemplaireDM> afficherTout() {return ex.getAll();}
    @Override
    public ExemplaireDM trouverId(int id) {return ex.getById(id);}

    @Override
    public List<ExemplaireDM> trouvezExemplaireByDMetTypeDm(String nomDM) {
        List<ExemplaireDM> lst=ex.getExemplaireByDMetTypeDm(nomDM);
        return lst;

    }
}
