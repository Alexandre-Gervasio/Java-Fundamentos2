public class Sistema {

    public void consultarSaldo(Conta conta) {
        System.out.println("Saldo atual: R$" + conta.getSaldo());
    }

    public void consultarChequeEspecial(Conta conta) {
        System.out.println("Limite do cheque especial: R$" + conta.getLimiteChequeEspecial());
    }

    public void depositar(Conta conta, double valor) {
        conta.depositar(valor);
    }

    public void sacar(Conta conta, double valor) {
        conta.sacar(valor);
    }

    public void pagarBoleto(Conta conta, double valor) {
        conta.pagarBoleto(valor);
    }

    public void verificarUsoChequeEspecial(Conta conta) {
        if (conta.estaUsandoChequeEspecial()) {
            System.out.println("A conta está usando o cheque especial.");
            System.out.println("Valor utilizado: R$" + conta.getValorUsadoChequeEspecial());
        } else {
            System.out.println("A conta NÃO está usando o cheque especial.");
        }
    }

}
