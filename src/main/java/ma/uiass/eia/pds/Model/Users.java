package ma.uiass.eia.pds.Model;

import jakarta.persistence.*;
import ma.uiass.eia.pds.Dao.UsersDao;
import ma.uiass.eia.pds.Service.UsersService;

import java.io.Serializable;
import java.util.List;

@Entity
@Table(name= "TUsers")
public class Users implements Serializable {
    public Users(String nomUser, String prenomUser, String phoneNumberUser, String emailUser, String userName, String passWord) {
        this.nomUser = nomUser;
        this.prenomUser = prenomUser;
        this.phoneNumberUser = phoneNumberUser;
        this.emailUser = emailUser;
        this.userName = userName;
        PassWord = passWord;
    }
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idUser;
    @Column(name="NomUser", length=50)
    private String nomUser;
    @Column(name="PrenomUser", length=50)
    private String prenomUser;
    @Column(name="PhoneNumberUser", length=50)
    private String phoneNumberUser;
    @Column(name="EmailUser", length=50)
    private String emailUser;
    public int getIdUser() {
        return idUser;
    }
    public void setIdUser(int idUser) {
        this.idUser = idUser;
    }
    public String getNomUser() {
        return nomUser;
    }
    public void setNomUser(String nomUser) {
        this.nomUser = nomUser;
    }

    public String getPrenomUser() {
        return prenomUser;
    }

    public void setPrenomUser(String prenomUser) {
        this.prenomUser = prenomUser;
    }

    public String getPhoneNumberUser() {
        return phoneNumberUser;
    }

    public void setPhoneNumberUser(String phoneNumberUser) {
        this.phoneNumberUser = phoneNumberUser;
    }

    public String getEmailUser() {
        return emailUser;
    }
    public void setEmailUser(String emailUser) {
        this.emailUser = emailUser;
    }
    public String getUserName() {
        return userName;
    }
    public void setUserName(String userName) {
        this.userName = userName;
    }
    public String getPassWord() {
        return PassWord;
    }
    public void setPassWord(String passWord) {
        PassWord = passWord;
    }
    @Column(name="UserName", length=50)
    private String userName;
    @Column(name="PassWord", length=50)
    private String PassWord;
    public Users(){

    }




}
