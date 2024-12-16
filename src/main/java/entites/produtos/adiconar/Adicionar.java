package entites.produtos.adiconar;


import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Adicionar {

    static String produto;
    static TextField preco;
    static TextField quantidade;
    static String imagem;

    public Adicionar(TextField produto, TextField preco, TextField quantidade){
        this.produto = String.valueOf(produto);
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    @Override
    public String toString() {
        Scanner sc = new Scanner(System.in);

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_de_Dados\\produto.txt";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))) {

            for (String escrever : produto.split("\n")){
                br.newLine();
                br.newLine();
                br.write(escrever+";");
                br.write(preco+";");
                br.write(quantidade+";");
                br.write(imagem);
            }
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return"";
    }
}
