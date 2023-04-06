package ma.uiass.eia.pds;

import com.sun.net.httpserver.HttpServer;

import jakarta.ws.rs.core.UriBuilder;

import ma.uiass.eia.pds.Controller.*;
import ma.uiass.eia.pds.Dao.*;
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
        config.register(ReservationController.class);
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
        ICommandeService commandeService = new CommandeService();


        /*Batiment batiment = new Batiment("Batiment A");
        batimentService.ajouter(batiment);

        Etage etage = new Etage("Etage 1", batiment);
        etageService.ajouter(etage);

        Etage etage1 = new Etage("Etage 2", batiment);
        Etage etage2 = new Etage("Etage 3", batiment);
        etageService.ajouter(etage);
        etageService.ajouter(etage1);
        etageService.ajouter(etage2);

        Service service1 = new Service("OC", "Oncologie", etage );
        serviceService.ajouter(service1);

        Service service2 = new Service("GY", "Gynegologie", etage1 );
        Service service3 = new Service("PN", "Pneumologie", etage2 );
        serviceService.ajouter(service1);
        serviceService.ajouter(service2);
        serviceService.ajouter(service3);

        Espace chambre = new Chambre(TypeChambre.SIMPLE,service1);
        chambreService.ajouter(chambre);

        Espace salle = new Salle("salle2", TypeSalle.OPERATION, service2);
        chambreService.ajouter(chambre);
        salleService.ajouter(salle);
        service1.setEspaces(new ArrayList<Espace>(Arrays.asList(salle, chambre)));


        chambreService.ajouter(chambre);*/

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




        TypeLit typeLit0 = new TypeLit("TL01","électrique B ");
        TypeLit typeLit1 = new TypeLit("TL02","électrique 2F  ");
        TypeLit typeLit2 = new TypeLit("TL03","4 sections MF ");
        TypeLit typeLit3 = new TypeLit("TL04","manuel");
        TypeLit typeLit4 = new TypeLit("TL05","soins rotatif MF ");

        typeLitService.ajouter(typeLit0);
        typeLitService.ajouter(typeLit1);
        typeLitService.ajouter(typeLit2);
        typeLitService.ajouter(typeLit3);
        typeLitService.ajouter(typeLit4);

        /*Lit lit = new Lit(EtatLit.BONNNEETAT,Boolean.FALSE,chambre,typeLit0,marque0);
        Lit lit1 = new Lit(EtatLit.BONNNEETAT,false,null,typeLit0,marque0);
        litService.ajouter(lit);
        litService.ajouter(lit1);*/

        Commande commande1 = new Commande("a230",15,"2025-03-20","2026-05-12",typeLit0.getNomTypeLit(),marque0.getNomMarque(),EtatCommande.EN_TRAITEMENT);
        Commande commande2 = new Commande("a231",16,"2025-03-20","2026-05-12",typeLit1.getNomTypeLit(),marque1.getNomMarque(),EtatCommande.TRAITEE);
        Commande commande3 = new Commande("a232",17,"2025-03-20","2026-05-12",typeLit2.getNomTypeLit(),marque2.getNomMarque(),EtatCommande.TRAITEE);
        Commande commande4 = new Commande("a233",18,"2025-03-20","2026-05-12",typeLit3.getNomTypeLit(),marque3.getNomMarque(),EtatCommande.TRAITEE);
        Commande commande5 = new Commande("a234",19,"2025-03-20","2026-05-12",typeLit4.getNomTypeLit(),marque4.getNomMarque(),EtatCommande.EN_TRAITEMENT);
        Commande commande7 = new Commande("souad5",15,"2025-03-20","2026-05-12",typeLit0.getNomTypeLit(),marque0.getNomMarque(),EtatCommande.EN_TRAITEMENT);

        commandeService.ajouter(commande1);
        commandeService.ajouter(commande2);
        commandeService.ajouter(commande3);
        commandeService.ajouter(commande4);
        commandeService.ajouter(commande5);
        commandeService.ajouter(commande7);


        //System.out.println(litService.afficherToutStock());
        //System.out.println("ajout");
        commandeService.supprimerCommande("a230");
        commandeService.supprimerCommande("souad5");
        commandeService.modifier("a234");
        System.out.println("suppression");
        System.out.println(commandeService.afficherTout());
        //System.out.println(commandeService.afficherTout2());
        //commandeService.modifier("a231");
       // MarqueDao marqueDao = new MarqueDao();
        //TypeLitDao typelitDao = new TypeLitDao();
        //System.out.println(typelitDao.getByCode("TL01"));








    }
}
