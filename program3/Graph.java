// Author   : Kevin De La Torre
// Class    : CS 241
// Professor: Garland
// Project  : Program 3 - Graphs

import java.util.*;

public class Graph {
	private Map<String, Vertex> vertices;

	public Graph() {
		vertices = new HashMap<String, Vertex>();

	}

	public boolean addVertex( String name ) {
		boolean duplicate = vertices.containsKey( name );
		if ( !duplicate ) {
			vertices.put( name, new Vertex( name ) );
		}
		
		return duplicate;

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
