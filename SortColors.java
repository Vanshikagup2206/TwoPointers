package TwoPointers;

import java.util.Arrays;

public class SortColors {
    public void sortColors(int[] nums) {
        int low = 0, mid = 0, high = nums.length - 1;
        while(mid <= high){
           if(nums[mid] == 0){
            int temp = nums[mid];
            nums[mid] = nums[low];
            nums[low] = temp;
            low++;
            mid++;
           }else if(nums[mid] == 1){
            mid++;
           }else{
            int temp = nums[mid];
            nums[mid] = nums[high];
            nums[high] = temp;
            high--;
           }
        }
        System.out.println(Arrays.toString(nums));
    }
    public static void main(String args[]){
        int[] nums = {1,0,2,1,0};
        SortColors sol = new SortColors();
        sol.sortColors(nums);
    }
}