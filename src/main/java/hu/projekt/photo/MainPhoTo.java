package hu.projekt.photo;

import javafx.application.Application;
import javafx.beans.property.ReadOnlyDoubleProperty;
import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.geometry.Orientation;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.text.Text;
import javafx.stage.Modality;
import javafx.stage.Stage;


import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class MainPhoTo extends Application {

    public static Scene scene;
    public static Stage stage;
    BorderPane root;

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;

        FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("main.fxml"));
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
        ToolBar toolBar = new ToolBar();
        List<Button> mainbuttonList = new ArrayList<>();//gombok listája ami dinamikusan fog megjeleni




//METHODS - temp

//        Rotate
        Button rotateRightBtn = new Button();
        rotateRightBtn.setText("Rotate right");
        mainbuttonList.add(rotateRightBtn);
//        rotateRightBtn.setOnAction(Muveletek.forgatJobb(imageView)); //TODO 1. itt nem éri el az imageView-t, 2. ez nem event iguess, 3. muveletek nem static so am se jó

        Button rotateLeftBtn = new Button();
        rotateLeftBtn.setText("Rotate left");
        mainbuttonList.add(rotateLeftBtn);
//        rotateRightBtn.setOnAction(Muveletek.forgatBal(imageView));


//        Flip / tukroz
        Button reflectHorizontal = new Button();
        reflectHorizontal.setText("Flip Horizontally");
        mainbuttonList.add(reflectHorizontal);
//        rotateRightBtn.setOnAction(Muveletek.tukrozViz(imageView));

        Button reflectVertical = new Button();
        reflectVertical.setText("Flip Vertically");
        mainbuttonList.add(reflectVertical);
//        rotateRightBtn.setOnAction(Muveletek.tukrozFugg(imageView));



////        mindig az utsó 2 gomb legyen sztem a zoom ha lesz
//        Button zoomInBtn = new Button();
//        zoomInBtn.setText("Zoom in");
//        mainbuttonList.add(zoomInBtn);
//
//        Button zoomOutBtn = new Button();
//        zoomOutBtn.setText("Zoom out");
//        mainbuttonList.add(zoomOutBtn);



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
        for (int i = 0; i < mainbuttonList.size(); i++) {
            toolBar.getItems().add(mainbuttonList.get(i));

        }
        toolBar.getItems().add(rightSpacer);//kötépre igazít

        root.setBottom(toolBar);
    }

    public static void main(String[] args) {
        launch();
    }


}