package entites.clientes.consultar_venda;

import java.io.BufferedReader;
import java.io.FileReader;

public class vendas {

    static String cliente;
    static String produto;
    static String data;
    public vendas(String cliente) {
        this.cliente = cliente;
        this.produto = produto;
        this.data = data;
    }

    @Override
    public String toString() {
        String arquivo = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\datas_vendas.txt";

        StringBuilder resultado = new StringBuilder();

        try(BufferedReader br = new BufferedReader(new FileReader(arquivo)) ){
            String linha = "";
            boolean encontrado = false;

            while ((linha = br.readLine()) != null) {
                String delimitador = linha.contains(";") ? ";" : ",";
                String[] separador = linha.split(delimitador);

                if (cliente != null) {
                    if (separador.length == 5 && separador[0].trim().toLowerCase().
                            contains(cliente.toLowerCase())) {

                        encontrado = true;
                        cliente = separador[0].trim();
                        data = separador[1].trim();
                        produto = separador[2].trim();
                        String quantidade = separador[3].trim();
                        String valor = separador[4].trim();

                        System.out.println("Cliente: " + cliente);
                        System.out.println("Data: " + data);
                        System.out.println("Produto: " + produto);
                        System.out.println("Quantidade de vendas: " + quantidade);
                        System.out.println("Valor da AdicionarVenda: " + valor  + "\n");
                        System.out.println(" ");
                    }
                }
            }
            if (!encontrado) {
                System.out.print(cliente+" não foi encontrado no Banco de Dados.");
            }

        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        return"";
    }
}
