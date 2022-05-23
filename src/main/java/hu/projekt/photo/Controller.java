package hu.projekt.photo;

import javafx.beans.InvalidationListener;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;

import java.awt.image.RenderedImage;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;


public class Controller implements Initializable {

    public static Image image;
    public static Image image2;
    FileKezel fk = new FileKezel();
    @FXML
    ImageView imageView;
    KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        image = kepMegjelenit.getImage();
        image2 = image = kepMegjelenit.getImage();
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

        fk.fileKezel(mi.getId());



        if(mi.getId().equals("openImage")){//TODO nem így kéne megoldani szerintem hanem a KepMegjelenít segítségével
            openImage(); //kiszerveztem hogyha kell máshova lehessen haszn.
        }

    }

    public void openImage() throws FileNotFoundException {
        if(fk.getFileImage()!=null){
            image = new Image(new FileInputStream(fk.getFileImage()));
            image2 = image;
            kepMegjelenit.setImage(image);
        }

    }

    public void aboutMeth()
    {
        ButtonType exitButton = new ButtonType("Cancel");
        Alert alert = new Alert(Alert.AlertType.NONE, "",exitButton);

        alert.setTitle("About");
        alert.setHeaderText("About");
        alert.setContentText("""
                The program PhoTo was created for the purpose of handling pictures properly. It was made in about 2 months to ensure the optimal experience for the users. It has some functions with which you can handle the picture, including rotation, flipping, or various filters.\s
                
                The functions are easily accessible and organized by the panels that have been created at the bottom of the program. Just click on the button of the function that you want to apply, it is that simple. Handling the files has been made dynamically as well, you can reach any of your pictures (as long as they are supported extension-wise). No matter where they are on the computer! You do not have to handle this task with a static folder. You also have 2 types of saves available.

                The program was created by three ambitious young people as a Project for their Programming 1 course. The team consists of Tamás Tóth, Gergő Török and Máté Subicz. Thank you for taking a look at it, hope you are satisfied.""");

        alert.show();
    }





}
