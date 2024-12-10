package aplication.nota_fiscal;

import entites.clientes.DadosVendas.DadosVendas;
import entites.clientes.DadosVendas.ListaVendas;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.awt.*;
import java.util.ArrayList;

public class NotasFiscais extends Application {

    @Override
    public void start(Stage primaryStage){
        ListaVendas Vnedas = new ListaVendas();

        primaryStage.setTitle("MY STORE");

        VBox vbox = new VBox();
        vbox.setId("vbox");
        vbox.setSpacing(10);

        List<ListaVendas> listaVendas = DadosVendas();

        GridPane grid = new GridPane();

        int row = 0;
        int col = 0;
        for (ListaVendas venda: vendas){

        }

        BorderPane root = new BorderPane();

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
