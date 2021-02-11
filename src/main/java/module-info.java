module contactbook {

    requires javafx.controls;
    requires javafx.fxml;

    exports com.IdczakI.contactbook.app to javafx.graphics;
    opens com.IdczakI.contactbook.controller to javafx.fxml;
    opens com.IdczakI.contactbook.model to javafx.base;

}