package org.restaurante.app;

import org.restaurante.cardapio.Lanche;
import org.restaurante.cardapio.LancheFactory;
import org.restaurante.pedido.GerenciadorPedidos;
import org.restaurante.pedido.Pedido;

import java.util.HashSet;

public class RestauranteFacade {

    private GerenciadorPedidos gerenciador = new GerenciadorPedidos();

    public Pedido criarPedido(String nomeCliente) {
        return gerenciador.criarPedido(nomeCliente);
    }

    public Lanche adicionarLanche(Pedido pedido, int opcao) {

        Lanche lanche;

        switch (opcao) {
            case 1:
                lanche = LancheFactory.xBurger();
                break;

            case 2:
                lanche = LancheFactory.xSalada();
                break;

            case 3:
                lanche = LancheFactory.xBacon();
                break;

            default:
                throw new IllegalArgumentException(
                        "Opção de lanche inválida."
                );
        }
        return lanche;
    }

    public void adicionarItem(Pedido pedido, org.restaurante.cardapio.ItemCardapio item) {
        pedido.adicionarItem(item);
    }

    public void removerItem(Pedido pedido, int indice) {
        pedido.removerItem(indice);
    }

    public double calcularTotalDoDia() {
        return gerenciador.calcularTotalDoDia();
    }

    public Iterable<Pedido> listarPedidos() {
        return gerenciador.getPedidos();
    }

    public Pedido buscarPedido(int numero){
        return gerenciador.buscarPedido(numero);
    }

    public Pedido cancelarPedido(int numero){
        return gerenciador.cancelarPedido(numero);
    }
    public HashSet<String> obterCombinacoes() {
        return gerenciador.obterCombinacoes();
    }
}