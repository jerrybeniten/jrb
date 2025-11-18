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
    void testInvalidVariableNoName() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("$ = 10;").nextToken();
        });
    }

    @Test
    void testUnterminatedDoubleQuotedString() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("\"hello").nextToken();
        });
    }

    @Test
    void testGarbageCharacters() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("☀★♣").nextToken();
        });
    }

    @Test
    void testIllegalCharacter() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createLexer("@illegal").nextToken();
        });
    }
}
