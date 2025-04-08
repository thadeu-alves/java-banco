import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Agencia ag = new Agencia();
        ag.adicionarConta("Thadeu", 244, 100, 1234);
        Scanner scNum = new Scanner(System.in);

        int op = -1;
        while (op!=0){
            System.out.println("[1] - Crie uma conta  \n[2] - Acesse uma conta \n[0] - Sair");
            op = scNum.nextInt();

            switch (op){
                case 1: ag.adicionarConta(); break;
                case 2:ag.acessoConta();break;
                default: System.out.println("Sem essa opção");
            }
        }
    }
      
}