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

                IEspaceService<Salle> salleIEspaceService=new SalleService();
                salleIEspaceService.ajouter(new Salle("Stock",TypeSalle.UNKNOWN,service));





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




                //------------------------------------------------------------------------------------------------------------------------
                TypeDmServiceImp typeDmServiceImp=new TypeDmServiceImp();
                typeDmServiceImp.ajouterTypeDm(new TypeDM("instruments légers"));
                typeDmServiceImp.ajouterTypeDm(new TypeDM("outils de diagnostic"));
                typeDmServiceImp.ajouterTypeDm(new TypeDM("mobilier"));
                typeDmServiceImp.ajouterTypeDm(new TypeDM("équipement léger"));
                typeDmServiceImp.ajouterTypeDm(new TypeDM("DM connectés"));
                typeDmServiceImp.ajouterTypeDm(new TypeDM("équipement lourd"));



                EtatsAmbulance etat1=new F();
                EtatsAmbulance etat2=new NFLD();
                EtatsAmbulance etat3=new NFCD();
                etat1.setStateName(StateName.F);
                etat2.setStateName(StateName.NFLD);
                etat3.setStateName(StateName.NFCD);
                IEtatsAmbulanceService etatsAmbulanceService=new EtatsAmbulanceService();
                etatsAmbulanceService.ajouter(etat1);
                etatsAmbulanceService.ajouter(etat2);
                etatsAmbulanceService.ajouter(etat3);


                IAmbulanceService ambulanceService=new AmbulanceService();
                ambulanceService.ajouter(new Ambulance("1/ALIF/20103","123909","12/9/2006"));
                Ambulance dd =new Ambulance("1/ALIF/20103","123909","12/9/2006");
                dd.setEtatsAmbulance(etat2);
                ambulanceService.ajouter(dd);
                Ambulance ambulance=new Ambulance("2/ALIF/20103","390309","1/10/2007");
                ambulance.setEtatsAmbulance(etat3);
                ambulanceService.ajouter(ambulance);
                Ambulance ambulance2=new Ambulance("58/ALIF/20103","12093","12/10/2013");
                ambulance2.setEtatsAmbulance(etat3);
                ambulanceService.ajouter(ambulance2);












               /* IAmbulanceService ambulanceService=new AmbulanceService();
                IEtatsAmbulanceService etatsAmbulanceService=new EtatsAmbulanceService();
                /*
                List<EtatsAmbulance> etatsAmbulanceList=etatsAmbulanceService.afficherTout();
                Ambulance ambulance=ambulanceService.afficherTout().get(0);
                System.out.println(ambulance.getEtatsAmbulance().getStateName().toString().equals("F"));

                System.out.println(ambulanceService.afficherAmbulanceEtat("F"));
                Ambulance ambulance1=new Ambulance("1/ALIF/20103","123909","12/9/2006");
                ambulance1.setEtatsAmbulance(etatsAmbulanceList.get(0));
                ambulanceService.ajouter(ambulance1);

                 */

              //  System.out.println(etatsAmbulanceService.afficherTout().get(0));




/*
                IAmbulanceService ambulanceService=new AmbulanceService();
                ambulanceService.ajouter(new Ambulance("1/ALIF/20103","123909","12/9/2006",etat1));
                Ambulance dd =new Ambulance("1/ALIF/20103","123909","12/9/2006",etat1);
                ambulanceService.ajouter(new Ambulance("2/ALIF/20103","390309","1/10/2007",etat2));
                ambulanceService.ajouter(new Ambulance("4/ALIF/20103","20309","2/10/2008",etat3));
                ambulanceService.ajouter(new Ambulance("6/ALIF/20103","1209","21/10/2009",etat3));
                ambulanceService.ajouter(new Ambulance("39/ALIF/20103","208309","14/10/2012",etat3));
                ambulanceService.ajouter(new Ambulance("58/ALIF/20103","12093","12/10/2013",etat1));
                ambulanceService.ajouter(new Ambulance("20/ALIF/20103","149","12/10/2014",etat1));
                ambulanceService.ajouter(new Ambulance("44/ALIF/20103","1309","12/10/2010",etat1));


 */













