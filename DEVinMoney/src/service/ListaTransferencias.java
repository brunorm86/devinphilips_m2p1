package service;

import entity.Conta;
import entity.Transferencia;
import enums.TipoConta;

import java.util.ArrayList;

public class ListaTransferencias {

    private ArrayList<Transferencia> listaTransferencias;

    public ListaTransferencias() {
        this.listaTransferencias = new ArrayList<Transferencia>();
    }

    public void setListaTransferencias(ArrayList<Transferencia> listaTransferencias) {
        this.listaTransferencias = listaTransferencias;
    }

    public ArrayList<Transferencia> getListaTransferencias() {

        return listaTransferencias;
    }

    public void getTransferenciaPorCliente(String cpf) {

        ArrayList<Transferencia> listaPorCPF = new ArrayList<>();


        for (int i = 0; i < this.listaTransferencias.size(); i++) {
            if (this.listaTransferencias.get(i).getContaOrigem().getCpf().equals(cpf) ||
                    this.listaTransferencias.get(i).getContaDestino().getCpf().equals(cpf)) {
                listaPorCPF.add(listaTransferencias.get(i));
            }
        }
        ListaTransferencias listaPorTipo = new ListaTransferencias();
        listaPorTipo.setListaTransferencias(listaPorCPF);
        System.out.println(listaPorTipo.getListaTransferencias().toString());
    }


    @Override
    public String toString() {
        return "ListaTransferencias{" +
                "listaTransferencias=" + listaTransferencias +
                '}';
    }
}


