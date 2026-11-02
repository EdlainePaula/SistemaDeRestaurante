package org.restaurante.cardapio;

public class Cheddar implements ItemCardapio {

    private ItemCardapio itemCardapio;

    public Cheddar(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    @Override
    public String getDescricao() {
        return itemCardapio.getDescricao() + " + cheddar";
    }

    @Override
    public double getPreco() {
        return itemCardapio.getPreco()+ 4.0;
    }
}