/*
                ambulanceService.afficherTout().get(0).setEtatsAmbulance(etat1);
                ambulanceService.afficherTout().get(1).setEtatAmbulance(etat1);
                ambulanceService.afficherTout().get(2).setEtatAmbulance(etat1);
                ambulanceService.afficherTout().get(3).setEtatAmbulance(etat1);
                ambulanceService.afficherTout().get(4).setEtatAmbulance(etat1);
                ambulanceService.afficherTout().get(5).setEtatAmbulance(etat1);
                ambulanceService.afficherTout().get(6).setEtatAmbulance(etat2);
                ambulanceService.afficherTout().get(6).setEtatAmbulance(etat3);

 */


















/*
                SalleService salleService=new SalleService();
                ServiceService serviceService1=new ServiceService();
                salleService.ajouter(new Salle("Stock",TypeSalle.UNKNOWN,serviceService1.afficherTout().get(serviceService1.afficherTout().size()-1)));

*/

                //------------------------------------------------------------------------------------------------------------------------


                /*

                System.out.println(typeDmServiceImp.afficherTypeDm());


                TypeDmServiceImp typeDmServiceImp=new TypeDmServiceImp();
                IDispoMedicalService dispoMedicalServiceImp=new DispoMedicalServiceImp();
                TypeDM typeDM = new TypeDM("fournitures");
                typeDmServiceImp.ajouterTypeDm(typeDM);



                typeDmServiceImp.ajouterTypeDm(new TypeDM("équipement lourd"));


             //IDispoMedicalService dispoMedicalServiceImp=new DispoMedicalServiceImp();
               /* dispoMedicalServiceImp.ajouterDispoMed(new DispoMedical("Scanner",typeDM,22));
                System.out.println(dispoMedicalServiceImp.afficherDispoMedical());




               // dispoMedicItemService.ajouter(i1);


                IDispoMedicalService dispoMedicalServiceImp=new DispoMedicalServiceImp();
                IDispoMedicItemService dispoMedicItemService=new DispoMedicItemService();
                ITypeDmService typeDmService=new TypeDmServiceImp();

                TypeDM t1=new TypeDM("équipement léger");
                typeDmService.ajouterTypeDm(t1);
                DispoMedical i= new DispoMedical("ScannerAlpha",t1,10);
                dispoMedicalServiceImp.ajouterDispoMed(i);
                for(int j=0;j<=3;j++){
                DispoMedicItem i1=new DispoMedicItem("Scanner"+Integer.valueOf((int)(Math.random()*100)),i);
                dispoMedicItemService.ajouter(i1);}



                /*IDetailsService detailsService=new DetailsLivraisonService();
                System.out.println(detailsService.afficherTout());









                IDispoMedicalService dispoMedicalServiceImp=new DispoMedicalServiceImp();
                ILivraisonService livraisonService=new LivraisonFourniseurService();
                IDetailsService detailsService=new DetailsLivraisonService();

                LivraisonFournisseur l1=new LivraisonFournisseur("BSDS1D",Fournisseur.McKessonCorporation,"10/02/2022");
                livraisonService.ajouter(l1);


                detailsService.ajouter(new DetailsLivraison(12,livraisonService.afficherTout().get(0), dispoMedicalServiceImp.afficherDispoMedical().get(0)));

                System.out.println(dispoMedicalServiceImp.afficherDispoMedical().get(dispoMedicalServiceImp.afficherDispoMedical().size()-1));



                 */



/*
                IAmbulanceService ambulanceService=new AmbulanceService();
                IEtatsAmbulanceService etatsAmbulanceService=new EtatsAmbulanceService();
                for(Ambulance ambulance:ambulanceService.afficherTout()){
                    if(ambulance.getEtatAmbulance() == null){
                        ambulance.setEtatAmbulance(etatsAmbulanceService.afficherTout().get(0));
                    }
                }
                System.out.println(ambulanceService.afficherAmbulanceEtat("NFCD"));



 */


















            }
        }
