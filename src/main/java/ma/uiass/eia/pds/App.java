            package ma.uiass.eia.pds;
            import com.sun.net.httpserver.HttpServer;
            import jakarta.ws.rs.core.UriBuilder;
            import ma.uiass.eia.pds.Controller.AdmissionController;
            import ma.uiass.eia.pds.Dao.IServiceDao;
            import ma.uiass.eia.pds.Dao.LitDao;
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
            import java.util.*;

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



                IAdmissionService admissionService =new AdmissionService();
                IDemandeService commandeService=new DemandeService();
                IServiceService serviceService = new ServiceService();
                IServiceDao s=new ServiceDao();
                ILitService litService = new LitService();
                IEspaceService chambreService = new ChambreService();
                IEspaceService salleService = new SalleService();
                IEtageService etageService = new EtageService();
                IBatimentService batimentService = new BatimentService();
                IMarqueService marqueService = new MarqueService();
                ITypeLitService typeLitService = new TypeLitService();
                IDescriptionDMService descriptionDMService=new DescriptionDMService();
                ITypeDMService typeDMService=new TypeDMService();
                IExemplaireDMService exemplaireDMService=new ExemplaireDMService();
                LitDao l=new LitDao();






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
        Service service4 = new Service("DR", "Dérmathologie", etage2 );

        serviceService.ajouter(service1);
        serviceService.ajouter(service2);
        serviceService.ajouter(service3);
        serviceService.ajouter(service4);

        Espace chambre = new Chambre(TypeChambre.SIMPLE, service2 );
        Espace salle = new Salle("salle78", TypeSalle.OPERATION,service2);
        Espace chambre2 = new Chambre(TypeChambre.SIMPLE, service1 );
        Espace salle2 = new Salle("salle0", TypeSalle.OPERATION,service1);
        Espace chambre1= new Chambre(TypeChambre.SIMPLE, service3 );
        Espace salle1 = new Salle("salle2", TypeSalle.OPERATION,service3);
        Espace salle3 = new Salle("salle3", TypeSalle.OPERATION,service4);
        Espace chambre3= new Chambre(TypeChambre.SIMPLE, service4 );


                    Marque marque0 = new Marque("MQ01", "Hillrom");
                    Marque marque1= new Marque("MQ02", "JD MED");
                    Marque marque2= new Marque("MQ03", "Favero");
                    Marque marque3= new Marque("MQ04", "stryker");
                    Marque marque4= new Marque("MQ05", "Malvestion");
                    Marque marque5= new Marque("MQ06", "MESPA");
                    Marque marque6= new Marque("MQ07", "FAMED");
                    Marque marque7= new Marque("MQ08", "SAIKANG");
                    Marque marque8= new Marque("MQ09", "HFMED");
                    Marque marque9= new Marque("MQ010", "Pukang");

        chambreService.ajouter(chambre);
        salleService.ajouter(salle);
        chambreService.ajouter(chambre1);
        salleService.ajouter(salle1);
        salleService.ajouter(salle2);
        chambreService.ajouter(chambre2);
        chambreService.ajouter(chambre3);
        salleService.ajouter(salle3);

                TypeLit typeLit = new TypeLit("Lit electrique");
                typeLitService.ajouter(typeLit);

                    marqueService.ajouter(marque0);
                    marqueService.ajouter(marque1);
                    marqueService.ajouter(marque2);
                    marqueService.ajouter(marque3);
                    marqueService.ajouter(marque4);
                    marqueService.ajouter(marque5);
                    marqueService.ajouter(marque6);
                    marqueService.ajouter(marque7);
                    marqueService.ajouter(marque8);
                    marqueService.ajouter(marque9);




                    TypeLit typeLit0 = new TypeLit("électrique B ","TL01");
                    TypeLit typeLit1 = new TypeLit("électrique 2F  ","TL02");
                    TypeLit typeLit2 = new TypeLit("4 sections MF ","TL03");
                    TypeLit typeLit3 = new TypeLit("manuel","TL04");
                    TypeLit typeLit4 = new TypeLit("soins rotatif MF ","TL05");

                    typeLitService.ajouter(typeLit0);
                    typeLitService.ajouter(typeLit1);
                    typeLitService.ajouter(typeLit2);
                    typeLitService.ajouter(typeLit3);
                    typeLitService.ajouter(typeLit4);
                    Demande demande1 = new Demande("a230",15,"2025-03-20","2026-05-12",typeLit0.getNomTypeLit(),marque0.getNomMarque(), EtatDemande.EN_TRAITEMENT,service1.getNomService());
                    Demande demande2 = new Demande("a231",16,"2025-03-20","2026-05-12",typeLit1.getNomTypeLit(),marque1.getNomMarque(), EtatDemande.TRAITEE,service2.getNomService());
                    Demande demande3 = new Demande("a232",17,"2025-03-20","2026-05-12",typeLit2.getNomTypeLit(),marque2.getNomMarque(), EtatDemande.TRAITEE,service3.getNomService());
                    Demande demande4 = new Demande("a233",18,"2025-03-20","2026-05-12",typeLit3.getNomTypeLit(),marque3.getNomMarque(), EtatDemande.TRAITEE,service2.getNomService());
                    Demande demande5 = new Demande("a234",19,"2025-03-20","2026-05-12",typeLit4.getNomTypeLit(),marque4.getNomMarque(), EtatDemande.EN_TRAITEMENT,service1.getNomService());
                    Demande demande7 = new Demande("souad5",15,"2025-03-20","2026-05-12",typeLit0.getNomTypeLit(),marque0.getNomMarque(), EtatDemande.EN_TRAITEMENT,service2.getNomService());

                    commandeService.ajouter(demande1);
                    commandeService.ajouter(demande2);
                    commandeService.ajouter(demande3);
                    commandeService.ajouter(demande4);
                    commandeService.ajouter(demande5);
                    commandeService.ajouter(demande7);

                    System.out.println("ajout");
                    commandeService.supprimerDemande("a230");
                    commandeService.supprimerDemande("souad5");
                    commandeService.modifier("a234");
                    System.out.println("suppression");
                    System.out.println(commandeService.afficherTout());
               /* LocalDate localDate2 = LocalDate.of(2023, 12, 13);
                LocalDateTime localDateTime2 = localDate2.atStartOfDay();
                Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
                LocalDate localDate3 = LocalDate.of(2020, 12, 13);
                LocalDateTime localDateTime3 = localDate2.atStartOfDay();
                Date date3 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());*/

                Lit lit1 = new Lit(EtatLit.BONNNEETAT,true,chambre,typeLit0,marque0);
                Lit lit2 = new Lit(EtatLit.BONNNEETAT,true,salle,typeLit1,marque0);
                Lit lit3 = new Lit(EtatLit.BONNNEETAT,true,chambre1,typeLit0,marque0);
                Lit lit4 = new Lit(EtatLit.BONNNEETAT,false,salle1,typeLit0,marque0);
                Lit lit5= new Lit(EtatLit.BONNNEETAT,false,salle1,typeLit0,marque0);
                Lit lit6 = new Lit(EtatLit.BONNNEETAT,false,chambre2,typeLit0,marque0);
                Lit lit7 = new Lit(EtatLit.BONNNEETAT,false,salle2,typeLit0,marque0);
                Lit lit8 = new Lit(EtatLit.DEFECTUEUSE,false,chambre2,typeLit0,marque0);
                Lit lit9 = new Lit(EtatLit.BONNNEETAT,false,chambre2,typeLit0,marque0);
                Lit lit10 = new Lit(EtatLit.BONNNEETAT,false,salle2,typeLit0,marque0);
                Lit lit11 = new Lit(EtatLit.BONNNEETAT,false,chambre3,typeLit0,marque0);
                Lit lit12 = new Lit(EtatLit.BONNNEETAT,true,salle3,typeLit0,marque0);
                Lit lit13= new Lit(EtatLit.BONNNEETAT,false,salle2,typeLit0,marque0);
                Lit lit14 = new Lit(EtatLit.BONNNEETAT,false,chambre2,typeLit0,marque0);
                Lit lit15 = new Lit(EtatLit.BONNNEETAT,false,salle2,typeLit0,marque0);
                Lit lit16 = new Lit(EtatLit.DEFECTUEUSE,true,chambre2,typeLit0,marque0);
                Lit lit17 = new Lit(EtatLit.BONNNEETAT,false,chambre,typeLit0,marque0);
                Lit lit18 = new Lit(EtatLit.BONNNEETAT,false,salle,typeLit0,marque0);
                Lit lit19 = new Lit(EtatLit.BONNNEETAT,true,chambre3,typeLit0,marque0);
                Lit lit20 = new Lit(EtatLit.BONNNEETAT,true,salle3,typeLit0,marque0);

        service2.setEspaces(new ArrayList<Espace>(Arrays.asList(salle, chambre)));
        service3.setEspaces(new ArrayList<Espace>(Arrays.asList(salle1, chambre1)));
        service1.setEspaces(new ArrayList<Espace>(Arrays.asList(salle2, chambre2)));
        service4.setEspaces(new ArrayList<Espace>(Arrays.asList(salle3, chambre3)));





        marqueService.ajouter(marque0);
        marqueService.ajouter(marque1);
        marqueService.ajouter(marque2);
        marqueService.ajouter(marque3);
        marqueService.ajouter(marque4);
        marqueService.ajouter(marque5);
        marqueService.ajouter(marque6);
        marqueService.ajouter(marque7);
        marqueService.ajouter(marque8);
        marqueService.ajouter(marque9);





        typeLitService.ajouter(typeLit0);
        typeLitService.ajouter(typeLit1);
        typeLitService.ajouter(typeLit2);
        typeLitService.ajouter(typeLit3);
        typeLitService.ajouter(typeLit4);

               /* LocalDate localDate2 = LocalDate.of(2023, 12, 13);
                LocalDateTime localDateTime2 = localDate2.atStartOfDay();
                Date date2 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());
                LocalDate localDate3 = LocalDate.of(2020, 12, 13);
                LocalDateTime localDateTime3 = localDate2.atStartOfDay();
                Date date3 = Date.from(localDateTime2.atZone(ZoneId.systemDefault()).toInstant());*/



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
                litService.ajouter(lit17);
                litService.ajouter(lit18);
                litService.ajouter(lit19);
                litService.ajouter(lit20);

                System.out.println(l.getNLO());



               /* LocalDate localDate = LocalDate.of(2022, 12, 13);
                LocalDateTime localDateTime = localDate.atStartOfDay();
                Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/

                //Admission reser1=new Admission("reser1", date2, Calendar.getInstance().getTime(),lit);
                // admissionService.ajouter(reser1);
                //Admission reser2=new Admission("reser2", date, Calendar.getInstance().getTime(),lit2);
               Admission reser1=new Admission("reser1", "2020-05-06", null,lit13);
               admissionService.ajouter(reser1);





                   TypeDM typeDM1=new TypeDM("fourniture");
                   TypeDM typeDM2=new TypeDM("instruments légers");
                   TypeDM typeDM3=new TypeDM("outils de diagnostic");
                   typeDMService.ajouter(typeDM1);
                   typeDMService.ajouter(typeDM2);
                   typeDMService.ajouter(typeDM3);

                    DispositifMedical des1=new DispositifMedical("bandes",15,typeDM1,null);
                    DispositifMedical des2=new DispositifMedical("gants",24,typeDM1,null);
                    DispositifMedical des3=new DispositifMedical("seringues",28,typeDM1,null);
                    descriptionDMService.ajouter(des1);
                    descriptionDMService.ajouter(des2);
                    descriptionDMService.ajouter(des3);
                    List<DispositifMedical> lstDM1= Arrays.asList(des1, des2, des3);

                    DispositifMedical des4=new DispositifMedical("pinces",20,typeDM2,null);
                    DispositifMedical des5=new DispositifMedical("ciseaux",12,typeDM2,null);
                    DispositifMedical des6=new DispositifMedical("scalpels",18,typeDM2,null);
                    descriptionDMService.ajouter(des4);
                    descriptionDMService.ajouter(des5);
                    descriptionDMService.ajouter(des6);
                    List<DispositifMedical> lstDM2= Arrays.asList(des4, des5, des6);

                    DispositifMedical des7=new DispositifMedical("stéthoscopes",40,typeDM3,null);
                    DispositifMedical des8=new DispositifMedical("thermomètres",22,typeDM3,null);
                    descriptionDMService.ajouter(des7);
                    descriptionDMService.ajouter(des8);
                    List<DispositifMedical> lstDM3= Arrays.asList(des7, des8);

                   /* ExemplaireDM ex1=new ExemplaireDM(des1);
                    ExemplaireDM ex2=new ExemplaireDM(des1);
                    ExemplaireDM ex3=new ExemplaireDM(des2);
                    ExemplaireDM ex4=new ExemplaireDM(des2);

                    exemplaireDMService.ajouter(ex1);
                    exemplaireDMService.ajouter(ex2);
                    exemplaireDMService.ajouter(ex3);
                    exemplaireDMService.ajouter(ex4);*/
                  /*  System.out.println( typeDMService.trouverTypeDMByDM("fourniture"));
                    System.out.println(exemplaireDMService.trouvezExemplaireByDMetTypeDm("fourniture","bandes"));*/

                   // descriptionDMService.addDescriptionDM("bandes",2,"fourniture","CBatiment AEtage 2GY1");
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
        litService.ajouter(lit17);
        litService.ajouter(lit18);
        litService.ajouter(lit19);
        litService.ajouter(lit20);

        System.out.println(l.getNLO());



               /* LocalDate localDate = LocalDate.of(2022, 12, 13);
                LocalDateTime localDateTime = localDate.atStartOfDay();
                Date date = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/

        //Admission reser1=new Admission("reser1", date2, Calendar.getInstance().getTime(),lit);
        // reservationService.ajouter(reser1);
        //Admission reser2=new Admission("reser2", date, Calendar.getInstance().getTime(),lit2);










        ExemplaireDM ex1=new ExemplaireDM(des1);
        ExemplaireDM ex2=new ExemplaireDM(des1);
        ExemplaireDM ex3=new ExemplaireDM(des2);
        ExemplaireDM ex4=new ExemplaireDM(des2);

        exemplaireDMService.ajouter(ex1);
        exemplaireDMService.ajouter(ex2);
        exemplaireDMService.ajouter(ex3);
        exemplaireDMService.ajouter(ex4);


        IDemandeDMService demandeDM = new DemandeDMService();
        demandeDM.create("DM1",service2.getNomService());
        demandeDM.create("DM2",service1.getNomService());
        demandeDM.create("DM3",service3.getNomService());
        System.out.println(demandeDM.getAll());
        System.out.println(demandeDM.getAllByService(service1));
        demandeDM.findBycode("DM1");
        IDetailDemandeDMService detailDemandeDM = new DetailDemandeDMService();
        detailDemandeDM.create("DDM1",des1.getNomDM(),10);
        detailDemandeDM.create("DDM2",des2.getNomDM(),20);
        detailDemandeDM.create("DDM3",des3.getNomDM(),5);
        detailDemandeDM.create("DDM4",des1.getNomDM(),6);
        detailDemandeDM.create("DDM5",des4.getNomDM(),70);
        detailDemandeDM.create("DDM6",des3.getNomDM(),110);
        detailDemandeDM.update("DDM2","DM1");
        detailDemandeDM.update("DDM6","DM2");
        detailDemandeDM.update("DDM3","DM3");
        detailDemandeDM.update("DDM4","DM1");
        detailDemandeDM.update("DDM5","DM2");
        detailDemandeDM.deleteBycode("DDM1");
        detailDemandeDM.updateqt("DDM2",5);
        System.out.println("hello");
        System.out.println(detailDemandeDM.listDetailDemande("DM2"));
        System.out.println("hello");
        System.out.println(detailDemandeDM.getByCode("DDM3"));

        IStockService stockservice = new StockService();
        Stock st1 = new Stock("logistique",null);
        Stock st2 = new Stock(service2.getNomService(),service2);
        Stock st3 = new Stock(service1.getNomService(),service1);
        Stock st4 = new Stock(service3.getNomService(),service3);
        Stock st5 = new Stock(service4.getNomService(),service4);
        stockservice.ajouter(st1);
        stockservice.ajouter(st2);
        stockservice.ajouter(st3);
        stockservice.ajouter(st4);
        stockservice.ajouter(st5);
        System.out.println(stockservice.trouverNOM("logistique"));
        IStocksDetailsService stockdetail = new StocksDetailsService();

        stockdetail.ajouterS(des1.getNomDM(),st1.getNomStock(),1000);
        stockdetail.ajouterS(des2.getNomDM(),st1.getNomStock(),1000);
        stockdetail.ajouterS(des3.getNomDM(),st1.getNomStock(),1000);
        stockdetail.ajouterS(des4.getNomDM(),st1.getNomStock(),1000);
        stockdetail.ajouterS(des5.getNomDM(),st1.getNomStock(),1000);
        stockdetail.ajouterS(des6.getNomDM(),st1.getNomStock(),1000);
        //stockdetail.updateqt(std1.getIdStocksDetails(),500);
        System.out.println(stockdetail.getByStock(1));






                    /*Demande demande1 = new Demande("2025-03-20",EtatDemande.NON_COMFIRMEE,service1.getNomService());
                    Demande demande2 = new Demande("2025-03-20", EtatDemande.TRAITEE,service2.getNomService());
                    Demande demande3 = new Demande("2025-03-20", EtatDemande.TRAITEE,service3.getNomService());
                    Demande demande4 = new Demande("2025-03-20", EtatDemande.TRAITEE,service2.getNomService());
                    Demande demande5 = new Demande("2025-03-20", EtatDemande.EN_TRAITEMENT,service1.getNomService());
                    Demande demande7 = new Demande("2025-03-20", EtatDemande.EN_TRAITEMENT,service2.getNomService());

                    demandeService.ajouter(demande1);
                    demandeService.ajouter(demande2);
                    demandeService.ajouter(demande3);
                    demandeService.ajouter(demande4);
                    demandeService.ajouter(demande5);
                    demandeService.ajouter(demande7);

                    System.out.println("ajout");
                    demandeService.supprimerDemande("DDM1");
                    demandeService.supprimerDemande("DDM2");
                    demandeService.modifier("DDM6");
                    demandeService.modifier2("DDM6");
                    demandeService.modifier3("DDM6");
                    System.out.println("suppression");
                    System.out.println(demandeService.afficherTout());
                    System.out.println(des1.getNomDM());

                    DetailDemandeService detaildemande = new DetailDemandeService();
                    DetailDemande dt1 = new DetailDemande(des1.getNomDM(),10);
                    DetailDemande dt2 = new DetailDemande(des4.getNomDM(),10);
                    detaildemande.ajouter(des1.getNomDM(),10);
                    detaildemande.ajouter(des4.getNomDM(),10);
                    detaildemande.update("Dbandes1","DDM3");
                    detaildemande.update("Dpinces2","DDM5");
                    detaildemande.supprimer("Dbandes1");
                    System.out.println(detaildemande.afficherTout());
*/












                /*LocalDate localDate1 = LocalDate.of(2023, 2, 13);
                LocalDateTime localDateTime1 = localDate.atStartOfDay();
                Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/
                /*LocalDate localDate5 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime5 = localDate5.atStartOfDay();
                Date date5 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate10 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime10 = localDate10.atStartOfDay();
                Date date10 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate15 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime15 = localDate10.atStartOfDay();
                Date date15 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());
                System.out.println(litService.afficherToutL("Oncologie"));


                 System.out.println(commandeService.afficherTout());
                 commandeService.modifier(commande1,date15,false);
                System.out.println(commandeService.afficherTout());
                litService.modifier(lit1,EtatLit.DEFECTUEUSE,false,salle);
                admissionService.modifier(reser1,Calendar.getInstance().getTime(),true);
                System.out.println(s.getAll());*/
                   // System.out.println(descriptionDMService.trouverDMByTypeDM("fourniture"));
                  //  descriptionDMService.ajouter(new DescriptionDM("sss",1,typeDM1,chambre1));
                    //System.out.println(exemplaireDMService.trouvezExemplaireByDMetTypeDm("gants"));
                    //System.out.println(descriptionDMService.trouverbyNom("bandes"));
                   // System.out.println( descriptionDMService.trouverQuantitéByDM("bandes"));
                   // typeDMService.modifier("instruments légers","I");
                  //  System.out.println(typeDMService.trouverbyNom("fournitures"));
                  //  descriptionDMService.modifier("bande","bandes");
                   //    System.out.println(typeDMService.trouverbyNom("fourniture"));
            }
                }

                /*LocalDate localDate1 = LocalDate.of(2023, 2, 13);
                LocalDateTime localDateTime1 = localDate.atStartOfDay();
                Date date1 = Date.from(localDateTime.atZone(ZoneId.systemDefault()).toInstant());*/
                /*LocalDate localDate5 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime5 = localDate5.atStartOfDay();
                Date date5 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate10 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime10 = localDate10.atStartOfDay();
                Date date10 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());

                LocalDate localDate15 = LocalDate.of(2023, 03, 22);
                LocalDateTime localDateTime15 = localDate10.atStartOfDay();
                Date date15 = Date.from(localDateTime5.atZone(ZoneId.systemDefault()).toInstant());
                System.out.println(litService.afficherToutL("Oncologie"));



                litService.modifier(lit1,EtatLit.DEFECTUEUSE,false,salle);
                reservationService.modifier(reser1,Calendar.getInstance().getTime(),true);
                System.out.println(s.getAll());*/
        //System.out.println(descriptionDMService.trouverDMByTypeDM("fourniture"));
        //System.out.println(exemplaireDMService.trouvezExemplaireByDMetT
        // ypeDm("gants"));
    }
}

