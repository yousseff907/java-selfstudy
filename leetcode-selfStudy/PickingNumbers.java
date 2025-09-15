/*
Given an array of integers, find the longest subarray where the absolute 
difference between any two elements is at most 1.

Input: arr = [4,6,5,3,3,1]
Output: 3 (subarray [4,3,3] or [3,3] - but [3,3,3] would be length 3)

Actually: [3,3] has length 2, but we can pick [5,6] or [3,4] etc.
The longest valid subarray is of length 3: we can pick three 3's if they existed,
or pick 3,3,4 etc.
*/

public class PickingNumbers
{
    public int pickingNumbers(int[] a)
	{
        // Your solution here
        // Hint: Count frequency of each number, then check consecutive values
    }
}