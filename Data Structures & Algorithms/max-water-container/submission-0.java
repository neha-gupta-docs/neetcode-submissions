class Solution {
    public int maxArea(int[] heights) {
        int max = 0;

        for(int start=0; start<heights.length-1; start++) {
            for(int end = start+1; end<heights.length; end++) {

                int area = 0;
                if(heights[start] < heights[end]) {
                    area = (end - start) * heights[start];
                } else {
                    area = (end - start) * heights[end];
                }
                
                max = area > max ? area : max;
            }
        }
        return max;
    }
}
