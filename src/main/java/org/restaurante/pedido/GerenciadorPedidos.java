package org.restaurante.pedido;

import org.restaurante.cardapio.ItemCardapio;

import java.util.Collection;

import java.util.HashMap;
import java.util.HashSet;

public class GerenciadorPedidos {

    private HashMap<Integer, Pedido> pedidos= new HashMap<>();
    private int contadorPedidos =1;

    public Pedido criarPedido(String nomeCliente){
        Pedido novo = new Pedido(contadorPedidos, nomeCliente);

        pedidos.put(novo.getNumero(), novo);
        contadorPedidos++;

        return novo;
    }

    public Pedido buscarPedido(int numero){
        return pedidos.get(numero);
    }

    public Pedido cancelarPedido(int numero) {
        return pedidos.remove(numero);
    }

    public Collection<Pedido> getPedidos(){
        return pedidos.values();
    }

    public double calcularTotalDoDia(){
        double total = 0.0;

        for (Pedido pedido : pedidos.values()){
            total += pedido.calcularTotal();
        }
        return total;
    }

    public HashSet<String> obterCombinacoes() {

        HashSet<String> combinacoes =
                new HashSet<>();

        for (Pedido pedido : pedidos.values()) {

            for (ItemCardapio item : pedido.getItens()) {

                combinacoes.add(
                        item.getDescricao());
            }
        }

        return combinacoes;
    }

}




