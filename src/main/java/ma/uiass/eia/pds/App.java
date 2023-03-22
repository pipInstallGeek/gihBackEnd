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
                IReservationService reservationService =new ReservationService();
                IServiceService serviceService = new ServiceService();
                ILitService litService = new LitService();
                IEspaceService chambreService = new ChambreService();
                IEspaceService salleService = new SalleService();
                IEtageService etageService = new EtageService();
                IBatimentService batimentService = new BatimentService();
                IMarqueService marqueService = new MarqueService();
                ITypeLitService typeLitService = new TypeLitService();
                ICommandeService commandeService = new CommandeService();


                Batiment batiment = new Batiment("Batiment A");
               //batimentService.ajouter(batiment);



                Etage etage = new Etage("Etage 1", batiment);
                Etage etage1 = new Etage("Etage 2", batiment);
                Etage etage2 = new Etage("Etage 3", batiment);

           /*etageService.ajouter(etage);
                etageService.ajouter(etage1);
                etageService.ajouter(etage2);*/

                Service service1 = new Service("OC", "Oncologie", etage );
                Service service2 = new Service("GY", "Gynegologie", etage1 );
                Service service3 = new Service("PN", "Pneumologie", etage2 );

                /*serviceService.ajouter(service1);
                serviceService.ajouter(service2);
                serviceService.ajouter(service3);*/

                Espace chambre = new Chambre("chambre 10",TypeChambre.SIMPLE,"Espace10", service1 );
                Espace salle = new Salle("salle2", TypeSalle.OPERATION, service2);
              // chambreService.ajouter(chambre);
              // salleService.ajouter(salle);
              service1.setEspaces(new ArrayList<Espace>(Arrays.asList(salle, chambre)));


               //chambreService.ajouter(chambre);

                Marque marque = new Marque("marque1", "Dorssal");
              // marqueService.ajouter(marque);

                TypeLit typeLit = new TypeLit("type Je sais pas ");
               typeLitService.ajouter(typeLit);
                LocalDate localDate2 = LocalDate.of(2023, 12, 13);
                LocalDateTime localDateTime2 = localDate2.atStartOfDay();
                Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
                LocalDate localDate3 = LocalDate.of(2020, 12, 13);
                LocalDateTime localDateTime3 = localDate2.atStartOfDay();
                Date date3 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
                Reservation reser1=new Reservation("reser2","patient2", date3,date2,false);
                //reservationService.ajouter(reser1);

                Lit lit = new Lit(EtatLit.BONNNEETAT,true,chambre,reser1,typeLit,marque);
                Lit lit1 = new Lit(EtatLit.BONNNEETAT,true,chambre,reser1,typeLit,marque);


               //litService.ajouter(lit);


                //litService.ajouter(lit1);
                LocalDate localDate = LocalDate.of(2022, 12, 13);
                LocalDateTime localDateTime = localDate.atStartOfDay();
                Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());


               Reservation  reser2=new Reservation(1,"reser2","patient2", date, Calendar.getInstance().getTime(),false,Arrays.asList(lit1,lit));

                //System.out.println(reservationService.afficheHistorique("patient2"));

              //reser2.setDateFin(LocalDate.of(2012, Month.MARCH,5));
              //reser2.setEstAnnulée(true);
                LocalDate localDate1 = LocalDate.of(2023, 2, 13);
                LocalDateTime localDateTime1 = localDate.atStartOfDay();
                Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());
                //reservationService.modifier(reser2,Calendar.getInstance().getTime(),true);
                System.out.println(reservationService.trouverId(3));


                LocalDate localDate5 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime5 = localDate5.atStartOfDay();
                Date date5 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate10 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime10 = localDate10.atStartOfDay();
                Date date10 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate15 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime15 = localDate10.atStartOfDay();
                Date date15 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                Commande commande1 = new Commande(1,"a230",15,date5,date10,true,Arrays.asList(lit1,lit));
                //commandeService.ajouter(commande1);
                System.out.println(commandeService.afficherTout());
                //commandeService.modifier(commande1,date15,false);
                System.out.println(commandeService.afficherTout());
                litService.modifier(lit1,EtatLit.DEFECTUEUSE,false,salle);






            }
        }
