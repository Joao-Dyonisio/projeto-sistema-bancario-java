package main;

import model.Conta;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        ArrayList<Conta> contas = new ArrayList<>();

        int opcao = 0;

        do {
            opcao = mostrarMenu(sc);

            switch (opcao) {
                case 1:
                    System.out.println("Digite o número da conta: ");
                    int numeroConta = sc.nextInt();

                    if (numeroConta <= 0) {
                        System.out.println("Não existe conta com número ZERO!");
                        break;
                    }
                    if (buscarConta(contas, numeroConta) != null) {
                        System.out.println("Já existe uma conta com esse número");
                        break;
                    }
                    sc.nextLine();

                    System.out.println("Digite o titular da conta: ");
                    String titular = sc.nextLine();

                    if (titular.isEmpty()) {
                        System.out.println("ERRO ao digitar o nome!");
                        break;
                    }

                    System.out.println("Digite o saldo inicial: ");
                    double saldoInicial = sc.nextDouble();

                    if (saldoInicial < 0) {
                        System.out.println("ERRO, nenhuma conta é menor que zero!");
                        break;
                    }

                    Conta novaConta = new Conta(numeroConta,saldoInicial, titular);
                    contas.add(novaConta);

                    System.out.println("Conta criada com sucesso!");
                    System.out.println("Total de contas: " + contas.size());
                    break;
                case 2:
                    System.out.println("Digite o número da conta: ");
                    int numero = sc.nextInt();

                    Conta conta = buscarConta(contas, numero);

                    if (conta == null) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }

                    System.out.println("Digite o valor para depositar: ");
                    double valor = sc.nextDouble();

                    if (valor <= 0) {
                        System.out.println("Valor inválido para depósito!");
                        break;
                    }

                    conta.depositar(valor);
                    System.out.println("Depósito realizado com sucesso!");
                    break;
                case 3:
                    System.out.println("Digite o número da conta: ");
                    numero = sc.nextInt();

                    conta = buscarConta(contas,numero);

                    if (conta == null ) {
                        System.out.println("Conta não encontrada!");
                        break;
                    }

                    System.out.println("Digite o valor para sacar: ");
                    valor = sc.nextDouble();

                    if (valor <= 0) {
                        System.out.println("Valor inválido para saque!");
                        break;
                    } else if (valor > conta.getSaldo()) {
                        System.out.println("Saldo insuficiente!");
                        break;
                    }

                    conta.sacar(valor);
                    System.out.println("Saque realizado com sucesso!");
                    break;
                case 4:
                    System.out.println("Digite o número da conta: ");
                    numero = sc.nextInt();

                    conta = buscarConta(contas,numero);

                    if (conta == null ) {
                        System.out.println("Conta não encontrada!");
                    }
                    else {
                        System.out.println("Saldo atual: R$ " + conta.getSaldo());
                    }
                    break;
                case 5:
                    System.out.println("Transferência entre contas");
                    System.out.println("Digite o número da conta ORIGEM: ");
                    int origemNumero = sc.nextInt();

                    Conta contaOrigem = buscarConta(contas, origemNumero);

                    if (contaOrigem == null) {
                        System.out.println("Conta origem não encontrada!");
                        break;
                    }

                    System.out.println("Digite o número da conta DESTINO: ");
                    int destinoNumero = sc.nextInt();

                    Conta contaDestino = buscarConta(contas, destinoNumero);

                    if (contaDestino == null) {
                        System.out.println("Conta destino não encontrada!");
                        break;
                    }
                    System.out.println("Digite o valor da transferência: ");
                    double valorTransferencia = sc.nextDouble();


                    if (valorTransferencia <= 0) {
                        System.out.println("Valor inválido!");
                        break;
                    }

                    if (valorTransferencia > contaOrigem.getSaldo()) {
                        System.out.println("Saldo insuficiente");
                        break;
                    }

                    contaOrigem.sacar(valorTransferencia);
                    contaDestino.depositar(valorTransferencia);

                    System.out.println("Transferência realizada com sucesso!");
                    break;
                case 0:
                    System.out.println("Saindo do sistema...");
                    break;
            }
        } while (opcao != 0);
        sc.close();
    }

    public static Conta buscarConta(ArrayList<Conta> contas, int numero) {
        for (Conta c : contas) {
            if(c.getNumeroConta() == numero) {
                return c;
            }
        }
        return null;
    }

    public static int mostrarMenu(Scanner sc) {

        System.out.println("\n=== MENU BANCÁRIO ===");
        System.out.println("1 - Criar conta");
        System.out.println("2 - Depositar");
        System.out.println("3 - Sacar");
        System.out.println("4 - Ver saldo");
        System.out.println("5 - Transferir");
        System.out.println("0 - Sair");
        System.out.print("Escolha uma opção: ");

        return sc.nextInt();
    }
}