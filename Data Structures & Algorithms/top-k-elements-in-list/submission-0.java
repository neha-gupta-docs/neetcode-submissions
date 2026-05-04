// Given an integer array nums and an integer k, return the k most frequent elements within the array.
// The test cases are generated such that the answer is always unique.
// You may return the output in any order.

// Example 1:
// Input: nums = [1,2,2,3,3,3], k = 2
// Output: [2,3]

// Example 2:
// Input: nums = [7,7], k = 1
// Output: [7]

// Constraints:
// 1 <= nums.length <= 10^4.
// -1000 <= nums[i] <= 1000
// 1 <= k <= number of distinct elements in nums.


// To be solved by bucket sort algorithm to do in O(n). It divides the data into buckets and then sorts internally, most using insertion sort.


class Solution {
    public int[] topKFrequent(int[] nums, int k) {

        // Create a hashmap and store frequencies of each number.
        HashMap<Integer, Integer> freq = new HashMap<>();
        for(int num: nums) {
            freq.put(num, freq.getOrDefault(num,0)+1);
        }

        // Create buckets
        List<List<Integer>> buckets = new ArrayList<>();
        while(buckets.size()<=nums.length+1) {
            buckets.add(new ArrayList<>());
        }

        // Index of list = frequency of list of numbers (stored as value at that index)
        for(int key: freq.keySet()) {
            int frequency = freq.get(key);
            buckets.get(frequency).add(key);
        }

        // Pick k numbers from the end of the array
        int[] output = new int[k];
        int count = 0;
        for(int i=buckets.size()-1; i>0 && count < k; i--) {
            for(int num : buckets.get(i)) {
                output[count++] = num;
                if(count == k)
                    return output;
            }
        }


        return output;
    }
}
