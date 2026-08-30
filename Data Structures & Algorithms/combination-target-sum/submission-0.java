class Solution {
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        List<List<Integer>> response = new ArrayList<>();
        findCombinations(0, target, nums, response, new ArrayList<>());
        return response;

    }

    private void findCombinations(int start, int remaining, int[] nums, List<List<Integer>> response, ArrayList<Integer> current) {
        if(remaining == 0) {
            response.add(new ArrayList<>(current));
            return;
        }

        if(remaining < 0) {
            return;
        }

        for(int i=start; i<nums.length; i++) {
            current.add(nums[i]);
            findCombinations(i, remaining-nums[i], nums, response, current);
            current.remove(current.size()-1);
        }
    }
}
