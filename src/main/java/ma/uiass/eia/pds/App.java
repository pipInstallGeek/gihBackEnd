            package ma.uiass.eia.pds;

            import com.sun.net.httpserver.HttpServer;

            import jakarta.ws.rs.core.UriBuilder;

            import ma.uiass.eia.pds.Controller.ReservationController;
            import ma.uiass.eia.pds.Dao.IMarqueDao;
            import ma.uiass.eia.pds.Dao.ITypeLitDao;
            import ma.uiass.eia.pds.Dao.MarqueDao;
            import ma.uiass.eia.pds.Dao.TypeLitDao;
            import ma.uiass.eia.pds.Model.*;
            import ma.uiass.eia.pds.Service.*;


            import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
            import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
            import org.glassfish.jersey.server.ResourceConfig;

            import java.net.*;
            import java.time.LocalDate;
            import java.time.LocalDateTime;
            import java.time.Month;
            import java.time.ZoneId;
            import java.util.ArrayList;
            import java.util.Arrays;
            import java.util.Calendar;
            import java.util.Date;


            public class App extends ResourceConfig {
            public App(){
                packages("ma.uiass.eia.pds");
            }
                public static void main(String[] args )
            {

                URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
                ResourceConfig config = new ResourceConfig().packages("ma.uiass.eia.pds");
                config.register(JacksonJsonProvider.class);
                config.register(ReservationController.class);
                HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
                System.out.println("server launched Successfully ");

                IBatimentService batimentService = new BatimentService();
                IEtageService etageService = new EtageService();
                IServiceService serviceService = new ServiceService();
                IEspaceService espaceService = new ChambreService();
                ITypeLitService typeLitService = new TypeLitService();
                IMarqueService marqueService = new MarqueService();
                ILitService litService = new LitService();

                Batiment batiment = new Batiment("Batiment A");
                Batiment batiment1 = new Batiment("Batiment B");
                batimentService.ajouter(batiment1);
                batimentService.ajouter(batiment);


                Etage etage = new Etage("Etage 1", batiment);
                Etage etage1 = new Etage("Etage 2", batiment);
                Etage etage4 = new Etage("Etage 3", batiment);
                Etage etage2 = new Etage("Etage 1", batiment1);
                Etage etage3 = new Etage("Etage 2", batiment1);
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



                Espace chambre = new Chambre("Chambre 10", TypeChambre.SIMPLE,service );
                Espace chambre1 = new Chambre("Chambre 2", TypeChambre.DOUBLE, service1);
                espaceService.ajouter(chambre);
                espaceService.ajouter(chambre1);

                TypeLit typeLit = new TypeLit("Lit electrique");
                typeLitService.ajouter(typeLit);

                Marque marque = new Marque("K","Kinedorss");
                marqueService.ajouter(marque);

                Lit lit = new Lit(EtatLit.DEFECTUEUSE, false, (Chambre) chambre1, typeLit, marque);
                Lit lit1 = new Lit(EtatLit.BONNNEETAT, true, (Chambre) chambre1, typeLit, marque);

                litService.ajouter(lit1);
                litService.ajouter(lit);



            }
        }
