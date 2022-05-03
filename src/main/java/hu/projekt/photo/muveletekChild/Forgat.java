package hu.projekt.photo.muveletekChild;

import hu.projekt.photo.Muveletek;
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
}
