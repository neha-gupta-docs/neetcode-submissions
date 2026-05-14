class Solution {
    public int[] twoSum(int[] numbers, int target) {

        int start= 0, end = numbers.length-1;
        
        while(start<end) {
            int curSum = numbers[start] + numbers[end];
            if(target == curSum) {
                int[] output = new int[2];
                output[0] = start+1;
                output[1] = end+1;
                return output;
            } else if(target > curSum) {
                start++;
            } else if( target < curSum) {
                end--;
            }
        }

        return new int[0];
    }
}
