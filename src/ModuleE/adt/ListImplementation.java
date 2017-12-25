
package ModuleE.adt;

/**
 *
 * @author chong kun ming RSD 3
 */
public class ListImplementation<T> implements myListInterface<T> {

    private Node firstNode;
    private int numberOfEntries = 0;

    @Override
    public void addNewItem(T newItem) {
        Node newNode = new Node(newItem);

        if (isEmpty()) {
            firstNode = newNode;
        } else {
            Node currentNode = firstNode;
            while (currentNode.next != null) {
                currentNode = currentNode.next;
            }
            currentNode.next = newNode;
        }

        numberOfEntries++;
    }

    @Override
    public boolean removeItem(int index) {
        Node currentNode = firstNode;

        if (index <= numberOfEntries && index > 0) {
            if (index == 1) {
                firstNode = firstNode.next;
            } else {
                for (int i = 1; i < index - 1; i++) {
                    currentNode = currentNode.next;
                }
                currentNode.next = currentNode.next.next;
                
            }
            numberOfEntries--;
            return true;
        }
        return false;
    }

    @Override
    public T getAllData(int position) {
        T data = null;
        Node tempNode = firstNode;
        for(int i = 0; i <= position; i++) {
            data = tempNode.data;
            tempNode = tempNode.next;
        }

        return data;
    }
    
    public boolean foundMatch(T newEntry){
        boolean isFound = false;
        if(firstNode != null){
            Node tempNode = firstNode;
            while(tempNode != null){
                if(tempNode.data.equals(newEntry)){
                    isFound = true;
                }else{
                    tempNode = tempNode.next;
                }
            }
        }
        return isFound;
    }

    @Override
    public T getSingleData(int index) {
        T data = null;

        if (index > 0 && index <= numberOfEntries) {
            Node currentNode = firstNode;
            for (int i = 0; i <= index - 1; i++) {
                data = currentNode.data;
                currentNode = currentNode.next;
            }
        }

        return data;
    }

    @Override
    public int getSize() {
        return numberOfEntries;
    }

    @Override
    public void clearList() {
        numberOfEntries = 0;
    }

    @Override
    public boolean isEmpty() {
        return numberOfEntries == 0;
    }


    private class Node {

        private T data;
        private Node next;

        private Node(T data) {
            this.data = data;
        }

        private Node(T data, Node next) {
            this.data = data;
            this.next = next;
        }

    }
}
