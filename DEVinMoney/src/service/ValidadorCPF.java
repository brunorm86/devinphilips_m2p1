package service;

public class ValidadorCPF {

    public static boolean validaCPF(String cpf) {

        boolean comprimento = cpf.length() == 11;

        boolean isNumber = true;

        char[] c = cpf.toCharArray();

        for (int i = 0; i < c.length; i++)
            // verifica se o char não é um dígito
            if (!Character.isDigit(c[i])) {
                isNumber = false;
                break;
            }


        return (comprimento && isNumber);

    }


}
