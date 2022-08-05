QUESTION LINK - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-minimum-moves-official/ojquestion

======================================================================================================================================================================
========================================================================ANSWER========================================================================================
  
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        //taking input array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        //creating dp array
        Integer dp[] = new Integer[n+1];
        
        //no. of moves form nth step to nth step itself = 0
        dp[n] = 0;
        
        //filling the dp array
        for(int i=n-1; i>=0 ; i--){
            
            if(arr[i] > 0){
                
                int min = Integer.MAX_VALUE;
                
                for(int j = 1; j<=arr[i] && i+j<dp.length; j++){
                    if(dp[i+j] != null){
                        min = Math.min(min , dp[i+j]);   
                    }
                }
                
                
                if(min != Integer.MAX_VALUE){
                    dp[i] = min+1;
                }
            }
            
        }
        
        System.out.println(dp[0]);
    }

}
