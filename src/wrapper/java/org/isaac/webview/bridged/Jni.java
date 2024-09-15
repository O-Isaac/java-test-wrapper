package org.isaac.webview.bridged;

import javafx.scene.web.WebEngine;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.io.File;

public class Jni {
    private WebEngine engine;
    private Stage stage;

    public Jni(WebEngine engine) {
        this.engine = engine;
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    public void test (String message) {
        FileChooser chooser = new FileChooser();
        chooser.setTitle(message);
        File file = chooser.showOpenDialog(this.stage);
        System.out.println(file.getName());
    }
}
