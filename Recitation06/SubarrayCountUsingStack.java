package rec_mar_01;

import java.util.Stack;

public class SubarrayCountUsingStack {
    public static int countSubarrays(int[] nums) {
        int n = nums.length;
        Stack<Integer> stack = new Stack<>();
        int totalCount = 0;

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && nums[stack.peek()] >= nums[i]) {
                stack.pop();
            }
            int nextSmallerIndex = stack.isEmpty() ? n : stack.peek();
            totalCount += (nextSmallerIndex - i);
            stack.push(i);
        }

        return totalCount;
    }

    public static void main(String[] args) {
        int[] nums = {1, 3, 5, 2}; // Example input
        System.out.println("Number of valid subarrays: " + countSubarrays(nums));
    }
}
