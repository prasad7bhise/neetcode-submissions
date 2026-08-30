class Solution {
    public int findDuplicate(int[] nums) {
        int slow = nums[0];
        int fast = nums[0];

        do {
            slow = nums[slow];           // 1 step: slow = slow.next
            fast = nums[nums[fast]];     // 2 steps: fast = fast.next.next
        } while (slow != fast);

        // Step 2: Find the entrance to the cycle (the duplicate number)
        int ptr1 = nums[0];
        int ptr2 = slow;

        while (ptr1 != ptr2) {
            ptr1 = nums[ptr1]; // Move 1 step from start
            ptr2 = nums[ptr2]; // Move 1 step from intersection point
        }

        return ptr1; // Or ptr2, as they are both pointing to the duplicate
    }
}
