import org.junit.jupiter.api.Test;
import org.restaurante.cardapio.Cheddar;
import org.restaurante.cardapio.ItemCardapio;
import org.restaurante.cardapio.LancheFactory;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class DecoratorTest {

    @Test
    void xBaconComCheddarCusta26() {

        ItemCardapio lanche =
                new Cheddar(LancheFactory.xBacon());

        assertEquals(
                26.0,
                lanche.getPreco(),
                0.001
        );
    }
}