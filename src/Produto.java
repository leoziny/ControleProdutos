import java.util.ArrayList;

public class Produto {
    private String nomeProduto;
    private double precoProduto;
    private int quantidadesProduto;

    public Produto(String nomeProduto, double precoProduto, int quantidadesProduto) {
        this.nomeProduto = nomeProduto;
        this.precoProduto = precoProduto;
        this.quantidadesProduto = quantidadesProduto;
    }

    public String pegarNome() {
        return nomeProduto;
    }

    public Double pegarPreco() {
        return precoProduto;
    }

    public int pegarQuantidades() {
        return quantidadesProduto;
    }
    public String modificarNome(String novoNome){
        this.nomeProduto = novoNome;
        return  this.nomeProduto;
    }
    public Double modificarPreco(double novoPreco){
        this.precoProduto = novoPreco;
        return this.precoProduto;
    }
    public int modificarQuantidadeProduto(int novaQuantidade){
        this.quantidadesProduto = novaQuantidade;
        return this.quantidadesProduto;
    }

}
