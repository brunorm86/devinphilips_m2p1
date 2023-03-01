package menu;

import entity.*;
import enums.*;
import service.ListaContas;
import service.ListaTransferencias;

import java.util.ArrayList;
import java.util.Scanner;

public class Menu {

    ListaContas listaContas = new ListaContas();

    ListaTransferencias listaTransferencias = new ListaTransferencias();
    ArrayList<ContaCorrente> listaCC = new ArrayList<>();
    ArrayList<ContaInvestimento> listaCI = new ArrayList<>();
    ArrayList<ContaPoupanca> listaCP = new ArrayList<>();


    Scanner scanner = new Scanner(System.in);

    public void menuPrincipal() {

        int opcao = 99999999;

        while (opcao != 0) {

            System.out.println("\n**************************************");
            System.out.println("***** DEVinBank Internet Banking *****");
            System.out.println("**************************************");
            System.out.println("*********** MENU PRINCIPAL ***********");
            System.out.println("**************************************");
            System.out.println("* 1 - Cadastrar Conta                *");
            System.out.println("* 2 - Buscar Conta                   *");
            System.out.println("* 3 - Realizar Transferência         *");
            System.out.println("* 4 - Listar Contas Geral            *");
            System.out.println("* 5 - Listar Contas Por Tipo         *");
            System.out.println("* 6 - Listar Contas Negativas        *");
            System.out.println("* 7 - Listar Total Investido         *");
            System.out.println("* 8 - Listar Transações por Cliente  *");
            System.out.println("* 0 - Sair                           *");
            System.out.println("**************************************");

            System.out.println("Digite a opção desejada: ");
            opcao = scanner.nextInt();
            switch (opcao) {
                case 0 -> System.out.println("O DEVinBank agradece a preferência!");
                case 1 -> menuCadastroConta();
                case 2 -> menuBuscaConta();
                case 3 -> menuRealizarTransferência();
                case 4 -> menuListarContasGeral();
                case 5 -> menuListarContasPorTipo();
                case 6 -> menuListarContasNegativas();
                case 7 -> menuListarTotalInvestido();
                case 8 -> menuListarTransacoesPorCliente();
                default -> System.out.println("Opção inválida\n");

            }

        }
    }

    // case 1
    public void menuCadastroConta() {

        System.out.println("**************************************");
        System.out.println("***** DEVinBank Internet Banking *****");
        System.out.println("**************************************");
        System.out.println("********* CADASTRO DE CONTAS *********");
        System.out.println("**************************************");
        System.out.println("* Digite o tipo de conta:            *");
        System.out.println("* 1 - Conta Corrente                 *");
        System.out.println("* 2 - Conta Investimento             *");
        System.out.println("* 3 - Conta Poupança                 *");

        int tipoConta = scanner.nextInt();
        Investimento investimento = null;

        while (tipoConta != 1 && tipoConta != 2 && tipoConta != 3) {

            System.out.println("Opção inválida!");
            tipoConta = scanner.nextInt();
        }

        if (tipoConta == 2) {

            System.out.println("* Digite o tipo de investimento      *");
            System.out.println("* 1 - LCI                            *");
            System.out.println("* 2 - CDB                            *");
            System.out.println("* 3 - FII                            *\n");
            int inves = scanner.nextInt();

            if (inves == 1) {
                investimento = Investimento.LCI;
            } else if (inves == 2) {
                investimento = Investimento.CDB;
            } else {
                investimento = Investimento.FII;
            }
        }

        scanner.nextLine();
        System.out.println("* Digite o nome:                     *\n");
        String nome = scanner.nextLine();
        System.out.println("* Digite o CPF:                      *\n");
        String cpf = scanner.nextLine();
        System.out.println("* Digite a Renda Mensal:             *\n");
        Double renda = scanner.nextDouble();
        System.out.println("* Digite a Agência de origem:        *");
        System.out.println("* 1 - Florianópolis                  *");
        System.out.println("* 2 - São José                       *");
        int ag = scanner.nextInt();

        Agencia agencia;

        if (ag == 1) {
            agencia = Agencia.FLORIANÓPOLIS;
        } else {
            agencia = Agencia.SÃO_JOSÉ;
        }

        System.out.println("\n**************************************");
        //Conta conta;
        if (tipoConta == 1) {
            ContaCorrente conta;
            conta = new ContaCorrente(nome, cpf, renda, agencia);
            System.out.println("Conta Corrente criada com sucesso!" + conta.toString());
            listaCC.add(conta);
            listaContas.getListaContas().add(conta);
        } else if (tipoConta == 2) {
            ContaInvestimento conta;
            conta = new ContaInvestimento(nome, cpf, renda, agencia, investimento);
            System.out.println("Conta Investimento criada com sucesso!" + conta.toString());
            listaCI.add(conta);
            listaContas.getListaContas().add(conta);
        } else {
            ContaPoupanca conta;
            conta = new ContaPoupanca(nome, cpf, renda, agencia);
            System.out.println("Conta Poupança criada com sucesso!" + conta.toString());
            listaCP.add(conta);
            listaContas.getListaContas().add(conta);
        }

    }

