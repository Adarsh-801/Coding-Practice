QUESTION LINK - https://leetcode.com/problems/best-time-to-buy-and-sell-stock/

======================================================================================================================================================================
========================================================================ANSWER========================================================================================
  
  class Solution {
    public int maxProfit(int[] prices) {
        
        int lsf = Integer.MAX_VALUE;   //lsf = least selling price so far
        int op = 0; //op = overall profit
        int pist = 0;  //pist = profit it sold today
        
        for(int i=0; i<prices.length; i++){
            
            if(prices[i] < lsf){
                lsf = prices[i];
            }
            
            pist = prices[i] - lsf;
            if(pist > op){
                op = pist;
            }
        }
        
        return op;
    }
}



NOTE: See the following youtube video to understand the appraoch
VIDEO LINK-   https://youtu.be/4YjEHmw1MX0
