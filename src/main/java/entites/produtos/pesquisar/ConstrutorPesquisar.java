package entites.produtos.pesquisar;

public class ConstrutorPesquisar{

    public String nomeProduto;
    public double preco;
    public int quantidade;
    public String imagem;

    public ConstrutorPesquisar(String nomeProduto, double preco,
                               int quantidade, String imagem){
        this.nomeProduto = nomeProduto;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    public ConstrutorPesquisar(){}

    public String getNomeProduto() {
        return nomeProduto;
    }

    public double getPreco(){
        return preco;
    }

    public int getQuantidade(int quantidade) {
        return quantidade;
    }

    public String getImagem() {
        return imagem;
    }
}
