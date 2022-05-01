package hu.projekt.photo;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.image.ImageView;

public /*abstract*/ class Muveletek {//TODO ki kell pluginformába szervezni
    String buttonName;
    //static KepMegjelenit kepMegjelenit = KepMegjelenit.getInstance();
    //abstract public Image muvelet();



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

}
