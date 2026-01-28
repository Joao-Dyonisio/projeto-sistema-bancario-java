package model;

import java.util.ArrayList;

public class Conta {

    private int numeroConta;
    private String nomeTitular;
    private double saldo;

    public Conta(int numeroConta, double saldo, String nomeTitular) {
        this.numeroConta = numeroConta;
        this.nomeTitular = nomeTitular;

        if (saldo >= 0) {
            this.saldo = saldo;
        } else {
            this.saldo = 0;
        }

    }

    public int getNumeroConta() {
        return numeroConta;
    }

    public String getNomeTitular() {
        return nomeTitular;
    }

    public double getSaldo() {
        return saldo;
    }

    public void depositar(double valor) {
        if (valor > 0) {
            saldo += valor;
        }
        else {
            System.out.println("Valor inválido para depósito!");
        }
    }

    public void sacar(double valor) {
        if (valor <= 0) {
            System.out.println("Valor inválido para saque!");
        }
        else if (valor > saldo) {
            System.out.println("Saldo Insuficiente!");
        }
        else {
            saldo -= valor;
            System.out.println("Saque realizado com sucesso!");;
        }
    }
}