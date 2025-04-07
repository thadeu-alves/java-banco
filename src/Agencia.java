import java.util.Scanner;
import java.util.ArrayList;


public class Agencia{
    int id;
    String endereco;
    ArrayList<Conta> contas;
    Scanner scString = new Scanner(System.in);
    Scanner scNum = new Scanner(System.in);
    
    public Agencia(){
        this.id = 0;
        this.endereco = "";
        this.contas = new ArrayList<Conta>();
    }
    public Agencia(ArrayList<Conta> conta,int id, String endereco){
        this.id = id;
        this.endereco = endereco;
        this.contas = conta;
    }
    public Agencia(int id, String endereco){
        this.id = id;
        this.endereco = endereco;
        this.contas = new ArrayList<Conta>();
    }
    

    public void adicionarConta(){
        String titulo;
        int numero;
        double valorInicial;
        int senha;
        System.out.print("insira seu titulo: ");
        titulo = this.scString.nextLine();
        System.out.print("insira seu numero: ");
        numero = this.scNum.nextInt();
        System.out.print("insira a senha: ");
        senha = this.scNum.nextInt();
        System.out.print("insira o valorInicial: ");
        valorInicial = this.scNum.nextDouble();
        adicionarConta( titulo, numero, valorInicial, senha);
        
    }

    public void adicionarConta(String titulo,int numero, double valorInicial, int senha){
        if(titulo != null && !titulo.equals("") && numero>0 && valorInicial>=0){
            Conta conta = new Conta(titulo,numero,valorInicial,senha);
            this.contas.add(conta);
            System.out.println("Conta criada com sucesso.");
        }
        else{
            System.out.println("Conta não criada. Algum dos dados está inválido.");
        }
        
    }

    public  Conta buscarConta(int numero){
        if(this.contas.size()>0){
            boolean achouConta = false;
            int senhaAtual;
            int i = 0;
            do{
                Conta contaAtual = contas.get(i);

                if(contaAtual.numero == numero){
                    System.out.print("insira a senha: ");
                    senhaAtual = this.scNum.nextInt();
                    int j = 0;
                    while(senhaAtual!=contaAtual.senha && j<3){
                        System.out.printf("senha incorreta (%d/3)\n",j);
                        System.out.println("insira a senha novamente: ");
                        senhaAtual = this.scNum.nextInt();
                        if(senhaAtual!=contaAtual.senha){
                            j++;
                        }
                        
                    };
                    if (senhaAtual == contaAtual.senha && j<3){
                        System.out.println("Conta encontrada");
                        return contas.get(i);
                    }
                    else{
                        System.out.println("Conta bloqueada");
                        return null;
                    }
                }
                else{
                    i++;
                }
           }while(i<this.contas.size() && !achouConta);
           System.out.println("Conta não encontrada");
           return null;
        }
            
        System.out.println("Agencia vazia.");
        return null;
        
    }
    public void operacaoNaConta(int numero, int operacao, int valor){
        if(numero !=0 && (operacao == 0 || operacao == 1) && valor>0){
            Conta conta = buscarConta(numero);
            if(conta != null){
                switch (operacao) {
                    case 0:conta.depositar(valor);break;
                    case 1:conta.sacar(valor);break;
                    default:break;
                }
            }
        }
        else{
            System.out.println("Algum dos dados está inválido.");
        }
    }
}

