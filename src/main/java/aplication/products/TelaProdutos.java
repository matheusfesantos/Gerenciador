package aplication.products;

import aplication.Tela;
import aplication.nota_fiscal.TelaVendas;
import entites.produtos.dados.DadosTotais;
import entites.produtos.dados.ListaProdutos;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
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
        root.setStyle("-fx-background-image: url('photos/images/backgroundpool.png');");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setId("vbox");
        vbox.setSpacing(10);
        vbox.setPrefWidth(840);
        vbox.setPrefHeight(450);
        vbox.setMaxWidth(840);
        vbox.setMaxHeight(450);

        TextField search = new TextField();
        search.setMaxWidth(200);
        search.setMaxHeight(30);
        search.setPromptText("Buscar");
        search.setId("search");
        vbox.getChildren().add(search);

        List<ListaProdutos> produtos = DadosTotais.carregarProdutos();

        ScrollPane scroll = new ScrollPane();
        scroll.setId("scroll");
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        scroll.setMaxWidth(600);
        scroll.setMaxHeight(300);
        vbox.getChildren().add(scroll);

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(25));
        gridPane.setHgap(10);
        gridPane.setVgap(0);
        gridPane.setAlignment(Pos.CENTER);

        int col = 0;
        int row = 0;
        for (ListaProdutos produto : produtos){
            String NomeProduto = produto.getNome();

            Image image = new Image("file:"+produto.getImagem());
            ImageView imageView = new ImageView(image);
            imageView.setId("image");
            imageView.setFitWidth(120);
            imageView.setFitHeight(80);
            imageView.setPreserveRatio(true);

            Label produtoLabel = new Label(produto.getNome());
            produtoLabel.setId("produtoLabel");
            gridPane.add(produtoLabel, col, row );

            Label quantidadeLabel = new Label("Em estoque: " + produto.getQuantidade());
            quantidadeLabel.setId("quantidadeLabel");
            gridPane.add(quantidadeLabel, col, row + 1);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(10);

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e -> {
            Tela tela = new Tela();
            tela.start(primaryStage);
        });
        hbox.getChildren().add(voltar);

        Button vendas = new Button("VENDAS");
        vendas.setId("button");
        vendas.setOnAction(e -> {
            TelaVendas nt = new TelaVendas();
            nt.start(primaryStage);
        });
        hbox.getChildren().add(vendas);

        Button produtosButton = new Button("PRODUTOS");
        produtosButton.setId("button-produtos");
        hbox.getChildren().add(produtosButton);

        scroll.setContent(gridPane);
        vbox.getChildren().add(hbox);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/TelaProdutos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("MY STORE");
        primaryStage.show();
    }
}