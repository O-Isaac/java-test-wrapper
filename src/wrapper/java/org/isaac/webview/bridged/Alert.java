package org.isaac.webview.bridged;

import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.web.WebEngine;

public class Alert {
    private final WebEngine engine;

    public Alert(WebEngine engine) {
        this.engine = engine;
        this.addToEngine();
    }

    private void addToEngine() {
        this.engine.setOnAlert(event -> this.onAlert(
            event.getData()
        ));
    }

    private void onAlert(String message) {
        Dialog<Void> alert = new Dialog<Void>();
        alert.getDialogPane().setContentText(message);
        alert.getDialogPane().getButtonTypes().add(ButtonType.OK);
        alert.showAndWait();
    }
}
