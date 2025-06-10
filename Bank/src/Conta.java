public class Conta {
    private double saldo;
    private double limiteChequeEspecial;
    private double valorUsadoChequeEspecial;

    public Conta(double depositoInicial) {
        this.saldo = depositoInicial;
        if (depositoInicial <= 500) {
            this.limiteChequeEspecial = 50.0;
        } else {
            this.limiteChequeEspecial = depositoInicial * 0.5;
        }
        this.valorUsadoChequeEspecial = 0.0;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getLimiteChequeEspecial() {
        return limiteChequeEspecial;
    }

    public double getValorUsadoChequeEspecial() {
        return valorUsadoChequeEspecial;
    }


    public boolean estaUsandoChequeEspecial() {
        return valorUsadoChequeEspecial > 0;
    }

    public void depositar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de depósito inválido.");
            return;
        }

        // Se estiver usando cheque especial
        if (valorUsadoChequeEspecial > 0) {
            // Calcula a taxa
            double taxa = valorUsadoChequeEspecial * 0.2;
            double totalParaQuitar = valorUsadoChequeEspecial + taxa;

            if (valor >= totalParaQuitar) {
                valor -= totalParaQuitar;
                System.out.printf("Foi cobrada uma taxa de R$%.2f pelo uso do cheque especial.%n", taxa);
                valorUsadoChequeEspecial = 0;
            } else {
                // Parcialmente quita o cheque especial (sem aplicar taxa ainda)
                System.out.println("Depósito insuficiente para quitar o uso do cheque especial com a taxa. Nenhuma taxa aplicada.");
                valorUsadoChequeEspecial -= valor;
                if (valorUsadoChequeEspecial < 0) valorUsadoChequeEspecial = 0;
                return;
            }
        }

        // Agora deposita o restante normalmente
        saldo += valor;
        System.out.printf("Depósito realizado com sucesso. Novo saldo: R$%.2f%n", saldo);
    }


    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor de saque inválido.");
            return;
        }

        double totalDisponivel = saldo + limiteChequeEspecial - valorUsadoChequeEspecial;

        if (valor <= saldo) {
            saldo -= valor;
            System.out.println("Saque realizado. Saldo atual: R$" + saldo);
        } else if (valor <= totalDisponivel) {
            double valorCheque = valor - saldo;
            saldo = 0;
            valorUsadoChequeEspecial += valorCheque;
            System.out.println("Saque realizado utilizando cheque especial. Valor usado: R$" + valorCheque);
        } else {
            System.out.println("Saque não autorizado. Saldo + cheque especial insuficiente.");
        }
    }

    public void pagarBoleto(double valor) {
        sacar(valor);
    }
}
