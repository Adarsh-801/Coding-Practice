QUESTION LINK - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/target-sum-subsets-dp-official/ojquestion

======================================================================================================================================================================
========================================================================ANSWER========================================================================================
  
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        
        int target = sc.nextInt();
        
        boolean[][] dp = new boolean[n+1][target+1];
        
        for(int i=0; i<dp.length; i++){
            for(int  j=0; j<dp[0].length; j++){
                
                //first cell
                if(i==0 && j==0){
                    dp[i][j] = true;
                }
                
                //first row
                else if(i==0){
                    dp[i][j] = false;
                }
                
                //first column
                else if(j==0){
                    dp[i][j] = true;
                }
                
                //rest all the cells
                else{
                    
                    if(dp[i-1][j] == true){
                        dp[i][j] = true;
                    }
                    else{
                        
                        int val = arr[i-1];
                        if(j >= val){
                            if(dp[i-1][j-val] == true){
                                dp[i][j] = true;
                            }
                        }
                    }
                }
            }
        }
        
        System.out.println(dp[dp.length-1][target]);
    }
}
