/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;

import adt.*;
import adt.*;
import entity.Node;

/**
 *
 * @author USHA
 */
public class LinkedQueue<T> implements QueueInterface<T> {

    private Node topNode;
    private Node bottomNode;
    private int size;

    public LinkedQueue() {
        topNode = null;
        bottomNode = null;
        size = 0;
    }

    @Override
    public void enqueue(T newEntry) {

        Node newNode = new Node(newEntry);
        if (isEmpty()) {
            topNode = newNode;
            bottomNode = newNode;
            size++;
        } else {
            bottomNode.setNext(newNode);
            bottomNode = newNode;
            size++;
        }
    }

    @Override
    public T dequeue() {

        Node node = topNode;
        if (node != null) {
            topNode = topNode.getNext();

            return (T) node.getData();
        } else {
            return null;
        }
    }

    @Override
    public T getFront() {
        return (T) (isEmpty()?null:topNode.getData());
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        topNode = null;
        bottomNode = null;
        size = 0;
    }

    public String toString() {

        String str = "";
        Node node = topNode;

        if (size > 0) {
            while (node != null) {
                str += node.getData().toString() + "\n";
                node = node.getNext();
            }

        }
        return str;

    }

    public int getSize() {
        return size;
    }

}
