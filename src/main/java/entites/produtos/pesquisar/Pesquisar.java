package entites.produtos.pesquisar;

import java.io.*;

public class Pesquisar {

    private String nomeproduto;

    public Pesquisar(String nome) {
        this.nomeproduto = nome;
    }

    @Override
    public String toString() {
        File arquivo = new File("C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\produtos.txt");

        StringBuilder resultado = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrado = false;

            while ((linha = br.readLine()) != null) {
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 3 && separador[0].trim().toLowerCase().
                        contains(nomeproduto.toLowerCase())){

                    encontrado = true;
                    nomeproduto = separador[0].trim();
                    double preco = Double.parseDouble(separador[1].trim());
                    int quantidade = Integer.parseInt(separador[2].trim());

                    resultado.append("Produto: ").append(nomeproduto).append("\n");
                    resultado.append("Preço: ").append(preco).append("\n");
                    resultado.append("Quantidade disponível: ").append(quantidade).append("\n");
                    break;
                }
            }
            if (!encontrado) {
                resultado.append(nomeproduto).append(" não foi encontrado no Banco de Dados.");
            }
        } catch (IOException e) {
            resultado.append("Erro ao acessar o arquivo: ").append(e.getMessage());
        }

        return resultado.toString();
    }
}