package hu.projekt.photo;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPhoTo extends Application {

    public Scene scene;
    VBox vbox;
    BorderPane root;

    @Override
    public void start(Stage stage) throws IOException {
        /*FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("main.fxml"));
        vbox = fxmlLoader.<VBox>load();
        scene = new Scene(vbox, 1400, 800);*/

        FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("main2.fxml"));
        root = fxmlLoader.<BorderPane>load();
        scene = new Scene(root, 1400, 800);


        stage.setMinHeight(500);
        stage.setMinWidth(875);
        stage.getIcons().add(new Image("https://i.ibb.co/rMTfSQN/icon.png"));
        stage.setTitle("PhoTo");
        stage.setScene(scene);
        stage.show();

        addButons();
    }

    public void addButons(){
        /*
        MenuBar menuBar = new MenuBar();
        vbox.getChildren().add(menuBar);

        Menu fileMenu = new Menu("File2");

        SeparatorMenuItem line = new SeparatorMenuItem();
        MenuItem item1 = new MenuItem("Open image");
        MenuItem item2 = new MenuItem("Save");
        MenuItem item3 = new MenuItem("Save as");
        MenuItem item4 = new MenuItem("Exit");

        fileMenu.getItems().addAll(item1, item2, item3,line, item4);
        menuBar.getMenus().addAll(fileMenu);*/

        ToolBar toolBar = new ToolBar();
        List<Button> buttonList = new ArrayList<>();//gombok listája ami dinamikusan fog megjeleni

        Button button = new Button();
        button.setText("asdads");
        buttonList.add(button);
        Button button2 = new Button();
        button2.setText("asdads2");
        buttonList.add(button2);

        final Pane leftSpacer = new Pane();
        HBox.setHgrow(
                leftSpacer,
                Priority.SOMETIMES
        );

        final Pane rightSpacer = new Pane();
        HBox.setHgrow(
                rightSpacer,
                Priority.SOMETIMES
        );
        toolBar.setPadding(new Insets(10, 20,10,20));
        toolBar.setStyle("-fx-border-color: lightblue");


        toolBar.getItems().add(leftSpacer);//kötépre igazít
        for (int i = 0; i < 2; i++) {
            toolBar.getItems().add(buttonList.get(i));

        }
        toolBar.getItems().add(rightSpacer);//kötépre igazít

        root.setBottom(toolBar);
    }

    public static void main(String[] args) {
        launch();
    }


}