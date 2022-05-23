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

import static hu.projekt.photo.Controller.image3;
import static hu.projekt.photo.Controller.kepek;
import static hu.projekt.photo.MainPhoTo.font;
import static hu.projekt.photo.muveletekChild.Forgat.rotateImage;

public class Tukroz extends Muveletek {


    @Override
    public void buttonSetup() {
        Button button = new Button("HOR");
        Button button2 = new Button("VER");

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

        setText("MIRROR");
    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            image3 = image;
            kepek.add(image);
            //System.out.println("==>vízszintes<==");
            kepMegjelenit.setImage(mirrorImage(image, "vizTuk"));
        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            image3 = image;
            kepek.add(image);
            //System.out.println("==>függőleges<==");
            kepMegjelenit.setImage(mirrorImage(image, "fugTuk"));
        };
        buttonList.get(1).setOnAction(event2);
    }

    public static Image mirrorImage(Image image,String s) {
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(width,height);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        if(s.equals("fugTuk")) {
            for (int j = 0, k = width-1; j < width; j++,k--) {
                for (int i = 0; i < height; i++) {
                    pixelWriter.setColor(j,i,pixelReader.getColor(k,i));
                }
            }
        }
        if(s.equals("vizTuk")) {
            for (int j = 0, k = height-1; j < height; j++,k--) {
                for (int i = 0; i < width; i++) {
                    pixelWriter.setColor(i,j,pixelReader.getColor(i,k));
                }
            }
        }
        return writableImage;
    }


}
