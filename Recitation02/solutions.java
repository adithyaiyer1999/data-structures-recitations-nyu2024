// package folder_sample;

import java.util.Arrays;

public class MainClass {
	public static void main(String[] args) {
		 
//		  Q1 
		int[] q1_nums = {-4, -2, 0, 3, 10};
	    int[] q1_ans = sortedSquares(q1_nums);
	    System.out.println(Arrays.toString(q1_ans));
	    
//	      Q2
	    String q2 = "Hello World";
        System.out.println(reverseWords(q2));
        
//        Q3
        int[] q3 = {0, 1, 0, 3, 12};
        moveZeroes(q3);
        System.out.println(Arrays.toString(q3));
        
//        Q4
        int[] q4 = {1,1,1,1,0,0,1,1,1,1,0};
	    int q4_ans = maxOnes(q4, 2);
	    System.out.println(q4_ans);
	    
//	      Q5
	    int[] q5 = {2,3,1,2,4,3};
	    int q5_ans = minSubArrayLen(7,q5 );
	    System.out.println(q5_ans);

//	      Q6
	    String q6 = "leetcode";
	    int q6_ans = maxVowels(q6,3);
        System.out.println(q6_ans);
        
//	      Q7
	    int[] q7nums = {1, -2, -3};//{-3, 2, -3, 4, 2};
	    int q7ans = minStartValue(q7nums );
	    System.out.println(q7ans);
        
    }
	
	public static int minStartValue(int[] nums) {
        int minPrefixSum = 0;
        int prefixSum = 0;
        for (int num : nums) {
            prefixSum += num;
            minPrefixSum = Math.min(minPrefixSum, prefixSum);
        }
        if (minPrefixSum < 1) {
            return 1 - minPrefixSum;
        } else {
            return 1;
        }
    }
	
	public static int maxVowels(String s, int k) {
		int i = 0;
		int j = 0;
		int voWelCount = 0;
		int ans = 0;
		while (j < s.length()) {
			if(isVowel(s.charAt(j)) ){
				voWelCount++;
			}
			if(j-i+1 > k) {
				if(isVowel(s.charAt(i))) {
					voWelCount--;
					
				}
				i++;
			}
			j++;
			ans = Math.max(ans, voWelCount);
		}
		return ans;
    }

    private static boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
	
	public static int maxOnes(int[] nums, int k) {
		int i = 0;
		int curr = 0;
		int ans=0;
		for(int j = 0; j <nums.length; j++){
			if(nums[j]==0) {
				curr++;
			}
			while(curr > k) {
				if (nums[i]==0) {
					curr--;
				}
				i++;
			}
			ans = Math.max(ans,j-i+1);
			
		}
		return ans;
	}
	
	public static int minSubArrayLen(int target, int[] nums) {
	    int result = Integer.MAX_VALUE;
	    int left = 0;
	    int sum = 0;
	    for (int right = 0; right < nums.length; right++) {
	        sum += nums[right];
	        while (sum >= target) {
	            result = Math.min(result, right + 1 - left);
	            sum = sum - nums[left];
	            left++;
	        }
	    }
	    return (result != Integer.MAX_VALUE) ? result : 0;
	}
	

	
	public static int[] sortedSquares(int[] nums) {
	    int n = nums.length;
	    int[] result = new int[n];
	    int left = 0, right = n - 1;
	    
	    for (int i = n - 1; i >= 0; i--) {
	        if (Math.abs(nums[left]) < Math.abs(nums[right])) {
	            result[i] = nums[right] * nums[right];
	            right--;
	        } else {
	            result[i] = nums[left] * nums[left];
	            left++;
	        }
	    }
	    
	    return result;
	}
	
	public static String reverseWords(String s) {
        String[] words = s.split(" ");
        String result = "";

        for (String word : words) {
            int i = 0, j = word.length() - 1;
            char[] charArray = word.toCharArray();

            while (i < j) {
                // Swap characters
                char temp = charArray[i];
                charArray[i] = charArray[j];
                charArray[j] = temp;

                // Move pointers
                i++;
                j--;
            }

            result += new String(charArray) + " ";
        }

        return result.trim();
    }
	
	public static void moveZeroes(int[] nums) {
	    int n = nums.length;
	    int left = 0, right = 0;

	    while (right < n) {
	        if (nums[right] != 0) {
	            int temp = nums[left];
	            nums[left] = nums[right];
	            nums[right] = temp;

	            left++;
	        }
	        right++;
	    }
	}
}
