package hu.projekt.photo;

import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.ImageObserver;
import java.awt.image.RenderedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;

import static hu.projekt.photo.Controller.image;


public class FileKezel {

    private static File fileImage;


    public static File getFileImage() {
        return fileImage;
    }

    public static void fileOpen() throws FileNotFoundException { //TODO ha le-mégse-zem a file megnyitást akkor exception jön
        FileChooser fc = new FileChooser();
        fc.setTitle("Open image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showOpenDialog(null);

        System.out.println("Opened from path: "+fileImage);
    }

    public static void fileSave() throws IOException {

        fileSavePure();
        System.out.println("Saved to the same path: "+fileImage);
    }

    public static void fileSaveAs() throws IOException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save image as");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showSaveDialog(null);

        fileSavePure();

        System.out.println("Saved to path: "+fileImage);
    }

    public static void fileSavePure() throws IOException {

//actual file kezeles
        File newFile = new File(String.valueOf(fileImage));
//        RenderedImage rendImage = (RenderedImage) image;  //TODO nem lehet RenderedImage-re castolni (egyik fx-es image másik awk-s)
//        ImageIO.write(rendImage,"png",fileImage);

    }

    public static void exit(){
        System.exit(0);
    }

    public static void fileKezel(String s) throws IOException {
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
