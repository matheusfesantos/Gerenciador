package aplication.products;

import entites.produtos.dados.DadosTotais;
import entites.produtos.dados.ListaProdutos;
import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.naming.directory.SearchControls;
import javax.naming.directory.SearchResult;
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

        List<ListaProdutos> produtos = DadosTotais.carregarProdutos();

        GridPane gridPane = new GridPane();
        gridPane.setPadding(new Insets(25));
        gridPane.setHgap(10);
        gridPane.setVgap(10);
        gridPane.setAlignment(Pos.CENTER);

        int col = 0;
        int row = 0;
        for (ListaProdutos produto : produtos){
            String NomeProduto = produto.getNome();

            Label produtoLabel = new Label(produto.getNome());
            produtoLabel.setId("produtoLabel");
            gridPane.add(produtoLabel, col, row);

            col++;
            if (col > 2) {
                col = 0;
                row++;
            }
        }

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(10);

        Button vendas = new Button("VENDAS");
        vendas.setId("button");
        hbox.getChildren().add(vendas);

        Button produtosButton = new Button("PRODUTOS");
        produtosButton.setId("button");
        hbox.getChildren().add(produtosButton);

        vbox.getChildren().add(gridPane);
        vbox.getChildren().add(hbox);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add(getClass().getResource("/Style/TelaProdutos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("MY STORE");
        primaryStage.show();
    }
}