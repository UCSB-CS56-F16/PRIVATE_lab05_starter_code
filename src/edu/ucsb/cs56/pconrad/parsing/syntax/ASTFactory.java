package edu.ucsb.cs56.pconrad.parsing.syntax;

/**
 * Decouples token constructors and underlying class hierarchy from
 * how AST nodes behave.  Only used in the test suites for the parser
 * and the evaluator.  Uses the Factory method design pattern.
 */
public interface ASTFactory {
    public AST makeLiteral(int value);
    public AST makePlusNode(AST left, AST right);
    public AST makeMinusNode(AST left, AST right);
    public AST makeTimesNode(AST left, AST right);
    public AST makeDivNode(AST left, AST right);
    public AST makeUnaryMinusNode(AST inner);

    // New AST nodes
    public AST makeEqualsNode(AST left, AST right);
    public AST makeNotEqualsNode(AST left, AST right);
    public AST makeExponentNode(AST left, AST right);

}
