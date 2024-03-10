package rec_mar_01;
import java.util.Stack;

public class MonotonicStackSum {

    public static int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        int[] left = new int[n]; // Stores the leftmost index for each element
        int[] right = new int[n]; // Stores the rightmost index for each element
        Stack<Integer> stack = new Stack<>();

        // Calculate left boundariesa
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] > arr[i]) {
                stack.pop();
            }
            left[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        // Clear the stack for reusing it
        stack.clear();

        // Calculate right boundaries
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] >= arr[i]) {
                stack.pop();
            }
            right[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        // Calculate the sum of minimums
        long ans = 0;
        int MOD = (int) 1e9 + 7;
        for (int i = 0; i < n; i++) {
            ans += (long) (i - left[i]) * (right[i] - i) % MOD * arr[i] % MOD;
            ans %= MOD;
        }

        return (int) ans;
    }

    public static void main(String[] args) {
        int[] arr = {3, 1, 2, 4};
        System.out.println("Sum of minimums: " + sumSubarrayMins(arr)); // Output: 17
    }
}
