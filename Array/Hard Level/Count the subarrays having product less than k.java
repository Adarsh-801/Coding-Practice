QUESTION LINK - https://practice.geeksforgeeks.org/problems/count-the-subarrays-having-product-less-than-k1708/1?page=1&difficulty[]=2&curated[]=7&sortBy=difficulty
EXPLANATION LINK - https://www.youtube.com/watch?v=X6oTiMTPzjw
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    
    public int countSubArrayProductLessThanK(long arr[], long n, long k)
    {   
        //base case
        if(k<=1) return 0;
        
        long product = 1;
        int res = 0;

        int si = 0;
        int ei = 0;

        while (ei < arr.length) {
            
            //calculating the product of the window            
            product *= arr[ei];

            //if the product is more than k then move the si forward 
            //and before doing that divide the current product by si index element
            while (product >= k) {
                product /= arr[si];
                si++;
            }
            
            //now if the produtc is less that k then add the legnth of the window to the
            //current number of valid subrrays -> deduced via observation
            //length of subarray = (ei-si+1)
            res += (ei - si + 1);
            
            //then increment the end pointer
            ei++;
        }
        
        //return the result at the end
        return res;
    }
}
