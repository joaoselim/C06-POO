public class Gato extends Animal implements Domesticavel{
    public Gato(String nome, int anoNascimento){
        super(nome, anoNascimento);
    }

    @Override
    public void emitirSom(){
        System.out.println(this.nome + " esta miando: miau");
    }

    @Override
    public void brincar(){
        System.out.println(this.nome + " esta brincando");    }
}
