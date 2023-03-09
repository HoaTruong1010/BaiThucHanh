module com.truongthikimhoa.englishapp {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;

    opens com.truongthikimhoa.englishapp to javafx.fxml;
    exports com.truongthikimhoa.englishapp;
    exports com.truongthikimhoa.pojo;
    exports com.truongthikimhoa.services;
}
