import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;

public class TestUtils {

    public static class ThrowingErrorListener extends BaseErrorListener {
        @Override
        public void syntaxError(Recognizer<?, ?> recognizer,
                                Object offendingSymbol,
                                int line, int charPositionInLine,
                                String msg, RecognitionException e)
                throws RuntimeException {
            throw new RuntimeException("Syntax error: " + msg);
        }
    }

    public static BenitenLanguageLexer createLexer(String input) {
        CharStream cs = CharStreams.fromString(input);
        BenitenLanguageLexer lexer = new BenitenLanguageLexer(cs);
        lexer.removeErrorListeners();
        lexer.addErrorListener(new ThrowingErrorListener());
        return lexer;
    }

    public static BenitenLanguageParser createParser(String input) {
        BenitenLanguageLexer lexer = createLexer(input);
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        BenitenLanguageParser parser = new BenitenLanguageParser(tokens);
        parser.removeErrorListeners();
        parser.addErrorListener(new ThrowingErrorListener());
        return parser;
    }
}
