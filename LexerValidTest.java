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

    @Test
    void testDoubleQuotedStringLiteral() {
        var lexer = TestUtils.createLexer("\"Hello\"");
        assertEquals(BenitenLanguageLexer.STRING, lexer.nextToken().getType());
    }

    @Test
    void testIntegerLiteral() {
        var lexer = TestUtils.createLexer("123");
        assertEquals(BenitenLanguageLexer.INT_LITERAL, lexer.nextToken().getType());
    }

    @Test
    void testComplexVariableName() {
        var lexer = TestUtils.createLexer("$var_123");
        assertEquals(BenitenLanguageLexer.VARIABLE, lexer.nextToken().getType());
    }

    @Test
    void testIdentifier() {
        var lexer = TestUtils.createLexer("myFunction");
        assertEquals(BenitenLanguageLexer.ID, lexer.nextToken().getType());
    }

    @Test
    void testOperatorEquals() {
        var lexer = TestUtils.createLexer("==");
        assertEquals(BenitenLanguageLexer.EQ, lexer.nextToken().getType());
    }

    @Test
    void testKeywords() {
        var lexer = TestUtils.createLexer("function if else while return echo");

        assertEquals(BenitenLanguageLexer.FUNCTION, lexer.nextToken().getType());
        assertEquals(BenitenLanguageLexer.IF, lexer.nextToken().getType());
        assertEquals(BenitenLanguageLexer.ELSE, lexer.nextToken().getType());
        assertEquals(BenitenLanguageLexer.WHILE, lexer.nextToken().getType());
        assertEquals(BenitenLanguageLexer.RETURN, lexer.nextToken().getType());
        assertEquals(BenitenLanguageLexer.ECHO, lexer.nextToken().getType());
    }

}
