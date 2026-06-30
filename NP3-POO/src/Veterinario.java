public class Veterinario {
    public String nome;

    public Veterinario(String nome){
        this.nome = nome;
    }
    public void examinar(Animal animal){
        System.out.println("Veterinario: " + this.nome);
        System.out.println("Animal sendo examinado: " + animal.nome);
    }
}
