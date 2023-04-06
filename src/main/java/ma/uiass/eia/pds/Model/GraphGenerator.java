package ma.uiass.eia.pds.Model;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.chart.PieChart;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import ma.uiass.eia.pds.Model.Espace;
import ma.uiass.eia.pds.Model.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GraphGenerator extends Application {
    private Map<Service, List<Espace>> serviceEspacesMap = new HashMap<>();

    @Override
    public void start(Stage primaryStage) {
        //Création des données de test pour le graphique
        ObservableList<PieChart.Data> pieChartData = FXCollections.observableArrayList(
                new PieChart.Data("Occupés", 50),
                new PieChart.Data("Disponibles", 50));

        //Création d'un GridPane pour afficher les graphiques
        GridPane root = new GridPane();
        root.setPadding(new Insets(10));
        root.setHgap(10);
        root.setVgap(10);

        //Pour chaque service, créer un graphique et l'ajouter au GridPane
        for (Service service : serviceEspacesMap.keySet()) {
            List<Espace> espaces = serviceEspacesMap.get(service);
            int nbLits = espaces.size();
            int nbLitsDispo = 0;
            int nbLitsOccupe = 0;
            for (Espace espace : espaces) {
                if (espace.getLit().size() == 0) {
                    nbLitsDispo++;
                } else {
                    nbLitsOccupe++;
                }
            }
            ObservableList<PieChart.Data> serviceData = FXCollections.observableArrayList(
                    new PieChart.Data("Occupés", ((double) nbLitsOccupe / nbLits) * 100),
                    new PieChart.Data("Disponibles", ((double) nbLitsDispo / nbLits) * 100));
            PieChart pieChart = new PieChart(serviceData);
            pieChart.setTitle(service.getNomService());
            root.add(pieChart, 0, service.getIdService() - 1);
        }

        //Création de la scène et affichage
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    //Méthode pour initialiser les données de test
    /*private void initTestData() {
        //Récupérer les espaces pour chaque service
        List<Service> services = ... //obtenir les services depuis la base de données
        for (Service service : services) {
            List<Espace> espaces = ... //obtenir les espaces depuis la base de données pour le service en cours
            serviceEspacesMap.put(service, espaces);
        }
    }*/

    public static void main(String[] args) {
        launch(args);
    }
}