package cademia.de.codigo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Estoque estoque = new Estoque();
        Venda venda = new Venda();

        int opcao;

        do {
            System.out.println("\n===== SISTEMA DE ESTOQUE =====");
            System.out.println("1 - Colocar produto no estoque");
            System.out.println("2 - Listar estoque");
            System.out.println("3 - Comprar produto");
            System.out.println("4 - Procurar produto");
            System.out.println("0 - Sair");
            System.out.print("Escolha: ");
            opcao = scanner.nextInt();
            scanner.nextLine();

            switch (opcao) {
                case 1:
                    System.out.print("Nome do produto: ");
                    String nome = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidade = scanner.nextInt();

                    System.out.print("Preço: ");
                    double preco = scanner.nextDouble();
                    scanner.nextLine();

                    estoque.adicionarItem(new Item(nome, quantidade, preco));
                    System.out.println("Produto colocado no estoque.");
                    break;

                case 2:
                    estoque.listarItens();
                    break;

                case 3:
                    System.out.print("Nome do produto que deseja comprar: ");
                    String produto = scanner.nextLine();

                    System.out.print("Quantidade: ");
                    int quantidadeCompra = scanner.nextInt();
                    scanner.nextLine();

                    venda.realizarVenda(estoque, produto, quantidadeCompra);
                    break;

                case 4:
                    System.out.print("Nome do produto: ");
                    String nomeBusca = scanner.nextLine();
                    Item item = estoque.buscarItem(nomeBusca);

                    if (item != null) {
                        System.out.printf("Produto: %s | Quantidade: %d | Preço: R$ %.2f%n",
                                item.getNome(), item.getQuantidade(), item.getPreco());
                    } else {
                        System.out.println("Produto não encontrado.");
                    }
                    break;

                case 0:
                    System.out.println("Programa encerrado.");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 0);

        scanner.close();
    }
}
