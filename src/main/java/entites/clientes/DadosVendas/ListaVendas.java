package entites.clientes.DadosVendas;

public class ListaVendas {

    private String cliente;
    private String data;
    private String produto;
    private int quantidade;
    private double valor;

    public ListaVendas(String data, String produto, int quantidade,
                       double valor, String cliente){
        this.data = data;
        this.produto = produto;
        this.quantidade = quantidade;
        this.valor = valor;
        this.cliente = cliente;
    }

    public ListaVendas() {}

    public String getCliente() {
        return cliente;
    }

    public void setCliente(String cliente) {
        this.cliente = cliente;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }

    public String getProduto() {
        return produto;
    }

    public void setProduto(String produto) {
        this.produto = produto;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public void setQuantidade(int quantidade){
        this.quantidade = quantidade;
    }

    public double getValor() {
        return valor * quantidade;
    }

    public void setValor(double valor) {
        this.valor = valor;
    }
}
