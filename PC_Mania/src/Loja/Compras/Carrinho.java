//CLASSE PARA TODAS AS AÇÕES REFERENTES AO CARRINHO DE COMPRAS
//ADIÇÃO, REMOÇÃO, VIZUALIZAÇÃO E CONCLUSÃO DO PRÓPRIO
package Loja.Compras;
import Clientes.Cliente;
import Loja.Computadores.Computador;

public class Carrinho {
    private float preco;
    private Computador[] pcs = new Computador[10];
    int pos = 0; //NUMERO DE ITENS NO CARRINHO, COLOQUEI UM LIMITE DE 10

    public void AddAoCarrinho(Computador pc){

        //VERIFICA QUAL POSIÇÃO ESTA VAGA PARA ADICIONAR ITENS AO CARRINHO
        for (int i = 0; i < pcs.length; i++) {
            if (pcs[i] == null) {
                pcs[i] = pc;
                this.preco += pcs[i].getPreco();
                System.out.println("Item adicionado ao seu carrinho com sucesso.");
                System.out.println("--------------------------------------------");

                pos++;
                break;
            }
        }
    }
    public void RemoveDoCarrinho(Computador pc){

        //REALIZA VARREDURA NO ARRAY COMPARANDO COM O ITEM DESEJADO E REMOVE SE O ACHAR
        for (int i = 0; i < pcs.length; i++){
            if (pcs[i] == pc){
                this.preco -= pcs[i].getPreco();
                pcs[i] = null;
                System.out.println("Item removido do seu carrinho com sucesso.");
                System.out.println("------------------------------------------");
                break;
            }
            if (i == pcs.length-1 && pcs[pos] != pc){
                System.out.println("Não foi possivel encontrar esse item no seu carrinho.");
                System.out.println("-----------------------------------------------------");
            }
        }
    }

    public void VizualizarCarrinho(){
        System.out.println("============ Carrinho ============");
        System.out.println("");

        //IMPRIME TODAS AS POSIÇÕES DO ARRAY QUE ESTÃO PREENCHIDAS
        for (int i = 0; i < pcs.length; i++){
            if (pcs[i] != null) {
                System.out.println("PC " + pcs[i].getMarca() + ", " + pcs[i].getSistema().getNome() + " | " + pcs[i].getSistema().getTipo() + " bits");
                System.out.println("Custo: " + pcs[i].getPreco());
                System.out.println("");
            }
        }

        System.out.println("----------------------------------");
        System.out.println("Custo Total: " + this.preco);
        System.out.println("");
    }

    public void ConcluirCarrinho(Cliente cliente){
        //IMPRIME TODOS OS DADOS, TANTO DO CLIENTE QUANTO DO CARRINHO
        System.out.println("-------- Dados da compra --------");
        System.out.println("Nome: " + cliente.getNome());
        System.out.println("");
        System.out.println("CPF: " + cliente.getCpf());
        System.out.println("");

        VizualizarCarrinho();
        System.out.println("");
    }


    //GETTER
    public float getPreco() {
        return preco;
    }
}
