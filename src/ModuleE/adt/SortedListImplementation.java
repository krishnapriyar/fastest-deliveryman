package ModuleE.adt;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author chong kun ming
 */
public class SortedListImplementation<T extends Comparable<T>> implements SortedListInterface<T> {

    private Node firstNode;
    private int numberOfEntries = 0;

    @Override
    public void addEntry(T newEntry) {
        Node newNode = new Node(newEntry);

        if (firstNode == null) {
            firstNode = newNode;
        } else {
            if (firstNode.next == null) {
                if (firstNode.data.compareTo(newNode.data) <= 0) {
                    firstNode.next = newNode;
                } else {
                    newNode.next = firstNode;
                    firstNode = newNode;
                }
            } else {

                Node tempNode = firstNode;
                Node currentNode = null;
                if (tempNode.data.compareTo(newNode.data) > 0) {
                    newNode.next = tempNode;
                    firstNode = newNode;
                } else {
                    while (tempNode.data.compareTo(newNode.data) <= 0) {
                        currentNode = tempNode;
                        if (tempNode.next == null) {
                            tempNode.next = newNode;
                        }
                        tempNode = tempNode.next;
                    }
                    if (tempNode.data.compareTo(newNode.data) > 0) {
                        currentNode.next = newNode;
                        newNode.next = tempNode;
                    }
                }
            }
        }
        numberOfEntries++;
    }
    
    @Override
    public T getEntry(int position) {
        T data = null;

        Node tempNode = firstNode;
        for (int i = 0; i <= position; i++) {
            data = tempNode.data;
            tempNode = tempNode.next;
        }

        return data;
    }

    @Override
    public int size() {
        return numberOfEntries;
    }

    @Override
    public boolean isEmpty() {
        return firstNode == null;
    }

    private class Node {

        private Node next;
        private T data;

        public Node(T data) {
            this.data = data;
        }

        public Node(Node next, T data) {
            this.next = next;
            this.data = data;
        }

    }
}
