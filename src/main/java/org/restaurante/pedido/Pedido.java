package org.restaurante.pedido;
import java.util.Scanner;

import org.restaurante.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<Lanche> itens;


    public Pedido(int numero, String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente inválido");
        }

        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(Lanche lanche) {
        itens.add(lanche);
    }

    public int getNumero() {
        return numero;
    }
    public double calcularTotal() {
        double total = 0.0;

        for (Lanche lanche : itens) {
            total += lanche.getPreco();
        }

        return total;
    }
}