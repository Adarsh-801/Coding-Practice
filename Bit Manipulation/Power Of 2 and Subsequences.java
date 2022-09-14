QUESTION LINK - https://practice.geeksforgeeks.org/problems/power-of-2-and-subsequences0759/1
EXPLANATION LINK - https://www.youtube.com/watch?v=vvU9HuwtRWQ
  
======================================================================ANSWER===========================================================================================
  
class Solution{
    static Long numberOfSubsequences(int N, ArrayList<Long> A){
        
        int mod = 1000000007;
        Long ans = (long) 0;
        
        for (int i = 0; i < N; i++)
        {
            Long temp = A.get(i);
            
            if (temp != 0 && (temp & temp - 1) == 0){
                ans = (2* ans + 1) % mod;
            }
        }
        
        return ans;
    }
}
