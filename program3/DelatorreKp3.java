// Author   : Kevin De La Torre
// Class    : CS 241
// Professor: Garland
// Project  : Program 3 - Graphs

import java.util.*;

public class DelatorreKp3 {
	public static void main( String[] args ) {
		Graph projectGraph = fillGraph();

		// Part one
		System.out.println("Part One:");
		System.out.println( projectGraph );

		// Part two
		System.out.println("Part Two:");
		Scanner input = new Scanner( System.in );
		//System.out.print( "Vertex to delete: ");
		//String vert = input.nextLine();
		//projectGraph.deleteVertex( vert );
		System.out.print( "Vertex to add: " );
		String vert = input.nextLine();
		projectGraph.addVertex( vert );
		System.out.print( "Edge to add: " );
		vert = input.nextLine();
		Scanner vertScan = new Scanner( vert );
		String aVert = vertScan.next();
		int vWeight = vertScan.nextInt();
		String bVert = vertScan.next();
		projectGraph.addEdge( aVert, bVert, vWeight );

		System.out.print( "Edge to add: " );
		vert = input.nextLine();
		vertScan = new Scanner( vert );
		aVert = vertScan.next();
		vWeight = vertScan.nextInt();
		bVert = vertScan.next();
		projectGraph.addEdge( aVert, bVert, vWeight );
		System.out.println();
		System.out.println( projectGraph );

		// Part three
		System.out.println( "\nPart Three:" );
		System.out.println( projectGraph );

		// Part four
		System.out.println( "\nPart Four:" );
		Vertex vertex = projectGraph.getVertex( "A" );
		System.out.print( "Vertices reachable from A: { " );
		ListIterator<Edge> nList = vertex.getNeighborIterator();
		while ( nList.hasNext() ) {
			Edge tmpEdge = nList.next();
			System.out.print( tmpEdge.getVertex().getName() );
			if ( nList.hasNext() ) {
				System.out.print( ", " );
			}
		}
		System.out.println( " }" );

		// Part 5
		System.out.println( "\n Part Five:" );
		projectGraph.dijkstra( projectGraph.getVertex( "A" ) );
		System.out.println( "Paths from A:" );
		Set<String> keys = projectGraph.getVertexSet();
		Iterator<String> keyPointer = keys.iterator();
		while ( keyPointer.hasNext() ) {
			vertex = projectGraph.getVertex( keyPointer.next() );
			System.out.printf( "To %s: length %d\n", vertex.getName(), vertex.getCost() );
		}


	}

	public static Graph fillGraph() {
		Graph tmpGraph = new Graph();
		tmpGraph.addVertex( "A" );
		tmpGraph.addVertex( "B" );
		tmpGraph.addVertex( "C" );
		tmpGraph.addVertex( "D" );
		tmpGraph.addVertex( "E" );
		tmpGraph.addVertex( "F" );
		tmpGraph.addVertex( "G" );
		tmpGraph.addVertex( "H" );
		tmpGraph.addVertex( "K" );
		tmpGraph.addVertex( "L" );
		tmpGraph.addVertex( "M" );
		tmpGraph.addVertex( "N" );

		tmpGraph.addEdge( "A", "B", 2 );
		tmpGraph.addEdge( "B", "C", 3 );
		tmpGraph.addEdge( "C", "D", 2 );
		tmpGraph.addEdge( "E", "A", 3 );
		tmpGraph.addEdge( "B", "F", 1 );
		tmpGraph.addEdge( "C", "G", 2 );
		tmpGraph.addEdge( "E", "F", 2 );
		tmpGraph.addEdge( "G", "F", 2 );
		tmpGraph.addEdge( "G", "H", 3 );
		tmpGraph.addEdge( "K", "E", 1 );
		tmpGraph.addEdge( "F", "L", 1 );
		tmpGraph.addEdge( "H", "N", 2 );
		tmpGraph.addEdge( "K", "L", 3 );
		tmpGraph.addEdge( "L", "M", 1 );
		tmpGraph.addEdge( "M", "N", 1 );

		return tmpGraph;
	}
}
