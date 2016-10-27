package edu.ucsb.cs56.pconrad.parsing;

import edu.ucsb.cs56.pconrad.parsing.tokenizer.TokenizerException;
import edu.ucsb.cs56.pconrad.parsing.parser.ParserException;
import edu.ucsb.cs56.pconrad.parsing.evaluator.EvaluatorException;

import static edu.ucsb.cs56.pconrad.parsing.DefaultInterpreterInterface.DEFAULT;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;
import org.junit.Test;

/**
 Tests going from a string to an final result,
 i.e. an end-to-end test of the entire evaluator
 */ 

public class EndToEndNewTest {

    public static final DefaultInterpreterInterface
	intepreter = DefaultInterpreterInterface.DEFAULT;

    public static int evaluateNoException(final String input) {
	int retval = 0;
        try {
	    retval = intepreter.tokenizeParseAndEvaluate(input);
	} catch (TokenizerException e) {
	    fail("Unexpected tokenizer exception: " + e.toString());
        } catch (ParserException e) {
            fail("Unexpected parse exception: " + e.toString());
	} catch (EvaluatorException e) {
            fail("Unexpected evaluator exception: " + e.toString());
        }
	return retval;
    }
    
    @Test public void testExponents() { assertEquals(512, evaluateNoException("2**3**2")); }

    @Test public void testExponentsWithParens() { assertEquals(64, evaluateNoException("(2**3)**2")); }
    
    @Test public void testEquality() { assertEquals(1, evaluateNoException("3+4==8-1")); }
    
    @Test public void testInequality() { assertEquals(0, evaluateNoException("3+4==8-2")); }


} // EndToEndTest.java

