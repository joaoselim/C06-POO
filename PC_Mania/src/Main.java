import Clientes.CadastroCliente;
import Loja.Compras.Compras;
import Loja.Computadores.GeradorDePCs;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        //CADASTRO E GERAÇÃO DO BANCO DE DADOS DE PCs
        System.out.println("Seja bem-vindo à PC Mania!");
        System.out.println("Para iniciar insira suas credenciais.");
        CadastroCliente cliente = new CadastroCliente();
        GeradorDePCs pcs = new GeradorDePCs();
        Compras compras = new Compras();

        //RENDERIZAÇÃO DA INTERFACE DA LOJA E INTERAÇÃO
        System.out.println("PC's disponiveis em nossa loja:");
        pcs.CarregamentoDosPCs();
        compras.Comprando(cliente.getCliente());

        //ENCERRAMENTO DO CÓDIGO
        System.out.println("Obrigado por comprar com a gente.");
        System.out.println("Volte sempre!");
    }
}