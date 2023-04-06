            package ma.uiass.eia.pds.Model;


            import java.io.Serializable;

            import com.fasterxml.jackson.annotation.JsonIgnore;
            import jakarta.persistence.*;
            import java.util.List;

            @Entity
            @Table(name= "TEspace")
            @Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
            public abstract class Espace implements Serializable {
                public Service getService() {
                    return service;
                }

                public void setService(Service service) {
                    this.service = service;
                }

                public List<Lit> getLit() {
                    return lit;
                }

                public String getTypeEspace() {
                    return typeEspace;
                }

                public void setTypeEspace(String typeEspace) {
                    this.typeEspace = typeEspace;
                }

                public void setLit(List<Lit> lit) {
                    this.lit = lit;
                }
                @Id
                @GeneratedValue(strategy = GenerationType.TABLE)
                private int idEspace;
                @Column(name="typeEspace", length=50)
                String typeEspace;
                //@JsonIgnore
                @ManyToOne(fetch = FetchType.EAGER)
                @JoinColumn(name = "idService", referencedColumnName = "idService")
                private Service service;
                @JsonIgnore
                @OneToMany
                @JoinColumn(name = "idEspace", referencedColumnName = "idEspace")
                private List<Lit> lit;
                public int getIdEspace() {
                    return idEspace;
                }
                public void setIdEspace(int idEspace) {
                    this.idEspace = idEspace;
                }
                public Espace( Service service) {
                    this.service = service;
                }
                public Espace() {
                }
                public String  toString(){
                    return this.getTypeEspace();
                }



            }




