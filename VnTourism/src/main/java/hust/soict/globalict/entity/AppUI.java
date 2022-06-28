package hust.soict.globalict.entity;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;


public class AppUI extends Application {

    private ChoiceBox<String> manmadeChoiceBox = new ChoiceBox<String>();
    private ChoiceBox<String> naturalChoiceBox = new ChoiceBox<String>();
    private String[] manmadeAttraction = {
            "Amusement Park", "Building", "Hotel", "Modern Architecture",
            "Bridge", "Cathedral", "Museum", "Temple"
    };

    private String[] naturalAttraction = {
            "Bay", "Beach", "Body of Water", "Lake", "River",
            "Botanical Garden", "Cave", "Island", "Mountain", "National Park",
            "Zoo"
    };


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text title = new Text("Welcome to Vietnam tourism");
        title.setFont(Font.font("Calibri",FontWeight.MEDIUM,20));
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton manmadeButton = new RadioButton();
        RadioButton naturalButton = new RadioButton();

        manmadeButton.setToggleGroup(toggleGroup);
        naturalButton.setToggleGroup(toggleGroup);

        manmadeChoiceBox.getItems().addAll(manmadeAttraction);
        naturalChoiceBox.getItems().addAll(naturalAttraction);

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400,200);
        gridPane.setPadding(new Insets(10,10,10,10));

        gridPane.setHgap(5);
        gridPane.setVgap(5);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(title,1,0);
        gridPane.add(manmadeButton,0,1);
        gridPane.add(new Text("Manmade attraction"),1,1);
        gridPane.add(manmadeChoiceBox,2,1);
        gridPane.add(naturalButton,0,2);
        gridPane.add(new Text("Natural attraction"),1,2);
        gridPane.add(naturalChoiceBox,2,2);
        gridPane.add(new Button("Get"),1,5);

        Scene scene = new Scene(gridPane,500,300);



        primaryStage.setTitle("Vietnam Tourism");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();



    }
}
