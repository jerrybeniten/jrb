import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class ParserInvalidTest {

    @Test
    void testMissingSemicolon() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser("int $x = 10").statement();
        });
    }

    @Test
    void testInvalidFunctionSyntax() {
        String broken = """
                function bad(int $x int $y) {
                    return $x;
                }
                """;
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser(broken).funcDecl();
        });
    }

    @Test
    void testInvalidIfStatement() {
        String broken = """
                if $x > 10 {
                    echo $x;
                }
                """;
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser(broken).ifStmt();
        });
    }
}
