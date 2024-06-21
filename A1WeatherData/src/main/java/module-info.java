module org.example.a1weatherdata {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires java.sql;

    opens org.example.a1weatherdata to javafx.fxml;
    exports org.example.a1weatherdata;
}