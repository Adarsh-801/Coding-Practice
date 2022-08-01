QUESTION LINK - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-official/ojquestion#!

======================================================================================================================================================================
================================================================ANSWERS===============================================================================================

-----------------------------------------------------------------MEMOIZATION APPROACH---------------------------------------------------------------------------------
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int dp[] = new int[n+1];
        int answer = countPaths(n , dp);
        System.out.println(answer);
    }
    
    public static int countPaths(int n, int[] dp){
        
        if(n == 0){
            return 1;
        }
        else if(n < 0 ){
            return 0;
        }
        
        if(dp[n] > 0){
            return dp[n];
        }
        int way1 = countPaths(n-1 , dp);
        int way2 = countPaths(n-2, dp);
        int way3 = countPaths(n-3, dp);
        int totalWays = way1+way2+way3;
        
        dp[n] = totalWays;
        
        return totalWays;
        
    }

}

----------------------------------------------------------------------TABULATION APPROACH--------------------------------------------------------------------------


import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int answer = countPathsTabulation(n);
        System.out.println(answer);
    }
    
    public static int countPathsTabulation(int n){
        
        int dp[] = new int[n+1];
        
        dp[0] = 1;
        for(int i=1; i<=n; i++){
            
            if(i==1){
                dp[i] = dp[i-1];
            }
            else if(i==2){
                dp[i] = dp[i-1] + dp[i-2];
            }
            else{
                dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
            }
        }
        
        return dp[n];
        
    }
    
    

}
