package entity;

import enums.Agencia;
import enums.TipoConta;
import service.Constantes;

public class ContaCorrente extends Conta {

    private double chequeEspecial;
    private double chequeEspecialDisponivel;

    public ContaCorrente(String nome, String cpf, double rendaMensal, Agencia agencia) {
        super(nome, cpf, rendaMensal, agencia);
        this.chequeEspecial = rendaMensal * Constantes.INDICE_CHEQUE_ESPECIAL;
        this.chequeEspecialDisponivel = chequeEspecial;
        this.tipo = TipoConta.CORRENTE;

    }

    public void setChequeEspecial(double chequeEspecialNovo) {
        this.chequeEspecialDisponivel += (chequeEspecialNovo - chequeEspecial);
        this.chequeEspecial = chequeEspecialNovo;
    }

    public double getChequeEspecial() {
        return chequeEspecial;
    }

    public double getChequeEspecialDisponivel() {

        return chequeEspecialDisponivel;
    }


    @Override
    public boolean saque(double valor) {

        if (valor > 0) {

            if (this.saldo >= valor) {
                this.saldo -= valor;
                System.out.println("Saque de R$" + valor + " realizado com sucesso!\nSaldo restante: R$" + this.saldo);
                return true;

            } else if (this.saldo + this.chequeEspecialDisponivel >= valor) {
                System.out.println("Saldo insuficiente. Utilizado R$" + (-1 * (this.saldo - valor)) + " do Cheque Especial");
                this.saldo = 0;
                this.chequeEspecialDisponivel -= (-1 * (this.saldo - valor));
                System.out.println("Cheque Especial disponível: R$" + chequeEspecialDisponivel);
                this.setNegativa(true);
                return true;

            } else if (this.saldo + this.chequeEspecialDisponivel < valor) {
                System.out.println("Saldo em conta e Cheque Especial disponível insuficientes para cobrir o saque!");
                return false;
            }

        } else {
            System.out.println("Valor inválido para saque!");
            return false;

        }

        return true;

    }

    @Override
    public void deposito(double valor) {

        if (chequeEspecialDisponivel < chequeEspecial) {
            this.chequeEspecialDisponivel += valor;

            if (chequeEspecialDisponivel > chequeEspecial) {
                this.saldo += (chequeEspecialDisponivel - chequeEspecial);
                this.chequeEspecialDisponivel = this.chequeEspecial;
                this.setNegativa(false);
            }

        } else {

            saldo += valor;
        }
    }

    @Override
    public String toString() {
        return "\nContaCorrente{" +
                "nome='" + nome + '\'' +
                ", cpf='" + cpf + '\'' +
                ", rendaMensal=" + rendaMensal +
                ", numConta=" + numConta +
                ", tipo=" + tipo +
                ", agencia=" + agencia +
                ", saldo=" + saldo +
                ", negativa=" + negativa +
                ", chequeEspecial=" + chequeEspecial +
                ", chequeEspecialDisponivel=" + chequeEspecialDisponivel +
                '}';
    }
}
