import java.util.ArrayList;
import java.util.Scanner;

public class App {
    static ArrayList<Produto> produtos = new ArrayList<Produto>();
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        int opcao = 0;
        while (opcao != 3) {
            menuPrincipal();
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    cadastrarProduto();
                    listarProdutos();
                    break;
                case 2:
                    listarProdutos();
                    break;
                case 3:
                    System.out.println("Saindo...");
                    scanner.close();
                    break;
                default:
                    System.out.println("Opcao invalida");
            }
        }
    }

    public static void cadastrarProduto() {
        System.out.println("\n----- Cadastro de Produto -----");
        System.out.println("Digite o nome do produto: ");
        scanner.nextLine();
        String nome = scanner.nextLine();

        System.out.println("Digite o preco do produto: ");
        double preco = scanner.nextDouble();

        System.out.println("Digite a descricao do produto: ");
        scanner.nextLine();
        String descricao = scanner.nextLine();

        System.out.println("O produto esta disponivel? (s/n) ");
        char op = scanner.next().charAt(0);

        boolean disponivel;

        if (op == 's') {
            disponivel = true;
        } else {
            disponivel = false;
        }

        Produto produto = new Produto(nome, descricao, preco, disponivel);
        produtos.add(produto);
        System.out.println("\nProduto cadastrado com sucesso!\n");
    }

    public static void listarProdutos() {
        menuListarProdutos();
        boolean apenasDisponiveis = false;
        int opcao = scanner.nextInt();

        switch (opcao) {
            case 1:
                produtos.sort((p1, p2) -> p1.getNome().compareTo(p2.getNome()));
                break;
            case 2:
                produtos.sort((p1, p2) -> Double.compare(p1.getPreco(), p2.getPreco()));
                break;
            case 3:
                apenasDisponiveis = true;
                break;
            default:
                System.out.println("Opcao invalida");
        }

        System.out.println("\n----- Lista de Produtos -----");
        for (Produto produto : produtos) {

            if (apenasDisponiveis && !produto.isDisponivel()) {
                continue;
            }

            System.out.println();
            System.out.println("Nome: " + produto.getNome());
            System.out.println("Descricao: " + produto.getDescricao());
            System.out.println("Preco: " + produto.getPreco());
            System.out.println();
        }
        System.out.println("--------------------------");

        System.out.println();
        System.out.println("Deseja Cadastar outro produto? (s/n)");
        String resposta = scanner.next();
        if (resposta.equals("s")) {
            cadastrarProduto();
            listarProdutos();
        } else {
            System.out.println();
        }
    }

    public static void menuPrincipal() {
        System.out.println("----- Menu Principal -----");
        System.out.println("1 - Cadastrar produto");
        System.out.println("2 - Listar produtos");
        System.out.println("3 - Sair");
        System.out.println("--------------------------");
        System.out.print("Digite uma opcao: ");
    }

    public static void menuListarProdutos() {
        System.out.println("--------------------------");
        System.out.println("1 - Listar por ordem alfabetica");
        System.out.println("2 - Listar por preco");
        System.out.println("3 - Listar apenas disponiveis");
        System.out.println("--------------------------");
        System.out.print("Digite uma opcao: ");
    }
}
