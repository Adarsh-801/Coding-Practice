QUESTION LINK - https://practice.geeksforgeeks.org/problems/form-a-palindrome1455/1
  
EXPLANATION LINK - https://youtu.be/AEcRW4ylm_c?list=PL_z_8CaSLPWekqhdCPmFohncHwz8TY2Go

=============================================================================ANSWER====================================================================================
  
  
//{ Driver Code Starts
import java.io.*;
import java.util.*; 

class GFG{
    public static void main(String args[]) throws IOException { 
        BufferedReader read = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(read.readLine());
        
        while(t-- > 0){
            String str = read.readLine();

            Solution ob = new Solution();
            
            System.out.println(ob.countMin(str));
        }
    } 
} 
// } Driver Code Ends


//User function Template for Java

class Solution{
    static int countMin(String s1)
    {
        String s2 = reverse(s1);
        
        int m = s1.length();
        int n = s2.length();
        
        int lcs_length =  lcs(s1 ,s2, m, n);
        
        int deletions = m - lcs_length;
        
        return deletions;
    }
    
    static String reverse(String s1){
        
        String rev_s1 = "";
        for(int i = s1.length()-1; i>=0; i--){
            rev_s1 += s1.charAt(i);
        }
        
        return rev_s1;
    }
    
    static int lcs(String s1 , String s2, int m , int n){
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0){
                    dp[i][j] = 0;
                }
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(s1.charAt(i-1) == s2.charAt(j-1))
                    dp[i][j] = 1 + dp[i-1][j-1];
                    
                else{
                    dp[i][j] = Math.max( dp[i-1][j] , dp[i][j-1] );
                }
            }
        }
        
        return dp[m][n];
    }
}
