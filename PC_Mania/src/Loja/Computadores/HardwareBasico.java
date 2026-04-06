package Loja.Computadores;

public class HardwareBasico {
    //NO UML MOSTRAVA QUE A CAPACIDADE ERA PARA SER FLOAT. MAS NAS DICAS EM BAIXO DISSE QUE É UM INT
    //ENTÃO ANALISEI A TABELA E COMO NÃO FOI USADO EM NENHUM CASO NENHUM NUMERO NÃO INTEIRO
    //OPTEI POR USAR O INT
    private int capacidade;
    private String nome;

    public HardwareBasico(String nome, int capacidade) {
        this.nome = nome;
        this.capacidade = capacidade;
    }


    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public float getCapacidade() {
        return capacidade;
    }

}
