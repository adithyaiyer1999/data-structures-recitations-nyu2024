package recitation4;

import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "*abc**d*e*fg*";
        System.out.println(removeStars(s));
        
        String s2 = "leet**cod*e";
        System.out.println(removeStars(s2));

        String s3 = "erase*****";
        System.out.println(removeStars(s3));
        
        int[] asteroids = {5, 10, -5};
        int[] result = asteroidCollision(asteroids);
        System.out.print("test1 \n");
        for (int i : result) {
        	 
            System.out.print(i + " ");
        }
        System.out.print("\ntest2 \n");
        int[] asteroids2 = {10, 2, -5};
        int[] result2 = asteroidCollision(asteroids2);
        for (int i : result2) {
            System.out.print(i + " ");
        }
        
        System.out.print("\n Q4 \n");
        int[] pushed = {1, 2, 3, 4, 5};
        int[] popped = {4, 5, 3, 2, 1};
        System.out.println(validateStackSequences(pushed, popped));
        
    }
    
    public static boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack<>();
        int i = 0;
        for (int x : pushed) {
            stack.push(x);
            while (!stack.empty() && i < popped.length && stack.peek() == popped[i]) {
                stack.pop();
                i++;
            }
        }
        return i == popped.length;
    }

    public static String removeStars(String s) {
        Stack<Character> stack = new Stack<>();
        
        // if * pop, else add
        for (char c : s.toCharArray()) {
            if (c == '*') {
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                stack.push(c);
            }
        }
        
        // create string out of it
        int len = stack.size();
        char[] result = new char[len];
        for (int i = len - 1; i >= 0; i--) {
            result[i] = stack.pop();
        }
        return new String(result);
    }
    
    public static int[] asteroidCollision(int[] asteroids) {
        Stack<Integer> stack = new Stack<>();
        int trash = 0;
        for (int i = 0; i < asteroids.length; i++) {
            if (asteroids[i] > 0 || stack.isEmpty() || stack.peek() < 0)
                stack.push(asteroids[i]);
            else if (stack.peek() < -asteroids[i]) {trash=stack.pop();i--;}
            else if (-asteroids[i]==stack.peek()) {trash=stack.pop();}//do nothing to stack, move ahead}
        }
        int[] result = new int[stack.size()];
        for (int l = result.length - 1; l >= 0; l--)
            result[l] = stack.pop();
        return result;
    }
}
