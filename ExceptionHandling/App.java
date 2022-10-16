import java.util.Scanner;

public class App {
    public static void main(String[] args) throws Exception {
        Scanner entrada = new Scanner(System.in);
        ContaCorrente conta = new ContaCorrente(500.00);
        
        System.out.println("Saldo total: " + conta.getSaldo());

        System.out.print("Valor a depositar: ");
        double valorDep = entrada.nextDouble();
        try{
            conta.deposito(valorDep);
            System.out.println("Novo saldo total: " + conta.getSaldo());
        }
        catch(FooRuntimeException e){
            System.out.println(e.getMessage());
        }

        System.out.print("Valor a retirar: ");
        double valorRet = entrada.nextDouble();
        try{
            conta.retirada(valorRet);
            System.out.println("Novo saldo total: " + conta.getSaldo());
        }
        catch(FooRuntimeException e){
            System.out.println(e.getMessage());
        }

        entrada.close();
    } 
}
