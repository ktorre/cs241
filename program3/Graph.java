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
