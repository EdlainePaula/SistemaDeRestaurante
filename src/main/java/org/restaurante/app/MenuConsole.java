package org.restaurante.app;

import java.util.Scanner;

public class MenuConsole {

    private Scanner scanner = new Scanner(System.in);

    public void exibirMenu() {
        System.out.println("\n=== RESTAURANTE ===");
        System.out.println("1 - Registrar novo pedido");
        System.out.println("2 - Listar pedidos do dia");
        System.out.println("3 - Fechar restaurante");
        System.out.println("0 - Sair");
    }

    public int lerOpcao() {
        System.out.print("Escolha uma opção: ");
        return scanner.nextInt();
    }

    public String lerNomeCliente() {
        scanner.nextLine(); // limpa buffer
        System.out.print("Nome do cliente: ");
        return scanner.nextLine();
    }

    public int lerOpcaoLanche() {
        System.out.println("\nCardápio:");
        System.out.println("1 - X-Burger (R$16)");
        System.out.println("2 - X-Salada (R$18)");
        System.out.println("3 - X-Bacon (R$22)");

        System.out.print("Escolha: ");
        return scanner.nextInt();
    }

    public boolean desejaAdicionarMais() {
        System.out.print("Adicionar outro item? (s/n): ");
        String resposta = scanner.next();

        return resposta.equalsIgnoreCase("s");
    }

    public void mostrarMensagem(String mensagem) {
        System.out.println(mensagem);
    }

    public void exibirFechamentoDoDia(double total) {
        System.out.printf("Total faturado: R$ %.2f%n", total);
    }
}