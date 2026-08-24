class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int maxSum = nums[0];
        int curMax = 0;

        int minSum = nums[0];
        int curMin = 0;

        int totalSum = 0;

        for(int num: nums){
            totalSum += num;

            curMax = Math.max(curMax, 0) + num;
            maxSum = Math.max(curMax, maxSum);

            curMin = Math.min(curMin, 0) + num;
            minSum = Math.min(curMin, minSum);

        }
        if(maxSum < 0){
            return maxSum;
        }
        return Math.max(maxSum, totalSum - minSum);
    }
}