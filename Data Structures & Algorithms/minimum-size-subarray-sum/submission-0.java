class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int start=0, end=0, length=Integer.MAX_VALUE, sum=0;
        while(start<=end && end<nums.length) {
            sum+=nums[end];
            if(sum>=target) {
                while(sum>=target) {
                    length=Math.min(length, end-start+1);
                    sum-=nums[start++];
                } 
            }
            end++;
        }
        return length==Integer.MAX_VALUE ? 0 : length;
    }
}