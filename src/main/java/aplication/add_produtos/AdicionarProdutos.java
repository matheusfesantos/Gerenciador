package aplication.add_produtos;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.stage.Stage;

public class AdicionarProdutos extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MY STORE");

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
