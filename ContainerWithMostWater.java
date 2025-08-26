package TwoPointers;

public class ContainerWithMostWater {
    public int maxArea(int[] height) {
        int start = 0;
        int end = height.length - 1;
        int area = 0;
        int maxArea = 0;
        while(start < end){
            area = Math.min(height[start], height[end]) * (end - start);
            if(height[start] < height[end])
                start++;
            else
                end--;
            maxArea = Math.max(area, maxArea);
        }
        return maxArea;
    }
}