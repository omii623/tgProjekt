package hu.projekt.photo.muveletekChild;

import hu.projekt.photo.Muveletek;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.PixelReader;
import javafx.scene.image.PixelWriter;
import javafx.scene.image.WritableImage;

import static hu.projekt.photo.muveletekChild.Forgat.rotateImage;

public class Tukroz extends Muveletek {


    @Override
    public void buttonSetup() {
        Button button = new Button("vizTuk");
        Button button1 = new Button("fugTuk");

        button.setMaxWidth(60);
        button1.setMinWidth(60);
        button.setMaxWidth(60);
        button1.setMinWidth(60);
        buttonList.add(button);
        buttonList.add(button1);

        setText("TUKROZ");
    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            System.out.println("==>vízszintes<==");
            kepMegjelenit.setImage(mirrorImage(image, "vizTuk"));
        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            System.out.println("==>függőleges<==");
            kepMegjelenit.setImage(mirrorImage(image, "fugTuk"));
        };
        buttonList.get(1).setOnAction(event2);
    }

    public static Image mirrorImage(Image image,String s) {
        int height = (int) image.getHeight();
        int width = (int) image.getWidth();

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(height,width);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        if(s.equals("vizTuk")) {
            for (int y = 0; y < height; y++) {
                for (int lx = 0, rx = width * 2 - 1; lx < width; lx++, rx--) {

                    pixelWriter.setColor(y, (width - 1) - lx, pixelReader.getColor(y, lx));
                }
            }
        }
        if(s.equals("fugTuk")) {
            for (int y = 0; y < width; y++) {
                for (int lx = 0, rx = height * 2 - 1; lx < height; lx++, rx--) {

                    pixelWriter.setColor((width - 1) - lx, y, pixelReader.getColor(lx, y));

                }
            }
        }
        return writableImage;
    }


}
