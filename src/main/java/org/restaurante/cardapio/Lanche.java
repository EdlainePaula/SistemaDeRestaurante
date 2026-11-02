package org.restaurante.cardapio;

public class Lanche implements ItemCardapio{

    private String descricao;
    private double preco;


    public Lanche(String descricao, double preco) {
        if (preco <= 0){
            throw new IllegalArgumentException("O preço não pode ser negativo");
        }
        if (descricao == null){
            throw new IllegalArgumentException("O nome não pode ser nulo");
        }
        this.descricao = descricao;
        this.preco = preco;
    }

    @Override
    public String getDescricao() {
        return descricao;
    }

    @Override
    public double getPreco() {
        return preco;
    }

    @Override
    public String toString() {
        return descricao + "R$" + preco;
    }
}
