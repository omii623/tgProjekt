package hu.projekt.photo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MainPhoTo extends Application {

    public static Scene scene;
    public static Stage stage;
    BorderPane root;
    KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();
    List<VBox> vboxList = new ArrayList<>();//gombok listája ami dinamikusan fog megjeleni

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

        loadButtons();
        addButons();
    }

    public void addButons(){
        ToolBar toolBar = new ToolBar();
/*        List<Button> mainbuttonList = new ArrayList<>();//gombok listája ami dinamikusan fog megjeleni

//METHODS - temp

//        Rotate
        Button rotateRightBtn = new Button();
        rotateRightBtn.setText("Rotate right");
        mainbuttonList.add(rotateRightBtn);
        //rotateRightBtn.setOnAction(Muveletek.forgatJobb(kepMegjelenit.getImageView())); //TODO 1. itt nem éri el az imageView-t, 2. ez nem event iguess, 3. muveletek nem static so am se jó

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
*/

        VBox vbox = new VBox();

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
        for (VBox value : vboxList) {
            toolBar.getItems().add(value);

        }
        toolBar.getItems().add(rightSpacer);//kötépre igazít

        root.setBottom(toolBar);
    }

    public static void main(String[] args) {
        launch();
    }

    private void loadButtons(){
        String[] pathnames;

        String s;
        s = getClass().getResource("").toString().substring(6);//linux - 5, windows - 6

        s+="muveletekChild/";
        File f = new File(s);
        pathnames = f.list();

        for (String pathname : pathnames) {
            //System.out.println(pathnames);
            String[] pathnameArray = pathname.split("\\.");
            System.out.println("--> "+pathnameArray[0]);
            createFXML(pathnameArray[0]);
            VBox vBox;
            try {
                vBox = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("plugins/"+pathnameArray[0]+".fxml")));
                vboxList.add(vBox);
                System.out.println("siker");
            } catch (IOException e) {
                e.printStackTrace();
                System.out.println("nemsiker");
            }
        }
    }

    private void createFXML(String name){
        String s;
        s = getClass().getResource("").toString().substring(6);s+="plugins/";//linux - 5, windows - 6

        File myObj = new File(s+name+".fxml");
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        try {
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "\n" +
                    "<?import javafx.scene.control.*?>\n" +
                    "<?import javafx.scene.layout.*?>\n" +
                    "\n" +
                    "<VBox fx:id=\"vbox\" alignment=\"TOP_CENTER\" maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"64.0\" prefWidth=\"136.0\" xmlns=\"http://javafx.com/javafx/16\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"hu.projekt.photo.muveletekChild."+name+"\">\n" +
                    "    <children>\n" +
                    "        <Label fx:id=\"label\" alignment=\"TOP_CENTER\" text=\"Label\" /><HBox fx:id=\"hbox\" alignment=\"CENTER\" prefHeight=\"53.0\" prefWidth=\"136.0\" />\n" +
                    "    </children>\n" +
                    "</VBox>\n");
            myWriter.close();
            System.out.println("Successfully wrote to the file.");
        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }
    }




}