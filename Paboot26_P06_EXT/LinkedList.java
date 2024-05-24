/*
 * Philip Booth
 * 03/22/2024
 * Project 4
 * CS231
 */
import java.util.Iterator; //defines iterator interface
import java.util.NoSuchElementException;


public class LinkedList<T> implements Stack<T>, Iterable<T>{
    
    
    private static class Node<T> {
        private T data; 
        private Node<T> pointer;
    
        //node constructor
        public Node(T item) {
            this.data = item;
            this.pointer = null;
            
        }

        public T getData() {
            return data;
        }

        public void setNext(Node<T> n) {
            this.pointer = n;
        }

        public Node<T> getNext() {
            return pointer;  
        } 
    }


    private class LLIterator implements Iterator<T> {
        Node<T> typeNode;

        public LLIterator(Node<T> head) {
            typeNode = head;
        }

        public boolean hasNext() {
            if (typeNode != null) {
                return true;
            } else {
                return false;
            }
        }

        public T next() {
            T curr = typeNode.getData();
            typeNode = typeNode.getNext();
            return curr;
        }

        public void remove() {
            
        }        

    }

    private Node<T> head;
    private Node<T> tail;
    private int size;

    public Iterator<T> iterator() {
        return new LLIterator(this.head);
        }

    public LinkedList() { 
        head = null;
        tail = null;
        size = 0;
    }

    public int size() {
        return size;
        }

    public void clear() {
        head = null;
        tail = null;
        size = 0;
    }

    public boolean isEmpty() {
        if (size ==0) {
            return true;
        } else {
            return false;
        }
    }
        
    public String toString() {
        String total = "[";
        Node<T> curr = head;
        while (curr != null) {
            total += curr.getData() + ", ";
            curr = curr.getNext();

    }
        return total + "]";
    }

    public void add(T item) {
        Node<T> newNode = new Node<T>(item);
        if (size == 0) {
            tail = newNode;
        }
        
        newNode.setNext(head);
        head = newNode;
        size++;
    }

    public boolean contains(Object o) {
        Node<T> curr = head;
        while (curr != null) {
            if (curr.getData().equals(o)){
                return true;
            }
            curr = curr.getNext();
        }
        return false;
}

    public T get(int index) {
        Node<T> curr = head;

        if (index == size-1) {
            return getLast();
        } 
        for (int i = 0; i < index; i++) {
            curr = curr.getNext();
        }
        return curr.getData();  
    }

    public T remove() {
        if (size == 0) {
            throw new IndexOutOfBoundsException("empty list");
        }
        Node<T> tempNode = head;//stores data associated with first node
        head = head.getNext();//now head points to the next node
        
        size--;
        if (size == 0) {
            head = null;
            tail = null;
        }
        return tempNode.getData();

    }

    public void add(int index, T item) {
        Node<T> curr = head;
        if (index == 0) {
            add(item);
        }
        else if (index == size) {
            addLast(item);
        } else {
            for( int i = 0; i< index-1; i++) {
                curr = curr.getNext();   
            }
            Node<T> tempNode = new Node<T>(item);
            tempNode.setNext(curr.getNext()); 
            curr.setNext(tempNode);//sets previous value in 
            
            size++;
        }
    }

    public T remove(int index) {
        Node<T> curr = head;
        
        if (index == 0) {
            return this.remove();
        }
        
        if (index == size) {// end of list
            return this.removeLast();

        } else {
            for( int i = 0; i< index-1; i++) {
                curr = curr.getNext();   
            }
            Node<T> removedNode = curr.getNext();
            curr.setNext(curr.getNext().getNext());
            size--;
            return removedNode.getData();
        }

    }

    public boolean equals(Object o) {
        if (!(o instanceof LinkedList)){
            return false;
        }
        // If I have reached this line, o must be a LinkedList
        LinkedList<T> oAsALinkedList = (LinkedList) o;
        // Now I have a reference to something Java knows is a LinkedList!
        if (oAsALinkedList.size() != this.size()) {
            return false;
        } else {
            for (int i = 0; i<this.size(); i++) {
                if (!oAsALinkedList.get(i).equals(this.get(i))) {
                    return false;
                    }
                }
            return true;
            }
        }

    public void addLast(T item) {
        // Node<T> newNode = new Node<T>(item);
        // tail = newNode;
        // size++;
        Node<T> newNode = new Node<>(item);
        if (size == 0) {
            head = newNode;
            tail = newNode;
        } else {
            tail.setNext(newNode);
            tail = newNode;
        }
        size++;
    }

    public T removeLast() {
        if (size == 0) {
            throw new NoSuchElementException();
        } else if (size == 1) {//only one element

            T data = head.getData();
            head = null;
            tail = null;
            size--;
            return data;

        } else {
            Node<T> curr = head;
            for( int i = 0; i< size-1; i++)  {
                curr = curr.getNext();
            }
            T data = tail.getData();
            tail = curr;
            tail.setNext(null);
            size--;
            return data;
        }
        }

    public T getLast() {
        if (size > 0) {
            return tail.getData();
        } else {
            return null;
        }
    }
    

//Stack interface
    public void push(T item) {
        add(0, item);
    }

    public T peek() {
        if (tail == null) {//doesn't matter if head or tail
            return null;
        }
        return head.getData();
    }

    public T pop() { 
        return remove(0);
    }

}
