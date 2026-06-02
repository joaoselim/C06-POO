import java.util.ArrayList;
import Itens.Item;
public class Inventario {

    private ArrayList<Item> itens;

    public Inventario() {
        itens = new ArrayList<>();
    }

    public void adicionarItem(Item item) {
        itens.add(item);
    }

    public boolean possuiItem(String nome) {

        for(Item item : itens) {

            if(item.getNome().equals(nome)) {
                return true;
            }
        }

        return false;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
}