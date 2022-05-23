module com.example.photo {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.desktop;
    requires javafx.swing;


    opens hu.projekt.photo to javafx.fxml;
    exports hu.projekt.photo;
    exports hu.projekt.photo.muveletekChild;
    opens hu.projekt.photo.muveletekChild to javafx.fxml;
}