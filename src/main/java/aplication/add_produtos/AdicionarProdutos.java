package aplication.add_produtos;

import aplication.products.TelaProdutos;
import entites.produtos.adiconar.Adicionar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import javax.swing.*;

import java.io.File;

public class AdicionarProdutos extends Application {

    @Override
    public void start(Stage primaryStage){
        primaryStage.setTitle("MY STORE");

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

        Button voltar = new Button("VOLTAR");
        voltar.setId("button");
        voltar.setOnAction(e ->{
            TelaProdutos tp = new TelaProdutos();
            tp.start(primaryStage);
        });

        Label NdP = new Label("Nome do Produto:");
        NdP.setAlignment(Pos.CENTER);
        NdP.setId("label");
        TextField produto = new TextField();
        produto.setAlignment(Pos.CENTER);
        produto.setId("textfield");
        produto.setMaxWidth(300);
        produto.setMaxHeight(20);
        produto.setPromptText("Digite o produto");

        Label Qtd = new Label("Quantidade:");
        Qtd.setAlignment(Pos.CENTER);
        Qtd.setId("label");
        TextField quantidade = new TextField();
        quantidade.setAlignment(Pos.CENTER);
        quantidade.setId("textfield");
        quantidade.setMaxWidth(300);
        quantidade.setMaxHeight(20);
        quantidade.setPromptText("Digite a quantidade");

        Label Valor = new Label("Valor:");
        Valor.setAlignment(Pos.CENTER);
        Valor.setId("label");
        TextField preco = new TextField();
        preco.setAlignment(Pos.CENTER);
        preco.setId("textfield");
        preco.setMaxWidth(300);
        preco.setMaxHeight(20);
        preco.setPromptText("Digite o valor");

        final String[] imagem = {null};
        Button AdicionarImagem = new Button("Imagem");
        AdicionarImagem.setId("button-imagem");
        AdicionarImagem.setMaxWidth(300);
        AdicionarImagem.setMaxHeight(20);
        AdicionarImagem.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter
                    ("Imagem", "*.png", "*.jpg", "*.jpeg", "*.gif"));
            File selectedFile = fileChooser.showOpenDialog(primaryStage);
            if (selectedFile != null) {
                imagem[0] = selectedFile.getAbsolutePath();
                System.out.println("Caminho da imagem: " + imagem[0]);
            }
        });

        Button Adicionar = new Button("ADICIONAR PRODUTO");
        Adicionar.setId("button");
        Adicionar.setOnAction( event -> {
            if (produto != null && quantidade != null
                    && preco != null && imagem[0] != null){
                Adicionar adicionar = new Adicionar
                        (produto, preco, quantidade, imagem[0]);
                System.out.print(adicionar);
            }
            else{
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText("Erro ao Adicionar o Produto");
                alert.setContentText("Informações invalidas");
            }
        });

        //VBOX ITENS
        vbox.getChildren().add(voltar);

        vbox.getChildren().addAll(NdP);
        vbox.getChildren().addAll(produto);

        vbox.getChildren().addAll(Qtd);
        vbox.getChildren().addAll(quantidade);

        vbox.getChildren().addAll(Valor);
        vbox.getChildren().addAll(preco);

        vbox.getChildren().add(AdicionarImagem);

        vbox.getChildren().add(Adicionar);
        //VBOX ITENS

        root.setCenter(vbox);

        Scene scene = new Scene(root, 900, 500);
        scene.getStylesheets().add(getClass().getResource
                ("/Style/AdicionarProdutos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
