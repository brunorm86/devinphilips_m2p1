package entity;

import enums.Agencia;
import enums.TipoConta;

import static service.Constantes.*;


public class ContaPoupanca extends Conta {


    public ContaPoupanca(String nome, String cpf, double rendaMensal, Agencia agencia) {
        super(nome, cpf, rendaMensal, agencia);
        this.tipo = TipoConta.POUPANÇA;

    }


    public static double simulaRendimento(double valor, int meses) {

        double valorSimulado = valor + (valor * RENDIMENTO_POUPANCA * meses);

        System.out.println("*** Simulador de rendimentos ***\nValor inicial: R$" + valor + "\nNúmero de meses: "
                + meses + "\nTaxa: " + RENDIMENTO_POUPANCA + "\nValor simulado: " + valorSimulado);

        return valorSimulado;
    }

    @Override
    public String toString() {
        return "\nContaPoupanca{" +
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



