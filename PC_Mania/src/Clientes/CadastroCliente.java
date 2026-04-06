//CLASSE PARA REALIZAÇÃO DO CADASTRO DO CLIENTE
package Clientes;

import java.util.Scanner;
public class CadastroCliente {

    private Cliente cliente;

    public CadastroCliente() {
        Scanner entrada = new Scanner(System.in);

        System.out.println("Nome: ");
        String nomeCliente = entrada.next();

        System.out.println("CPF: ");
        String cpf = entrada.next();

        cliente = new Cliente(nomeCliente, cpf);

        System.out.println("Cliente criado! Bem vindo(a) " + nomeCliente);
        System.out.println("");
        System.out.println("");
    }

    //GETTER
    public Cliente getCliente() {
        return cliente;
    }
}
