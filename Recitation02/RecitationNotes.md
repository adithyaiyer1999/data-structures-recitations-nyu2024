# Recitation 2 : Questions

## Recap : refer to uploaded pdf notes

## Questions : 


### Question 1

Given an integer array nums sorted in non-decreasing order, return  an array of the squares of each number sorted in non-decreasing order.

Example 1:
```
Input: nums = [-4,-1,0,3,10]
Output: [0,1,9,16,100]
Explanation: After squaring, the array becomes [16,1,0,9,100].
After sorting, it becomes [0,1,9,16,100].
```
Example 2:
```
Input: nums = [-7,-3,2,3,11]
Output: [4,9,9,49,121]
```
Constraints:
```
1 <= nums.length <= 104
-104 <= nums[i] <= 104
nums is sorted in non-decreasing order.
```
### Question 2
Given a string s, reverse the order of characters in each word within a sentence while s>ll preserving whitespace and ini>al word order.

```
Input: "Let's take LeetCode contest"
Output: "s'teL ekat edoCteeL tsetnoc"
```

### Question 3
Given an integer array nums, move all 0's to the end of it while maintaining the rela> ve order of the non-zero elements. Note that you must do this in-place without making a copy of the array.

```
Input :  arr[] = {1, 2, 0, 4, 3, 0, 5, 0};
Output : arr[] = {1, 2, 4, 3, 5, 0, 0, 0};

Input : arr[]  = {1, 2, 0, 0, 0, 3, 6};
Output : arr[] = {1, 2, 3, 6, 0, 0, 0};
```

### Question 4
Given a binary array nums and an integer k, return the maximum number of consecutive 1’s in the array if you can flip at most k 0’s.

Example 1:
```
Input: nums = [1,1,1,0,0,0,1,1,1,1,0], k = 2
Output: 6
Explanation:  [1,1,1,0,0,1,1,1,1,1,1]
```
Example 2:
```
Input: nums = [0,0,1,1,0,0,1,1,1,0,1,1,0,0,0,1,1,1,1], k = 3
Output: 10
Explanation:  [0,0,1,1,1,1,1,1,1,1,1,1,0,0,0,1,1,1,1]
```
Constraints:
```
1 <= nums.length <= 10^5
nums[i] is either 0 or 1.
0 <= k <= nums.length
```
### Question 5
Given an array of positive integers nums and a posi>ve integer target, return the minimal length of a subarray whose sum is greater than or equal to target. If there is no such subarra y, return 0 instead.

Example 1:
```
Input: target = 7, nums = [2,3,1,2,4,3]
Output: 2
Explanation: The subarray [4,3] has the minimal length under the problem constraint.
```
Example 2:
```
Input: target = 4, nums = [1,4,4]
Output: 1
```
### Question 6

Given a string s and an integer k, return the maximum number of vowel leIers in any substring of s with length k. Vowel letters in English are 'a', 'e', 'i', 'o', and 'u'.

Example 1:
```
Input: s = "abciiidef", k = 3
Output: 3
Explanation: The substring "iii" contains 3 vowel letters.
```
Example 2:
```
Input: s = "aeiou", k = 2
Output: 2
Explanation: Any substring of length 2 contains 2 vowels.
```
Example 3:
```
Input: s = "leetcode", k = 3
Output: 2
Explanation: "lee", "eet" and "ode" contain 2 vowels.
```

### Question 7
Given an array of integers nums, you start with an initial positive value startValue.
In each iteration, you calculate the step by step sum of startValue plus elements in nums (from left to right).
Return the minimum positive value of startValue such that the step by step sum is never less than 1.

Example 1:
```
Input: nums = [-3,2,-3,4,2]
Output: 5
Explanation: If you choose startValue = 4, in the third iteration your step by step sum is less than 1.
step by step sum
startValue = 4 | startValue = 5 | nums
  (4 -3 ) = 1  | (5 -3 ) = 2    |  -3
  (1 +2 ) = 3  | (2 +2 ) = 4    |   2
  (3 -3 ) = 0  | (4 -3 ) = 1    |  -3
  (0 +4 ) = 4  | (1 +4 ) = 5    |   4
  (4 +2 ) = 6  | (5 +2 ) = 7    |   2

```
Example 2:
```
Input: nums = [1,2]
Output: 1
Explanation: Minimum start value should be positive. 
```