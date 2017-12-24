/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;


import ModuleB.entity.Node;

/**
 *
 * @author Priya
 */
public class CircularDoublyLinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int size;

    public CircularDoublyLinkedList() {

        this.firstNode = null;
        this.size = 0;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNext(firstNode);

        if (isEmpty()) {
            firstNode = newNode;
            firstNode.setNext(newNode);
            firstNode.setPrevious(newNode);

        } else {
            Node lastNode = firstNode.getPrevious();

            newNode.setNext(firstNode);
            newNode.setPrevious(lastNode);

            lastNode.setNext(newNode);
            firstNode.setPrevious(newNode);

        }
        size++;
    }

    @Override
    public boolean remove(T anEntry) {
        boolean removed = false;

        if (size == 1 && firstNode.getData().equals(anEntry)) {

            firstNode = null;
            size = 0;
            removed = true;
        } else {
            Node node = firstNode;
            do {
                if (node.getData().equals(anEntry)) {

                    if (node.equals(firstNode)) {
                        firstNode = firstNode.getNext();
                    }
                    Node tempnode = node;

                    node.getNext().setPrevious(tempnode.getPrevious());
                    node.getPrevious().setNext(tempnode.getNext());
                    size--;
                    removed = true;

                    
                }
                node = node.getNext();

            } while (!node.equals(firstNode));

        }

        return removed;
    }

    @Override
    public T getEntry(int index) {
        if (index > 0 && index < size + 1) {
            Node currentNode = firstNode;

            for (int i = 1; i < index; i++) {
                currentNode = currentNode.getNext();
            }

            return (T) currentNode.getData();
        } else {

            return null;

        }
    }

    @Override
    public boolean contains(T anEntry) {
        Node currentNode = firstNode;
        Node node = new Node(anEntry);
        boolean contains = false;
        do {
            if (currentNode.getData().equals(anEntry)) {
                contains = true;
                break;
            }
            currentNode = currentNode.getNext();
        } while (currentNode != firstNode);

        return contains;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public String toString() {
        String str = "";
        Node node = firstNode;
        if (size > 0) {
            do {
                str += node.getData().toString() + "\n";
                node = node.getNext();
            } while (!node.equals(firstNode));
        }

        return str;

    }

    public int getSize() {
        return size;
    }

}
