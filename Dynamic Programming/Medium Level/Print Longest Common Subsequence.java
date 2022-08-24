QUESTION LINK - https://www.geeksforgeeks.org/printing-longest-common-subsequence/
  
EXPLANATION LINK - https://www.youtube.com/watch?v=-zI4mrF2Pb4
  
=====================================================================ANSWER==========================================================================================
  
  
/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
class GFG {
	public static void main (String[] args) {
		
		Scanner sc = new Scanner(System.in);
		String s = sc.nextLine();
		String t = sc.nextLine();
		
		lcs(s,t);
	}
	
	public static void lcs(String s, String t) {
        
        int m = s.length();
        int n = t.length();
        
        int dp[][] = new int[m+1][n+1];
        
        for(int i=0; i<dp.length; i++){
            for(int j=0; j<dp[0].length; j++){
                
                if(i==0 || j==0)
                    dp[i][j] = 0;
            }
        }
        
        for(int i=1; i<dp.length; i++){
            for(int j=1; j<dp[0].length; j++){
                
                if(s.charAt(i-1) == t.charAt(j-1)){
                    dp[i][j] = 1 + dp[i-1][j-1];
                }
                
                else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        
        int i=m;
        int j=n;
        ArrayList<Character> list = new ArrayList<>();
        
        while(i>0 && j>0){
            if(s.charAt(i-1) == t.charAt(j-1)){
                list.add(s.charAt(i-1));
                
                i--;
                j--;
            }
            else if(dp[i-1][j] > dp[i][j-1]){
                i--;
            }
            else{
                j--;
            }
        }
        
        String answer = "";
        for(int k=list.size()-1; k>=0; k--){
            answer += list.get(k);
        }
        
        System.out.println(answer);
    }
}
