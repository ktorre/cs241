// Author : Kevin De La Torre
// Purpose: Binary Search Tree implementation

public class tree {

	private node root;
	private int size;
	public static String tree; // Extremely dirty ik but couldn't figure out how to keep toString string without it being global

	public tree() {
		size = 0;
	}

	public void add( int value ) {
		node tempNode = new node( value ); // Create a node to hold potentially new value
		node posNode = this.root;	// node to move through tree
		if ( root == null ) {
			this.root = tempNode;
		} else {
			while ( true ) {
				if ( tempNode.getValue() == posNode.getValue() ) {
					System.out.println( "Value already in tree" );
					return;

				} else if ( tempNode.getValue() < posNode.getValue() ) {
					if ( posNode.getLeft()!= null ) {
						posNode = posNode.getLeft();
					} else {
						posNode.setLeft( tempNode );
						return;
					}

				} else if ( tempNode.getValue() > posNode.getValue()  ) {
					if ( posNode.getRight() != null ) {
						posNode = posNode.getRight();
					} else {
						posNode.setRight( tempNode );
						return;
					}
				}

			}
		}
	}

	public void delete( int value ) {
		if ( root == null ) {
			System.out.println( "Unable to delete, tree is empty" );
		} else {
			if ( root.getValue() == value ) {
				node tmpRoot = new node( 0 );
				tmpRoot.setLeft( this.root );
				root.remove( tmpRoot, value );
				root = tmpRoot.getLeft();
			} else {
				root.remove( null, value );
			}
		}
	}

	// public void delete( int value ) {
	// 	if ( root == null ) {
	// 		System.out.println( "Unable to delete, tree is empty" );
	// 	} else {
	// 		if ( !this.root.search( value ) ) { 	// This ensures the number is in tree so we don't have to do checks in following
	// 			System.out.println( "Unable to delete, value not in tree" );
	// 		} else {
	// 			node posNode = this.root;
	// 			while ( true ) {
	// 				if ( posNode.getValue() == value ) {
	// 					if ( posNode.isLeaf() ) {
	// 						if ( value > posNode.getParent().getValue() ) {
	// 							posNode.getParent().setRight( null );
	// 						} else {
	// 							posNode.getParent().setLeft( null );
	// 						}
	// 						return;
	// 					} else if ( posNode.getLeft() == null || posNode.getRight() == null ) {
	// 						posNode.getParent().setLeft( posNode.getLeft() );
	// 						posNode.getParent().setRight( posNode.getRight() );
	// 						return;
	// 					} 
	// 				} else if ( value < posNode.getValue() ) {
	// 					posNode = posNode.getLeft();
	// 				} else {
	// 					posNode = posNode.getRight();
	// 				}
	// 			}
	// 		}
	// 	}
	// }

	public boolean search( int value ) {
		if ( root == null ) {
			return false;
		} else {
			return this.root.search( value );
		}

	}

	public void preOrder( node pNode ) {
		if ( pNode == null ) {
			return;
		}		

		tree += pNode.getValue() + " ";

		preOrder( pNode.getLeft() );

		preOrder( pNode.getRight() );

	}

	public void inOrder( node pNode ) {
		if ( pNode == null ) {
			return;
		}		

		inOrder( pNode.getLeft() );

		tree += pNode.getValue() + " ";

		inOrder( pNode.getRight() );

	}

	public void postOrder( node pNode ) { 
		if ( pNode == null ) {
			return;
		}		

		postOrder( pNode.getLeft() );

		postOrder( pNode.getRight() );

		tree += pNode.getValue() + " ";

	}

	public String toString() {
		if ( root == null ) {
			tree = "Tree is empty";
		} else {
			tree = "";
			tree += "Pre-Order : ";
			preOrder( root );
			tree += "\nIn-Order  : ";
			inOrder( root );
			tree += "\nPost-Order: ";
			postOrder( root );
		}
		
		return tree;
	}


}
