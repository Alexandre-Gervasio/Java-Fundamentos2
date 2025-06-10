import java.util.Scanner;

public class Menu {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Sistema sistema = new Sistema();

        System.out.print("Digite o valor do depósito inicial: ");
        double depositoInicial = scanner.nextDouble();
        Conta conta = new Conta(depositoInicial);

        int opcao;
        do {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Consultar saldo");
            System.out.println("2. Consultar cheque especial");
            System.out.println("3. Depositar");
            System.out.println("4. Sacar");
            System.out.println("5. Pagar boleto");
            System.out.println("6. Verificar uso do cheque especial");
            System.out.println("0. Sair");
            System.out.print("Escolha uma opção: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    sistema.consultarSaldo(conta);
                    break;
                case 2:
                    sistema.consultarChequeEspecial(conta);
                    break;
                case 3:
                    getDeposito(scanner, sistema, conta);
                    break;
                case 4:
                    getSaque(scanner, sistema, conta);
                    break;
                case 5:
                    getBoleto(scanner, sistema, conta);
                    break;
                case 6:
                    sistema.verificarUsoChequeEspecial(conta);
                    break;
                case 0:
                    System.out.println("Encerrando o sistema...");
                    break;
                default:
                    System.out.println("Opção inválida.");
            }

        } while (opcao != 0);

        scanner.close();
    }

    private static void getBoleto(Scanner scanner, Sistema sistema, Conta conta) {
        System.out.print("Digite o valor do boleto: ");
        double boleto = scanner.nextDouble();
        sistema.pagarBoleto(conta, boleto);
    }

    private static void getSaque(Scanner scanner, Sistema sistema, Conta conta) {
        System.out.print("Digite o valor do saque: ");
        double saque = scanner.nextDouble();
        sistema.sacar(conta, saque);
    }

    private static void getDeposito(Scanner scanner, Sistema sistema, Conta conta) {
        System.out.print("Digite o valor do depósito: ");
        double deposito = scanner.nextDouble();
        sistema.depositar(conta, deposito);
    }
}
