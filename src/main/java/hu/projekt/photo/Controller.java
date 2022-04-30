package hu.projekt.photo;

import javafx.beans.value.ChangeListener;
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
import java.io.IOException;


public class Controller {

    static Image image;
    @FXML
    ImageView imageView;

    @FXML
    public void fileControl(ActionEvent event) throws IOException {
        MenuItem mi = (MenuItem) event.getSource();
        System.out.println(mi.getId());
        FileKezel.fileKezel(mi.getId());


        if(mi.getId().equals("openImage")){
            openImage(); //kiszerveztem hogyha kell máshova lehessen haszn.
        }

//        azt hittem ezek is ide kellenek de láttam hogy a fileKezelben is van rá cucc
//
//        if(mi.getId().equals("exit")){
//            System.exit(0);
//        }
//
//        if(mi.getId().equals("save")){
//            FileKezel.fileSave();
//        }
//
//        if(mi.getId().equals("saveAs")){
//            FileKezel.fileSaveAs();
//        }
    }

    public void openImage() throws FileNotFoundException {
        image = new Image(new FileInputStream(FileKezel.getFileImage()));
        imageView.setImage(image);

        ChangeListener<Number> stageSizeListener = (observable, oldValue, newValue) ->{
            if(imageView != null){
                imageView.setFitHeight(MainPhoTo.scene.getHeight()-100);
                imageView.setFitWidth(MainPhoTo.scene.getWidth()-100);

            }
        };
        MainPhoTo.stage.widthProperty().addListener(stageSizeListener);
        MainPhoTo.stage.heightProperty().addListener(stageSizeListener);
    }

    @FXML
    public void imageRefresh(){
        //image = new Image(new FileInputStream(FileKezel.getFileImage()));
        imageView.setImage(image);
    }






}
