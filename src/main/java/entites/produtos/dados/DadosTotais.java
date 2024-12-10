package entites.produtos.dados;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadosTotais {

    public static List<ListaProdutos> carregarProdutos() {
        List<ListaProdutos> produtos = new ArrayList<>();
        File arquivo = new File("C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\produtos.txt");

        try (Scanner sc = new Scanner(arquivo)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 4) {
                    String nome = separador[0].trim();
                    double preco = Double.parseDouble(separador[1].trim());
                    int quantidade = Integer.parseInt(separador[2].trim());
                    String imagem = separador[3].trim();

                    produtos.add(new ListaProdutos(nome, preco, quantidade, imagem));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return produtos;
    }
}