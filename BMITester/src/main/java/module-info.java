module com.truongthikimhoa.bmitester {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.truongthikimhoa.bmitester to javafx.fxml;
    exports com.truongthikimhoa.bmitester;
}
