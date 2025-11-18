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
    void testInvalidVariableName() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser("echo variable").statement();
        });
    }

    @Test
    void testTypeMismatch() {
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser("int $aInt = '25'").statement();
        });
    }

    @Test
    void testInvalidReturnType() {
        String broken = """
                function helloWorld(): float {
                    return '27.23'
                }
                """;
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser(broken).funcDecl();
        });
    }

    @Test
    void testInvalidVariableScope() {
        String broken = """            
                echo $functionLocalScope;                   
                function main(): string {
                    string $functionLocalScope = 'FN Local Scope';
                    return 'hello world';
                }                
                """;
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser(broken).funcDecl();
        });
    }

    @Test
    void testInvalidOperand() {
        String broken = """
                int $aInt =21;
                string $bString = 'Jerry';
                float $result = 0.00;
                $result = $aInt + $bString;
                """;
        assertThrows(RuntimeException.class, () -> {
            TestUtils.createParser(broken).funcDecl();
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
