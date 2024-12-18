package entites.clientes.adiconar_venda;

import javafx.scene.control.TextField;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class AdicionarVenda {

    static String cliente;
    static String nomeproduto;
    static String data_venda;
    static int quantidade;
    static double valor;

    public AdicionarVenda(TextField cliente, TextField dataVenda,
                          TextField quantidade, double valor, String nomeProduto){

        this.cliente = cliente.getText();
        this.nomeproduto = cliente.getText();
        this.data_venda = dataVenda.getText();
        this.quantidade = Integer.parseInt(quantidade.getText());
        this.valor = valor;
        this.nomeproduto = nomeProduto;
    }

    @Override
    public String toString(){

        String vendas = "C:\\Users\\matheus.fgs\\Desktop\\" +
                "Gerenciador_Java\\Banco_De_Dados\\datas_vendas.txt";

        try(BufferedWriter br = new BufferedWriter
                (new FileWriter(vendas, true))) {

            for (String escrever : cliente.split("\n")){
                br.newLine();
                br.newLine();
                br.write(data_venda+";");
                br.write(nomeproduto+";");
                br.write(quantidade+";");
                valor = valor * quantidade;
                br.write(valor+";");
                br.write(cliente+";");
            }
        }catch (IOException e){
            System.out.println("Erro: " + e.getMessage());
        }
        return"Data: "+data_venda+"\n\n"
                + "Produto: "+nomeproduto+"\n\n"
                + "Quantidade: "+quantidade+"\n\n"
                + "Valor: "+valor+"\n\n"
                + "Cliente: "+cliente+"\n\n";
    }
}
