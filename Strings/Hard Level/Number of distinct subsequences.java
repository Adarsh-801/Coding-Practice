QUESTION LINK - https://practice.geeksforgeeks.org/problems/number-of-distinct-subsequences0909/1
EXPLANATION LINK - 1. Using Recursion - https://www.youtube.com/watch?v=Sa5PmCFF_zI&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=25
                   2. Using Dymanic Programming - https://www.youtube.com/watch?v=9UEHPiK53BA
  
======================================================================ANSWER===========================================================================================
  
  
class Solution {
    
    int distinctSubsequences(String S) {
        
        Set<String> arr = helper(S);
        
        return arr.size();
    }
    
    
  Set<String> helper(String S){
        
        if(S.length() == 0){
            Set<String> baseResult = new HashSet<>();
            baseResult.add("");
            return baseResult;
        }
        
        String smallString = S.substring(1);
        Set<String> smallAns = helper(smallString);
        
        Set<String> ans = new HashSet<>();
        for(String str : smallAns){
            ans.add(S.charAt(0) + str);
            ans.add("" + str);
        }

         return ans;
    }
}


--------------------------------------------------------------OPTIMIZED APPROACH------------------------------------------------------------------------------------
  
class Solution {
    int distinctSubsequences(String S) {
        
        int n = S.length();
        int mod = 1000000007;
        
        HashMap<Character , Integer> lastOccurence = new HashMap<>();
        
        int[] dp = new int[n+1];
        dp[0] = 1;
        
        for(int i=1; i<dp.length; i++){
            
            dp[i] = (2*dp[i-1])%mod ;
            
            char ch = S.charAt(i-1);
            
            if(lastOccurence.containsKey(ch)){
                int j = lastOccurence.get(ch);
                dp[i] = (dp[i] - dp[j-1] + mod)%mod ;
            }
            
            lastOccurence.put(ch , i);
        }
        
        int ans = dp[n];
        
        return (ans)%mod;
    }
}
  
