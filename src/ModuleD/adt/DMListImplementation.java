package ModuleD.adt;

public class DMListImplementation<T> implements DMListInterface<T> {

    Node firstNode;
    int numOfEntries = 0;

    @Override
    public boolean addNewEntry(T newEntry) {
        Node newNode = new Node(newEntry);
        Node tempNode = firstNode;

        if (tempNode == null) {
            firstNode = new Node(newEntry);
            firstNode.next = null;
        } else {
            while (tempNode.next != null) {
                tempNode = tempNode.next;
            }
            tempNode.next = newNode;
        }
        numOfEntries++;
        return true;
    }

    @Override
    public T retrieveAllEntry(int position) {
        T data = null;
        Node tempNode = firstNode;     
        
	for(int i = 0; i <= position ; i++){           
	    data = tempNode.result;
            tempNode = tempNode.next;
	}
        return data;
    }

    @Override
    public boolean containAnEntry(T anEntry) {
        Node aNode = new Node(anEntry);
        Node tempNode = firstNode;

        if (numOfEntries != 0) {
            while (aNode != null) {
                if (tempNode.equals(aNode)) {
                    return true;
                }
                aNode = aNode.next;
            }
        }
        return false;
    }

    @Override
    public int retrieveSize() {
//        while (firstNode.next != null) {
//            firstNode = firstNode.next;
//            numOfEntries++;
//        }
        return numOfEntries;
    }

    @Override
    public boolean isEmpty() {
        if (firstNode == null) {
            return false;
        } else {
            return true;
        }
    }

    private class Node {

        private T result;
        private Node next;

        private Node(Node next) {
            this.next = next;
        }

        private Node(T result) {
            this.result = result;
        }

        public Node(T result, Node next) {
            this.result = result;
            this.next = next;
        }
    }
}
