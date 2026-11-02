package org.restaurante.cardapio;


public class ComBaconExtra implements ItemCardapio {

    private ItemCardapio itemCardapio;

    public ComBaconExtra(ItemCardapio itemCardapio) {
        this.itemCardapio = itemCardapio;
    }

    @Override
    public String getDescricao() {
        return itemCardapio.getDescricao() + " + bacon extra";
    }

    @Override
    public double getPreco() {
        return itemCardapio.getPreco()+ 6.0;
    }
}
