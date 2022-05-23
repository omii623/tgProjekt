package hu.projekt.photo.muveletekChild;

import hu.projekt.photo.Muveletek;
import javafx.beans.binding.Bindings;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;
import javafx.scene.paint.Color;

import static hu.projekt.photo.Controller.image2;
import static hu.projekt.photo.MainPhoTo.font;

public class VisszaAllit extends Muveletek{


    @Override
    public void buttonSetup() {
        Button button = new Button("RETURN");

        button.setFont(font);
        button.setStyle(" -fx-background-color: transparent;" + " -fx-text-fill: white; " + " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;");
        button.styleProperty().bind(Bindings.when(button.hoverProperty())
                .then("-fx-background-color: rgba(255, 255, 255, 0.95);" + " -fx-text-fill: black; "+ " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;")
                .otherwise("-fx-background-color: transparent;" + " -fx-text-fill: white; "+ " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;"));
        button.setMaxWidth(100);
        button.setMinWidth(80);

        button.setCursor(Cursor.HAND);

        buttonList.add(button);


        setText("RETURN");

    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            //System.out.println("==>jobb<==");
            kepMegjelenit.setImage(visszaImage(image, "mono"));

        };
        buttonList.get(0).setOnAction(event);


    }

    public static Image visszaImage(Image image,String s) {
        int height = (int) Math.floor(image.getHeight());
        int width = (int) Math.floor(image.getWidth());

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(height,width);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        image = image2;
        return image;
    }


}

