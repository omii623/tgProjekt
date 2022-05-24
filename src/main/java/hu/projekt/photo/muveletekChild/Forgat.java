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

import static hu.projekt.photo.Controller.image3;
import static hu.projekt.photo.Controller.kepek;
import static hu.projekt.photo.MainPhoTo.font;

public class Forgat extends Muveletek{


    @Override
    public void buttonSetup() {
        Button button = new Button("LEFT");
        Button button2 = new Button("RIGHT");

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

        setText("ROTATE");
    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            image3 = image;
            kepek.add(image);
            //System.out.println("==>jobb<==");
            kepMegjelenit.setImage(rotateImage(image, "jobb"));
        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            image3 = image;
            kepek.add(image);
            //System.out.println("==>bal<==");
            kepMegjelenit.setImage(rotateImage(image, "bal"));
        };
        buttonList.get(1).setOnAction(event2);
    }

    public static Image rotateImage(Image image,String s) {
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(height,width);
        PixelWriter pixelWriter = writableImage.getPixelWriter();

        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                switch (s){
                    case "bal":
                        pixelWriter.setColor((height-1)-i, j, pixelReader.getColor(j,i));
                        break;
                    case "jobb":
                        pixelWriter.setColor(i,(width-1)-j, pixelReader.getColor(j,i));
                        break;
                }

            }
        }

        return writableImage;
    }


}
