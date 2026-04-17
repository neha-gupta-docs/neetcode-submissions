class Solution {
    public boolean hasDuplicate(int[] nums) {
        HashSet<Integer> numbers = new HashSet<>();
        boolean output = false;
        for(int num : nums) {
            if(!numbers.add(num)) {
                output = true;
                break;
            }
        }
        return output;
    }
}