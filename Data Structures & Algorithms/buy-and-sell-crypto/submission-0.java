class Solution {
    public int maxProfit(int[] prices) {
        int maxProfit=0;
        
        for(int minIndex = 0; minIndex < prices.length; minIndex++) {
            int maxIndex = minIndex+1;

            while(maxIndex < prices.length) {
                int diff = prices[maxIndex] - prices[minIndex];
                maxIndex++;   
                if(diff > maxProfit) {
                    maxProfit = diff;
                }
            }
        }
        
        return maxProfit > 0 ? maxProfit : 0;
    }
}
