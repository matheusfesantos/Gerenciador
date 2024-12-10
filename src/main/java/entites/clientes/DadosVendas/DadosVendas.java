package entites.clientes.DadosVendas;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadosVendas {

    private static final String ARQUIVO_VENDAS = "C:\\Users\\matheus.fgs\\Desktop\\"
            + "Gerenciador_de_Estoque\\Banco_de_Dados\\datas_vendas.txt";

    public List<ListaVendas> carregarVendas() {
        List<ListaVendas> vendas = new ArrayList<>();
        File arquivo = new File(ARQUIVO_VENDAS);

        try (Scanner scanner = new Scanner(arquivo)) {
            while (scanner.hasNextLine()) {
                String linha = scanner.nextLine();
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 5) {
                    try {
                        String data = separador[0].trim();
                        String produto = separador[1].trim();
                        int quantidade = Integer.parseInt(separador[2].trim());
                        double valor = Double.parseDouble(separador[3].trim());
                        String cliente = separador[4].trim();

                        vendas.add(new ListaVendas(data, produto, quantidade, valor, cliente));
                    } catch (NumberFormatException e) {
                        System.err.println("Erro ao processar linha: " + linha);
                        e.printStackTrace();
                    }
                } else {
                    System.err.println("Linha inválida: " + linha);
                }
            }
        } catch (FileNotFoundException e) {
            System.err.println("Arquivo não encontrado: " + ARQUIVO_VENDAS);
            e.printStackTrace();
        }

        return vendas;
    }

    @Override
    public String toString() {
        List<ListaVendas> vendas = carregarVendas();
        StringBuilder sb = new StringBuilder();

        for (ListaVendas venda : vendas) {
            sb.append("Data: ").append(venda.getData()).append("\n");
            sb.append("Produto: ").append(venda.getProduto()).append(" (").append(venda.getQuantidade()).append(")\n");
            sb.append("Valor da Venda: ").append(venda.getValor()).append("\n");
            sb.append("Cliente: ").append(venda.getCliente()).append("\n\n");
        }

        return sb.toString();
    }
}