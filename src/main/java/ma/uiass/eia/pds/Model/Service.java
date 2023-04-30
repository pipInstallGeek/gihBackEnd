
package ma.uiass.eia.pds.Model;
import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

//import javax.persistence.*;
@Entity
@Table(name= "TService")
@Data
@NoArgsConstructor
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

	@OneToOne(mappedBy = "service", optional = true)
	private Stock stock;



	public Service(String codeS, String nomService, Etage etage) {
		setEtage(etage);
		setCodeService(etage.getCodeEtage()+codeS);
		setNomService(nomService);
	}


	public String toString() {
		return this.nomService;
	}
}