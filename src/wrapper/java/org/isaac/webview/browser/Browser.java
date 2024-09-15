package org.isaac.webview.browser;

import javafx.scene.Scene;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;
import netscape.javascript.JSObject;
import org.isaac.webview.bridged.Alert;
import org.isaac.webview.bridged.Jni;

public class Browser {
    private final WebView view = new WebView();
    private final WebEngine engine = this.view.getEngine();
    private final Jni jni = new Jni(this.engine);
    private final Stage stage;

    public Browser(Stage stage) {
        this.stage = stage;
        this.loadBrowser();

        new Alert(this.engine);
    }

    public WebEngine getEngine() {
        return engine;
    }

    public WebView getView() {
        return view;
    }

    public void goTo(String pageUrl) {
        this.engine.load(pageUrl);
    }

    private void loadBrowser() {
        this.jni.setStage(this.stage);

        JSObject windowJs = (JSObject) this.engine.executeScript("window");
        windowJs.setMember("jni", this.jni);

        this.stage.setScene(
            new Scene(this.view)
        );
    }
}
