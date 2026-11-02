package org.restaurante.pedido;
import java.util.Scanner;

import org.restaurante.cardapio.ItemCardapio;
import org.restaurante.cardapio.Lanche;

import java.util.ArrayList;

public class Pedido {
    private int numero;
    private String nomeCliente;
    private ArrayList<ItemCardapio> itens;



    public ArrayList<ItemCardapio> getItens() {
        return itens;
    }

    public void setItens(ArrayList<ItemCardapio> itens) {
        this.itens = itens;
    }

    public Pedido(int numero, String nomeCliente) {
        if (nomeCliente == null || nomeCliente.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome do cliente inválido");
        }

        this.numero = numero;
        this.nomeCliente = nomeCliente;
        this.itens = new ArrayList<>();
    }

    public void adicionarItem(ItemCardapio item) {
        itens.add(item);
    }

    public String getNomeCliente() {
        return nomeCliente;
    }

    public int getNumero() {
        return numero;
    }
    public double calcularTotal() {
        double total = 0.0;

        for (ItemCardapio lanche : itens) {
            total += lanche.getPreco();
        }

        return total;
    }

    public void removerItem(int indice){
        itens.remove(indice);
    }
}