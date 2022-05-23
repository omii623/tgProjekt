package hu.projekt.photo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.layout.*;
import javafx.scene.text.Font;
import javafx.stage.Stage;


import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

import static javafx.scene.text.Font.loadFont;

public class MainPhoTo extends Application {

    public static Scene scene;
    public static Stage stage;
    BorderPane root;
    KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();
    List<VBox> vboxList = new ArrayList<>();//gombok listája ami dinamikusan fog megjeleni
    public static Font font = loadFont("file:font/FuturaLight.ttf", 22);

    @Override
    public void start(Stage stage) throws IOException {
        this.stage=stage;

        FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("main.fxml"));
        root = fxmlLoader.<BorderPane>load();
        scene = new Scene(root, 1400, 800);
        stage.setMaximized(true);    //itt full screenre rakom az egészet

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
        toolBar.setPadding(new Insets(20, 30,20,30));
        toolBar.setStyle("-fx-background-color: #005580;");


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

        System.out.println((System.getProperty("os.name").split(" ")[0]));

        if(Objects.equals(System.getProperty("os.name").split(" ")[0], "Windows"))
        {
            s = getClass().getResource("").toString().substring(6);//linux - 5, windows - 6
        }
        else // if linux
        {
            s = getClass().getResource("").toString().substring(5);//linux - 5, windows - 6
        }



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

        if(Objects.equals(System.getProperty("os.name").split(" ")[0], "Windows"))
        {
            s = getClass().getResource("").toString().substring(6);//linux - 5, windows - 6
        }
        else // if linux
        {
            s = getClass().getResource("").toString().substring(5);//linux - 5, windows - 6
        }
        s+="plugins/";

        File myObj = new File(s+name+".fxml");
        System.out.println("Absolute path: " + myObj.getAbsolutePath());
        try {
            FileWriter myWriter = new FileWriter(myObj);
            myWriter.write("<?xml version=\"1.0\" encoding=\"UTF-8\"?>\n" +
                    "\n" +
                    "<?import javafx.scene.control.*?>\n" +
                    "<?import javafx.scene.layout.*?>\n" +
                    "\n" +
                    "<VBox fx:id=\"vbox\" alignment=\"TOP_CENTER\" maxHeight=\"-Infinity\" maxWidth=\"-Infinity\" minHeight=\"-Infinity\" minWidth=\"-Infinity\" prefHeight=\"80.0\" prefWidth=\"200.0\" xmlns=\"http://javafx.com/javafx/16\" xmlns:fx=\"http://javafx.com/fxml/1\" fx:controller=\"hu.projekt.photo.muveletekChild."+name+"\">\n" +
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