package aplication.tela_de_venda;

import entites.produtos.pesquisar.Pesquisar;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaVenda extends Application {

    String nomeproduto;
    public TelaVenda(String nomeproduto){
        this.nomeproduto = nomeproduto;
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("MY STORE");

        Pesquisar pes = new Pesquisar(nomeproduto);

        BorderPane root = new BorderPane();
        root.setId("body");
        try{
            root.setStyle("-fx-background-image:" +
                    "url('photos/images/backgroundpool.png')");
        }
        catch (Exception e){
            System.out.println(e.getMessage());
        }

        VBox vbox = new VBox();
        vbox.setId("vbox");


        Image image = new Image(pes.getImagem());
        ImageView imageView = new ImageView(image);
        root.setCenter(imageView);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
        vbox.getChildren().add(imageView);

        root.setBottom(vbox);

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
