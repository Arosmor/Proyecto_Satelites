module es.amosrosado.satelites {
    requires javafx.controls;
    requires javafx.fxml;

    requires java.instrument;
    requires java.persistence;
    requires java.sql;
    requires java.base;
    
    opens es.amosrosado.satelites.entities;
    opens es.amosrosado.satelites to javafx.fxml;
    exports es.amosrosado.satelites;
}
