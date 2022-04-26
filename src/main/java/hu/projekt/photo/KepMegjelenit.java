package hu.projekt.photo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;

public class KepMegjelenit {

    public Image kirajzol(File file) throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream(file);
        System.out.println("asd "+file);
        Image image = new Image(inputstream);

        return image;
    }

}
