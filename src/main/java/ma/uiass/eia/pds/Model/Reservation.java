package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

import java.io.Serializable;

import java.util.Date;


@Entity
@Table(name= "TReservation")
@Inheritance(strategy = InheritanceType.JOINED)
public class Reservation implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idReservation;
    @Column(name="NumReservation", length=50)
    private String numReservation;

    @Column(name="DateDébut", length=50)
    private Date dateDébut;
    @Column(name="DateFin", length=50)
    private Date dateFin;
    @Column
    private Boolean estAnnulée;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "idLit")
    private Lit lit;
    public String getNumReservation() {
        return numReservation;
    }
    public void setNumReservation(String numReservation) {
        this.numReservation = numReservation;
    }
    public Date getDateDébut() {
        return dateDébut;
    }
    public void setDateDébut(Date dateDébut) {
        this.dateDébut = dateDébut;
    }


    public Reservation(int idReservation) {
        this.idReservation = idReservation;
    }

    /* public Reservation(String numReservation, String numPatient, LocalDate dateDébut, LocalDate dateFin, Boolean estAnnulée, List<Lit> lits) {
                this.numReservation = numReservation;
                this.numPatient = numPatient;
                this.dateDébut = dateDébut;
                this.dateFin = dateFin;
                this.estAnnulée = estAnnulée;
                this.lits = lits;
            }*/
    public Date getDateFin() {
        return dateFin;
    }
    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }
    public Boolean getEstAnnulée() {
        return estAnnulée;
    }
    public void setEstAnnulée(Boolean estAnnulée) {
        this.estAnnulée = estAnnulée;
    }
    public int getIdReservation() {
        return idReservation;
    }


    public Reservation(String numReservation, Date dateDébut, Date dateFin, Boolean estAnnulée,Lit lit) {
        this.numReservation = numReservation;
        this.dateDébut = dateDébut;
        this.dateFin = dateFin;
        this.estAnnulée = estAnnulée;
        this.lit=lit;
    }
    public Lit getLit() {
        return lit;
    }

    public void setLit(Lit lit) {
        this.lit = lit;
    }
    public void setIdReservation(int idReservation) {
        this.idReservation = idReservation;
    }
    public  Reservation(){}
    public String toString(){
        return this.idReservation + " "+this.numReservation+" "+" "+this.dateDébut+" "+this.dateFin+" "+this.estAnnulée+" "+this.lit;
    }
}
