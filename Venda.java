package cademia.de.codigo;

public class Venda {

    public void realizarVenda(Estoque estoque, String nomeProduto, int quantidade) {
        Item item = estoque.buscarItem(nomeProduto);

        if (item == null) {
            System.out.println("Produto não encontrado.");
            return;
        }

        if (item.diminuirEstoque(quantidade)) {
            double total = item.getPreco() * quantidade;
            System.out.printf("Compra realizada. Total: R$ %.2f%n", total);
        } else {
            System.out.println("Quantidade insuficiente no estoque.");
        }
    }
}
