package TwoPointers;

public class MinSizeSubArraySum {
    public int minSubArrayLen(int target, int[] nums) {
        int start = 0;
        int end = 0;
        
        int minLength = Integer.MAX_VALUE;
        int currentSum = 0;

        while(end < nums.length){
            if(currentSum < target){
                currentSum += nums[end];
                end++;
            }

            while(currentSum >= target){
                minLength = Math.min(minLength, end - start);
                currentSum -= nums[start];
                start++;
            }
        }

        return (minLength == Integer.MAX_VALUE) ? 0 : minLength;
    }
}