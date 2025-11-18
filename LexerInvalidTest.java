import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LexerInvalidTest {

    @Test
    void testUnterminatedString() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("'hello").nextToken();
        });
    }

    @Test
    void testIllegalCharacterInOperations() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("int $x = 10 @ 5;").nextToken();
        });
    }

    @Test
    void testIllegalCharacter() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("@illegal").nextToken();
        });
    }
}
