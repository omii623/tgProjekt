package hu.projekt.photo;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.Random;

/**
 * adatátvitel
 * */
public class KepMegjelenit {
    private static final KepMegjelenit instance = new KepMegjelenit();

    private Text text = new Text("");
    private ImageView imageView = new ImageView();

    private KepMegjelenit(){}

    public static KepMegjelenit getInstance(){
        return instance;
    }

    public Text getText(){
        return text;
    }

    public void setText(String data){
        this.text.setText(data);
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView imageView) {
        this.imageView = imageView;
    }
}
