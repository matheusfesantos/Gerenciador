package aplication.tela_de_venda;

import aplication.products.TelaProdutos;

import entites.clientes.adiconar_venda.AdicionarVenda;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import static java.lang.Integer.parseInt;

public class VendaCliente extends Application {

    static String nomeProduto;
    static String imagemProduto;
    static double precoProduto;
    static int quantidadeProduto;

    public VendaCliente(String nomeProduto, String imagemProduto,
                        double precoProduto, int quantidadeProduto){

        this.nomeProduto = nomeProduto;
        this.imagemProduto = imagemProduto;
        this.precoProduto = precoProduto;
        this.quantidadeProduto = quantidadeProduto;
    }

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MY STORE");

        BorderPane root = new BorderPane();
        root.setId("body");
        root.setStyle("-fx-background-image: url('photos/images/backgroundpool.png');");

        VBox vbox = new VBox();
        vbox.setAlignment(Pos.CENTER);
        vbox.setId("vbox");
        vbox.setSpacing(12);
        vbox.setPrefWidth(840);
        vbox.setPrefHeight(450);
        vbox.setMaxWidth(840);
        vbox.setMaxHeight(450);

        HBox hbox = new HBox();
        hbox.setSpacing(20);
        hbox.setAlignment(Pos.CENTER);

        Image image = new Image("file:" + imagemProduto);
        ImageView imageView = new ImageView(image);
        imageView.setFitHeight(90);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        imageView.setSmooth(true);

        double valor = precoProduto;
        Label infoProduto = new Label("  "+precoProduto + " R$ \n\n " +
                +  quantidadeProduto + " em estoque");
        infoProduto.setId("info-produto");
        infoProduto.setAlignment(Pos.CENTER);
        hbox.getChildren().addAll(imageView, infoProduto);

        vbox.getChildren().add(hbox);

        Label nomeliente = new Label("Cliente");
        nomeliente.setAlignment(Pos.CENTER);
        nomeliente.setId("label");
        nomeliente.setPrefWidth(100);
        nomeliente.setPrefHeight(20);
        TextField cliente = new TextField();
        cliente.setAlignment(Pos.CENTER);
        cliente.setPromptText("Digite o nome do cliente");
        cliente.setId("textfield");
        cliente.setMaxWidth(300);
        cliente.setMaxHeight(20);

        LocalDate hoje = LocalDate.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String dataFormatada = hoje.format(formato);

        Label data = new Label("Data da Venda");
        data.setAlignment(Pos.CENTER);
        data.setId("label");
        data.setMaxWidth(300);
        TextField data_venda = new TextField(dataFormatada);
        data_venda.setAlignment(Pos.CENTER);
        data_venda.setEditable(false);
        data_venda.setId("textfield-data");
        data_venda.setMaxWidth(300);
        data_venda.setMaxHeight(20);

        Label quantidadeproduto = new Label("Quantidade");
        quantidadeproduto.setAlignment(Pos.CENTER);
        quantidadeproduto.setId("label");
        quantidadeproduto.setMaxWidth(300);
        quantidadeproduto.setPrefHeight(20);
        quantidadeproduto.setPrefWidth(300);
        TextField quantidade = new TextField();
        quantidade.setAlignment(Pos.CENTER);
        quantidade.setPromptText("Digite a quantidade");
        quantidade.setId("textfield");
        quantidade.setMaxWidth(300);
        quantidade.setMaxHeight(20);

        vbox.getChildren().add(nomeliente);
        vbox.getChildren().add(cliente);

        vbox.getChildren().add(data);
        vbox.getChildren().add(data_venda);

        vbox.getChildren().add(quantidadeproduto);
        vbox.getChildren().add(quantidade);

        HBox botoes = new HBox();
        botoes.setAlignment(Pos.CENTER);
        botoes.setSpacing(30);

        Button voltar = new Button("CANCELAR COMPRA");
        voltar.setId("button");
        voltar.setOnAction(e ->{
            TelaProdutos tp = new TelaProdutos();
            tp.start(primaryStage);
        });

        Button comprarbnt = new Button("COMPRAR");
        comprarbnt.setId("button");
        comprarbnt.setOnAction(e ->{
            AdicionarVenda addV = new AdicionarVenda
                    (cliente, data_venda, quantidade, valor, nomeProduto );
            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);

            String nome = cliente.getText();//PASSAR NOME CLIENTE PARA VARIÁVEL
            String NomeUpperCase = nome.toUpperCase();// DEIXAR TUDO MAIÚSCULO

            alert.setTitle("COMPRA DE "+NomeUpperCase+" RELIZADA");
            alert.setHeaderText(null);
            alert.setContentText(addV.toString());
            alert.showAndWait();
            if (addV != null) {
                TelaProdutos tp = new TelaProdutos();
                tp.start(primaryStage);
            }
        });

        botoes.getChildren().add(voltar);
        botoes.getChildren().add(comprarbnt);
        vbox.getChildren().add(botoes);

        root.setCenter(vbox);

        Scene scene = new Scene(root, 900,500);
        scene.getStylesheets().add("/Style/VendaCliente.css");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
