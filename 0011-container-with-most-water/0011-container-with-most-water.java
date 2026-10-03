class Solution {
    public int maxArea(int[] height) {
        int maxWater = 0, startingEndex = 0, endingEndex = height.length - 1;
        while (startingEndex < endingEndex) {
            maxWater = Math.max(maxWater,Math.min(height[startingEndex],height[endingEndex])*(endingEndex - startingEndex));
            if(height[startingEndex]<height[endingEndex]){
                startingEndex++;
            }else{
                endingEndex--;
            }
        }
        return maxWater;
    }
}