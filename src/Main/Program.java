package Main;

import entities.CartaoDeCredito;
import entities.Compra;

import java.util.Scanner;

public class Program {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Insira o limite da conta: ");
        Double limite = sc.nextDouble();
        CartaoDeCredito cartao = new CartaoDeCredito(limite);

        System.out.println("Insira 1 para continuar ou 0 para sair: ");
        int op = sc.nextInt();

        while(op != 0) {
            System.out.println("Digite a descrição da compra: ");
            sc.nextLine();
            String descricao = sc.nextLine();

            System.out.println("Digite o valor da compra: ");
            Double valor = sc.nextDouble();

            Compra compra = new Compra(descricao, valor);

            boolean compraRealizada = cartao.lancaCompra(compra);

            if(compraRealizada) {
                System.out.println("Insira 1 para continuar ou 0 para sair: ");
                op = sc.nextInt();
            } else {
                System.out.println("Saldo insuficiente");
                System.out.println("Insira 1 para continuar ou 0 para sair: ");
                op = sc.nextInt();
            }
        }

        for(Compra c: cartao.getCompras()) {
            System.out.println(c);
        }

        System.out.printf("Saldo atual: (%.2f) ", cartao.getSaldo());
    }
}
