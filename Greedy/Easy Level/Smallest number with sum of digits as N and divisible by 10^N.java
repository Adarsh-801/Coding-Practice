QUESTION LINK - https://practice.geeksforgeeks.org/problems/smallest-number-with-sum-of-digits-as-n-and-divisible-by-10n4032/1
EXPLANATION LINK - https://www.youtube.com/watch?v=T9ogAK8a6QI
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    public String digitsNum(int N)
    {
        int val = N/9;
        
        StringBuilder sb = new StringBuilder();
        
        //take 299 as example to understand
        if( N%9 != 0){
            sb.append(N%9);
        }
        
        for(int i=0; i<val; i++){
            sb.append("9");
        }
        
        for(int i=0; i<N; i++){
            sb.append("0");
        }
        
        return sb.toString();
    }
}
