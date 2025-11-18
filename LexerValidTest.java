import org.antlr.v4.runtime.Token;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class LexerValidTest {

    @Test
    void testValidVariableName() {
        var lexer = TestUtils.createLexer("int $x = 10;");
        assertNotNull(lexer.nextToken());
    }

    @Test
    void testBooleanLiterals() {
        var lexer = TestUtils.createLexer("true false");
        assertEquals(BenitenLanguageLexer.BOOL_LITERAL, lexer.nextToken().getType());
        assertEquals(BenitenLanguageLexer.BOOL_LITERAL, lexer.nextToken().getType());
    }

    @Test
    void testStringLiteral() {
        var lexer = TestUtils.createLexer("'Hello World'");
        assertEquals(BenitenLanguageLexer.STRING, lexer.nextToken().getType());
    }

    @Test
    void testFloatLiteral() {
        var lexer = TestUtils.createLexer("3.14");
        assertEquals(BenitenLanguageLexer.FLOAT_LITERAL, lexer.nextToken().getType());
    }
}
