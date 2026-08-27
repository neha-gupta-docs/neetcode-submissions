class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> response = new ArrayList<>();
        createSubset(0,new ArrayList<>(), nums, response);
        return response;
    }

    private void createSubset(int index, List<Integer> subset, int[] nums, List<List<Integer>> response)   
    {
        if(index == nums.length) {
            response.add(subset);
            return;
        }

        createSubset(index+1, new ArrayList<>(subset), nums, response);

        List<Integer> newList = new ArrayList<>(subset);
        newList.add(nums[index]);
        createSubset(index+1, newList, nums, response);
        return;
    }
}
