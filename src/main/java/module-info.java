module ru.maxawergy.rkss_pr {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;

    opens ru.maxawergy.rkss_pr1 to javafx.fxml;
    exports ru.maxawergy.rkss_pr1;
}