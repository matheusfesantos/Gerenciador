package aplication;

import aplication.nota_fiscal.NotasFiscais;
import aplication.products.TelaProdutos;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Tela extends Application {

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MY STORE");

        BorderPane root = new BorderPane();
        root.setId("body");
        try{
            root.setStyle("-fx-background-image:" +
                    "url('photos/images/backgroundpool.png')");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        VBox vBox = new VBox();
        vBox.setSpacing(40);

        Image image = new Image("photos/icons/TITULO_GERENCIADOR.png");
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(400);
        imageView.setFitWidth(400);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);
        vBox.getChildren().add(imageView);

        Button produtos = new Button("PRODUTOS");
        produtos.setId("button-produtos");
        TelaProdutos tp = new TelaProdutos();
        produtos.setOnAction(event ->{
                tp.start(primaryStage);
        });
        vBox.getChildren().add(produtos);

        Button vendas = new Button("VENDAS");
        vendas.setId("button-vendas");
        NotasFiscais nt = new NotasFiscais();
        vendas.setOnAction(event ->{
                nt.start(primaryStage);
        });
        vBox.getChildren().add(vendas);

        root.setCenter(vBox);
        vBox.setSpacing(10);
        vBox.setAlignment(Pos.CENTER);

        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add("Style/Main.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
