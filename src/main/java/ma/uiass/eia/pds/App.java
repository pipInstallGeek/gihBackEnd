            package ma.uiass.eia.pds;
            import com.sun.net.httpserver.HttpServer;
            import jakarta.ws.rs.core.UriBuilder;
            import ma.uiass.eia.pds.Controller.AdmissionController;
            import ma.uiass.eia.pds.Dao.IServiceDao;
            import ma.uiass.eia.pds.Dao.ServiceDao;
            import ma.uiass.eia.pds.Model.*;
            import ma.uiass.eia.pds.Service.*;
            import org.glassfish.jersey.jackson.internal.jackson.jaxrs.json.JacksonJsonProvider;
            import org.glassfish.jersey.jdkhttp.JdkHttpServerFactory;
            import org.glassfish.jersey.server.ResourceConfig;
            import java.net.*;
            import java.time.LocalDate;
            import java.time.LocalDateTime;
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
                config.register(AdmissionController.class);
                HttpServer server = JdkHttpServerFactory.createHttpServer(baseUri, config);

                System.out.println("server launched Successfully ");
                IAdmissionService reservationService =new AdmissionService();
                IServiceService serviceService = new ServiceService();
                IServiceDao s=new ServiceDao();
                ILitService litService = new LitService();
                IEspaceService chambreService = new ChambreService();
                IEspaceService salleService = new SalleService();
                IEtageService etageService = new EtageService();
                IBatimentService batimentService = new BatimentService();
                IMarqueService marqueService = new MarqueService();
                ITypeLitService typeLitService = new TypeLitService();
                IUsersService userService=new UsersService();


                Users user1 =new Users("EL HIDAOUI","Souad","0762703212","yaghitab2002@gmail.com","root","root");
                userService.ajouter(user1);


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

                Espace chambre = new Chambre("chambre55",TypeChambre.SIMPLE, service2 );
                Espace salle = new Salle("salle78", TypeSalle.OPERATION,service2);
                Espace chambre2 = new Chambre("chambre0",TypeChambre.SIMPLE, service1 );
                Espace salle2 = new Salle("salle0", TypeSalle.OPERATION,service1);
                Espace chambre1= new Chambre("chambre1",TypeChambre.SIMPLE, service3 );
                Espace salle1 = new Salle("salle2", TypeSalle.OPERATION,service3);
                chambreService.ajouter(chambre);
                salleService.ajouter(salle);
                chambreService.ajouter(chambre1);
                salleService.ajouter(salle1);
                salleService.ajouter(salle2);
                chambreService.ajouter(chambre2);

                service2.setEspaces(new ArrayList<Espace>(Arrays.asList(salle, chambre)));
                service3.setEspaces(new ArrayList<Espace>(Arrays.asList(salle1, chambre1)));
                service1.setEspaces(new ArrayList<Espace>(Arrays.asList(salle2, chambre2)));



                Marque marque = new Marque("marque1", "Dorssal");
               marqueService.ajouter(marque);

                TypeLit typeLit = new TypeLit("type Je sais pas ");
                typeLitService.ajouter(typeLit);
               /* LocalDate localDate2 = LocalDate.of(2023, 12, 13);
                LocalDateTime localDateTime2 = localDate2.atStartOfDay();
                Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
                LocalDate localDate3 = LocalDate.of(2020, 12, 13);
                LocalDateTime localDateTime3 = localDate2.atStartOfDay();
                Date date3 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());*/

                Lit lit1 = new Lit("lit1",EtatLit.BONNNEETAT,true,chambre,typeLit,marque);
                Lit lit2 = new Lit("lit2",EtatLit.BONNNEETAT,true,salle,typeLit,marque);
                Lit lit3 = new Lit("lit3",EtatLit.BONNNEETAT,true,chambre1,typeLit,marque);
                Lit lit4 = new Lit("lit4",EtatLit.BONNNEETAT,false,salle1,typeLit,marque);
                Lit lit5= new Lit("lit5",EtatLit.BONNNEETAT,false,salle1,typeLit,marque);
                Lit lit6 = new Lit("lit6",EtatLit.BONNNEETAT,false,chambre2,typeLit,marque);
                Lit lit7 = new Lit("lit7",EtatLit.BONNNEETAT,false,salle2,typeLit,marque);
                Lit lit8 = new Lit("lit8",EtatLit.DEFECTUEUSE,false,chambre2,typeLit,marque);
                Lit lit9 = new Lit("lit9",EtatLit.BONNNEETAT,false,chambre2,typeLit,marque);
                Lit lit10 = new Lit("lit10",EtatLit.BONNNEETAT,false,salle2,typeLit,marque);


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



               /* LocalDate localDate = LocalDate.of(2022, 12, 13);
                LocalDateTime localDateTime = localDate.atStartOfDay();
                Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/

                //Admission reser1=new Admission("reser1", date2, Calendar.getInstance().getTime(),lit);
                // reservationService.ajouter(reser1);
                //Admission reser2=new Admission("reser2", date, Calendar.getInstance().getTime(),lit2);
               // Admission reser1=new Admission("reser1", "2020-5-6", "2020-7-6",lit13);
                //Admission reser2=new Admission("reser2", "2020-5-7", "2020-7-30",lit14);
                /*reservationService.addAdmission("reser1","2020-05-06",lit4.getCodeLit());
                reservationService.addAdmission("reser2","2020-05-07",lit5.getCodeLit());*/
                //reservationService.updateAdmission("reser1","2020-07-06");

               //reservationService.updateAdmission("reser1","2020-07-06");

               /* reservationService.ajouter(reser1);
                reservationService.ajouter(reser2);*/


                /*LocalDate localDate1 = LocalDate.of(2023, 2, 13);
                LocalDateTime localDateTime1 = localDate.atStartOfDay();
                Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/

               //reservationService.modifier(reser2,Calendar.getInstance().getTime(),true);
               // System.out.println(reservationService.trouverId(3));


                LocalDate localDate5 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime5 = localDate5.atStartOfDay();
                Date date5 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate10 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime10 = localDate10.atStartOfDay();
                Date date10 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate15 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime15 = localDate10.atStartOfDay();
                Date date15 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                
                // System.out.println(commandeService.afficherTout());
                // commandeService.modifier(commande1,date15,false);
                //System.out.println(commandeService.afficherTout());
                //litService.modifier(lit1,EtatLit.DEFECTUEUSE,false,salle);
                //reservationService.modifier(reser1,Calendar.getInstance().getTime(),true);
                System.out.println(s.getAll());
            }
        }
