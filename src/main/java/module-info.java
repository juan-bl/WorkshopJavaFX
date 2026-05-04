module com.juan.workshopjavafx {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.juan.workshopjavafx to javafx.fxml;
    exports com.juan.workshopjavafx;
}