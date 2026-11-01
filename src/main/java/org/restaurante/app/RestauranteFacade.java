package org.restaurante.app;

import org.restaurante.pedido.GerenciadorPedidos;
import org.restaurante.pedido.Pedido;
import org.restaurante.cardapio.Lanche;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public void adicionarLanche(Pedido pedido, int opcao) {

        Lanche lanche = null;

        switch (opcao) {
            case 1:
                lanche = new Lanche("X-Burger", 16.0);
                break;

            case 2:
                lanche = new Lanche("X-Salada", 18.0);
                break;

            case 3:
                lanche = new Lanche("X-Bacon", 22.0);
                break;
        }

        if (lanche != null) {
            pedido.adicionarItem(lanche);
        }
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public Iterable<Pedido> listarPedidos() {
        return gerenciador.getPedidos();
    }
}