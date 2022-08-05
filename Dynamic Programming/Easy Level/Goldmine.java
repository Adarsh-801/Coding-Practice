QUESTION LINK - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/goldmine-official/ojquestion

======================================================================================================================================================================
========================================================================ANSWER========================================================================================
 
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        //taking input
        Scanner sc = new Scanner(System.in);
        int numRow = sc.nextInt();
        int numCol = sc.nextInt();
        
        int[][] arr = new int[numRow][numCol];
        for(int i=0; i<numRow; i++){
            for(int j=0; j<numCol; j++){
                arr[i][j] = sc.nextInt();
            }
        }
        
        //creating dp matrix
        int[][] dp = new int[numRow][numCol];
        
        //filling the dp matrix
        for(int j= dp[0].length-1; j >= 0 ;j--){
            for(int i=0; i<dp.length; i++){
                
                //last column
                if(j == dp[0].length-1){
                  dp[i][j] = arr[i][j];  
                }
                
                //first row
                else if(i == 0){
                    dp[i][j] = arr[i][j] + Math.max(dp[i][j+1], dp[i+1][j+1]);
                }
                
                //last row
                else if(i == dp.length - 1){
                   dp[i][j] =  arr[i][j] + Math.max (dp[i-1][j+1] , dp[i][j+1]);
                }
                
                //every other position
                else{
                    dp[i][j] = arr[i][j] + Math.max(dp[i-1][j+1],Math.max(dp[i][j+1] , dp[i+1][j+1]));
                }
            }
        }
        
        int max = Integer.MAX_VALUE;
        for(int i = 0; i<dp.length; i++){
            if(dp[i][0] > max){
                max = dp[i][0];
            }
        }
        
        System.out.println(max);
    }

}
