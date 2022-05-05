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
    private Image image= new Image("https://i.ibb.co/rMTfSQN/icon.png");

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

    public Image getImage() {
        return image;
    }

    public void setImage(Image image) {
        this.image = image;

        Random random = new Random();
        int rand = random.nextInt();
        setText(""+rand);
    }
}
