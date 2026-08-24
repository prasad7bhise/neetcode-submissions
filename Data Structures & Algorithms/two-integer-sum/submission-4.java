class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer,Integer> sumToCheck = new HashMap();

        for(int i =0; i< nums.length; i++){
            int difference = target - nums[i];
            if(sumToCheck.containsKey(difference)){
                int j = sumToCheck.get(difference);
                return new int[]{Math.min(i,j), Math.max(i,j)};
            }
            sumToCheck.put(nums[i], i);
        }
        return new int[]{-1, -1};
    }
}
