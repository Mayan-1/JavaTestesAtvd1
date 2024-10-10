package test;

import classes.Venda;
import org.junit.Test;
import classes.Produto;

import static org.junit.Assert.*;

public class AppTest {


    @Test
    public void testeValoresValidos(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        assertEquals("Teclado", produto.getNome());
        assertEquals(100, produto.getPreco(), 0.01);
        assertEquals(10, produto.getEstoque());
    }

    @Test
    public void testePrecoNegativo(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        assertFalse("Preço deve ser positivo", produto.getPreco() < 0);
    }

    @Test
    public void testeEstoqueNegativo(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        assertFalse("Estoque deve ser positivo", produto.getEstoque() < 0);
    }

    @Test
    public void testeNomeAlterado(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        produto.setNome("Monitor LG");
        assertEquals("Monitor LG", produto.getNome());
    }

    @Test
    public void testePrecoValido(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        produto.setPreco(90.0);
        assertEquals(90.0, produto.getPreco(), 0.01);
    }

    @Test
    public void testeEstoquePosisitvo(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        produto.setEstoque(30);
        assertEquals(30, produto.getEstoque());
    }

    @Test
    public void testeVendaComMenorEstoque(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        Venda venda = new Venda(produto, 8);
        assertTrue(venda.realizarVenda());
        assertEquals(2, produto.getEstoque());
    }

    @Test
    public void testeVendaIgualEstoque(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        Venda venda = new Venda(produto, 8);
        assertTrue(venda.realizarVenda());
        assertEquals(2, produto.getEstoque());
    }

    @Test
    public void testeVendaComMaiorEstoque(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        Venda venda = new Venda(produto, 15);
        assertFalse(venda.realizarVenda());
    }

    @Test
    public void calcularValorVenda(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        Venda venda = new Venda(produto, 8);
        venda.realizarVenda();
        assertEquals(800.0, venda.getTotalVenda(), 0.01);
    }

    @Test
    public void testeAumentarEstoquePosVenda(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        produto.aumentarEstoque(5);
        assertEquals(15, produto.getEstoque());
    }

    @Test
    public void testeDiminiuirEstoque(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        Venda venda = new Venda(produto, 8);
        venda.realizarVenda();
        assertEquals(2, produto.getEstoque());
    }

    @Test
    public void testeVendaProdutoInexistente(){
        Produto produto = null;
        Venda venda = new Venda(produto, 1);
        assertThrows(NullPointerException.class, venda::realizarVenda);
    }

    @Test
    public void testecriarVendaQtdNegativa(){
        Produto produto = new Produto("Teclado", 100.0, 10);
        Venda venda = new Venda(produto, 8);
        assertTrue(venda.realizarVenda());
    }

    @Test
    public void testeAlterarEstoqueComQtdInsuficiente(){
        Produto produto = new Produto("Teclado", 100.0, 5);
        Venda venda = new Venda(produto, 8);
        venda.realizarVenda();
        assertEquals(5, produto.getEstoque());
    }

    @Test
    public void testeCriacaoVariorProdutosVendas(){
        Produto produto1 = new Produto("Monitor", 1000.0, 15);
        Produto produto2 = new Produto("Cadeira", 2000.0, 12);
        Venda venda1 = new Venda(produto1, 5);
        Venda venda2 = new Venda(produto2, 5);
        assertTrue(venda1.realizarVenda());
        assertTrue(venda2.realizarVenda());
        assertEquals(10, produto1.getEstoque());
        assertEquals(7, produto2.getEstoque());

    }

    @Test
    public void testeTotalVendaPrecoAlteradoAntesVenda() {
        Produto produto = new Produto("Teclado", 70.0, 10);
        produto.setPreco(100.0);
        Venda venda = new Venda(produto, 3);
        venda.realizarVenda();
        assertEquals(300.0, venda.getTotalVenda(), 0.01);
    }

    @Test
    public void testeVendaEstoqueInicialZero() {
        Produto produto = new Produto("Teclado", 70.0, 0);
        Venda venda = new Venda(produto, 1);
        assertFalse(venda.realizarVenda());
    }

    @Test
    public void testAumentoEstoque() {
        Produto produto = new Produto("Teclado", 100.0, 0);
        produto.aumentarEstoque(5);
        Venda venda = new Venda(produto, 3);
        assertTrue(venda.realizarVenda());
        assertEquals(2, produto.getEstoque());
    }
}
