module com.example.projectta3 {
    requires javafx.controls;
    requires javafx.fxml;
    requires javafx.web;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;
    requires validatorfx;
    requires org.kordamp.ikonli.javafx;
    requires org.kordamp.bootstrapfx.core;
    requires eu.hansolo.tilesfx;
    requires com.jfoenix;
    requires javafx.media;
    requires jfoenix;

    opens com.example.projectta3 to javafx.fxml;
    exports com.example.projectta3;
    exports com.example;
    opens com.example to javafx.fxml;
    exports com.example.Avabilities;
    opens com.example.Avabilities to javafx.fxml;
}