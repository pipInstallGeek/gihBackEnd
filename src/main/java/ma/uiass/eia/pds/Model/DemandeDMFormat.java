package ma.uiass.eia.pds.Model;

import java.util.List;

public class DemandeDMFormat {
    private int id;
    private String code, date;
    private EtatDemande etat;
    private List<DetailDemandeDM> lst;
    private Service service;

    public DemandeDMFormat(int id, String code, String date, EtatDemande etat, Service service) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.etat = etat;
        this.lst = lst;
        this.service = service;
    }

    public DemandeDMFormat() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public EtatDemande getEtat() {
        return etat;
    }

    public void setEtat(EtatDemande etat) {
        this.etat = etat;
    }

    public List<DetailDemandeDM> getLst() {
        return lst;
    }

    public void setLst(List<DetailDemandeDM> lst) {
        this.lst = lst;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }


    @Override
    public String toString() {
        return "DemandeDMFormat{" +
                "id=" + id +
                ", code='" + code + '\'' +
                ", date='" + date + '\'' +
                ", etat=" + etat +
                ", service=" + service +
                '}';
    }
}
