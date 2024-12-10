package aplication.nota_fiscal;

import aplication.Tela;
import entites.clientes.DadosVendas.DadosVendas;
import entites.clientes.DadosVendas.ListaVendas;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class NotasFiscais extends Application {

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

        List<ListaVendas> vendas = DadosVendas.carregarVendas();

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setId("vbox");
        vbox.setSpacing(10);
        vbox.setPrefWidth(840);
        vbox.setPrefHeight(450);
        vbox.setMaxWidth(840);
        vbox.setMaxHeight(450);

        Image NotaFiscal = new Image("photos/icons/nota_fiscal.png");

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        ScrollPane scroll = new ScrollPane();
        scroll.setId("scroll");
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        scroll.setPrefHeight(200);
        scroll.setPrefWidth(300);
        scroll.setMaxWidth(300);
        scroll.setMaxHeight(200);
        vbox.getChildren().add(scroll);

        int row = 0;
        int col = 0;
        GridPane gridPane = new GridPane();
        gridPane.setHgap(10);
        gridPane.setVgap(0);

        for (ListaVendas venda : vendas) {
            ImageView imageView = new ImageView(NotaFiscal);
            imageView.setFitHeight(50);
            imageView.setFitWidth(50);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setId("NotaFiscal");

            Label vendaLabel = new Label(venda.getCliente());
            vendaLabel.setId("NotaFiscal");

            gridPane.add(imageView, col, row);
            gridPane.add(vendaLabel, col, row + 1);  // Ajustei para colocar a label abaixo da imagem

            col++;
            if (col > 3) {
                col = 0;
                row += 2;
            }
        }
        scroll.setContent(gridPane);

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e -> {
            Tela tela = new Tela();
            tela.start(primaryStage);
        });
        vbox.getChildren().add(voltar);

        Button vendabt = new Button("VENDAS");
        vendabt.setId("button");
        vbox.getChildren().add(vendabt);

        Button produtosButton = new Button("PRODUTOS");
        produtosButton.setId("button");
        vbox.getChildren().add(produtosButton);

        root.setCenter(vbox);

        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add("Style/TelaVenda.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
