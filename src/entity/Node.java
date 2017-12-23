/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entity;

/**
 *
 * @author Priya
 */
public class Node<T> {
    
    private T data;
    private Node next;
    private Node previous;


    public Node() {

    }
    public Node(T data) {
      this.data = data;
      this.next = null;
    }

    public Node(T data, Node next) {
      this.data = data;
      this.next = next;
    }

    public T getData() {
        return data;
    }

    public Node getNext() {
        return next;
    }

    public void setData(T data) {
        this.data = data;
    }

    public void setNext(Node next) {
        this.next = next;
    }
    
    public Node getPrevious() {
        return previous;
    }

    public void setPrevious(Node previous) {
        this.previous = previous;
    }
    
    
}


