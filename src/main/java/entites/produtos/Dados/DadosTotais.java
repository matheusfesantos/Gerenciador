package entites.produtos.Dados;

import java.io.File;
import java.util.Scanner;

public class DadosTotais {

    public static void main(String[] args) {

        File arquivo = new File("C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\produtos.txt");

        Scanner sc = null;

        try {
            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado: " + arquivo.getAbsolutePath());
                return;
            }

            sc = new Scanner(arquivo);
            String linha;
            while (sc.hasNextLine()) {
                linha = sc.nextLine();
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 4) {
                    String produto = separador[0].trim();
                    double preco = Double.parseDouble(separador[1].trim());
                    int quantidade = Integer.parseInt(separador[2].trim());
                    String imagem = separador[3].trim();

                    System.out.println("Produto: " + produto);
                    System.out.println("Preço: " + preco);
                    System.out.println("Quantidade disponível: " + quantidade);
                    System.out.println(" ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
    }
    @Override
    public String toString() {
        File arquivo = new File("C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\produtos.txt");

        Scanner sc = null;

        try {
            if (!arquivo.exists()) {
                System.out.println("Arquivo não encontrado: " + arquivo.getAbsolutePath());
            }

            sc = new Scanner(arquivo);
            String linha;
            while (sc.hasNextLine()) {
                linha = sc.nextLine();
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 3) {
                    String produto = separador[0].trim();
                    double preco = Double.parseDouble(separador[1].trim());
                    int quantidade = Integer.parseInt(separador[2].trim());

                    System.out.println("Produto: " + produto);
                    System.out.println("Preço: " + preco);
                    System.out.println("Quantidade disponível: " + quantidade);
                    System.out.println(" ");
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (sc != null) {
                sc.close();
            }
        }
        return "";
    }
}
