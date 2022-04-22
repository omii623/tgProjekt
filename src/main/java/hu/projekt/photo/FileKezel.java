package hu.projekt.photo;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

public class FileKezel {

    private File fileImage;
    @FXML
    ImageView imageView;

    public File getFileImage() {
        return fileImage;
    }

    @FXML
    public void test() throws FileNotFoundException {
        FileInputStream inputstream = new FileInputStream(fileImage);
        Image image = new Image(inputstream);
        imageView.setImage(image);
    }

    @FXML
    private void fileOpen() throws FileNotFoundException {
        System.out.println("file open");

        FileChooser fc = new FileChooser();
        fc.setTitle("Open image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showOpenDialog(null);

        System.out.println("Path: "+fileImage);
        test();
    }

    @FXML
    private void fileSave(){
        System.out.println("file save");
    }

    @FXML
    private void fileSaveAs(){
        System.out.println("file save as");
    }

    @FXML
    private void exit(){
        System.out.println("exit");
    }

    public FileKezel() {
    }
}
