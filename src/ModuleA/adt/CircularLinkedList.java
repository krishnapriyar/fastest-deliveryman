/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleA.adt;


import ModuleA.entity.Node;

/**
 *
 * @author Lysan Chen
 */
public class CircularLinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int size;

    public CircularLinkedList() {

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

        } else {
            Node currentNode = getLastNode();
            currentNode.setNext(newNode);
        }
        size++;
    }

    @Override
    public boolean remove(T anEntry) {

        boolean success = false;

        if (firstNode.getData().equals(anEntry)) {

            if (size == 1) {
                firstNode = null;
                size = 0;
                success = true;
            } else {
                getLastNode().setNext(firstNode.getNext());
                firstNode = firstNode.getNext();
                success = true;
                size--;
            }

        } else {
            Node currentNode = firstNode;

            do {
                if (currentNode.getNext().getData().equals(anEntry)) {
                    currentNode.setNext(currentNode.getNext().getNext());
                    success = true;
                    size--;
                    break;

                }
                currentNode = currentNode.getNext();
            } while (currentNode != firstNode);

        }

        return success;
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
        Node newNode = new Node(anEntry);
        boolean contains = false;
        do {
            if (currentNode.getData().equals(anEntry)) {
                contains = true;
                break;
            }
            currentNode = currentNode.getNext();
        }while (currentNode != firstNode);
        
        return contains;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    private Node getLastNode() {

        Node currentNode = firstNode;

        do {
            currentNode = currentNode.getNext();

        } while (!currentNode.getNext().equals(firstNode));

        return currentNode;

    }

    @Override
    public String toString() {
        String str = "";
        Node currentNode = firstNode;
        if (size != 0) {
            do {
                str += currentNode.getData().toString() + "\n";
                currentNode = currentNode.getNext();
            } while (!currentNode.equals(firstNode));
        }

        return str;
    }

    public int getSize() {
        return size;
    }
    
    

}
