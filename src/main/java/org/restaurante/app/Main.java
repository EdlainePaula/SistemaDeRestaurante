package org.restaurante.app;

import org.restaurante.cardapio.*;
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
                    try {
                        Pedido pedido = sistema.criarPedido(menu.lerNomeCliente());
                        do {
                            adicionarLanche(menu, sistema, pedido);
                        } while (menu.desejaAdicionarMais());
                        menu.mostrarMensagem("Pedido criado com sucesso! Número: " + pedido.getNumero());
                    } catch (IllegalArgumentException e) {
                        menu.mostrarMensagem(e.getMessage());
                    }
                    break;
                case 2:
                    menu.exibirPedidos(sistema.listarPedidos());
                    break;
                case 3:
                    menu.exibirFechamentoDoDia(sistema.calcularTotalDoDia());
                    menu.exibirCombinacoes(sistema.obterCombinacoes());
                    break;
                case 4:
                    int numero = menu.lerNumeroPedido();
                    Pedido existente = sistema.buscarPedido(numero);
                    if (existente == null) {
                        menu.mostrarMensagem("Pedido não encontrado.");
                        break;
                    }
                    int alteracao = menu.lerOpcaoAlteracao();
                    switch (alteracao) {
                        case 1:
                            adicionarLanche(menu, sistema, existente);
                            break;
                        case 2:
                            menu.exibirItensPedido(existente);
                            int indice = menu.lerNumeroItem() - 1;
                            if (indice >= 0 && indice < existente.getItens().size()) {
                                sistema.removerItem(existente, indice);
                                menu.mostrarMensagem("Item removido.");
                            } else menu.mostrarMensagem("Item inválido.");
                            break;
                        case 3:
                            sistema.cancelarPedido(numero);
                            menu.mostrarMensagem("Pedido cancelado.");
                            break;
                        case 0:
                            break;
                        default:
                            menu.mostrarMensagem("Opção inválida.");
                    }
                    break;
                case 0:
                    break;
                default:
                    menu.mostrarMensagem("Opção inválida.");
            }
        } while (opcao != 0);
    }

    private static void adicionarLanche(MenuConsole menu, RestauranteFacade sistema, Pedido pedido) {
        int opcao = menu.lerOpcaoLanche();
        Lanche lanche;
        try {
            lanche = sistema.adicionarLanche(pedido, opcao);
        } catch (IllegalArgumentException e) {
            menu.mostrarMensagem(e.getMessage());
            return;
        }
        lanche.setQueijo(menu.querQueijo());
        lanche.setAlface(menu.querAlface());
        lanche.setTomate(menu.querTomate());
        lanche.setCebola(menu.querCebola());
        ItemCardapio item = lanche;
        if (menu.desejaCheddar()) item = new Cheddar(item);
        if (menu.desejaBaconExtra()) item = new ComBaconExtra(item);
        sistema.adicionarItem(pedido, item);
    }
}
