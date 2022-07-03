package hust.soict.globalict.frontend;

import hust.soict.globalict.backend.touristattraction.TouristAttraction;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Bridge;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Cathedral;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Museum;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.Temple;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.AmusementPark;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.Building;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.Hotel;
import hust.soict.globalict.backend.touristattraction.manmadeattraction.modernarchitecture.ModernArchitecture;
import hust.soict.globalict.backend.touristattraction.naturalattraction.*;
import hust.soict.globalict.backend.touristattraction.naturalattraction.bodyofwater.*;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.concurrent.Task;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.apache.http.util.NetUtils;

import java.io.ByteArrayOutputStream;
import java.util.Optional;


public class AppUI extends Application {
    private ChoiceBox<String> manmadeChoiceBox = new ChoiceBox<String>();
    private ChoiceBox<String> naturalChoiceBox = new ChoiceBox<String>();

    private ChoiceBox<String> bodyOfWaterChoiceBox = new ChoiceBox<String>();
    private String[] manmadeAttraction = {
            "Amusement Park", "Building", "Hotel", "Modern Architecture",
            "Bridge", "Cathedral", "Museum", "Temple"
    };

    private String[] naturalAttraction = {
            "Body of Water",
            "Botanical Garden", "Cave", "Island", "Mountain",
            "National Park", "Zoo"
    };

    private String[] bodyofWater = {
            "Body of Water", "Bay", "Beach", "Lake", "River"
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

        RadioButton touristAttractionButton = new RadioButton("Tourist Attraction");
        RadioButton manmadeButton = new RadioButton("Manmade Attraction");
        RadioButton naturalButton = new RadioButton("Natural Attraction");
        touristAttractionButton.setToggleGroup(toggleGroup);
        manmadeButton.setToggleGroup(toggleGroup);
        naturalButton.setToggleGroup(toggleGroup);

        manmadeChoiceBox.getItems().addAll(manmadeAttraction);
        naturalChoiceBox.getItems().addAll(naturalAttraction);
        bodyOfWaterChoiceBox.getItems().addAll(bodyofWater);

        manmadeChoiceBox.getSelectionModel().selectFirst();
        naturalChoiceBox.getSelectionModel().selectFirst();
        bodyOfWaterChoiceBox.getSelectionModel().selectFirst();

        manmadeChoiceBox.setDisable(true);
        naturalChoiceBox.setDisable(true);
        bodyOfWaterChoiceBox.setDisable(true);

        Button buttonGet = new Button("Get");
        buttonGet.setDisable(true);
        Button buttonExit = new Button("Exit");

        manmadeButton.setVisible(false);
        manmadeChoiceBox.setVisible(false);
        naturalButton.setVisible(false);
        naturalChoiceBox.setVisible(false);
        bodyOfWaterChoiceBox.setVisible(false);

        naturalChoiceBox.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener<Number>() {
            @Override
            public void changed(ObservableValue<? extends Number> observableValue, Number number, Number number2) {
                buttonGet.setDisable(false);
                if(naturalChoiceBox.getItems().get((Integer)number2).equals("Body of Water")){
                    bodyOfWaterChoiceBox.setDisable(false);
                    bodyOfWaterChoiceBox.setVisible(true);
                }
                else{
                    bodyOfWaterChoiceBox.setDisable(true);
                    bodyOfWaterChoiceBox.setVisible(false);
                }
            }
        });

        ToggleGroup toggleGroup1 = new ToggleGroup();
        ToggleButton allDataButton1 = new ToggleButton("All");
        ToggleButton detailDataButton1 = new ToggleButton("Detail");
        allDataButton1.setToggleGroup(toggleGroup1);
        detailDataButton1.setToggleGroup(toggleGroup1);

        allDataButton1.setDisable(true);
        detailDataButton1.setDisable(true);

