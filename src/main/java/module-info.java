module com.juan.workshopjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.juan.workshopjavafx to javafx.fxml;
    opens com.juan.workshopjavafx.model.entities to javafx.base;
    exports com.juan.workshopjavafx;
}