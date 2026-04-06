//CLASSE DE INTERAÇÃO COM A INTERFACE, ONDE SE REALIZA DECISÕES E CHAMA OS METODOS DE ACORDO
package Loja.Compras;
import Clientes.Cliente;
import Loja.Computadores.GeradorDePCs;
import java.util.Scanner;

public class Compras {
    Scanner entrada = new Scanner(System.in);

    short escolha;                          //ESCOLHA DENTRE AS OPÇÕES DO MENU
    int num;                                //QUAL PROMOÇÃO DESEJA ADICIONAR OU REMOVER
    Carrinho carrinho = new Carrinho();
    GeradorDePCs pcs = new GeradorDePCs();
    Interface interfc = new Interface();

    //METODO PARA REALIZAR AS CHAMADAS DE OUTROS METODOS E CLASSES
    public void Comprando(Cliente cliente) {
        interfc.CarregarInterface();
        escolha = entrada.nextShort();

        //ENQUANTO NÃO SELECIONA "SAIR"
        while(escolha != 5) {

            switch (escolha){
                //CONCLUIR COMPRA
                case 0:
                    System.out.println("Deseja realmente concluir sua compra?");
                    System.out.println("[1] - Sim");
                    System.out.println("[2] - Não");
                    int aux = entrada.nextInt();
                    if (aux == 1){
                        carrinho.ConcluirCarrinho(cliente);

                        System.out.println("Deseja realizar algo mais?");
                    }
                    else System.out.println("Conclusão cancelada!");
                    System.out.println("");

                    break;

                //ADD COMPRA
                case 1:

                    System.out.println("Insira o código da promoção que deseja adicionar do carrinho: ");
                    num = entrada.nextInt();
                    if (num == 1){ carrinho.AddAoCarrinho(pcs.pc1); }
                    if (num == 2){ carrinho.AddAoCarrinho(pcs.pc2); }
                    if (num == 3){ carrinho.AddAoCarrinho(pcs.pc3); }
                    System.out.println("");
                    break;

                //REMOVE COMPRA
                case 2:
                    System.out.println("Insira o código da promoção que deseja remover do carrinho: ");
                    num = entrada.nextInt();
                    if (num == 1){ carrinho.RemoveDoCarrinho(pcs.pc1); }
                    if (num == 2){ carrinho.RemoveDoCarrinho(pcs.pc2); }
                    if (num == 3){ carrinho.RemoveDoCarrinho(pcs.pc3); }
                    System.out.println("");
                    break;

                //VIZUALIZAR CARRINHO
                case 3:
                    carrinho.VizualizarCarrinho();
                    break;

                //RECARREGA LOJA
                case 4:
                    System.out.println("");
                    pcs.CarregamentoDosPCs();
                    System.out.println("");
                    break;

                default:
                    System.out.println("Opção inválida! Escolha uma das opções fornecidas.");
            }

            interfc.CarregarInterface();
            escolha = entrada.nextShort();
        }
    }
}
