
package ma.uiass.eia.pds.Model;
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

	@OneToMany(mappedBy = "service")
	private List<Espace> espaces;
	@ManyToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "idEtage", referencedColumnName = "idEtage")
	private Etage etage;

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
	public List<Espace> getEspace() {
		return espaces;
	}
	public void setEspace(List<Espace> espaces) {
		this.espaces = espaces;
	}

	public Service(String codeS, String nomService,Etage etage) {
		setEtage(etage);
		setCodeService(codeS);
		setNomService(nomService);
	}
	private void setEtage(Etage etage) {
	}
	public Service() {

	}
}