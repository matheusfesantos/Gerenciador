package aplication.tela_de_venda;

import entites.produtos.pesquisar.Pesquisar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;

public class TelaVenda extends Application {

    private String nomeproduto;

    public TelaVenda(String nomeproduto) {
        this.nomeproduto = nomeproduto;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MY STORE");

        Pesquisar pes = new Pesquisar(nomeproduto);
        String resultadoProduto = pes.pesquisarProduto();

        BorderPane root = new BorderPane();
        root.setId("body");
        root.setStyle("-fx-background-image:" +
                "url('photos/images/backgroundpool.png')");

        VBox vbox = new VBox();
        vbox.setId("vbox");

        int valor = (int) pes.getPreco();
        String imagemProduto = pes.getImagem();

        Image image = new Image("file:" + imagemProduto);
        ImageView imageView = new ImageView(image);
        imageView.setFitWidth(200);
        imageView.setPreserveRatio(true);
        vbox.getChildren().add(imageView);

        Label PrecoProduto = new Label(valor + "");
        vbox.getChildren().add(PrecoProduto);

        root.setCenter(vbox);

        Scene scene = new Scene(root, 900, 500);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}