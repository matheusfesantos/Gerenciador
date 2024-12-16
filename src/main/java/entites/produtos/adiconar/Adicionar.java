package entites.produtos.adiconar;


import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Adicionar {

    static String produto;
    static double preco;
    static int quantidade;
    static String imagem;

    public Adicionar(TextField produto, TextField preco, TextField quantidade, String imagem){
        this.produto = produto.getText();
        this.preco = Double.parseDouble(preco.getText());
        this.quantidade = Integer.parseInt(quantidade.getText());
    }

    public static void main(String[] args) {

        Scanner sc = null;

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";

            if(produto != null && preco > 0 && quantidade > 0 && imagem != null){

                try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))){
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
            }else{
                System.out.print("Valores nulos !!");
            }
    }
    @Override
    public String toString(){

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";

        if(produto != null && preco > 0 && quantidade > 0 && imagem != null){

            try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))){
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
        }else{
            System.out.print("Valores nulos !!");
        }

        return "Produtos adicionados com sucesso.";
    }
}
