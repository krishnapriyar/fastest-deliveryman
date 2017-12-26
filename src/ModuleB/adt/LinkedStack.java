/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ModuleB.adt;
/**
 *
 * @author Priya
 */
public class LinkedStack<T> implements StackInterface<T>{
    
    Node top;
    int size;

    public LinkedStack() {
        top = null;
        size= 0;
    }

    public int getSize() {
        return size;
    }

    @Override
    public void push(T newEntry) {
        Node newNode= new Node(newEntry);
        
       if(top==null){
           top = newNode;
       }else{
       
       newNode.setNext(top);
       top = newNode;
       }
       size++;
    }

    @Override
    public T pop() {
       Node node = null;
       if(top != null){
           node = top;
           top = top.getNext();
           size--;
       }
       
       if(node!=null)
            return (T)node.getData();
       else
           return null;
    }

    @Override
    public T peek() {
       Node node = null;
       if(top != null){
           node = top;
       }
       
       if(node!=null)
            return (T)node.getData();
       else
           return null;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public void clear() {
        top = null;
        size= 0;
    }

    @Override
    public T replaceTop(T newEntry) {
        
        T node = pop();
        push(newEntry);    
        return node;
        
    }
    
}
