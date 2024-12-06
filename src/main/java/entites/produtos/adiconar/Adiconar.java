package entites.produtos.adiconar;


import java.io.*;
import java.util.Scanner;

public class Adiconar {

    static String produto;
    static double preco;
    static int quantidade;
    public Adiconar(String produto, double preco, int quantidade){
        this.produto = produto;
        this.preco = preco;
        this.quantidade = quantidade;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\banco.txt";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))) {

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
    }
    @Override
    public String toString() {
        Scanner sc = new Scanner(System.in);

        String banco = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\produto.txt";

        try(BufferedWriter br = new BufferedWriter(new FileWriter(banco, true))) {

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
        return"";
    }
}
