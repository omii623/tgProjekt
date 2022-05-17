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

public class Filter extends Muveletek{


    @Override
    public void buttonSetup() {
        Button button = new Button("mono");
        Button button2 = new Button("vissza");

        button.setMaxWidth(60);
        button.setMinWidth(60);
        button2.setMaxWidth(60);
        button2.setMinWidth(60);

        buttonList.add(button);
        buttonList.add(button2);

        setText("Filter");
    }

    @Override
    public void buttonEvents() {
        EventHandler<ActionEvent> event = e -> {
            Image image = kepMegjelenit.getImage();
            //System.out.println("==>jobb<==");
                kepMegjelenit.setImage(monoImage(monoImage(image, "mono"), "mono"));

        };
        buttonList.get(0).setOnAction(event);

        EventHandler<ActionEvent> event2 = e -> {
            Image image = kepMegjelenit.getImage();
            //System.out.println("==>jobb<==");
            kepMegjelenit.setImage(monoImage(image, "vissza"));
        };
        buttonList.get(1).setOnAction(event);

    }

    public static Image monoImage(Image image,String s) {
        int height = (int) Math.floor(image.getHeight());
        int width = (int) Math.floor(image.getWidth());

        final PixelReader pixelReader = image.getPixelReader();

        WritableImage writableImage = new WritableImage(height,width);
        PixelWriter pixelWriter = writableImage.getPixelWriter();
        if(s.equals("mono")) {
            for (int i = 0; i < height; i++) {
                for (int j = 0; j < width; j++) {


                    Color color = pixelReader.getColor(j,i);
                    double grey = (color.getBlue() + color.getGreen() + color.getRed()) / 3;
                    color = new Color(grey, grey, grey, 0.9);


                    pixelWriter.setColor (i,j, color);

                }

            }
        }
        if(s.equals("vissza")){
        }

        return writableImage;
    }


}
