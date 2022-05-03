package hu.projekt.photo.muveletekChild;

import hu.projekt.photo.Controller;
import hu.projekt.photo.MainPhoTo;
import hu.projekt.photo.Muveletek;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import java.net.URL;
import java.util.Random;
import java.util.ResourceBundle;

public class gomb1 /*extends Muveletek*/ implements Initializable {
    @FXML
    HBox hbox;
    @FXML
    VBox vbox;
    @FXML
    Label label;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        //hbox.setAlignment(Pos.CENTER);

        vbox.setStyle(" -fx-border-color: #2e8b57;" +
                " -fx-background-color: #A0BBA2;" +
                "    -fx-border-width: 2px;" +
                "    -fx-spacing: 8;");

        hbox.setSpacing(10);
        hbox.setMaxWidth(1000);
        vbox.setMaxWidth(1000);



        Button button = new Button("new");
        hbox.getChildren().add(button);
        Button button2 = new Button("new2");
        hbox.getChildren().add(button2);
        Button button3 = new Button("new3sadasd");
        button3.setMaxWidth(60);
        button3.setMinWidth(60);

        button.setMaxWidth(60);
        button.setMinWidth(60);

        button2.setMaxWidth(60);
        button2.setMinWidth(60);
        hbox.getChildren().add(button3);

        EventHandler<ActionEvent> event = e -> System.out.println("==>lefut3<==" + button3.getWidth());
        button3.setOnAction(event);


        hbox.setMinWidth(3*60+3*10);
        vbox.setMinWidth(hbox.getMinWidth());

        System.out.println("hbox " + button.getWidth());

        label.setText("asdasd");
        System.out.println("==>lefut<==");
    }
}
