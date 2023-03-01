package entity;

import entity.Conta;

import java.util.Date;

public class Transferencia {

    private int idReferencia = 1;

    private int id;
    private Conta contaOrigem;
    private Conta contaDestino;
    private double valor;
    private Date data;

    public Transferencia(Conta contaOrigem, Conta contaDestino, double valor) {
        // deixar essa verificacao aqui?
        if (contaOrigem.getSaldo() >= valor && contaOrigem.getNumConta() != contaDestino.getNumConta()) {

            this.id = idReferencia++;
            this.contaOrigem = contaOrigem;
            this.contaDestino = contaDestino;
            this.valor = valor;
            this.data = new Date();

            if (this.contaOrigem.saque(this.valor)) {
                this.contaDestino.deposito(this.valor);
            }

        } else {
            System.out.println("Transferência não realizada!");

        }


    }


    public int getIdReferencia() {
        return idReferencia;
    }

    public int getId() {
        return id;
    }


    public Conta getContaOrigem() {
        return contaOrigem;
    }


    public Conta getContaDestino() {
        return contaDestino;
    }


    public double getValor() {
        return valor;
    }


    public Date getData() {
        return data;
    }

    @Override
    public String toString() {
        return "Transferencia{" +
                "id=" + id +
                ", contaOrigem=" + contaOrigem +
                ", contaDestino=" + contaDestino +
                ", valor=" + valor +
                ", data=" + data +
                '}';
    }
}
