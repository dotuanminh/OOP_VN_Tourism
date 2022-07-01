package hust.soict.globalict.frontend;

import hust.soict.globalict.backend.touristattraction.manmadeattraction.Bridge;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Cathedral;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Museum;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Temple;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.AmusementPark;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.Building;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.Hotel;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.ModernArchitecture;
import hust.soict.globalict.backend.touristattraction.naturalattraction.*;
import hust.soict.globalict.backend.touristattraction.naturalattraction.bodyofwater.Bay;
import hust.soict.globalict.backend.touristattraction.naturalattraction.bodyofwater.Beach;
import hust.soict.globalict.backend.touristattraction.naturalattraction.bodyofwater.Lake;
import hust.soict.globalict.backend.touristattraction.naturalattraction.bodyofwater.River;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.ByteArrayOutputStream;
import java.util.Optional;


public class AppUI extends Application {
    private ChoiceBox<String> manmadeChoiceBox = new ChoiceBox<String>();
    private ChoiceBox<String> naturalChoiceBox = new ChoiceBox<String>();
    private String[] manmadeAttraction = {
            "Amusement Park", "Building", "Hotel", "Modern Architecture",
            "Bridge", "Cathedral", "Museum", "Temple"
    };

    private String[] naturalAttraction = {
            "Bay", "Beach", "Lake", "River",
            "Botanical Garden", "Cave", "Island", "Mountain",
            "National Park", "Zoo"
    };

    ByteArrayOutputStream stream = new ByteArrayOutputStream();
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        Text title = new Text("Welcome to Vietnam tourism");
        title.setFont(Font.font("Calibri",FontWeight.EXTRA_BOLD,26));
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
                RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
                String chosen = null;
                if(rb.getText().equals(manmadeButton.getText())){
                    chosen = manmadeChoiceBox.getValue();
                }
                else if (rb.getText().equals(naturalButton.getText())){
                    chosen = naturalChoiceBox.getValue();
                }

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initStyle(StageStyle.DECORATED);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Press OK to proceed with your choice, else press Cancel to return to main menu.");
                alert.setContentText("You have selected " + rb.getText() + " - " + chosen);

                TextArea textArea = new TextArea("Connecting...");
                textArea.setEditable(false);
                textArea.setWrapText(true);

                textArea.setMaxWidth(Double.MAX_VALUE);
                textArea.setMaxHeight(Double.MAX_VALUE);
                GridPane.setVgrow(textArea, Priority.ALWAYS);
                GridPane.setHgrow(textArea, Priority.ALWAYS);

                GridPane outputContent = new GridPane();
                outputContent.setMaxWidth(Double.MAX_VALUE);
                outputContent.add(textArea,0,1);
                alert.getDialogPane().setExpandableContent(outputContent);
                textArea.setVisible(false);

                Optional<ButtonType> option = alert.showAndWait();

                if(option.get() == ButtonType.OK){
                    alert.setAlertType(Alert.AlertType.INFORMATION);
                    alert.setTitle("Processing request");
                    alert.setHeaderText("Collecting data...");
                    alert.setContentText(chosen);
                    textArea.setVisible(true);
                    alert.getDialogPane().setContent(textArea);

                    alert.show();

                    String finalChosen = chosen;
                    Task<Void> task = new Task<Void>() {
                        @Override
                        protected Void call() throws Exception {
                            if(finalChosen.equals("Amusement Park"))
                                (new AmusementPark()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Building"))
                                (new Building()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Hotel"))
                                (new Hotel()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Modern Architecture"))
                                (new ModernArchitecture()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Bridge"))
                                (new Bridge()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Cathedral"))
                                (new Cathedral()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Museum"))
                                (new Museum()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Temple"))
                                (new Temple()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Bay"))
                                (new Bay()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Beach"))
                                (new Beach()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Lake"))
                                (new Lake()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("River"))
                                (new River()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Botanical Garden"))
                                (new BotanicalGarden()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Cave"))
                                (new Cave()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Island"))
                                (new Island()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Mountain"))
                                (new Mountain()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("National Park"))
                                (new NationalPark()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Zoo"))
                                (new Zoo()).collectDataToTtlFile(stream);
                            textArea.setText(stream.toString());
                            return null;
                        }
                    };

                    task.setOnSucceeded(event -> {
                        Alert notify = new Alert(Alert.AlertType.INFORMATION);
                        notify.setHeaderText("Task completed.");
                        notify.setContentText("Collected data is saved as " + finalChosen + ".ttl in project folder.");
                        notify.show();

                    });

                    Thread t = new Thread(task);
                    t.setDaemon(true);
                    t.start();

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
        gridPane.setMinSize(400,150);

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
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }
}
