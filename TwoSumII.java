package TwoPointers;

public class TwoSumII {
    public int[] twoSum(int[] numbers, int target) {
        int start = 0;
        int end = numbers.length - 1;
        int[] result = new int[2];
        while(start < end){
            if(numbers[start] + numbers[end] == target){
                result[0] = start + 1;
                result[1] = end + 1;
                return result;
            }else if(numbers[start] + numbers[end] < target){
                start++;
            }else{
                end--;
            }
        }
        return result;
    }
}