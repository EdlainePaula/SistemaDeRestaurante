package org.restaurante.app;

import org.restaurante.cardapio.ItemCardapio;
import org.restaurante.pedido.Pedido;

import java.util.HashSet;
import java.util.Scanner;
import java.util.InputMismatchException;

public class MenuConsole {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("4 - Modificar pedido");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        return lerNumero("Escolha uma opção: ");
    }

    public String lerNomeCliente() {
        System.out.print("Nome do cliente: ");
        return scanner.nextLine();
    }

    public int lerOpcaoLanche() {
        System.out.println("\nCardápio:");
        System.out.println("1 - X-Burger (R$16)");
        System.out.println("2 - X-Salada (R$18)");
        System.out.println("3 - X-Bacon (R$22)");

        return lerNumero("Escolha: ");
    }

    public boolean querQueijo() {
        System.out.print("Quer queijo? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean querAlface() {
        System.out.print("Quer alface? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean querTomate() {
        System.out.print("Quer tomate? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean querCebola() {
        System.out.print("Quer cebola? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean desejaCheddar() {
        System.out.print("Adicionar cheddar por R$ 4? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean desejaBaconExtra() {
        System.out.print("Adicionar bacon extra por R$ 6? (s/n): ");
        return scanner.nextLine().equalsIgnoreCase("s");
    }

    public boolean desejaAdicionarMais() {
        System.out.print("Adicionar outro item? (s/n): ");
        String resposta = scanner.nextLine();

        return resposta.equalsIgnoreCase("s");
    }

    public void exibirItensPedido(Pedido pedido) {

        int contador = 1;

        for (ItemCardapio item : pedido.getItens()) {

            System.out.println(
                    contador + " - "
                            + item.getDescricao()
                            + " R$ "
                            + item.getPreco());

            contador++;
        }
    }

    public void exibirCombinacoes(
            HashSet<String> combinacoes) {

        System.out.println(
                "Combinações diferentes: "
                        + combinacoes.size());

        for (String descricao : combinacoes) {
            System.out.println(descricao);
        }
    }
    public int lerNumeroItem() {
        return lerNumero("Número do item: ");
    }

    public int lerNumero(String mensagem) {
        while (true) {
            System.out.print(mensagem);
            try {
                int numero = scanner.nextInt();
                scanner.nextLine();
                return numero;
            } catch (InputMismatchException e) {
                System.out.println("Digite um número válido.");
                scanner.nextLine();
            }
        }
    }

    public int lerNumeroPedido() { return lerNumero("Número do pedido: "); }

    public int lerOpcaoAlteracao() {
        System.out.println("1 - Acrescentar item");
        System.out.println("2 - Remover item");
        System.out.println("3 - Cancelar pedido");
        System.out.println("0 - Voltar");
        return lerNumero("Escolha: ");
    }

    public void exibirPedidos(Iterable<Pedido> pedidos) {
        for (Pedido pedido : pedidos) {
            System.out.println("Pedido " + pedido.getNumero() + " - " + pedido.getNomeCliente());
            exibirItensPedido(pedido);
            System.out.printf("Total: R$ %.2f%n", pedido.calcularTotal());
        }
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.printf("Total faturado: R$ %.2f%n", total);
    }
}