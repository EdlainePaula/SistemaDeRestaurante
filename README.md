# Sistema de Restaurante

Link do vídeo: https://drive.google.com/file/d/1f_mLKZpiPvBtOMpCrS49R66TWAMjb5qS/view?usp=sharing


Neste projeto, desenvolvi um sistema de restaurante utilizando Java 27, dividido em três níveis e aplicando conceitos de Programação Orientada a Objetos.

**Organização:** Separei o projeto em pacotes (`app`, `cardapio` e `pedido`), organizando as responsabilidades. O `Main` controla o fluxo, o `MenuConsole` cuida da interação com o usuário e a `RestauranteFacade` coordena as operações entre as classes.

**Nível 1 — Estrutura inicial:** Criei as classes `Lanche`, `Pedido` e `GerenciadorPedidos`. Enquanto `Pedido` representa uma comanda e calcula seu total, `GerenciadorPedidos` administra todas as comandas utilizando `HashMap`.

**Nível 2 — Cardápio e padrões de projeto:** Criei a interface `ItemCardapio`, permitindo que os pedidos armazenem lanches simples ou com adicionais. A `LancheFactory` centraliza a criação dos lanches padrão, enquanto o padrão Decorator permite adicionar ingredientes pagos, como cheddar e bacon extra, sem modificar a classe original.

**Nível 3 — Personalização:** Implementei a retirada de ingredientes, a modificação e o cancelamento de pedidos, além do uso de `HashSet` para identificar combinações diferentes. Também adicionei tratamento para entradas inválidas.

**Demonstração e testes:** O sistema será demonstrado com o registro de um X-Bacon sem cebola e com cheddar, seguido da listagem dos pedidos e do fechamento do dia. Também será executado um teste com JUnit para validar o preço do lanche com adicional (R$ 26,00).

Com o projeto, pratiquei encapsulamento, interfaces, coleções, separação de responsabilidades, padrões de projeto e testes automatizados.
