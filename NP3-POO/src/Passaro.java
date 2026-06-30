public class Passaro extends Animal{
    public Passaro(String nome, int anoNascimento){
        super(nome, anoNascimento);
    }

    @Override
    public void emitirSom(){
        System.out.println(this.nome + " esta cantando: *assobios*");
    }
}
