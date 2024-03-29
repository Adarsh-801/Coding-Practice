QUESTION LINK - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/min-cost-maze-traversal-official/ojquestion

======================================================================================================================================================================
========================================================================ANSWER========================================================================================
  
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        //taking input
        
        Scanner sc = new Scanner(System.in);
        int row = sc.nextInt();
        int col = sc.nextInt();
        int[][] arr = new int [row][col];
        
        for(int i =0; i<arr.length; i++ ){
            for(int j = 0; j<arr[0].length; j++){
               arr[i][j] = sc.nextInt(); 
            }
        }
        
        // creating the dp matrix
         int[][] dp = new int[row][col];
          
         // filling dp matrix
        
        for(int i =dp.length-1; i>=0; i-- ){
            for(int j = dp[0].length - 1; j>=0; j--){
               
               if(i == dp.length-1 && j== dp[0].length-1 ){
                   dp[i][j] = arr[i][j];
               } 
               
               else if(i == dp.length-1){
                   dp[i][j] = arr[i][j] + dp[i][j+1];
               }
               
               else if(j== dp[0].length-1){
                   dp[i][j] = arr[i][j] + dp[i+1][j];
               }
               
               else{
                 dp[i][j] = arr[i][j] + Math.min(dp[i][j+1],dp[i+1][j]);
               }
            }
        }
        
        System.out.println(dp[0][0]);
        
        
    }

}
