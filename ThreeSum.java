package TwoPointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThreeSum {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();
        
        for(int i = 0; i < nums.length; i++){
            // skip duplicate 'i'
            if (i > 0 && nums[i] == nums[i - 1]) continue;

            int start = i + 1;
            int end = nums.length - 1;

            while(start < end){
                if(nums[i] + nums[start] + nums[end] == 0){
                    result.add(Arrays.asList(nums[i], nums[start], nums[end]));

                    // skip duplicate 'start' values
                    while (start < end && nums[start] == nums[start + 1]) start++;

                    // skip duplicate 'end' values
                    while (start < end && nums[end] == nums[end - 1]) end--;

                    start++;
                    end--;
                }else if(nums[i] + nums[start] + nums[end] < 0){
                    start++;
                }else{
                    end--;
                }
            }
        }
        return result;
    }
}