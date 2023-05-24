package ma.uiass.eia.pds.Service;

import ma.uiass.eia.pds.Model.Ambulance;

public interface IAmbulanceService extends IService<Ambulance> {
    Ambulance trouverByCode(String code);
    void addAMB(String dateMiseEnCirculation);
    void modifierS(String codeAMB,String NewState);

    void delete(int id);

   void update(Ambulance ambulance);
    void modifierK(String codeAMB,double NewKilo);


}
