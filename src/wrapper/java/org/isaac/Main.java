package org.isaac;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;
import org.isaac.webview.browser.Browser;

public class Main extends Application {
    public static void main(String[] args) {
        launch(args);
    }

    public void start(Stage stage) throws Exception {
        Browser browser = new Browser(stage);
        browser.goTo("https://google.es");

        stage.show();

        Platform.runLater(() -> {
         browser.getEngine().executeScript("window.jni.test('Invocado desde la web')");
        });
    }
}