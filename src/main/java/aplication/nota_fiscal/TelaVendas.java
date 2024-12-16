package aplication.nota_fiscal;

import aplication.Tela;
import aplication.products.TelaProdutos;
import entites.clientes.DadosVendas.DadosVendas;
import entites.clientes.DadosVendas.ListaVendas;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.List;

public class TelaVendas extends Application {

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
        vbox.setSpacing(40);
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

        GridPane grid = new GridPane();
        grid.setAlignment(Pos.CENTER);

        ScrollPane scroll = new ScrollPane();
        scroll.setId("scroll");
        scroll.setFitToWidth(true);
        scroll.setFitToHeight(true);
        scroll.setMaxWidth(600);
        scroll.setMaxHeight(300);
        vbox.getChildren().add(scroll);

        int row = 0;
        int col = 0;
        GridPane gridPane = new GridPane();
        gridPane.setAlignment(Pos.CENTER);
        gridPane.setPadding(new javafx.geometry.Insets(10));
        gridPane.setHgap(10);
        gridPane.setVgap(0);

        for (ListaVendas venda : vendas){

            Image NotaFiscal = new Image("photos/icons/nota_fiscal.png");
            ImageView imageView = new ImageView(NotaFiscal);
            imageView.setFitHeight(80);
            imageView.setFitWidth(200);
            imageView.setPreserveRatio(true);
            imageView.setSmooth(true);
            imageView.setId("NotaFiscal");

            Label vendaLabel = new Label(venda.getCliente());
            vendaLabel.setId("vendaLabel");
            vendaLabel.setPrefHeight(20);
            vendaLabel.setPrefWidth(80);
            vendaLabel.setAlignment(Pos.CENTER);
            vendaLabel.setCursor(Cursor.HAND);
            vendaLabel.setOnMouseClicked(e -> {
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Cliente: " + venda.getCliente());
                alert.setContentText("Data da Compra: " + venda.getData()+ "\n" +
                        "Produto Comprado: " + venda.getProduto()+ "\n" +
                        "Quantidade Comprada: "+ venda.getQuantidade()+ "\n" +
                        "Valor total: " + venda.getValorTotal());
                alert.showAndWait();
            });

            Label data = new Label(venda.getData());
            data.setAlignment(Pos.CENTER);
            data.setId("data");
            data.setPrefHeight(20);
            data.setPrefWidth(80);

            Label espaco = new Label("");
            gridPane.add(espaco, col, row + 3);

            gridPane.add(imageView, col, row);
            gridPane.add(data, col, row + 1 );
            gridPane.add(vendaLabel, col, row + 2);

            col++;
            if (col > 3) {
                col = 0;
                row += 2;
            }
        }
        scroll.setContent(gridPane);

        HBox hbox = new HBox();
        hbox.setSpacing(10);
        hbox.setAlignment(Pos.CENTER);
        vbox.getChildren().add(hbox);

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e -> {
            Tela tela = new Tela();
            tela.start(primaryStage);
        });
        hbox.getChildren().add(voltar);

        Button vendabt = new Button("VENDAS");
        vendabt.setId("button-venda");
        hbox.getChildren().add(vendabt);

        Button produtosButton = new Button("PRODUTOS");
        produtosButton.setId("button");
        produtosButton.setOnAction(e -> {
            TelaProdutos tp = new TelaProdutos();
            tp.start(primaryStage);
        });
        hbox.getChildren().add(produtosButton);

        root.setCenter(vbox);

        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add("Style/TelaVenda.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
