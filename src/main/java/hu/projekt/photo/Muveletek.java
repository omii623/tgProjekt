package hu.projekt.photo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public abstract class Muveletek implements Initializable {
    @FXML
    protected HBox hbox;
    @FXML
     VBox vbox;
    @FXML
    Label label;
    protected List<Button> buttonList = new ArrayList<>();
    protected String text = "name";

    abstract public void buttonSetup();

    public void setText(String text){
        this.text = text;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        buttonSetup();
        label.setText(text);

        vbox.setStyle(" -fx-border-color: #2e8b57;" +
                " -fx-background-color: #A0BBA2;" +
                "    -fx-border-width: 2px;" +
                "    -fx-spacing: 8;");

        hbox.setSpacing(10);
        hbox.setMaxWidth(1000);
        vbox.setMaxWidth(1000);

        hbox.setMinWidth(buttonList.size()*60+buttonList.size()*10);
        vbox.setMinWidth(hbox.getMinWidth());

        for (Button button:buttonList) {
            hbox.getChildren().add(button);
        }
    }

/*
//    forgat
    //    TODO ezitt nem jo helyen van ik meg nem abstract
    public void forgatJobb(ImageView modositando)
    {
        System.out.println("asdasdaddsadasdasd");
        modositando.setRotate(modositando.getRotate()+90);
        //kepMegjelenit.setImageView(modositando);
    }

    public void forgatBal(ImageView modositando)
    {
        modositando.setRotate(modositando.getRotate()-90);
    }

//    tukroz / flip
    public void tukrozViz(ImageView modositando)
    {
        modositando.setScaleY(-1);
    }

    public void tukrozFugg(ImageView modositando)
    {
        modositando.setScaleX(-1);
    }
*/
}
