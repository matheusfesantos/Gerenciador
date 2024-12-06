package entites.clientes.adiconar_venda;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarVenda {

    static String cliente;
    static String nomeproduto;
    static String data_venda;
    static int quantidade;
    static double valor;
    public AdicionarVenda(String cliente, String nomeproduto, String data,
                          int quantidade, double valor){
        this.cliente = cliente;
        this.nomeproduto = nomeproduto;
        this.data_venda = data;
        this.quantidade = quantidade;
        this.valor = valor * quantidade;
    }
    @Override
    public String toString(){

        String vendas = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_de_Estoque\\Banco_de_Dados\\datas_vendas.txt";

        try(BufferedWriter br = new BufferedWriter
                (new FileWriter(vendas, true))) {

            for (String escrever : cliente.split("\n")){
                br.newLine();
                br.newLine();
                br.write(data_venda+";");
                br.write(nomeproduto+";");
                br.write(quantidade+";");
                br.write(valor+";");
                br.write(cliente+";");
            }
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return"";
    }
}
