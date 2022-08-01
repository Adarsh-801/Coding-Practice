QUESTION LINK - https://www.pepcoding.com/resources/online-java-foundation/dynamic-programming-and-greedy/climb-stairs-with-variable-jumps-official/ojquestion#


======================================================================================================================================================================
====================================================================ANSWERS===========================================================================================
  
import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        
        //taking the input array
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();
        }
        
        //creating the tabulation array
        int[] dp = new int[n+1];
        
        
        //no. of ways from nth step to nth step itself = 1
        dp[n] = 1;
        
        
        //filling the tabulation array
        // i = dp[] iterator
        //j = arr[] iterator
        for(int i = n-1; i>=0; i--){
            
            for(int j=1; j<=arr[i] && i+j<dp.length; j++){
                dp[i] += dp[i+j];
            }
        }
        
        System.out.println(dp[0]);
    }

}
