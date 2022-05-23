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
import static hu.projekt.photo.MainPhoTo.font;

public class Fenyero extends Muveletek{


    @Override
    public void buttonSetup() {
        Button button = new Button("PLUS");
        Button button2 = new Button("MINUS");

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

        setText( "BRIGHTNESS" );

    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            image3 = image;
            //System.out.println("==>jobb<==");
            kepMegjelenit.setImage(fenyeroImage(fenyeroImage(image, "plus"), "plus"));

        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            image3 = image;
            //System.out.println("==>jobb<==");
            kepMegjelenit.setImage(fenyeroImage(fenyeroImage(image, "minus"), "minus"));
        };
        buttonList.get(1).setOnAction(event2);

    }

    public static Image fenyeroImage(Image image,String s) {
        int height = (int) Math.floor(image.getHeight());
        int width = (int) Math.floor(image.getWidth());

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(height,width);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        if(s.equals("plus")) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {

                    Color color = pixelReader.getColor(j,i);
                    if(color.getRed() < 0.95 && color.getGreen() < 0.95 && color.getBlue() < 0.95) {
                        double red = color.getRed() + 0.05;
                        double green = color.getGreen() + 0.05;
                        double blue = color.getBlue() + 0.05;
                        color = new Color(red, green, blue, 1);
                    }
                    pixelWriter.setColor (i,j, color);

                }

            }
        }
        if(s.equals( "minus" )){
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {


                    Color color = pixelReader.getColor(j,i);
                    if(color.getRed() > 0.05 && color.getGreen() > 0.05 && color.getBlue() > 0.05) {
                        double red = color.getRed() - 0.05;
                        double green = color.getGreen() - 0.05;
                        double blue = color.getBlue() - 0.05;
                        color = new Color(red, green, blue, 1);
                    }
                    pixelWriter.setColor (i,j, color);

                }

            }
        }

        return writableImage;
    }


}

