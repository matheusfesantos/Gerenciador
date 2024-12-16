package entites.produtos.adiconar;


import javafx.scene.control.TextField;

import java.io.*;
import java.util.Scanner;

public class Adicionar {

    static String produto;
    static double preco;
    static int quantidade;
    public Adicionar(TextField produto, TextField preco, TextField quantidade){
        this.produto = String.valueOf(produto);
        this.preco = Double.parseDouble(preco.getText());
        this.quantidade = Integer.parseInt(quantidade.getText());
    }

    public static void main(String[] args) {

        Scanner sc = null;

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))) {

            if(produto != null && preco > 0 && quantidade > 0){
                for (String escrever : produto.split("\n")){
                    br.newLine();
                    br.newLine();
                    br.write(escrever+";");
                    br.write(preco+";");
                    br.write(quantidade+";");
                }
            }else{
                System.out.print("Valores nulos !!");
            }

        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
    }
    @Override
    public String toString() {
        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))) {

            if(produto != null && preco > 0 && quantidade > 0){
                for (String escrever : produto.split("\n")){
                    br.newLine();
                    br.newLine();
                    br.write(escrever+";");
                    br.write(preco+";");
                    br.write(quantidade+";");
                }
            }else{
                System.out.print("Valores nulos !!");
            }

        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return "Produtos adicionados com sucesso.";
    }
}
