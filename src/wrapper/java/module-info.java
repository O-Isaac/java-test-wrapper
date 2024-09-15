module aa.servants {
    requires javafx.web;
    requires javafx.controls;
    requires javafx.base;
    requires javafx.graphics;
    requires javafx.media;
    requires jdk.jsobject;

    exports org.isaac.webview.bridged;
    opens org.isaac;
}