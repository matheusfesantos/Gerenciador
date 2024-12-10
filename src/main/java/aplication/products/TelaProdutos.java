package aplication.products;

import entites.produtos.dados.DadosTotais;
import entites.produtos.dados.ListaProdutos;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class TelaProdutos extends Application {

    @Override
    public void start(Stage primaryStage) {

        BorderPane root = new BorderPane();
        root.setId("body");
        root.setStyle("-fx-background-image:" +
                "url('photos/images/backgroundpool.png')");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setId("vbox");
        vbox.setSpacing(10);
        vbox.setPrefWidth(840);
        vbox.setPrefHeight(450);
        vbox.setMaxWidth(840);
        vbox.setMaxHeight(450);

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(10);

        List<ListaProdutos> produtos = DadosTotais.carregarProdutos();

        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(10);

        int row = 0;
        for (ListaProdutos produto : produtos) {
            VBox produtoBox = new VBox(5);

            ImageView imageView;
                Image image = new Image("file:" + produto.getImagem());
                imageView = new ImageView(image);
                imageView.setFitWidth(100);
                imageView.setPreserveRatio(true);

            produtoBox.getChildren().addAll(imageView);

            gridPane.add(produtoBox, row % 3, row / 3);
            row++;
        }

        Button vendas = new Button("VENDAS");
        vendas.setId("button");
        hbox.getChildren().add(vendas);

        Button produtosButton = new Button("PRODUTOS");
        produtosButton.setId("button");
        hbox.getChildren().add(produtosButton);

        vbox.getChildren().add(hbox);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 900,500);
        primaryStage.setScene(scene);
        primaryStage.setTitle("MY STORE");
        primaryStage.show();
    }
}
