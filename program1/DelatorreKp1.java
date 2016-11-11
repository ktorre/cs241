// Author: Kevin De La Torre
// Class : CS 241
// Professor: Garland
// Project  : 1
// Purpose  : Implement a binary search tree and interface to (A)dd, (D)elete, (P)rint, or (Q)uit

import java.util.Scanner;

public class DelatorreKp1 {
	
	public static void main( String[] args ) {

		tree bTree = new tree();

		System.out.println( "Binary Search Tree" );
		System.out.println( "Available options: (A)dd, (D)elete, (P)rint, (S)earch, (Q)uit" );
		processInput( bTree );

	}

	public static void processInput( tree bTree ) {
		Scanner reader = new Scanner( System.in );

		String inString = "";
		char inChar = 'x';
		int value;

		while ( inChar != 'q' && inChar != 'Q' ) {
			System.out.print( ">> " );
			inString = reader.nextLine();
			Scanner strReader = new Scanner( inString );
			inChar = strReader.next().charAt( 0 );

			switch ( inChar ) {
				case 'a':
				case 'A':
					if ( !strReader.hasNext() ) {
						System.out.println( "Invalid entry" );
					} else {
						value = strReader.nextInt();
						bTree.add( value );
					}
					break;
				case 'd':
				case 'D':
					if ( !strReader.hasNext() ) {
						System.out.println( "Invalid entry" );
					} else {
						value = strReader.nextInt();
						bTree.delete( value );
					}
					break;
				case 'p':
				case 'P':
					System.out.println( bTree );
					break;
				case 's':
				case 'S':
					if ( !strReader.hasNext()  ) {
						System.out.println( "Invalid entry" );
					} else {
						value = strReader.nextInt();
						System.out.println( "\"" + value + "\" in tree: " + bTree.search( value ) );
					}
					break;
				case 'q':
				case 'Q':
					System.out.println( "Exiting..." );
					break;
				default:
					System.out.println( "Invalid option" );
					break;
			}
		}
	}
}
