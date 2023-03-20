    package ma.uiass.eia.pds;

    import com.sun.net.httpserver.HttpServer;

    import jakarta.ws.rs.core.UriBuilder;

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
    import java.util.ArrayList;
    import java.util.Arrays;


    public class App extends ResourceConfig {
    public App(){
        packages("ma.uiass.eia.pds");
    }

        public static void main(String[] args )
    {

        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig().packages("ma.uiass.eia.pds");
        config.register(JacksonJsonProvider.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);

        System.out.println("server launched Successfully ");

        IServiceService serviceService = new ServiceService();
        ILitService litService = new LitService();
        IEspaceService chambreService = new ChambreService();
        IEspaceService salleService = new SalleService();
        IEtageService etageService = new EtageService();
        IBatimentService batimentService = new BatimentService();
        IMarqueService marqueService = new MarqueService();
        ITypeLitService typeLitService = new TypeLitService();

/*
        Batiment batiment = new Batiment("Batiment A");
        batimentService.ajouter(batiment);

        Etage etage = new Etage("Etage 1", batiment);
        Etage etage1 = new Etage("Etage 2", batiment);
        Etage etage2 = new Etage("Etage 3", batiment);

        etageService.ajouter(etage);
        etageService.ajouter(etage1);
        etageService.ajouter(etage2);


        Service service1 = new Service("OC", "Oncologie", etage );
        Service service2 = new Service("GY", "Gynegologie", etage1 );
        Service service3 = new Service("PN", "Pneumologie", etage2 );

        serviceService.ajouter(service1);
        serviceService.ajouter(service2);
        serviceService.ajouter(service3);

        Espace chambre = new Chambre("chambre 10",TypeChambre.SIMPLE,"Espace10", service1 );
        Espace salle = new Salle("salle2", TypeSalle.OPERATION, service2);
        chambreService.ajouter(chambre);
        salleService.ajouter(salle);
        service1.setEspaces(new ArrayList<Espace>(Arrays.asList(salle, chambre)));


        chambreService.ajouter(chambre);

        Marque marque = new Marque("marque1", "Dorssal");
        marqueService.ajouter(marque);

        TypeLit typeLit = new TypeLit("type Je sais pas ");
        typeLitService.ajouter(typeLit);

        Lit lit = new Lit(marque, typeLit, EtatLit.BONNNEETAT,chambre);

        litService.ajouter(lit);

 */







    }
}
