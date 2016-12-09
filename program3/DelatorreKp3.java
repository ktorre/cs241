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
		System.out.print( "Vertex to delete: ");
		String vert = input.nextLine();
		projectGraph.deleteVertex( vert );
		System.out.print( "Vertex to add: " );
		vert = input.nextLine();
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
		System.out.println( "\nPart Five:" );
		projectGraph.dijkstra( projectGraph.getVertex( "A" ) );
		System.out.println( "Path cost from A:" );
		Set<String> keys = projectGraph.getVertexSet();
		Iterator<String> keyPointer = keys.iterator();
		while ( keyPointer.hasNext() ) {
			vertex = projectGraph.getVertex( keyPointer.next() );
			if ( vertex.getCost() == Integer.MAX_VALUE ) {
				System.out.printf( "To %s: length ( infinity )\n", vertex.getName() );
			} else {
				System.out.printf( "To %s: length %d\n", vertex.getName(), vertex.getCost() );
			}
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

class Edge {
	private Vertex endVertex;
	private int weight;

	public Edge( Vertex b, int weight ) {
		endVertex = b;
		this.weight = weight;
	}

	public Vertex getVertex() {
		return endVertex;
	}

	public int getWeight() {
		return weight;
	}
}

class Vertex {
	private String name;
	private List<Edge> neighbors;
	private boolean visited;
	private int cost;
	private Vertex predecessor;

	public Vertex( String name ) {
		this.name = name;
		visited = false;
		neighbors = new LinkedList<Edge>();
		predecessor = null;
		cost = 0;
	}

	public String getName() {
		return name;
	}

	public void visit() {
		visited = true;
	}

	public void unvisit() {
		visited = false;
	}

	public boolean isVisited() {
		return visited;
	}

	public boolean connect( Vertex b, int weight ) {
		boolean valid = false;

		if ( !( this.name == b.getName() ) ) {
			ListIterator<Edge> nList = getNeighborIterator();
			boolean duplicates = false;
			while ( !duplicates && nList.hasNext() ) {
				Vertex nextNeighbor = nList.next().getVertex();
				if ( b.getName() == nextNeighbor.getName() ) {
					duplicates = true;
				}
			}

			if ( !duplicates ) {
				neighbors.add( new Edge( b, weight ) );
				valid = true;
			}
		}
		return valid;
	}

	public ListIterator<Edge> getNeighborIterator() {
		ListIterator<Edge> lstNeighbors = neighbors.listIterator();
		return lstNeighbors;

	}

	public boolean hasNeighbor() {
		return neighbors.isEmpty();
	}

	public Vertex getUnvisitedNeighbor() {
		Vertex result = null;
		ListIterator<Edge> nList = getNeighborIterator();
		while ( nList.hasNext() && result == null ) {
			Vertex nextNeighbor = nList.next().getVertex();
			if ( !nextNeighbor.isVisited() ) {
				result = nextNeighbor;
			}
		}
		return result;
	}

	public Vertex getPredecessor() {
		if ( predecessor != null ) {
			return predecessor;
		}
		return null;
	}

	public void setPredecessor( Vertex predecessor ) {
		this.predecessor = predecessor;
	}

	public boolean hasPredecessor() {
		return predecessor != null;
	}

	public int getCost() {
		return cost;
	}

	public void setCost( int newCost ) {
		this.cost = newCost;
	}

}

class Graph {
	private Map<String, Vertex> vertices;

	public Graph() {
		vertices = new HashMap<String, Vertex>();

	}

	public void dijkstra( Vertex vertex ) {
		Set<Vertex> vSet = new HashSet<Vertex>();
		Set<String> keys = getVertexSet();
		Iterator<String> vIterator = keys.iterator();

		while ( vIterator.hasNext() ) {
			Vertex tmpVert = vertices.get( vIterator.next() );
			tmpVert.setCost( Integer.MAX_VALUE ); // Using max value as inf
			tmpVert.setPredecessor( null );
			tmpVert.unvisit();
			vSet.add( tmpVert );
		}

		vertex.setCost( 0 ); // Set root to 0

		Iterator<Vertex> vertIt = vSet.iterator(); // Reset iterator

		while ( vertIt.hasNext() ) {
			vertIt.next();
			Vertex u = minDistance( vSet );
			u.visit();

			ListIterator<Edge> nList = u.getNeighborIterator();
			while ( nList.hasNext() ) {
				Edge tmpEdge = nList.next();
				Vertex edgeVert = tmpEdge.getVertex();
				if ( !edgeVert.isVisited() && u.getCost() != Integer.MAX_VALUE && ( u.getCost() + tmpEdge.getWeight() ) < edgeVert.getCost() ) {
					edgeVert.setCost( u.getCost() + tmpEdge.getWeight() );
				}
			}
		}
	
	}

	public Vertex minDistance( Set<Vertex> vSet ) {
		int minDist = Integer.MAX_VALUE;
		Vertex minVert = null;
		Iterator<Vertex> vPoint = vSet.iterator();

		while ( vPoint.hasNext() ) {
			Vertex tmpVert = vPoint.next();

			if ( !tmpVert.isVisited() && tmpVert.getCost() <= minDist ) {
				minDist = tmpVert.getCost();
				minVert = tmpVert;
			}
		}

		return minVert;
	}

	public Set<String> getVertexSet() {
		return vertices.keySet();
	}

	public boolean addVertex( String name ) {
		boolean duplicate = vertices.containsKey( name );
		if ( !duplicate ) {
			vertices.put( name, new Vertex( name ) );
		}
		
		return duplicate;

	}

	public void deleteVertex( String name ) {
		vertices.remove( name );	
	}

	public Vertex getVertex( String name ) {
		return vertices.get( name );
	}

	public boolean addEdge( String a, String b, int weight ) {
		boolean valid = false;

		Vertex aVertex = vertices.get( a );
		Vertex bVertex = vertices.get( b );

		if ( ( aVertex != null ) && ( bVertex != null ) ) {
			valid = aVertex.connect( bVertex, weight );
		}

		return valid;

	}

	public boolean hasEdge( String a, String b ) {
		boolean edgy = false;

		Vertex aVert = vertices.get( a );
		Vertex bVert = vertices.get( b );
		ListIterator<Edge> nList = aVert.getNeighborIterator();

		if ( ( aVert != null ) && ( bVert != null ) ) {
			while ( nList.hasNext() && !edgy ) {
				Vertex next = nList.next().getVertex();
				if ( next.getName() == bVert.getName() ) {
					edgy = true;
				}
			}
		}
		return edgy;
	}

	public boolean isEmpty() {
		return vertices.isEmpty();
	}

	public void clear() {
		vertices.clear();

	}

	public String toString() {
		String output = "";

		Set<String> vertSet = vertices.keySet();
		Iterator<String> vertIt = vertSet.iterator();

		while ( vertIt.hasNext() ) {
			String key = vertIt.next();
			output += "Vertex ";
			output += key;
			output += ": ";
			Vertex vert = vertices.get( key );
			ListIterator<Edge> nList = vert.getNeighborIterator();

			while ( nList.hasNext() ) {
				Edge tmpEdge = nList.next();
				output += key;
				output += "-";
				output += tmpEdge.getWeight();
				output += "-";
				output += tmpEdge.getVertex().getName();
				if ( nList.hasNext() ) {
					output += ", ";
				}
			}

			output += "\n";
		
		}

		return output;
	}

}
