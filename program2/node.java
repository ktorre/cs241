// Author : Kevin De La Torre
// Purpose: Heap node implementation

public class node {
    private int value;
    private node left;
    private node right;
    private node parent;

    public node( int value ) {
	this.value = value;
	this.left = null;
	this.right = null;
	this.parent = null;
    }

    public node( node copy ) {
	this.value = copy.getValue();
	this.left = copy.getLeft();
	this.right = copy.getRight();
	this.parent = copy.getParent();
    }

    // Getters
    public int getValue() {
	    return this.value;
    }

    public node getLeft() {
	    return this.left;
    }

    public node getRight() {
	    return this.right;
    }

    public node getParent() {
	    return this.parent;
    }

    // Setters
    public void setValue( int value ) {
	    this.value = value;
    }

    public void setLeft( node left ) {
	    this.left = left;
	    if ( left != null ) {
		    left.setParent( this );
	    }
    }

    public void setRight( node right ) {
	    this.right = right;
	    if ( right != null ) {
		    right.setParent( this );
	    }
    }

    public void setParent( node parent ) {
	    this.parent = parent;

    }

    public boolean isLeaf() {
	    return ( this.left == null && this.right == null );
    }

}
