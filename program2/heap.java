// Author : Kevin De La Torre
// Purpose: Heap implementation

public class heap {
    private node[] heap;
    private int size;

    public heap( int maxSize ) {
	size = 0;
	heap = new node[ maxSize + 1 ]
    }

    public add( node h ) {
    }

    public node peek() {
	return this.root;
    }

    public node getMin() {
	return this.last;
    }
}
