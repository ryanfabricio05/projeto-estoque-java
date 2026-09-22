package cademia.de.codigo;

import java.util.ArrayList;

public class Estoque {
    private ArrayList<Item> listaItens = new ArrayList<>();

    public void adicionarItem(Item item) {
        listaItens.add(item);
    }

    public Item buscarItem(String nome) {
        for (Item item : listaItens) {
            if (item.getNome().equalsIgnoreCase(nome)) {
                return item;
            }
        }
        return null;
    }

    public void listarItens() {
        if (listaItens.isEmpty()) {
            System.out.println("Estoque vazio.");
            return;
        }

        for (Item item : listaItens) {
            System.out.printf("Produto: %s | Quantidade: %d | Preço: R$ %.2f%n",
                    item.getNome(), item.getQuantidade(), item.getPreco());
        }
    }
}
