package org.restaurante.cardapio;

public class Lanche {

    private String nome;
    private double preco;


    public Lanche(String nome, double preco) {
        setNome(nome);
        setPreco(preco);
        if (preco <= 0){
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
        if (nome == null){
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public double getPreco() {
        return preco;
    }

    public void setPreco(double preco) {
        this.preco = preco;
    }

}
