package org.restaurante.app;

import org.restaurante.cardapio.Lanche;
import org.restaurante.cardapio.LancheFactory;
import org.restaurante.pedido.GerenciadorPedidos;
import org.restaurante.pedido.Pedido;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public Lanche adicionarLanche(Pedido pedido, int opcao) {

        Lanche lanche = null;

        switch (opcao) {
            case 1:
                return LancheFactory.xBurger();

            case 2:
                return LancheFactory.xSalada();

            case 3:
                return LancheFactory.xBacon();

            default:
                throw new IllegalArgumentException(
                        "Opção de lanche inválida."
                );
        }
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public Iterable<Pedido> listarPedidos() {
        return gerenciador.getPedidos();
    }
}