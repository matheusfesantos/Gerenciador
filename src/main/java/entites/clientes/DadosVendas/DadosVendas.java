package entites.clientes.DadosVendas;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DadosVendas {

    public static List<ListaVendas> carregarVendas() {
        List<ListaVendas> vendas = new ArrayList<>();
        File arquivo = new File("C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_de_Dados\\datas_vendas.txt");

        try (Scanner sc = new Scanner(arquivo)) {
            while (sc.hasNextLine()) {
                String linha = sc.nextLine();
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (separador.length == 5) {
                    String data = separador[0].trim();
                    String produto = separador[1].trim();
                    int quantidade = Integer.parseInt(separador[2].trim());
                    double valor = Double.parseDouble(separador[3].trim());
                    String cliente = separador[4].trim();

                    vendas.add(new ListaVendas(data, produto,
                            quantidade, valor, cliente));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        return vendas;
    }
}