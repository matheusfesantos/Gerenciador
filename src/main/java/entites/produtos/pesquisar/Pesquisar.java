package entites.produtos.pesquisar;

import java.io.*;

public class Pesquisar {

    private String nomeProduto;
    public Pesquisar(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String pesquisarProduto() {
        File arquivo = new File("C:\\Users\\matheus.fgs\\" +
                "Desktop\\Gerenciador_Java\\Banco_De_Dados\\produtos.txt");

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 4 && separador[0].trim().toLowerCase()
                        .contains(nomeProduto.toLowerCase())){

                    String nomeProduto = separador[0].trim();
                    double preco = Double.parseDouble(separador[1].trim());
                    int quantidade = Integer.parseInt(separador[2].trim());
                    String imagem = separador[3].trim();

                    ConstrutorPesquisar constr = new ConstrutorPesquisar
                            (nomeProduto, preco, quantidade, imagem);

                    break;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "";
    }
}