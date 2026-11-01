package org.restaurante.app;

import org.restaurante.pedido.Pedido;

public class Main {

    public static void main(String[] args) {

        MenuConsole menu = new MenuConsole();
        RestauranteFacade sistema = new RestauranteFacade();

        int opcao;

        do {

            menu.exibirMenu();
            opcao = menu.lerOpcao();

            switch (opcao) {

                case 1:

                    String nome = menu.lerNomeCliente();

                    Pedido pedido = sistema.criarPedido(nome);

                    boolean continuar;

                    do {

                        int opcaoLanche = menu.lerOpcaoLanche();

                        sistema.adicionarLanche(pedido, opcaoLanche);

                        continuar = menu.desejaAdicionarMais();

                    } while (continuar);

                    menu.mostrarMensagem(
                            "Pedido criado com sucesso!"
                    );

                    break;

                case 2:

                    for (Pedido p : sistema.listarPedidos()) {
                        System.out.println(p);
                    }

                    break;

                case 3:

                    double total = sistema.calcularTotalDoDia();

                    menu.exibirFechamentoDoDia(total);

                    break;

            }

        } while (opcao != 0);
    }
}