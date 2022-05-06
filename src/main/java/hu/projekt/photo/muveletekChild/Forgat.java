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
            kepMegjelenit.setImage(rotateImage(image, "jobb"));
        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            System.out.println("==>bal<==");
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
                    case "jobb":
                        pixelWriter.setColor((height-1)-i, j, pixelReader.getColor(j,i));
                        break;
                    case "bal":
                        pixelWriter.setColor(i,(width-1)-j, pixelReader.getColor(j,i));
                        break;
                }

            }
        }

        return writableImage;
    }


}
