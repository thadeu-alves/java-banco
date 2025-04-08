public class Conta {
    int numero;
    String titular;
    double saldo;
    int senha;

    public Conta(String titular, int numero, double saldo, int senha) {
        this.numero = numero;
        this.titular = titular;
        this.saldo = saldo;
        this.senha = senha;
    }

    public void depositar(double valor) {

        System.out.println("Saldo atual: "+ saldo + " R$ ");
        saldo += valor;
        System.out.println("Saldo atualizado: " + saldo);
    }

    public void sacar(double valor) {

        if(saldo > 0) {
            if(saldo >= valor) {
                System.out.println("Conta de " + titular + ", sacando dinheiro.");
                System.out.println("Saldo atual: " + saldo);
                saldo -= valor;
                System.out.println("Saldo atualizado: " + saldo);
            }else {
                System.out.println("Conta de " + titular + ", conta sem dinheiro para saque. ");
            }
        }else {
            System.out.println("Conta de " + titular + ", conta sem dinheiro para saque. ");
        }

    }


    public void consultarSaldo() {
        System.out.println("Saldo disponivel: " + saldo);
    }

    public String toString() {
        return "Nome do titular: " + titular + ", Numero de indentificação: " + numero;
    }


}
