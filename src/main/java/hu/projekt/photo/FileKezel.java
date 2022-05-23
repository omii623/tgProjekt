package hu.projekt.photo;

import javafx.geometry.Bounds;
import javafx.scene.image.*;
import javafx.scene.image.Image;
import javafx.stage.FileChooser;

import javax.imageio.ImageIO;
import javax.imageio.stream.ImageOutputStream;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.*;
import java.nio.ByteBuffer;

import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javafx.embed.swing.SwingFXUtils;

import static hu.projekt.photo.Controller.image2;


public class FileKezel {

    private File fileImage;

    public File getFileImage() {
        return fileImage;
    }

    public void fileOpen() throws FileNotFoundException {
        FileChooser fc = new FileChooser();
        fc.setTitle("Open image");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("Images","*.jpg","*.png"));
        fileImage = fc.showOpenDialog(null);

        System.out.println("Opened from path: "+fileImage);
    }

    public void fileSave() {
        KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();
        Image image = kepMegjelenit.getImage();
        if (image == null){
            System.out.println("No image to save");
        }
        File fileToSave = fileImage;//askUserForFileToSave();

        if (fileToSave == null){
        }
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bufferedImage, "png", fileToSave);
        } catch (IOException e) {
        }

        System.out.println("Saved to the same path: "+fileImage);
    }

    public void fileSaveAs() {
        FileChooser fc = new FileChooser();
        fc.setTitle("Save image as");
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("JPG","*.jpg"));
        fc.getExtensionFilters().add(new FileChooser.ExtensionFilter("PNG","*.png"));
        fileImage = fc.showSaveDialog(null);

        KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();
        Image image = kepMegjelenit.getImage();
        if (image == null){
            System.out.println("No image to save");
        }
        File fileToSave = fileImage;//askUserForFileToSave();

        if (fileToSave == null){
        }
        BufferedImage bufferedImage = SwingFXUtils.fromFXImage(image, null);
        try {
            ImageIO.write(bufferedImage, "png", fileToSave);

        } catch (IOException e) {
        }

        System.out.println("Saved to path: "+fileImage);

    }

    public void exit(){
        System.exit(0);
    }

    public void fileKezel(String s) throws IOException {
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
