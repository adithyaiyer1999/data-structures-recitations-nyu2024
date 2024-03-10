package rec_mar_01;
import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

public class VisiblePeopleInQueue {

        
    
    public static int[] canSeePersonsCount(int[] heights) {
        int length = heights.length;
        int[] counts = new int[length];
        Deque<Integer> stack = new LinkedList<Integer>();
        for (int i = length - 1; i >= 0; i--) {
            int height = heights[i];
            while (!stack.isEmpty()) {
                int prevHeight = stack.peek();
                counts[i]++;
                if (prevHeight <= height)
                    stack.pop();
                else
                    break;
            }
            stack.push(height);
        }
        return counts;
    }

    public static void main(String[] args) {
        int[] heights = {10, 6, 8, 5, 11, 9};
        int[] result = canSeePersonsCount(heights);

        System.out.println("Number of visible people to the right:");
        for (int count : result) {
            System.out.print(count + " ");
        }
        System.out.println(); // Newline for readability
    }
}
