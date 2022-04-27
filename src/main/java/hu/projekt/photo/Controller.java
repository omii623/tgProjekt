package hu.projekt.photo;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class Controller {

    FileKezel fileKezel;
    KepMegjelenit kepMegjelenit = new KepMegjelenit();

    @FXML
    ImageView imageView;

    @FXML
    public void fileControl(ActionEvent event) throws FileNotFoundException {
        MenuItem mi = (MenuItem) event.getSource();
        System.out.println(mi.getId());
        fileKezel = new FileKezel(mi.getId());

        if(mi.getId().equals("openImage"))
            imageView.setImage(kepMegjelenit.kirajzol(fileKezel.getFileImage()));
    }

}
