// Author: Kevin De La Torre
// Class: CS 241
// Professor: Garland
// Project: Program 3 - Graphs

import java.util.*;

public class Vertex {
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
