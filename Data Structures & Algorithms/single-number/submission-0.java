class Solution {
    public int singleNumber(int[] nums) {
       int singleNo = 0;
       for(int num : nums){
        singleNo ^= num;
       }
       return singleNo;
    }
}
