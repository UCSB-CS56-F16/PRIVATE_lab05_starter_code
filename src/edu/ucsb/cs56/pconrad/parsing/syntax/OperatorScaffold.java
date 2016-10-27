package edu.ucsb.cs56.pconrad.parsing.syntax;

public abstract class OperatorScaffold implements Operator {
    // begin instance variables
    protected final String repr;
    // end instance variables

    public OperatorScaffold(char repr) {
        this.repr = "" + repr;
    }

    public OperatorScaffold(String repr) {
	this.repr = repr;
    }

    public String getRepr() { return repr; }
    
    public String toString() { return repr; }

    public boolean equals(Object other) {
	if (other==null) return false;
	return (other instanceof OperatorScaffold &&
		((OperatorScaffold)other).repr.equals(repr));
    }

    public int hashCode() {
	return repr.hashCode();
    }
}
