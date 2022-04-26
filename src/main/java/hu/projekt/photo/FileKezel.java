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


    public File getFileImage() {
        return fileImage;
    }

    public void fileOpen() throws FileNotFoundException {
        System.out.println("file open");

        FileChooser fc = new FileChooser();
        fc.setTitle("Open image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showOpenDialog(null);

        System.out.println("Path: "+fileImage);
    }

    public void fileSave(){
        System.out.println("file save");
    }

    public void fileSaveAs(){
        System.out.println("file save as");
    }

    public void exit(){
        System.out.println("exit");
    }

    public FileKezel(String s) throws FileNotFoundException {
        switch (s){
            case "openImage":
                fileOpen();
                break;
            case "save":
                fileSave();
                break;
            case "saveAs":
                fileOpen();
                break;
            case "exit":
                exit();
                break;
        }
    }
}
