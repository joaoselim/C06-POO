public abstract class Animal {
    protected String nome;
    public int anoNascimento;

    public Animal(String nome, int anoNascimento){
        this.nome = nome;
        this.anoNascimento = anoNascimento;
    }

    public void emitirSom(){
        System.out.println("emitindo som");
    }
    public void alimentar(){
        System.out.println(this.nome + " esta se alimentando");
    }
}
