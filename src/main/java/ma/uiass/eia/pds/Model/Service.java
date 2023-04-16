
package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TService")
public class Service implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idService;
	@Column(name="codeService",length=50)
	private String codeService;
	@Column(name="NomService",length=50)
	private String nomService;
	@JsonIgnore
	@OneToMany(mappedBy = "service")
	private List<Espace> espaces;

	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEtage", referencedColumnName = "idEtage")
	private Etage etage;



	public int getIdService() {
		return idService;
	}

	public void setIdService(int idService) {
		this.idService = idService;
	}

	public List<Espace> getEspaces() {
		return espaces;
	}

	public void setEspaces(List<Espace> espaces) {
		this.espaces = espaces;
	}

	public Etage getEtage() {
		return etage;
	}

	public String getCodeService() {
		return codeService;
	}

	public void setCodeService(String codeS) {
		this.codeService = codeS;
	}

	public String getNomService() {
		return nomService;
	}

	public void setNomService(String nomService) {
		this.nomService = nomService;
	}

	public void setEtage(Etage etage) {
		this.etage = etage;
	}


	public Service(String codeS, String nomService,Etage etage) {
		setEtage(etage);
		setCodeService(etage.getCodeEtage()+codeS);
		setNomService(nomService);
	}

	public Service() {

	}

	public String toString() {
		return this.nomService;
	}
}