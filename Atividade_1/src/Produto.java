public class Produto {


    // Criado a Classe Produto para utilizar os métodos get na classe função e os construtores na classe Man

    private Integer id;
    private String nome;
    private String descricao;
    private Double quantidade;
    private Double preco;

    public Produto(String nome, String descricao, Double quantidade, Double preco) {
        super();
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Produto(Integer id, String nome, String descricao, Double quantidade, Double preco) {
        this.id = id;
        this.nome = nome;
        this.descricao = descricao;
        this.quantidade = quantidade;
        this.preco = preco;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public String getDescricao() {
        return descricao;
    }

    public Double getQuantidade() {
        return quantidade;
    }

    public Double getPreco() {
        return preco;
    }
}
