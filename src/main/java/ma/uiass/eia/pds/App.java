
    package ma.uiass.eia.pds;

    import com.sun.net.httpserver.HttpServer;

    import jakarta.ws.rs.core.UriBuilder;

    import ma.uiass.eia.pds.Model.Chambre;
    import ma.uiass.eia.pds.Model.Service;
    import ma.uiass.eia.pds.Service.*;
    import ma.uiass.eia.pds.Model.EtatLit;
    import ma.uiass.eia.pds.Model.Lit;


    import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
    import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
    import org.glassfish.jersey.server.ResourceConfig;

    import java.net.*;
    import java.util.ArrayList;
    import java.util.List;


    public class App extends ResourceConfig {
    public App(){
        packages("ma.uiass.eia.pds");
    }

        public static void main(String[] args )
    {
        System.out.println("here");
        URI baseUri = UriBuilder.fromUri("http://localhost/").port(9998).build();
        ResourceConfig config = new ResourceConfig().packages("ma.uiass.eia.pds");
        config.register(JacksonJsonProvider.class);
        HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);
        System.out.println("not here");

        IServiceService serviceService = new ServiceService();
        ILitService litService = new LitService();
        IChambreService chambreService = new ChambreService();

        Service service1 = new Service("CD", "Cardiologie");
        serviceService.ajouterService(service1);
        Chambre chambre = new Chambre("Num120","etage 1", "double", service1);
        chambreService.ajouterChambre(chambre);
        EtatLit etatLit = null;
        Lit lit = new Lit(EtatLit.INDISPONIBLE);
        litService.ajouterLit(lit);


        /*
        Service service1 = new Service("OC", "Oncologie" );
        Service service2 = new Service("GY", "Gynegologie" );
        Service service3 = new Service("PN", "Pneumologie" );

        serviceService.ajouterService(service);
        serviceService.ajouterService(service1);
        serviceService.ajouterService(service2);
        serviceService.ajouterService(service3);
*/

    }
}
