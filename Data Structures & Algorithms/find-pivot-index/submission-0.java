class Solution {
    public int pivotIndex(int[] nums) {
        int n = nums.length;
        int[] prefix = new int[n];
        int total = 0;
        for(int i = 0; i<n; i++){
            total += nums[i];
            prefix[i] = total; 
        }
        for(int i=0; i< n; i++){
         int leftSum = (i>0)? prefix[i - 1] : 0;
         int rightSum = prefix[n-1] - prefix[i];
         if(leftSum == rightSum){
            return i;
         }
        }
        return -1;
    }
}