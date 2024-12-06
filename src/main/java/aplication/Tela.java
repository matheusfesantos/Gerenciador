package aplication;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class Tela extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MY STORE");

        BorderPane root = new BorderPane();
        root.setId("body");

        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource
                ("/Style/Tela.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
