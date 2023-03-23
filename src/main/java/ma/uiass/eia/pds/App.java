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






            }
        }
