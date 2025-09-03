package TwoPointers;

public class TrappingRainWater {
    public int trap(int[] height) {
        int left = 0;
        int right = height.length - 1;

        int leftMax = 0;
        int rightMax = 0;

        int totalWater = 0;

        while(left < right){
            if(height[left] < height[right]){
                if(height[left] >= leftMax){
                    leftMax = height[left];
                }else{
                    totalWater += leftMax - height[left];
                }
                left++;
            }else{
                if(height[right] >= rightMax){
                    rightMax = height[right];
                }else{
                    totalWater += rightMax - height[right];
                }
                right--;
            }
        }

        return totalWater;
    }
}

/*
 * Input: [4,2,0,3,2,5]

left=0 (4), right=5 (5)
→ left < right, check left
→ leftMax=4, totalWater=0

left=1 (2)
→ leftMax=4 > 2 → add 4-2=2 → totalWater=2

left=2 (0)
→ leftMax=4 > 0 → add 4-0=4 → totalWater=6

left=3 (3)
→ leftMax=4 > 3 → add 4-3=1 → totalWater=7

left=4 (2)
→ leftMax=4 > 2 → add 4-2=2 → totalWater=9

left=5 == right → loop ends

Output = 9
 */