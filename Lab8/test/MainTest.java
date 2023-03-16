import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MainTest {

    @Test
    void pigLatin() {
        String output = Main.pigLatin("MAKING A PIG DEAL ABOUT PIG LATIN");
        assertEquals("AKINGMAY AWAY IGPAY EALDAY ABOUTWAY IGPAY ATINLAY",
                output);
    }
}