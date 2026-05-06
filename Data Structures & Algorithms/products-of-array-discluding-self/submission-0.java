class Solution {
    public int[] productExceptSelf(int[] nums) {

        int[] productLeft = new int[nums.length];
        int[] productRight = new int[nums.length];
        
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                productLeft[i] = nums[i];
                continue;
            }

            productLeft[i] = productLeft[i-1]*nums[i];
        }

        for(int i=nums.length-1; i>=0; i--) {
            if(i==nums.length-1) {
                productRight[i] = nums[i];
                System.out.println(productRight[i]);
                continue;
            }

            productRight[i] = productRight[i+1]*nums[i];
        }

        int[] output = new int[nums.length];
        for(int i=0; i<nums.length; i++) {
            if(i==0) {
                output[i]=productRight[i+1];
            } else if(i==nums.length-1) {
                output[i]=productLeft[i-1];
            } else {
                output[i] = productLeft[i-1] * productRight[i+1];
            }
        }

        return output;
    }
}  
