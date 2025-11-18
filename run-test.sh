#!/bin/bash

# Exit on errors
set -e

# Print commands (optional)
set -x

# Re-compile
javac -cp ".:antlr-4.13.1-complete.jar:junit-platform-console-standalone-1.10.2.jar" LexerInvalidTest.java LexerValidTest.java ParserInvalidTest.java ParserValidTest.java TestUtils.java

# Run JUnit Platform Console Standalone
java -jar junit-platform-console-standalone-1.10.2.jar \
  --class-path ".:antlr-4.13.1-complete.jar" \
  --scan-class-path
