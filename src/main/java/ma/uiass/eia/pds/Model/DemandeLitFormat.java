package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;


public class DemandeLitFormat implements Serializable {

    private int id;
    private String code, date;
    private EtatDemande etat;
    private List<DetailDemandeLit> listedetail_lit;
    private Service service;

    public DemandeLitFormat(int id, String code, String date, EtatDemande etat, Service service) {
        this.id = id;
        this.code = code;
        this.date = date;
        this.etat = etat;
        this.listedetail_lit = listedetail_lit;
        this.service = service;
    }

    public DemandeLitFormat() {

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

    public List<DetailDemandeLit> getLst() {
        return listedetail_lit;
    }

    public void setLst(List<DetailDemandeLit> lst) {
        this.listedetail_lit = lst;
    }

    public Service getService() {
        return service;
    }

    public void setService(Service service) {
        this.service = service;
    }

    public List<DetailDemandeLit> getListedetail_lit() {
        return listedetail_lit;
    }

    public void setListedetail_lit(List<DetailDemandeLit> listedetail_lit) {
        this.listedetail_lit = listedetail_lit;
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