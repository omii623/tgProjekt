package hu.projekt.photo.muveletekChild;

import hu.projekt.photo.Muveletek;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

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
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            System.out.println("==>jobb<==");
        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            System.out.println("==>bal<==");
        };
        buttonList.get(1).setOnAction(event2);
    }



}
