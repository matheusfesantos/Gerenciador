package entites.produtos.autializar_produtos;

import java.io.*;

public class AtualizarProdutos {

    private String nomeproduto;
    private int quantidade;

    // Construtor
    public AtualizarProdutos(String nomeproduto, int quantidade) {
        this.nomeproduto = nomeproduto;
        this.quantidade = quantidade;
    }

    @Override
    public String toString() {
        String arquivo = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\produtos.txt";

        StringBuilder conteudoAtualizado = new StringBuilder();
        boolean encontrado = false;

        try (BufferedReader br = new BufferedReader(new FileReader(arquivo))) {
            String linha;

            while ((linha = br.readLine()) != null) {
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 4 && separador[0].trim()
                        .equalsIgnoreCase(nomeproduto)) {
                    encontrado = true;

                    nomeproduto = separador[0].trim();
                    double preco = Double.parseDouble(separador[1].trim());
                    int quantidadeAtual = Integer.parseInt(separador[2].trim());
                    String imagem = separador[3].trim();

                    quantidadeAtual = quantidadeAtual - quantidade;

                    conteudoAtualizado.append(nomeproduto).append(";")
                            .append(preco).append(";")
                            .append(quantidadeAtual).append(";")
                            .append(imagem);
                } else {
                    conteudoAtualizado.append(linha).append("\n");
                }
            }
        } catch (FileNotFoundException e) {
            return "Arquivo não encontrado: " + arquivo;
        } catch (IOException e) {
            return "Erro ao processar o arquivo: " + e.getMessage();
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(arquivo))) {
            bw.write(conteudoAtualizado.toString());
            System.out.println("Arquivo atualizado com sucesso!");
        } catch (IOException e) {
            return "Erro ao gravar no arquivo: " + e.getMessage();
        }

        if (!encontrado) {
            return "Produto '" + nomeproduto + "' não encontrado no arquivo.";
        }
        return "";
    }
}