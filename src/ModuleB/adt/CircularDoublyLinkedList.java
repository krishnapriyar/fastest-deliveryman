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
 * CircularDoublyLinkedList means elements are linked to elements to the front and back.
 * The last element in the list also points to the first element in the list.
 */
public class CircularDoublyLinkedList<T> implements ListInterface<T> {

    //firstNode refers to the first/top/front element in the list
    private Node firstNode;
    private int size;
    
    //Initialize empty list
    public CircularDoublyLinkedList() {

        this.firstNode = null;
        this.size = 0;
    }


    @Override
    public void add(T newEntry) {
        Node newNode = new Node(newEntry);
        newNode.setNext(firstNode);

        if (isEmpty()) {
            //New element is the firstNode if the list is empty
            firstNode = newNode;
            firstNode.setNext(newNode);
            firstNode.setPrevious(newNode);

        } else {
            
           //New elements are added to the end of the list
           
            Node lastNode = firstNode.getPrevious();

            //The new entry points to the firstNode (as next node) and the former last element (as previous node)
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
        
        //If the only element equals the one to be removed, the list is reinitialised to empty
        if (size == 1 && firstNode.getData().equals(anEntry)) {

            firstNode = null;
            size = 0;
            removed = true;
        } else {
            Node node = firstNode;
            do {
                if (node.getData().equals(anEntry)) {

                    //firstNode is set the next element in case it needs to be removed
                    if (node.equals(firstNode)) {
                        firstNode = firstNode.getNext();
                    }
                    //References to the node to be removed are reassigned
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
        
        //Valid index starts at 1 and is not more than the size of the list
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
