public class Cachorro extends Animal implements Domesticavel{

    public Cachorro(String nome, int anoNascimento){
        super(nome, anoNascimento);
    }

    @Override
    public void emitirSom(){
        System.out.println(this.nome + " esta latindo: au");
    }
    @Override
    public void brincar(){
        System.out.println(this.nome + " esta brincando");
    }
}
