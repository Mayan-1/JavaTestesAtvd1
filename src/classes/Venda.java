package classes;

public class Venda {
    private Produto produto;
    private int quantidadeVenda;
    private double totalVenda;

    public Venda(Produto produto, int quantidadeVenda) {
        this.produto = produto;
        this.quantidadeVenda = quantidadeVenda;
    }

    public  boolean realizarVenda(){
        if (produto.diminiuirEstoque(quantidadeVenda)){
            totalVenda = produto.getPreco() * quantidadeVenda;
            return true;
        }
        return false;
    }

    public Produto getProduto() {
        return produto;
    }

    public int getQuantidadeVenda() {
        return quantidadeVenda;
    }

    public double getTotalVenda() {
        return totalVenda;
    }
}