    // case 2
    public void menuBuscaConta() {

        System.out.println("\n**************************************");
        System.out.println("***** DEVinBank Internet Banking *****");
        System.out.println("**************************************");
        System.out.println("*********** BUSCA DE CONTAS **********");
        System.out.println("**************************************");
        System.out.println("* Digite o número da conta:          *");

        int numConta = scanner.nextInt();

        Conta conta;

        conta = this.listaContas.getContaPorNum(numConta);
        if (conta != null) {
            System.out.println("Numero de conta inválido");
        } else {
            conta.toString();
        }

    }

    // case 3

    public void menuRealizarTransferência() {
        System.out.println("\n**************************************");
        System.out.println("***** DEVinBank Internet Banking *****");
        System.out.println("**************************************");
        System.out.println("*********** TRANSFERÊNCIAS ***********");
        System.out.println("**************************************");
        System.out.println("* Digite o número da conta origem    *");
        //sem tratamento de erros.
        int numOrigem = scanner.nextInt();
        Conta contaOrigem = this.listaContas.getContaPorNum(numOrigem);
        System.out.println("* Digite o número da conta destino   *");
        int numDestino = scanner.nextInt();
        Conta contaDestino = this.listaContas.getContaPorNum(numDestino);
        System.out.println("* Digite o valor a ser transferido   *");
        double valor = scanner.nextDouble();
        Transferencia transferencia = new Transferencia(contaOrigem, contaDestino, valor);
        this.listaTransferencias.getListaTransferencias().add(transferencia);
    }

    //case 4
    public void menuListarContasGeral() {
        System.out.println("\n**************************************");
        System.out.println("***** DEVinBank Internet Banking *****");
        System.out.println("**************************************");
        System.out.println("****** LISTAGEM TOTAL DE CONTAS ******");
        System.out.println("**************************************");
        System.out.println(listaContas.getListaContas().toString());
        System.out.println(listaContas.getListaContas().size());

    }

    //case 5
    public void menuListarContasPorTipo() {
        System.out.println("\n**************************************");
        System.out.println("***** DEVinBank Internet Banking *****");
        System.out.println("**************************************");
        System.out.println("****** BUSCA DE CONTAS POR TIPO ******");
        System.out.println("**************************************");
        System.out.println("* Digite o tipo de conta:            *");
        System.out.println("* 1 - Conta Corrente                 *");
        System.out.println("* 2 - Conta Investimento             *");
        System.out.println("* 3 - Conta Poupança                 *");
        int tipoConta = scanner.nextInt();
        if (tipoConta == 1) {
            this.listaContas.getContaPorTipo(TipoConta.CORRENTE);

        } else if (tipoConta == 2) {
            this.listaContas.getContaPorTipo(TipoConta.INVESTIMENTO);

        } else if (tipoConta == 3) {
            this.listaContas.getContaPorTipo(TipoConta.POUPANÇA);

        }
    }

    public void menuListarContasNegativas() {
        this.listaContas.getContasSaldoNegativo();
    }

    public void menuListarTotalInvestido() {
        double totalInvestido = 0;
        for (int i = 0; i < listaCI.size(); i++) {
            totalInvestido += listaCI.get(i).getTotalInvestido();
        }
        System.out.println("O total investido em " + listaCI.size() + " contas de Investimento é R$" + totalInvestido);

    }

    public void menuListarTransacoesPorCliente() {

        System.out.println("Digite o CPF do Cliente a buscar: ");
        String cpf = scanner.next();
        this.listaTransferencias.getTransferenciaPorCliente(cpf);


    }


}
