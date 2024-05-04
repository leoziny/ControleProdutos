import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class Controle {
    public static void main(String[] args) throws InputMismatchException {
        ArrayList<Produto> listaProdutos = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        boolean continuar = true;
        try{
            while (continuar) {
                System.out.println("O que deseja fazer?");
                System.out.println("[1] Adicionar produto");
                System.out.println("[2] Listar produtos adicionados");
                System.out.println("[3] Remover um produto");
                System.out.println("[4] Modificar um produto");
                System.out.println("[0] Sair");
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1: {
                        adicionarProduto(listaProdutos, sc);
                        sc.nextLine();
                        break;
                    }
                    case 2: {
                        listarProdutos(listaProdutos);
                        sc.nextLine();
                        break;
                    }
                    case 3: {
                        apagarProduto(listaProdutos, sc);
                        sc.nextLine();

                        break;
                    }
                    case 4: {
                        modificarProduto(listaProdutos, sc);
                        sc.nextLine();
                        break;
                    }
                    case 0:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                }
            }
            System.out.println("Programa encerrado.");
            sc.close();
        }catch (InputMismatchException ex){
            System.out.println("Digite um numero inteiro válido, nada de caracteres ou digitos especiais.");

        }
    }

    public static void adicionarProduto(ArrayList<Produto> listaProdutos, Scanner sc) throws InputMismatchException {
        try {
            while (true) {
                System.out.print("Digite o nome do produto: ");
                String nomeProduto = sc.next();

                System.out.print("Digite o preço do produto: ");
                double precoProduto = sc.nextDouble();

                System.out.print("Digite a quantidade de produtos: ");
                int quantidadesProduto = sc.nextInt();

                listaProdutos.add(new Produto(nomeProduto, precoProduto, quantidadesProduto));
                System.out.print("Quer continuar registrando? [S/s para continuar, N/n para sair] ");
                String respostaUsuario = sc.next().toLowerCase();
                if (respostaUsuario.equals("n")) {
                    break;
                }
            }
        }catch (InputMismatchException ex){
            System.out.println("Só pode digitar numeros nos preços e quantidades, nas quantidades é apenas numeros inteiros.");
        }catch (NoSuchElementException ex){
            System.out.println("Estavamos esperando dados de entrada, não aceitamos atalhos.");
        }
    }

    public static void listarProdutos(ArrayList<Produto> listaProdutos) throws InputMismatchException{
        Verificadores verificador = new Verificadores();
        if(!verificador.existeItem(listaProdutos)){
            System.out.println("Não existe produtos registrados.");
        }
        else {
        for (Produto produto : listaProdutos) {
            System.out.println("Nome: " + produto.pegarNome() + ", Preço: R$" + produto.pegarPreco() + ", Quantidade: " + produto.pegarQuantidades());
        }
        }
    }

    public static void apagarProduto(ArrayList<Produto> listaProdutos, Scanner sc) throws InputMismatchException{
        int indexProduto = 1;
        Verificadores verificador = new Verificadores();
        if(!verificador.existeItem(listaProdutos)){
            System.out.println("Não existe produtos registrados.");
        }else{

        try{

        for (Produto produto : listaProdutos) {
            System.out.println("Nome: " + produto.pegarNome() + " Está na posição " + indexProduto);
            indexProduto += 1;
        }
        System.out.println("Digite a posição que o produto será apagado.");
        int escolhaIndexProduto = sc.nextInt();
        if(escolhaIndexProduto > indexProduto - 1 || escolhaIndexProduto <= 0){
            System.out.println("Digite uma posição existente.");
        }
        else {
        listaProdutos.remove(escolhaIndexProduto -1);
        }

    }catch (InputMismatchException ex){
        System.out.println("Digite um numero inteiro.");
    }catch (NoSuchElementException ex){
        System.out.println("Estavamos esperando dados de entrada, não aceitamos atalhos.");
        }
    }



    }
    public static void modificarProduto(ArrayList<Produto> listaProdutos, Scanner sc) throws InputMismatchException{
        Verificadores verificador = new Verificadores();
        if(!verificador.existeItem(listaProdutos)){
            System.out.println("Não existe produtos registrados.");
        }
        else {


        try {
            int escolhaIndexProduto;
            int indexProduto = 1;
            boolean continuar = true;
            System.out.println("Qual desses produtos deseja alterar?");
            for (Produto produto : listaProdutos) {
                System.out.println("Nome: " + produto.pegarNome() + " Está na posição " + indexProduto);
                indexProduto += 1;
            }
            System.out.println("Escolha a posição do item que deseja modificar");

            while (true) {
                escolhaIndexProduto = sc.nextInt() - 1;
                if (escolhaIndexProduto >= 0 && escolhaIndexProduto < indexProduto) {
                    break;
                } else {
                    System.out.println("Escolha um índice válido entre 1 e " + indexProduto + ":");
                }
            }
            while (continuar) {
                System.out.println("O que deseja modificar desse item?");
                System.out.println("[1] Nome");
                System.out.println("[2] Preços");
                System.out.println("[3] Quantidade");
                System.out.println("[0] Sair da edição");
                int opcao = sc.nextInt();

                switch (opcao) {
                    case 1: {
                        Produto produto = listaProdutos.get(escolhaIndexProduto);
                        System.out.print("Digite o novo nome do produto: ");
                        String nomeProduto = sc.next();
                        produto.modificarNome(nomeProduto);
                        System.out.print("Nome alterado para " + produto.pegarNome());
                        break;

                    }
                    case 2: {
                        Produto produto = listaProdutos.get(escolhaIndexProduto);
                        System.out.print("Digite o novo preço do produto: ");
                        double precoProduto = sc.nextDouble();
                        produto.modificarPreco(precoProduto);
                        System.out.print("preço alterado para " + produto.pegarPreco());
                        break;
                    }
                    case 3: {
                        Produto produto = listaProdutos.get(escolhaIndexProduto);
                        System.out.print("Digite a nova quantidade do produto: ");
                        int quantidadeProduto = sc.nextInt();
                        produto.modificarQuantidadeProduto(quantidadeProduto);
                        System.out.print("quantidade alterado para " + produto.pegarPreco());
                        break;
                    }
                    case 0:
                        continuar = false;
                        break;

                }
            }

        } catch (InputMismatchException ex) {
            System.out.println("Apenas numeros inteiros são aceitos.");
        }catch (NoSuchElementException ex){
            System.out.println("Estavamos esperando dados de entrada, não aceitamos atalhos.");
        }



    }


        }
}
