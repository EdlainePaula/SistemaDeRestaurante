import org.junit.jupiter.api.Test;
import org.restaurante.cardapio.Lanche;

import static org.junit.jupiter.api.Assertions.assertThrows;

public class LancheTest {

    @Test
    void naoDevePermitirPrecoNegativo() {

        assertThrows(
                IllegalArgumentException.class,
                () -> new Lanche("Teste", -10.0)
        );
    }
}
