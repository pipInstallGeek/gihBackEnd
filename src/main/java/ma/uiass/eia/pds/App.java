            package ma.uiass.eia.pds;

            import com.sun.net.httpserver.HttpServer;

            import jakarta.ws.rs.core.UriBuilder;

            import ma.uiass.eia.pds.Controller.ReservationController;
            import ma.uiass.eia.pds.Dao.*;
            import ma.uiass.eia.pds.Model.*;
            import ma.uiass.eia.pds.Service.*;


            import org.glassfish.jersey.jackson.JacksonFeature;
            import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
            import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
            import org.glassfish.jersey.server.ResourceConfig;

            import java.net.*;
            import java.time.LocalDate;
            import java.time.LocalDateTime;
            import java.time.Month;
            import java.time.ZoneId;
            import java.util.*;


            public class App extends ResourceConfig {
            public App(){
                packages("ma.uiass.eia.pds");
            }
                public static void main(String[] args )
            {

                URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
                ResourceConfig config = new ResourceConfig().packages("ma.uiass.eia.pds","com.fasterxml.jackson.jaxrs.json.provider").register(JacksonFeature.class);
                config.register(ReservationController.class);
                HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
                System.out.println("server launched Successfully ");

/*
                IBatimentService batimentService = new BatimentService();
                IEtageService etageService = new EtageService();
                IServiceService serviceService = new ServiceService();
                IEspaceService espaceService = new ChambreService();
                ITypeLitService typeLitService = new TypeLitService();
                IMarqueService marqueService = new MarqueService();
                ILitService litService = new LitService();

                Batiment batiment = new Batiment("A");
                Batiment batiment1 = new Batiment("B");
                Batiment batiment2 = new Batiment("C");
                batimentService.ajouter(batiment1);
                batimentService.ajouter(batiment2);
                batimentService.ajouter(batiment);


                Etage etage = new Etage("1", batiment);
                Etage etage1 = new Etage("2", batiment);
                Etage etage4 = new Etage("3", batiment);
                Etage etage2 = new Etage("1", batiment1);
                Etage etage3 = new Etage("2", batiment1);
                etageService.ajouter(etage);
                etageService.ajouter(etage1);
                etageService.ajouter(etage2);
                etageService.ajouter(etage3);
                etageService.ajouter(etage4);

                Service service = new Service("Car", "Cardiologie", etage);
                Service service1 = new Service("On", "Oncologie", etage);
                Service service2 = new Service("Gy", "Gynécologie", etage1);
                serviceService.ajouter(service);
                serviceService.ajouter(service1);
                serviceService.ajouter(service2);



                Espace chambre = new Chambre(TypeChambre.SIMPLE,service );
                Espace chambre1 = new Chambre(TypeChambre.DOUBLE, service1);
                Espace chambre2 = new Chambre(TypeChambre.DOUBLE, service2);
                espaceService.ajouter(chambre2);
                espaceService.ajouter(chambre);
                espaceService.ajouter(chambre1);

                TypeLit typeLit = new TypeLit("Lit electrique");
                TypeLit typeLit1 = new TypeLit("Lit manuelle");
                typeLitService.ajouter(typeLit);
                typeLitService.ajouter(typeLit1);

                Marque marque = new Marque("K","Kinedorssal");
                Marque marque1 = new Marque("K","ComfyBed");
                Marque marque2 = new Marque("K","MyBedsComfy");
                marqueService.ajouter(marque);
                marqueService.ajouter(marque1);
                marqueService.ajouter(marque2);

                Lit lit = new Lit(EtatLit.DEFECTUEUSE, false, chambre1, typeLit1, marque);
                Lit lit1 = new Lit(EtatLit.DEFECTUEUSE, true, chambre, typeLit, marque1);
                Lit lit2 = new Lit(EtatLit.DEFECTUEUSE, true, chambre2, typeLit, marque2);
                Lit lit3 = new Lit(EtatLit.DEFECTUEUSE, false, chambre1, typeLit1, marque2);
                Lit lit4 = new Lit(EtatLit.BONNNEETAT, false, chambre2, typeLit, marque1);
                Lit lit5 = new Lit(EtatLit.BONNNEETAT, true, chambre, typeLit1, marque);
                Lit lit6 = new Lit(EtatLit.DEFECTUEUSE, true, chambre, typeLit, marque1);
                Lit lit7 = new Lit(EtatLit.DEFECTUEUSE, false, chambre1, typeLit1, marque2);
                Lit lit8 = new Lit(EtatLit.BONNNEETAT, true, chambre1, typeLit, marque);
                Lit lit9 = new Lit(EtatLit.DEFECTUEUSE, true, chambre2, typeLit1, marque2);
                Lit lit10 = new Lit(EtatLit.BONNNEETAT, false, chambre2, typeLit, marque2);
                Lit lit11 = new Lit(EtatLit.DEFECTUEUSE, true, chambre, typeLit1, marque1);
                Lit lit12 = new Lit(EtatLit.BONNNEETAT, false, chambre1, typeLit1, marque);
                Lit lit13= new Lit(EtatLit.DEFECTUEUSE, true, chambre2, typeLit, marque1);
                Lit lit14= new Lit(EtatLit.BONNNEETAT, true, chambre, typeLit, marque2);
                Lit lit15= new Lit(EtatLit.BONNNEETAT, false, chambre2, typeLit1, marque);
                Lit lit16= new Lit(EtatLit.BONNNEETAT, true, chambre1, typeLit, marque1);


                litService.ajouter(lit);
                litService.ajouter(lit1);
                litService.ajouter(lit2);
                litService.ajouter(lit3);
                litService.ajouter(lit4);
                litService.ajouter(lit5);
                litService.ajouter(lit6);
                litService.ajouter(lit7);
                litService.ajouter(lit8);
                litService.ajouter(lit9);
                litService.ajouter(lit10);
                litService.ajouter(lit11);
                litService.ajouter(lit12);
                litService.ajouter(lit13);
                litService.ajouter(lit14);
                litService.ajouter(lit15);
                litService.ajouter(lit16);


 */
            IStockService stockService = new StockService();
            Stock stock  = new Stock("Agent Logistic",null);
            stockService.ajouter(stock);


            ITypeDMSerivce typeDMSerivce = new TypeDMService();
            TypeDM typeDM = new TypeDM("Fr","fourniture");
            typeDMSerivce.ajouter(typeDM);
            TypeDM typeDM1 = new TypeDM("I L ", "instruments légers");
            typeDMSerivce.ajouter(typeDM1);

            IDispoMedicalService dispoMedicalService = new DispoMedicalServiceImp();
            DispositifMedical dispo = new DispositifMedical("Seringue", typeDM);
            dispoMedicalService.ajouterDispoMed(dispo);

            }
        }
