package hu.projekt.photo;

import javafx.beans.value.ChangeListener;
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

    private static File fileImage;


    public static File getFileImage() {
        return fileImage;
    }

    public static void fileOpen() throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showOpenDialog(null);

        System.out.println("Path: "+fileImage);
    }

    public static void fileSave(){
    }

    public static void fileSaveAs(){
    }

    public static void exit(){
    }

    public static void fileKezel(String s) throws FileNotFoundException {
        switch (s){
            case "openImage":
                fileOpen();
                break;
            case "save":
                fileSave();
                break;
            case "saveAs":
                fileSaveAs();
                break;
            case "exit":
                exit();
                break;
        }
    }
}
