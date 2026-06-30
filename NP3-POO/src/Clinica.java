import java.util.ArrayList;
import java.util.List;

public class Clinica {
    private List<Consulta> consultas;
    public String nome;

    public Clinica(String nome){
        this.consultas = new ArrayList<>();
        this.nome = nome;
    }

    public void criarConsulta(Animal animal, Veterinario veterinario){
        Consulta consulta = new Consulta(animal, veterinario);
        consultas.add(consulta);
    }

    public void cancelarConsulta(){
        //consultas.remove();
    }

    public void mostrarConsultas(List consultas){
        /*for (){
            System.out.println();
        }*/
    }
}
