import java.util.Scanner;
import static java.lang.System.exit;

public class Principal {

    static Scanner scanner = new Scanner(System.in);
    static int quantidadeProdutos = 0;
    static Produto[] produtos = new Produto[2];

    public static void main(String[] args) {

        chamarMenu();

    }

    private static void chamarMenu() {

        System.out.println("\nO que você deseja fazer?");

        System.out.println("(1) criar uma loja");
        System.out.println("(2) criar um produto");
        System.out.println("(3) sair");

        String resposta = scanner.nextLine();

        switch (resposta) {
            case "1":
                criarLoja();
                break;

            case "2":
                criarProduto();
                break;

            case "3":
                sair();
                break;

            default:
                System.out.println("Opção inválida. Escolha uma opção: ");
                chamarMenu();
        }
    }

    private static void criarLoja() {

        System.out.println("Digite o nome da loja: \n");
        String nome = scanner.nextLine();

        System.out.println("Digite a quantidade de funcionários: \n");
        int quantidadeFuncionarios = Integer.parseInt(scanner.nextLine());

        System.out.println("Digite o salário base para os funcionários: \n");
        double salarioBaseFuncionario = Double.parseDouble(scanner.nextLine());

        System.out.println("Para o endereço da loja, digite o nome da rua: \n");
        String nomeDaRua = scanner.nextLine();
        System.out.println("Para o endereço da loja, digite a cidade: \n");
        String cidade = scanner.nextLine();
        System.out.println("Para o endereço da loja, digite o estado: \n");
        String estado = scanner.nextLine();
        System.out.println("Para o endereço da loja, digite o país: \n");
        String pais = scanner.nextLine();
        System.out.println("Para o endereço da loja, digite o cep: \n");
        String cep = scanner.nextLine();
        System.out.println("Para o endereço da loja, digite o número: \n");
        String numero = scanner.nextLine();
        System.out.println("Para o endereço da loja, digite o complemento: \n");
        String complemento = scanner.nextLine();

        Endereco endereco = new Endereco(nomeDaRua, cidade, estado, pais, cep, numero, complemento);

        System.out.println("Para a data de fundação, digite o dia: \n");
        int dia = Integer.parseInt(scanner.nextLine());
        System.out.println("Para a data de fundação, digite o mês: \n");
        int mes = Integer.parseInt(scanner.nextLine());
        System.out.println("Para a data de fundação, digite o ano: \n");
        int ano = Integer.parseInt(scanner.nextLine());

        Data dataFundacao = new Data(dia, mes, ano);

        System.out.println("Digite quantos produtos há em estoque: \n");
        int estoqueProdutos = Integer.parseInt(scanner.nextLine());

        Loja loja = new Loja(nome, quantidadeFuncionarios, salarioBaseFuncionario, endereco, dataFundacao, estoqueProdutos);

        System.out.println("Você criou a seguinte loja:\n" + loja.toString());

        chamarMenu();
    }

    private static void criarProduto() {

        System.out.println("Digite o nome do produto: \n");
        String nome = scanner.nextLine();

        System.out.println("Digite o preço do produto: \n");
        double preco = Double.parseDouble(scanner.nextLine());

        System.out.println("Para a data de validade do produto, digite primeiro o dia: \n");
        int dia = Integer.parseInt(scanner.nextLine());
        System.out.println("Para a data de validade do produto, digite agora o mês: \n");
        int mes = Integer.parseInt(scanner.nextLine());
        System.out.println("Para a data de validade do produto, digite agora o ano: \n");
        int ano = Integer.parseInt(scanner.nextLine());

        Data dataValidade = new Data(dia, mes, ano);

        Produto produto = new Produto(nome, preco, dataValidade);

        System.out.println("Você criou o seguinte produto:\n" + produto.toString());

        if (produtos.length < 2) {
            produtos[quantidadeProdutos] = produto;
            quantidadeProdutos++;
        }

        if (produtos.length == 2) verificarProdutos();

        chamarMenu();
    }

    private static void verificarProdutos() {

        for (Produto produto : produtos) {
            if (produto.estaVencido(produto.getDataValidade())) {
                System.out.println(produto + " VENCIDO");
            } else {
                System.out.println(produto + " NÃO VENCIDO");
            }
        }
    }

    private static void sair() {
        System.out.println("Saindo da aplicação.");
        exit(0);
    }
}

