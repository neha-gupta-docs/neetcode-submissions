class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {

        for(int row = 0; row<matrix.length; row++) {
            int[] rowArr = matrix[row]; 
            if(target >= rowArr[0] && target <= rowArr[rowArr.length-1]) {
                int left = 0, right = rowArr.length-1;
                while(left<=right) {
                    int mid = (left+right)/2;

                    if(rowArr[mid] == target) {
                        return true;
                    } else if( rowArr[mid] < target) {
                        left=mid+1;
                    } else {
                        right=mid-1;
                    }
                }

            }
        }
        
        return false;
    }
}
