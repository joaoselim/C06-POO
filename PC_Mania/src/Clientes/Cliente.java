package Clientes;

import Loja.Compras.Carrinho;

public class Cliente {
    private String nome;
    private String cpf;
    Loja.Compras.Carrinho carrinho;

    public Cliente(String nome, String cpf){
        this.nome = nome;
        this.cpf = cpf;
        carrinho = new Carrinho();
    }
    float calculaTotalCompra(){
        return carrinho.getPreco();
    }


    //GETTERS E SETTERS
    public String getNome() {
        return nome;
    }

    public String getCpf() {
        return cpf;
    }
}
