QUESTION LINK - https://practice.geeksforgeeks.org/problems/next-larger-element-1587115620/1
EXPLANATION LINK - https://www.youtube.com/watch?v=rSf9vPtKcmI
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    //Function to find the next greater element for each element of the array.
    public static long[] nextLargerElement(long[] arr, int n)
    { 
        Stack<Long> st = new Stack<>();
        long[] ans = new long[n];
        
        st.push(arr[n-1]);
        ans[n-1] = -1;
        
        for(int i=n-2 ; i>=0; i--){
            
            while(!st.isEmpty() && arr[i] >= st.peek()){
                st.pop();
            }
            
            if(st.size() == 0)  ans[i] = -1;
            else ans[i] = st.peek();
            
            st.push(arr[i]);
        }
        
        return ans;
    } 
}
