package aplication;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tela extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MY STORE");

        BorderPane root = new BorderPane();
        root.setId("body");
        root.setStyle("-fx-background-image:" +
                "url('photos/images/backgroundpool.png')");

        VBox vBox = new VBox();

        Label titulo = new Label("GERENCIADOR");
        titulo.setId("titulo");
        vBox.getChildren().add(titulo);

        Button produtos = new Button("PRODUTOS");
        produtos.setId("button-produtos");
        vBox.getChildren().add(produtos);

        Button vendas = new Button("VENDAS");
        vendas.setId("button-vendas");
        vBox.getChildren().add(vendas);

        root.setCenter(vBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 800, 500);
        scene.getStylesheets().add(getClass().getResource
                ("/Style/Tela.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}