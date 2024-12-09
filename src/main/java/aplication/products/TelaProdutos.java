package aplication.products;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaProdutos extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setId("body");
        root.setStyle("-fx-background-image:" +
                "url('photos/images/backgroundpool.png')");

        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.setSpacing(10);
        vbox.setPrefWidth(700);
        vbox.setPrefHeight(400);
        vbox.setMaxWidth(700);
        vbox.setMaxHeight(400);

        HBox hbox = new HBox();
        hbox.setSpacing(10);

        root.setCenter(vbox);

        Scene scene = new Scene(root, 900,500);
        scene.getStylesheets().add(getClass().getResource("/Style/TelaProdutos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("MY STORE");
        primaryStage.show();
    }
}
