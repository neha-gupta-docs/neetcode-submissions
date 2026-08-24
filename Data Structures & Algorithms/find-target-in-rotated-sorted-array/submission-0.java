class Solution {
    public int search(int[] nums, int target) {

        int mid = 0;

        for(int i=1; i<nums.length; i++) {
            if(nums[i] < nums[i-1]) {
                mid=i;
                break;
            }
        }

        if(target == nums[mid]) {
            return mid;
        }
        else {

            if(target <= nums[nums.length-1]) {
                return findNum(mid, nums.length-1, nums, target);
            } else {
                return findNum(0, mid, nums, target);
            }
        }
    }

    private int findNum(int start, int end, int[] nums, int target) {
        while(start<=end) {
            if(nums[start] == target) {
                return start;
            }
            start++;
        }

        return -1;
    }
}
