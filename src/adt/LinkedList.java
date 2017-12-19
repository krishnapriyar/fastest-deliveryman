/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Node;

/**
 *
 * @author Priya
 */
public class LinkedList<T> implements ListInterface<T> {

    private Node firstNode;
    private int numberOfEntries;

    public LinkedList() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (currentNode.getNext() != null) {
                currentNode = currentNode.getNext();
            }
            currentNode.setNext(newNode);
        }
        numberOfEntries++;
    }

    @Override
    public boolean remove(T anEntry) {
//        boolean result = true;                
//
//    if ((givenPosition >= 1) && (givenPosition <= numberOfEntries)) {
//      if (givenPosition == 1) {      // case 1: remove first entry
//        result = firstNode.data;     // save entry to be removed
//        firstNode = firstNode.next;
//      } else {                         // case 2: givenPosition > 1
//        Node nodeBefore = firstNode;
//        for (int i = 1; i < givenPosition - 1; ++i) {
//          nodeBefore = nodeBefore.next;		// advance nodeBefore to its next node
//        }
//        result = nodeBefore.next.data;  // save entry to be removed
//        nodeBefore.next = nodeBefore.next.next;	// make node before point to node after the
//      } 																
// one to be deleted (to disconnect node from chain)
//
//      numberOfEntries--;
//    }
        boolean rs = false;
        Node currentNode = firstNode;

        if (firstNode != null) {
            if (firstNode.getData().equals(anEntry)) {
                firstNode = firstNode.getNext();
            } else {
                while (currentNode.getNext() != null) {
                    if (currentNode.getNext().getData().equals(anEntry)) {
                        currentNode.setNext(currentNode.getNext().getNext());
                        rs = true;
                        break;
                    }
                    currentNode = currentNode.getNext();
                }
            }

        }
        numberOfEntries--;
        return false;
    }

    @Override
    public T getEntry(int index) {

        if (index > 0 && index < numberOfEntries + 1) {
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }

    public String toString() {

        String str = "";
        Node currentNode = firstNode;
        while (currentNode != null) {
            str += currentNode.getData().toString() + "\n";
            currentNode = currentNode.getNext();
        }

        return str;

    }

    public int getNumberOfEntries() {
        return numberOfEntries;
    }

}
