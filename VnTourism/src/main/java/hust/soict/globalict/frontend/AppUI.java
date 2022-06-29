package hust.soict.globalict.frontend;



import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.util.Optional;



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
        title.setFont(Font.font("Calibri",FontWeight.MEDIUM,24));
        ToggleGroup toggleGroup = new ToggleGroup();

        RadioButton manmadeButton = new RadioButton("Manmade Attraction");
        RadioButton naturalButton = new RadioButton("Natural Attraction");

        manmadeButton.setToggleGroup(toggleGroup);
        naturalButton.setToggleGroup(toggleGroup);

        manmadeChoiceBox.getItems().addAll(manmadeAttraction);
        naturalChoiceBox.getItems().addAll(naturalAttraction);

        manmadeChoiceBox.getSelectionModel().selectFirst();
        naturalChoiceBox.getSelectionModel().selectFirst();

        manmadeChoiceBox.setDisable(true);
        naturalChoiceBox.setDisable(true);

        Button buttonGet = new Button("Get");
        buttonGet.setDisable(true);
        Button buttonExit = new Button("Exit");

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                buttonGet.setDisable(false);
                RadioButton rb = (RadioButton) t1;
                if(rb.getText().equals(manmadeButton.getText())){
                    manmadeChoiceBox.setDisable(false);
                    manmadeChoiceBox.show();
                    naturalChoiceBox.setDisable(true);
                }
                else if(rb.getText().equals(naturalButton.getText())){
                    naturalChoiceBox.setDisable(false);
                    naturalChoiceBox.show();
                    manmadeChoiceBox.setDisable(true);
                }

            }
        });



        buttonGet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initStyle(StageStyle.UTILITY);
                alert.setTitle("Confirmation");
                RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
                String chosen = null;
                if(rb.getText().equals(manmadeButton.getText())){
                    chosen = manmadeChoiceBox.getValue();
                }
                else if (rb.getText().equals(naturalButton.getText())){
                    chosen = naturalChoiceBox.getValue();
                }
                alert.setHeaderText("Is this your choice?");
                alert.setContentText("You have selected " + rb.getText() + " - " + chosen);
                Optional<ButtonType> option = alert.showAndWait();
                if(option.get() == ButtonType.OK){
                    // needs processing here
                }

            }
        });

        buttonExit.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                Platform.exit();
            }
        });

        GridPane gridPane = new GridPane();
        gridPane.setMinSize(400,200);
//        gridPane.setPadding(new Insets(20,20,20,20));

        gridPane.setHgap(10);
        gridPane.setVgap(30);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(title,0,0);
        gridPane.add(manmadeButton,0,1);

        gridPane.add(manmadeChoiceBox,1,1);
        gridPane.add(naturalButton,0,2);

        gridPane.add(naturalChoiceBox,1,2);
        gridPane.add(buttonGet,0,3);
        gridPane.add(buttonExit,1,3);

        Scene scene = new Scene(gridPane,500,300);



        primaryStage.setTitle("Vietnam Tourism");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UTILITY);
        primaryStage.show();



    }
}