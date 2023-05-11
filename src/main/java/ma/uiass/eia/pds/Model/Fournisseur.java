package ma.uiass.eia.pds.Model;


import jakarta.persistence.*;

@Entity
@Table(name = "TFournisseur")
public class Fournisseur {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int codeFournisseur;

    @Column
    private String nomFournisseur;

    @Column
    private String telephoneFournisseur;

    @Column
    private String emailFournisseur;

    @Column
    private String localisationFournisseur;

    public String getLocalisationFournisseur() {
        return localisationFournisseur;
    }

    public void setLocalisationFournisseur(String localisationFournisseur) {
        this.localisationFournisseur = localisationFournisseur;
    }

    public int getCodeFournisseur() {
        return codeFournisseur;
    }

    public void setCodeFournisseur(int codeFournisseur) {
        this.codeFournisseur = codeFournisseur;
    }

    public String getNomFournisseur() {
        return nomFournisseur;
    }

    public void setNomFournisseur(String nomFournisseur) {
        this.nomFournisseur = nomFournisseur;
    }

    public String getTelephoneFournisseur() {
        return telephoneFournisseur;
    }

    public void setTelephoneFournisseur(String telephoneFournisseur) {
        this.telephoneFournisseur = telephoneFournisseur;
    }

    public String getEmailFournisseur() {
        return emailFournisseur;
    }

    public void setEmailFournisseur(String emailFournisseur) {
        this.emailFournisseur = emailFournisseur;
    }

    public Fournisseur(String nomFournisseur, String telephoneFournisseur, String emailFournisseur,String localisationFournisseur) {
        this.nomFournisseur = nomFournisseur;
        this.telephoneFournisseur = telephoneFournisseur;
        this.emailFournisseur = emailFournisseur;
        this.localisationFournisseur=localisationFournisseur;
    }



    public Fournisseur() {
    }

    public String toString(){
        return this.nomFournisseur;
    }
}
