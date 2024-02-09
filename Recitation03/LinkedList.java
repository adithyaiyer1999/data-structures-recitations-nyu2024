// This contains Q1 and 2 from the recitation

package folder_sample;

public class LinkedList<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
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
    
    public Node<E> swapPairs(Node<E> head) {
        // Dummy node acts as the starting point of the swapped list
        Node<E> dummy = new Node<>(null, head);
        Node<E> prev = dummy;

        while (prev.next != null && prev.next.next != null) {
            Node<E> curr = prev.next; // First node of the pair
            Node<E> next = curr.next; // Second node of the pair
            
            // Swapping
            curr.next = next.next;
            next.next = curr;
            prev.next = next;

            // Moving prev two nodes ahead
            prev = curr;
        }

        return dummy.next;
    }

    public void deleteDuplicates() {
        if (head == null || head.getNext() == null) {
            return;
        }

        Node<E> slow = head;
        Node<E> fast = head.getNext();

        while (fast != null) {
            if (!slow.getElement().equals(fast.getElement())) {
                slow.setNext(fast);
                slow = slow.getNext();
            }
            fast = fast.getNext();
        }
        slow.setNext(null); // Disconnect any remaining duplicates after the last unique element
    }
   
    
    public static void main(String[] args) {
        LinkedList<Integer> list = new LinkedList<>();
        list.addLast(1);
        list.addLast(2);
        list.addLast(3);
        list.addLast(4);

        // Before removing duplicates: print the elements
		Node<Integer> current = list.head;
		while (current != null) {
		System.out.print(current.getElement() + "->");
		current = current.getNext();
				}
        System.out.print("\n");
        list.deleteDuplicates();
         // After removing duplicates: print the elements
		current = list.head;
		while (current != null) {
			System.out.print(current.getElement() + "->");
			current = current.getNext();
				}
		
		System.out.println("break");
		
		LinkedList listy = new LinkedList();
		listy.addLast(5);
		listy.addLast(4);
		listy.addLast(2);
		listy.addLast(1);
		
		System.out.println("og list : /n");
		current = listy.head;
		while (current != null) {
			System.out.print(current.getElement() + "->");
			current = current.getNext();
				}
		System.out.println("new list : /n");
		current = listy.head;
		Node<Integer> current_2 = listy.swapPairs(current);

		while (current_2 != null) {
			System.out.print(current_2.getElement() + "->");
			current_2 = current_2.getNext();
				}
	
        
    }
}