package entites.produtos.adiconar;


import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Adicionar {

    static String produto;
    static double preco;
    static int quantidade;
    static String imagem;

    public Adicionar(TextField produto, TextField preco, TextField quantidade){
        this.produto = produto.getText();
        this.preco = Double.parseDouble(preco.getText());
        this.quantidade = Integer.parseInt(quantidade.getText());
    }

    public static void main(String[] args) {

        Scanner sc = null;

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))){
            for (String escrever : produto.split("\n")){
                br.newLine();
                br.newLine();
                br.write(produto+";");
                br.write(preco+";");
                br.write(quantidade+";");
            }
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    @Override
    public String toString(){

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";
            try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))){
                for (String escrever : produto.split("\n")){
                    br.newLine();
                    br.newLine();
                    br.write(escrever+";");
                    br.write(preco+";");
                    br.write(quantidade+";");
                }
            }catch (IOException e){
                System.out.println("Erro: " + e.getMessage());
            }
        return "Produto: "+produto+"\n\n"+
                "Preço: "+ preco+"\n\n"+
                "Quantidade: "+quantidade;
    }
}
