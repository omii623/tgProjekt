package hu.projekt.photo;

import javafx.beans.value.ChangeListener;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuItem;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    static Image image;
    @FXML
    ImageView imageView;
    KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image = kepMegjelenit.getImage();
        imageView.setImage(image);
    }

    public Controller(){
        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) ->{
            if(imageView != null){
                imageView.setFitHeight(MainPhoTo.scene.getHeight()-100);
                imageView.setFitWidth(MainPhoTo.scene.getWidth()-100);

            }
        };
        MainPhoTo.stage.widthProperty().addListener(stageSizeListener);
        MainPhoTo.stage.heightProperty().addListener(stageSizeListener);

        ChangeListener<String> kepMegjelenitListener = (observable, oldValue, newValue) ->{

            image = kepMegjelenit.getImage();
            imageView.setImage(image);

            System.out.println("--listener--");
        };
        kepMegjelenit.getText().textProperty().addListener(kepMegjelenitListener);
    }

    @FXML
    public void fileControl(ActionEvent event) throws IOException {
        MenuItem mi = (MenuItem) event.getSource();
        System.out.println(mi.getId());
        FileKezel.fileKezel(mi.getId());


        if(mi.getId().equals("openImage")){//TODO nem így kéne megoldani szerintem hanem a KepMegjelenít segítségével
            openImage(); //kiszerveztem hogyha kell máshova lehessen haszn.
        }

    }

    public void openImage() throws FileNotFoundException {
        image = new Image(new FileInputStream(FileKezel.getFileImage()));
        kepMegjelenit.setImage(image);
    }





}
