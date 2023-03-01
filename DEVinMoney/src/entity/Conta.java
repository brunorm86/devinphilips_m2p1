package entity;

import enums.Agencia;
import enums.TipoConta;
import service.ValidadorCPF;

public abstract class Conta {

    protected static int baseConta = 1;

    protected String nome;

    protected String cpf;

    protected double rendaMensal;

    protected int numConta;

    protected TipoConta tipo;

    protected Agencia agencia;

    protected double saldo;

    protected boolean negativa;

    public Conta(String nome, String cpf, double rendaMensal, Agencia agencia) {

        if (ValidadorCPF.validaCPF(cpf)) {
            this.nome = nome;
            this.cpf = cpf;
            this.rendaMensal = rendaMensal;
            this.numConta = baseConta++;
            this.agencia = agencia;
            this.saldo = 0;
            this.negativa = false;
        } else {
            System.out.println("CPF Inválido!");
        }
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setRendaMensal(double rendaMensal) {
        this.rendaMensal = rendaMensal;
    }

    public void setNumConta(int numConta) {
        this.numConta = numConta;
    }

    public void setAgencia(Agencia agencia) {
        this.agencia = agencia;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public static int getBaseConta() {
        return baseConta;
    }

    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }

    public double getRendaMensal() {
        return rendaMensal;
    }

    public int getNumConta() {
        return numConta;
    }

    public TipoConta getTipo() {
        return tipo;
    }

    public Agencia getAgencia() {
        return agencia;
    }

    public double getSaldo() {
        return saldo;
    }


    public boolean saque(double valor) {

        if (valor > 0) {

            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso!\nSaldo restante: R$" + this.saldo);

            } else {
                System.out.println("Saldo insuficiente na conta " + this.numConta + "!");
                return false;

            }

        } else {
            System.out.println("Valor inválido para saque!");

            return false;

        }
        return true;

    }

    public void deposito(double valor) {
        this.saldo += valor;
    }

    public boolean isNegativa() {
        return negativa;
    }

    public void setNegativa(boolean negativa) {
        this.negativa = negativa;
    }

    @Override
    public String toString() {
        return "Conta{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", numConta=" + numConta +
                ", tipo=" + tipo +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", negativa=" + negativa +
                '}';
    }


}