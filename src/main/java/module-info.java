module com.example.javafxsqllite {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.javafxsqllite to javafx.fxml;
    exports com.example.javafxsqllite;
}