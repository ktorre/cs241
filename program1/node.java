// Author : Kevin De La Torre
// Purpose: Binary tree node implementation

public class node {
	private int value;
	private node leftChild;
	private node rightChild;
	private node parent;

	// Constructor
	public node( int value ) {
		this.value = value;
		this.leftChild = null;
		this.rightChild = null;
		this.parent = null;
	}
		
	public node( node copy ) {
		this.value = copy.getValue();
		this.leftChild = copy.getLeft();
		this.rightChild= copy.getRight();
		this.parent = copy.getParent();
	}

	// Getters
	public int getValue() {
		return this.value;
	}

	public node getLeft() {
		return this.leftChild;
	}

	public node getRight() {
		return this.rightChild;
	}

	public node getParent() {
		return this.parent;
	}

	// Setters
	public void setValue( int value ) {
		this.value = value;
	}

	public void setLeft( node left ) {
		this.leftChild = left;
		if ( left != null ) {
			left.setParent( this );
		}
	}

	public void setRight( node right ) {
		this.rightChild = right;
		if ( right != null ) {
			right.setParent( this );
		}
	}

	public void setParent( node parent ) {
		this.parent = parent;

	}

	public boolean isLeaf() {
		return ( this.leftChild == null && this.rightChild == null );
	}

	public boolean search( int value ) {
		if ( this.value == value ) {
			return true;
		} else if ( value < this.value ) {
			if ( this.leftChild == null ) {
				return false;
			} else {
				return this.leftChild.search( value );
			}
		} else if ( value > this.value ) {
			if ( this.rightChild == null ) {
				return false;
			} else {
				return this.rightChild.search( value );
			}
		} 
		return false;
	}

	public void remove( node parent, int value ) {
		if ( value < this.value ) {
			if ( this.leftChild != null ) {
				this.leftChild.remove( this, value );
			} else {
				System.out.println( "Value not in tree" );
			}
		} else if ( value > this.value ) {
			if ( this.rightChild != null ) {
				this.rightChild.remove( this, value );
			} else {
				System.out.println( "Value not in tree" );
			}
		} else {
			if ( this.leftChild != null && this.rightChild != null ) {
				this.value = this.rightChild.smallestValue();
				this.rightChild.remove( this, this.value );
			} else if ( this == this.parent.getLeft() ) {
				if ( this.leftChild != null ) {
					this.parent.setLeft( this.leftChild );
				} else {
					this.parent.setLeft( this.rightChild );
				}
			} else if ( this.parent.getRight() == this ) {
				if ( this.rightChild != null ) {
					this.parent.setRight( this.rightChild );
				} else {
					this.parent.setRight( this.leftChild );
				}

			}

		}
	}

	public int smallestValue() {
		if ( this.leftChild == null ) {
			return value;
		} else {
			return this.leftChild.smallestValue();
		}
	}

	// toString method
	public String toString() {
		return Integer.toString( this.value );
	}

}
