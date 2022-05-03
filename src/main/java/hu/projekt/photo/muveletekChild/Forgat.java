package hu.projekt.photo.muveletekChild;

import hu.projekt.photo.Muveletek;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class Forgat extends Muveletek{


    @Override
    public void buttonSetup() {
        Button button = new Button("jobb");
        Button button2 = new Button("bal");

        button.setMaxWidth(60);
        button.setMinWidth(60);
        button2.setMaxWidth(60);
        button2.setMinWidth(60);

        buttonList.add(button);
        buttonList.add(button2);

        setText("FORGAT");
    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> System.out.println("==>jobb<==");
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> System.out.println("==>bal<==");
        buttonList.get(1).setOnAction(event2);
    }
}
