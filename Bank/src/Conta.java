public class Conta {
    private double saldo;
    private double chequeEspecial;
    private boolean usandoChequeEspecial;

    public Conta(double saldoInicial, double chequeEspecial) {
        this.saldo = saldoInicial;
        this.chequeEspecial = chequeEspecial;
        this.usandoChequeEspecial = false;
    }

    public double getSaldo() {
        return saldo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public boolean isUsandoChequeEspecial() {
        return usandoChequeEspecial;
    }
    
    public void depositar() {
        
    }
}
