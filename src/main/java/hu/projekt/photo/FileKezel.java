package hu.projekt.photo;

import javafx.fxml.FXML;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.FileChooser.ExtensionFilter;
import javafx.stage.Window;

import java.io.File;

public class FileKezel {

    File fileImage;

    @FXML
    private void fileOpen(){
        System.out.println("file open");

        FileChooser fc = new FileChooser();
        fc.setTitle("Open image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showOpenDialog(null);
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
