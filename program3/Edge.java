public class Edge {
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
