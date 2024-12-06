package entites.clientes.DadosVendas;

import java.io.File;
import java.util.Scanner;

public class DadosVendas {
    @Override
    public String toString() {
        File arquivo = new File("C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\datas_vendas.txt");

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

                if (separador.length == 5) {
                    String data = separador[0].trim();
                    String produto = separador[1].trim();
                    String quantidade = separador[2].trim();
                    String valor = separador[3].trim();
                    String cliente = separador[4].trim();

                    System.out.println("Data: " + data);
                    System.out.println("Produto: " + produto + "("+quantidade+")");
                    System.out.println("Valor da AdicionarVenda: "+ valor);
                    System.out.print("Cliente: "+ cliente + "\n");
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
        return"";
    }
}
