package aplication.products;

import aplication.tela_de_venda.TelaVenda;
import entites.clientes.adiconar_venda.AdicionarVenda;
import entites.produtos.pesquisar.Pesquisar;
import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

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

        Image search = new Image("photos/produtos/cloro.png");
        String nomeproduto = "Cloro";
        ImageView imageView = new ImageView(search);
        imageView.setFitWidth(100);
        imageView.setFitHeight(100);
        vbox.getChildren().add(imageView);

        TelaVenda telaVenda = new TelaVenda(nomeproduto);
        imageView.setOnMouseClicked(event -> {
            try{
                telaVenda.start(primaryStage);
            }
            catch(Exception e){
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("ERRO");
                alert.setHeaderText("Aconteceu algum erro, tente novamente");
                alert.setContentText(e.getMessage());
            }
        });

        HBox hbox = new HBox();
        hbox.setAlignment(Pos.TOP_CENTER);
        hbox.setSpacing(10);

        Button vendas = new Button("VENDAS");
        vendas.setId("button");
        hbox.getChildren().add(vendas);

        Button produtos = new Button("PRODUTOS");
        produtos.setId("button");
        hbox.getChildren().add(produtos);

        vbox.getChildren().add(hbox);
        root.setCenter(vbox);

        Scene scene = new Scene(root, 900,500);
        scene.getStylesheets().add(getClass().getResource("/Style/TelaProdutos.css").toExternalForm());
        primaryStage.setScene(scene);
        primaryStage.setTitle("MY STORE");
        primaryStage.show();
    }
}
