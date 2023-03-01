package service;

import entity.Conta;
import entity.ContaCorrente;
import entity.ContaInvestimento;
import enums.TipoConta;

import java.util.ArrayList;

public class ListaContas {

    private ArrayList<Conta> listaContas;

    public ListaContas() {

        this.listaContas = new ArrayList<Conta>();
    }

    public ArrayList<Conta> getListaContas() {

        return listaContas;
    }

    public void setListaContas(ArrayList<Conta> listaContas) {
        this.listaContas = listaContas;
    }

    public Conta getContaPorNum(int numConta) {
        Conta conta;
        for (int i = 0; i < listaContas.size(); i++) {
            if (listaContas.get(i).getNumConta() == numConta) {

                conta = listaContas.get(i);
                return conta;
            }
        }
        return null;
    }

    public void getContaPorTipo(TipoConta tipo) {

        ArrayList<Conta> contas = new ArrayList<Conta>();

        for (int i = 0; i < listaContas.size(); i++) {
            if (listaContas.get(i).getTipo() == tipo) {
                contas.add(listaContas.get(i));
            }
        }
        ListaContas listaPorTipo = new ListaContas();
        listaPorTipo.setListaContas(contas);
        System.out.println(listaPorTipo.getListaContas().toString());


    }

    //as únicas contas que podem conter saldo negativo são as Correntes, em virtude do recurso do Cheque Especial
    public void getContasSaldoNegativo() {

        ArrayList<Conta> listaContasCorrentes = new ArrayList<>();


        for (int i = 0; i < listaContas.size(); i++) {
            if (listaContas.get(i).getTipo() == TipoConta.CORRENTE) {
                listaContasCorrentes.add(listaContas.get(i));
            }
        }

        ArrayList<Conta> listaContasNegativas = new ArrayList<>();

        for (int i = 0; i < listaContasCorrentes.size(); i++) {
            if (listaContasCorrentes.get(i).isNegativa()) {
                listaContasNegativas.add(listaContasCorrentes.get(i));
            }
        }

        ListaContas listaNegativas = new ListaContas();
        listaNegativas.setListaContas(listaContasNegativas);
        System.out.println(listaNegativas.getListaContas().toString());


    }

    @Override
    public String toString() {
        return "ListaContas{" +
                "listaContas=" + listaContas +
                '}';
    }
}
