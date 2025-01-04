public class Produto {
    private String nome;
    private String descricao;
    private double preco;
    private boolean disponivel;

    public Produto(String nome, String descricao, double preco, boolean disponivel) {
        this.nome = nome;
        this.descricao = descricao;
        this.preco = preco;
        this.disponivel = disponivel;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public double getPreco() {
        return preco;
    }

    public boolean isDisponivel() {
        return disponivel;
    }
}
