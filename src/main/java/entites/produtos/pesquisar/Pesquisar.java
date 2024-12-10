package entites.produtos.pesquisar;

import java.io.*;

public class Pesquisar {

    private String nomeProduto;
    private String imagem;
    private double preco;
    private int quantidade;

    public Pesquisar(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public String pesquisarProduto() {
        File arquivo = new File("C:\\Users\\matheus.fgs\\" +
                "Desktop\\Gerenciador_Java\\Banco_de_Dados\\produtos.txt");

        StringBuilder resultado = new StringBuilder();

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;
            boolean encontrado = false;

            while ((linha = br.readLine()) != null) {
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 4 && separador[0].trim().toLowerCase().contains(nomeProduto.toLowerCase())) {
                    encontrado = true;

                    this.nomeProduto = separador[0].trim();
                    this.preco = Double.parseDouble(separador[1].trim());
                    this.quantidade = Integer.parseInt(separador[2].trim());
                    this.imagem = separador[3].trim();

                    resultado.append("Produto: ").append(nomeProduto).append("\n")
                            .append("Preço: R$ ").append(preco).append("\n")
                            .append("Quantidade disponível: ").append(quantidade).append("\n")
                            .append("Imagem: ").append(imagem).append("\n");
                    break;
                }
            }

            if (!encontrado) {
                resultado.append("O produto ").append(nomeProduto).append(" não foi encontrado no Banco de Dados.");
            }
        } catch (IOException e) {
            resultado.append("Erro ao acessar o arquivo: ").append(e.getMessage());
        }

        return resultado.toString();
    }

    public String getNomeProduto() {
        return nomeProduto;
    }

    public void setNomeProduto(String nomeProduto) {
        this.nomeProduto = nomeProduto;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade) {
        this.quantidade = quantidade;
    }

    public String getImagem() {
        return imagem;
    }

    public void setImagem(String imagem) {
        this.imagem = imagem;
    }
}