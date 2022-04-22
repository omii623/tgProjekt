package hu.projekt.photo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;

public class MainPhoTo extends Application {
    @Override
    public void start(Stage stage) throws IOException {
        //FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("hello-view.fxml"));
        FXMLLoader fxmlLoader = new FXMLLoader(MainPhoTo.class.getResource("main.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 320, 240);

        stage.getIcons().add(new Image("https://i.ibb.co/rMTfSQN/icon.png"));
        stage.setTitle("PhoTo");
        stage.setScene(scene);
        stage.show();
        //KOMMENTET TESZTELEK ITT MOST ÉN AMÚGY
        //KOMMENTET TESZTELEK ITT MOST ÉN AMÚGY
        //KOMMENTET TESZTELEK ITT MOST ÉN AMÚGY
        //MASIK KOMMENT
    }

    public static void main(String[] args) {
        launch();
    }
}