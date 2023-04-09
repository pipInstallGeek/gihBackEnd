            package ma.uiass.eia.pds;

            import com.sun.net.httpserver.HttpServer;

            import jakarta.ws.rs.core.UriBuilder;

            import ma.uiass.eia.pds.Config.SecurityConfiguration;
            import ma.uiass.eia.pds.Controller.ReservationController;
            import ma.uiass.eia.pds.Dao.IDao;
            import ma.uiass.eia.pds.Dao.UserDao;
            import ma.uiass.eia.pds.Model.*;
            import ma.uiass.eia.pds.Repository.IUserRepository;


            import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
            import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
            import org.glassfish.jersey.server.ResourceConfig;

            import java.net.*;


            public class App extends ResourceConfig {
                private static IUserRepository IUserRepository;
            public App(){
                packages("ma.uiass.eia.pds");
            }
                public static void main(String[] args )
            {

                URI baseUri = UriBuilder.fromUri("http://localhost/").port(8080).build();
                ResourceConfig config = new ResourceConfig().packages("ma.uiass.eia.pds");
                config.register(JacksonJsonProvider.class);
                config.register(ReservationController.class).register(SecurityConfiguration.class);
                HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
                System.out.println("server launched Successfully ");




                User user = new User("marouane","marouane","marouane10", Role.ADMIN);

                IDao<User> userIDao = new UserDao();

                userIDao.add(user);
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
                batimentService.ajouter(batiment1);
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
                espaceService.ajouter(chambre);
                espaceService.ajouter(chambre1);

                TypeLit typeLit = new TypeLit("Lit electrique");
                typeLitService.ajouter(typeLit);

                Marque marque = new Marque("K","Kinedorssal");
                marqueService.ajouter(marque);

                Lit lit = new Lit(EtatLit.DEFECTUEUSE, false, chambre1, typeLit, marque);
                Lit lit1 = new Lit(EtatLit.BONNNEETAT, true, chambre1, typeLit, marque);

                litService.ajouter(lit1);
                litService.ajouter(lit);
*/




            }
        }
