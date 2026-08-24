class Solution {
    public int maxSubArray(int[] nums) {
        int maxSum = nums[0];
        int curSum = 0;

        for(int num : nums){
            curSum = Math.max(curSum, 0) + num;
            maxSum = Math.max(curSum, maxSum);
        }
        return maxSum;
    }
}
