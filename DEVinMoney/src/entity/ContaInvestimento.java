package entity;

import enums.Agencia;
import enums.Investimento;
import enums.TipoConta;
import service.Constantes;

public class ContaInvestimento extends Conta {

    private Investimento modalidadeInvestimento;
    private double totalInvestido;


    public ContaInvestimento(String nome, String cpf, double rendaMensal, Agencia agencia, Investimento modalidadeInvestimento) {
        super(nome, cpf, rendaMensal, agencia);
        this.tipo = TipoConta.INVESTIMENTO;
        this.modalidadeInvestimento = modalidadeInvestimento;
        this.totalInvestido = 0;
    }

    public void simulaInvestimento(double valor, int meses) {
        double taxa = 0;
        switch (this.modalidadeInvestimento) {
            case CDB -> taxa = Constantes.TAXA_CDB;

            case FII -> taxa = Constantes.TAXA_FII;

            case LCI -> taxa = Constantes.TAXA_LCI;
        }

        double valorSimulado = valor + (valor * taxa * meses);

        System.out.println("*** Simulador de investimentos ***\nValor inicial: R$" + valor + "\nNúmero de meses: "
                + meses + "\nTaxa: " + taxa + "\nValor simulado: " + valorSimulado);

    }

    public Investimento getModalidadeInvestimento() {
        return modalidadeInvestimento;
    }

    public void setModalidadeInvestimento(Investimento modalidadeInvestimento) {
        this.modalidadeInvestimento = modalidadeInvestimento;
    }

    public double getTotalInvestido() {
        return totalInvestido;
    }

    public void setTotalInvestido(double totalInvestido) {
        this.totalInvestido = totalInvestido;
    }

    public void Investir(double valor) {
        if (this.saque(valor)) {
            this.totalInvestido += (valor);
        } else {
            System.out.println("Não há esse saldo disponível para investir!");
        }
    }

    @Override
    public String toString() {
        return "\nContaInvestimento{" +
                ", nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", numConta=" + numConta +
                ", tipo=" + tipo +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", negativa=" + negativa +
                ", modalidadeInvestimento=" + modalidadeInvestimento +
                ", TotalInvestido=" + totalInvestido +
                '}';
    }

}