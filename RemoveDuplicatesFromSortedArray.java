package TwoPointers;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates(int[] nums) {
        int j = 0;
        for(int i = 1; i < nums.length; i++){
            if(nums[i] != nums[j]){
                j++;
                nums[j] = nums[i];
            }
        }
        return j+1;
    }
    public static void main(String args[]){
        int[] nums = {-2, 2, 4, 4, 4, 4, 5, 5};
        RemoveDuplicatesFromSortedArray sol = new RemoveDuplicatesFromSortedArray();
        System.out.println(sol.removeDuplicates(nums));
    }
}