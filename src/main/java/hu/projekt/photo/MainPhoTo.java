package hu.projekt.photo;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPhoTo extends Application {

    public Scene scene;

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("main.fxml"));
        VBox vbox = fxmlLoader.<VBox>load();
        scene = new Scene(vbox, 1400, 800);

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

        List<Button> buttonList = new ArrayList<>();//gombok listája ami dinamikusan fog megjeleni

        Button button = new Button();
        button.setText("asdads");
        buttonList.add(button);

        vbox.getChildren().add(buttonList.get(0));


        stage.getIcons().add(new Image("https://i.ibb.co/rMTfSQN/icon.png"));
        stage.setTitle("PhoTo");
        stage.setScene(scene);
        stage.show();



    }

    public static void main(String[] args) {
        launch();
    }


}