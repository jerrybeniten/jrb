import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserValidTest {

    @Test
    void testValidVariableDeclaration() {
        var parser = TestUtils.createParser("int $x = 10;");
        assertDoesNotThrow(() -> parser.statement());
    }

    @Test
    void testValidFunction() {
        String code = """
                function add(int $a, int $b): int {
                    return $a + $b;
                }
                """;
        var parser = TestUtils.createParser(code);
        assertDoesNotThrow(() -> parser.funcDecl());
    }

    @Test
    void testValidIfStatement() {
        String code = """
                if ($x > 10) {
                    echo $x;
                }
                """;
        var parser = TestUtils.createParser(code);
        assertDoesNotThrow(() -> parser.ifStmt());
    }

    @Test
    void testValidWhileStatement() {
        String code = """
                while ($x < 5) {
                    $x = $x + 1;
                }
                """;
        var parser = TestUtils.createParser(code);
        assertDoesNotThrow(() -> parser.whileStmt());
    }
}
