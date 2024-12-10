package entites.produtos.dados;

public class ListaProdutos {
    private String nome;
    private double preco;
    private int quantidade;
    private String imagem;

    public ListaProdutos(String nome, double preco,
                         int quantidade, String imagem) {
        this.nome = nome;
        this.preco = preco;
        this.quantidade = quantidade;
        this.imagem = imagem;
    }

    public String getNome() {
        return nome;
    }

    public double getPreco() {
        return preco;
    }

    public int getQuantidade() {
        return quantidade;
    }

    public String getImagem() {
        return imagem;
    }
}
