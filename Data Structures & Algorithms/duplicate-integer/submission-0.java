class Solution {
    public boolean hasDuplicate(int[] nums) {
       HashSet<Integer> check = new HashSet();
       for(int num: nums){
        if(check.contains(num)){
            return true;
        }
        check.add(num);
       }
       return false;
    }
}