package folder_sample;
// This contains Q3 from the recitation

public class LinkedListInt<E> {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    private static class Node<E> {
        private Integer element;
        private Node<E> next;

        public Node(Integer e, Node<E> n) {
            element = e;
            next = n;
        }

        public Integer getElement() {
            return element;
        }

        public Node<E> getNext() {
            return next;
        }

        public void setNext(Node<E> n) {
            next = n;
        }
    }

    public void addLast(Integer e) {
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
    
    public int maxTwinSum() {
        // Fast and slow pointers to find the middle
        Node<E> slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }

        // Reverse the second half of the list
        Node<E> prev = null, curr = slow, temp;
        while (curr != null) {
            temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }

        // Calculate the twin sums and find the maximum
        int maxSum = 0;
        Node<E> firstHalf = head;
        Node<E> secondHalf = prev; // This is now the head of the reversed second half
        while (secondHalf != null) {
            int sum = firstHalf.element + secondHalf.element;
            maxSum = Math.max(maxSum, sum);
            firstHalf = firstHalf.next;
            secondHalf = secondHalf.next;
        }

        return maxSum;
    }
    
    
    

    public static void main(String[] args) {
        
    	LinkedListInt listf = new LinkedListInt();
		listf.addLast(7);
		listf.addLast(4);
		listf.addLast(2);
		listf.addLast(1);

        int maxTwinSum = listf.maxTwinSum();
        System.out.println("Maximum Twin Sum: " + maxTwinSum);
//        
    }
}