package hu.projekt.photo;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
                imageView.setFitHeight(MainPhoTo.scene.getHeight()-150);
                imageView.setFitWidth(MainPhoTo.scene.getWidth()-150);

            }
        };
        MainPhoTo.stage.widthProperty().addListener(stageSizeListener);
        MainPhoTo.stage.heightProperty().addListener(stageSizeListener);

        MainPhoTo.stage.maximizedProperty().addListener(new ChangeListener<Boolean>() {

            @Override
            public void changed(ObservableValue<? extends Boolean> ov, Boolean t, Boolean t1) {
                /*if(imageView != null){
                    imageView.setFitHeight(MainPhoTo.scene.getHeight()-150);
                    imageView.setFitWidth(MainPhoTo.scene.getWidth()-150);
                }*/
                System.out.println("--nagyitas/kicsinyites--");
            }
        });//valamiert nem jo

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
        if(FileKezel.getFileImage()!=null){
            image = new Image(new FileInputStream(FileKezel.getFileImage()));
            kepMegjelenit.setImage(image);
        }

    }





}
