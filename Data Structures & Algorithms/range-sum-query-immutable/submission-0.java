class NumArray {
private int[] prefix;
    public NumArray(int[] nums) {
        prefix = new int[nums.length]; 
        int total = 0;
        for(int i = 0; i< nums.length; i++){
            total += nums[i];
            prefix[i] = total;
        }
    }
    
    public int sumRange(int left, int right) {
        int preRight = prefix[right];
        int preLeft = (left > 0) ? prefix[left - 1] : 0;
        return preRight-preLeft;
    }
}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * int param_1 = obj.sumRange(left,right);
 */