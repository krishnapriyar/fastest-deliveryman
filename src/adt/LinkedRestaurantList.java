/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package adt;

import entity.Node;

/**
 *
 * @author Lysan Chen
 */
public class LinkedRestaurantList<T> implements ListInterface2<T> {
    
      private Node firstNode;
    private int numberOfEntries;

    public LinkedRestaurantList() {
        this.firstNode = null;
        this.numberOfEntries = 0;
    }

    @Override
    public void add(T Entry) {
        Node newNode = new Node(Entry);

        if (firstNode == null) {
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
    public boolean contains(T Entry) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
