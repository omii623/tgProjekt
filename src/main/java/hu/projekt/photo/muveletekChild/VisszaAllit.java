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

import static hu.projekt.photo.Controller.*;
import static hu.projekt.photo.MainPhoTo.font;

public class VisszaAllit extends Muveletek{


    @Override
    public void buttonSetup() {
        Button button = new Button("ORIGINAL");
        Button button2 = new Button("1 STEP");

        button.setFont(font);
        button.setStyle(" -fx-background-color: transparent;" + " -fx-text-fill: white; " + " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;");
        button.styleProperty().bind(Bindings.when(button.hoverProperty())
                .then("-fx-background-color: rgba(255, 255, 255, 0.95);" + " -fx-text-fill: black; "+ " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;")
                .otherwise("-fx-background-color: transparent;" + " -fx-text-fill: white; "+ " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;"));
        button2.setFont(font);
        button2.setStyle(" -fx-background-color: transparent;" + " -fx-text-fill: white; " + " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;");
        button2.styleProperty().bind(Bindings.when(button2.hoverProperty())
                .then("-fx-background-color: rgba(255, 255, 255, 0.95);" + " -fx-text-fill: black; "+ " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;")
                .otherwise("-fx-background-color: transparent;" + " -fx-text-fill: white; "+ " -fx-border-color: white;" + "-fx-border-width: 1px;" + "-fx-border-radius: 4px;"));
        button.setMaxWidth(100);
        button.setMinWidth(80);
        button2.setMaxWidth(100);
        button2.setMinWidth(80);
        button.setCursor(Cursor.HAND);
        button2.setCursor(Cursor.HAND);
        buttonList.add(button);
        buttonList.add(button2);

        setText("RETURN");

    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            //System.out.println("==>jobb<==");
            kepMegjelenit.setImage(visszaImage(image, "original"));

        };

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            //System.out.println("==>függőleges<==");
            kepMegjelenit.setImage(visszaImage(image, "1step"));
        };
        buttonList.get(1).setOnAction(event2);
        buttonList.get(0).setOnAction(event);

    }

    public static Image visszaImage(Image image,String s) {
        int height = (int) Math.floor(image.getHeight());
        int width = (int) Math.floor(image.getWidth());

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(height,width);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        if(s.equals("original")){
            image = image2;
            return image;
        }
        if(s.equals("1step") && kepek != null && kepek.size() > 0){
            image = kepek.get(kepek.size()-1);
            kepek.remove(kepek.get(kepek.size()-1));
            //image = image3;
            return image;
        }
        return image;
    }


}

