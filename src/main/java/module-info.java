module com.example.photo {
    requires javafx.controls;
    requires javafx.fxml;


    opens hu.projekt.photo to javafx.fxml;
    exports hu.projekt.photo;
}