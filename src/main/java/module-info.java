module com.kevinomyonga.snowman {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.kevinomyonga.snowman to javafx.fxml;
    exports com.kevinomyonga.snowman;
}