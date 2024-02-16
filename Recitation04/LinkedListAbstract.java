package folder_sample;

import java.util.NoSuchElementException;

public class LinkedListAbstract<E> {
	public Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public static class Node<E> {
        private E element;
        private Node<E> next;

        public Node(E e, Node<E> n) {
            element = e;
            next = n;
        }

        public E getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public void addLast(E e) {
        Node<E> newest = new Node<>(e, null);
        if (isEmpty()) {
            head = newest;
        } else {
            tail.setNext(newest);
        }
        tail = newest;
        size++;
    }

    public boolean isEmpty() {
        return size == 0;
    }
    
    public E popFirst() {
        if (isEmpty()) {
            throw new NoSuchElementException("List is empty");
        }

        Node<E> first = head;
        head = head.next;
        size--;

        if (head == null) {
            tail = null; // List becomes empty if head is removed
        }

        return first.element;
    }
    
    
    public static void main(String[] args) {
        LinkedListAbstract<Integer> list = new LinkedListAbstract<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);
		
		
		Integer a = list.popFirst();
		System.out.print("The element popped out is : ");
		System.out.println(a);
		
		Node<Integer> current = list.head;
		
		System.out.print("The list now becomes : ");
		while (current != null) {
		System.out.print(current.getElement() + "->");
		current = current.getNext();
				}
       

        
    }
}