        allDataButton1.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if(!detailDataButton1.isSelected())
                allDataButton1.setSelected(true);
            buttonGet.setDisable(false);
            manmadeButton.setVisible(false);
            manmadeChoiceBox.setVisible(false);
            naturalButton.setVisible(false);
            naturalChoiceBox.setVisible(false);
            bodyOfWaterChoiceBox.setVisible(false);
        }));

        detailDataButton1.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if(!allDataButton1.isSelected())
                detailDataButton1.setSelected(true);
            buttonGet.setDisable(true);
            manmadeButton.setVisible(true);
            manmadeChoiceBox.setVisible(false);
            manmadeChoiceBox.setDisable(true);
            naturalButton.setVisible(true);
        }));

        ToggleGroup toggleGroup2 = new ToggleGroup();
        ToggleButton allDataButton2 = new ToggleButton("All");
        ToggleButton detailDataButton2 = new ToggleButton("Detail");
        allDataButton2.setToggleGroup(toggleGroup2);
        detailDataButton2.setToggleGroup(toggleGroup2);

        allDataButton2.setVisible(false);
        detailDataButton2.setVisible(false);

        allDataButton2.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if(!detailDataButton2.isSelected())
                allDataButton2.setSelected(true);
            buttonGet.setDisable(false);
            naturalChoiceBox.setVisible(false);
            naturalChoiceBox.setDisable(true);
            bodyOfWaterChoiceBox.setVisible(false);
        }));

        detailDataButton2.selectedProperty().addListener(((observable, oldValue, newValue) -> {
            if(!allDataButton2.isSelected())
                detailDataButton2.setSelected(true);
            buttonGet.setDisable(false);
            naturalChoiceBox.setVisible(true);
            naturalChoiceBox.setDisable(false);
            if(naturalChoiceBox.getSelectionModel().getSelectedItem().equals("Body of Water")) {
                bodyOfWaterChoiceBox.setVisible(true);
                bodyOfWaterChoiceBox.setDisable(false);
            }
        }));

        toggleGroup.selectedToggleProperty().addListener(new ChangeListener<Toggle>() {
            @Override
            public void changed(ObservableValue<? extends Toggle> observableValue, Toggle toggle, Toggle t1) {
                buttonGet.setDisable(false);
                RadioButton rb = (RadioButton) t1;
                if(rb.getText().equals(touristAttractionButton.getText())){
                    allDataButton1.setSelected(true);
                    detailDataButton1.setSelected(false);
                    allDataButton1.setDisable(false);
                    detailDataButton1.setDisable(false);
                    manmadeButton.setVisible(false);
                    manmadeChoiceBox.setVisible(false);
                    naturalButton.setVisible(false);
                    naturalChoiceBox.setVisible(false);
                    allDataButton2.setVisible(false);
                    detailDataButton2.setVisible(false);
                }
                if(rb.getText().equals(manmadeButton.getText())){
                    buttonGet.setDisable(false);
                    allDataButton1.setDisable(true);
                    detailDataButton1.setDisable(true);
                    allDataButton2.setDisable(true);
                    detailDataButton2.setDisable(true);
                    manmadeChoiceBox.setVisible(true);
                    manmadeChoiceBox.setDisable(false);
                    manmadeChoiceBox.show();
                    naturalChoiceBox.setDisable(true);
                    bodyOfWaterChoiceBox.setDisable(true);
                    bodyOfWaterChoiceBox.setVisible(false);
                }
                else if(rb.getText().equals(naturalButton.getText())){
                    buttonGet.setDisable(true);
                    allDataButton1.setDisable(true);
                    detailDataButton1.setDisable(true);
                    allDataButton2.setVisible(true);
                    detailDataButton2.setVisible(true);
                    allDataButton2.setDisable(false);
                    detailDataButton2.setDisable(false);
                    allDataButton2.setSelected(true);
                    manmadeChoiceBox.setDisable(true);
                }
            }
        });

        buttonGet.setOnAction(new EventHandler<ActionEvent>() {
            @Override
            public void handle(ActionEvent actionEvent) {
                RadioButton rb = (RadioButton) toggleGroup.getSelectedToggle();
                String chosen = null;
                if(rb.getText().equals(touristAttractionButton.getText())){
                    chosen = "Tourist Attraction";
                }
                if(rb.getText().equals(manmadeButton.getText())){
                    chosen = manmadeChoiceBox.getValue();
                }
                else if (rb.getText().equals(naturalButton.getText())){
                    if(allDataButton2.isSelected())
                        chosen = "Natural Attraction";
                    else if(detailDataButton2.isSelected()){
                        if (naturalChoiceBox.getValue().equals("Body of Water")){
                            chosen = bodyOfWaterChoiceBox.getValue();
                        }
                        else{
                            chosen = naturalChoiceBox.getValue();
                        }
                    }
                }

                Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
                alert.initStyle(StageStyle.DECORATED);
                alert.setTitle("Confirmation");
                alert.setHeaderText("Press OK to proceed with your choice, or press Cancel to discard.");
                alert.setContentText("You have selected " + rb.getText() + " - " + chosen);

                TextArea textArea = new TextArea("Working...");
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
                            if(finalChosen.equals("Tourist Attraction"))
                                (new TouristAttraction()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Amusement Park"))
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
                            else if(finalChosen.equals("Body of Water"))
                                (new BodyOfWater()).collectDataToTtlFile(stream);
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
                            else if(finalChosen.equals("Natural Attraction"))
                                (new NaturalAttraction()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("National Park"))
                                (new NationalPark()).collectDataToTtlFile(stream);
                            else if(finalChosen.equals("Zoo"))
                                (new Zoo()).collectDataToTtlFile(stream);
                            textArea.setText(stream.toString());
                            stream.reset();
                            return null;
                        }
                    };

                    task.setOnSucceeded(event -> {
                        Alert notify = new Alert(Alert.AlertType.INFORMATION);
                        notify.setHeaderText("Task completed");
                        notify.setContentText("Collected data is saved as " + finalChosen.replaceAll("\\s","") + ".ttl in project folder.");
                        notify.show();
                        alert.setHeaderText("Completed");
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
        gridPane.setMinSize(400,200);
        gridPane.setPadding(new Insets(10,10,10,10));

        gridPane.getColumnConstraints().add(new ColumnConstraints(175));

        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        gridPane.add(title,0,0);

        gridPane.add(touristAttractionButton,0,1);
        gridPane.add(allDataButton1,1,1);
        gridPane.add(detailDataButton1,2,1);

        gridPane.add(manmadeButton,0,2);
        gridPane.add(manmadeChoiceBox,3,2);

        gridPane.add(naturalButton,0,3);
        gridPane.add(allDataButton2,1,3);
        gridPane.add(detailDataButton2,2,3);
        gridPane.add(naturalChoiceBox,3,3);
        gridPane.add(bodyOfWaterChoiceBox,4,3);

        gridPane.add(buttonGet,0,4);
        gridPane.add(buttonExit,1,4);

        Scene scene = new Scene(gridPane);

        primaryStage.setTitle("Vietnam Tourism");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.DECORATED);
        primaryStage.show();
    }
}
