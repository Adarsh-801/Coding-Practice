QUESTION LINK - https://practice.geeksforgeeks.org/problems/common-elements1132/1
  
APPROACH - Use TreeSet to implemet a Set because in TreeSet the elements are in sorted order

=====================================================================ANSWER===========================================================================================
  
//{ Driver Code Starts
//Initial Template for Java

import java.util.*;

public class GFG
{
    public static void main(String args[]) 
    {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) 
        {
            int n1 = sc.nextInt();
            int n2 = sc.nextInt();
            int n3 = sc.nextInt();
            
            int A[] = new int[n1];
            int B[] = new int[n2];
            int C[] = new int[n3];
            
            for (int i = 0;i < n1;i++)
            {
                A[i] = sc.nextInt();
            }
            for (int i = 0;i < n2;i++)
            {
                B[i] = sc.nextInt();
            }
            for (int i = 0;i < n3;i++)
            {
                C[i] = sc.nextInt();
            }
            
            Solution sol = new Solution();
            ArrayList<Integer> res = sol.commonElements(A, B, C, n1, n2, n3);
            if (res.size() == 0)
            {
                System.out.print(-1);
            }
            else 
            {
                for (int i = 0;i < res.size();i++)
                {
                    System.out.print(res.get(i) + " ");
                }    
            }
            System.out.println();
        }
    }
}


// } Driver Code Ends


//User function Template for Java

class Solution
{
    ArrayList<Integer> commonElements(int A[], int B[], int C[], int n1, int n2, int n3) 
    {
        
        Set<Integer> s1 = new TreeSet<>();
        Set<Integer> s2 = new TreeSet<>();
        Set<Integer> s3 = new TreeSet<>();
        ArrayList<Integer> answer = new ArrayList<>();
        
        //filling the set1
        for(int i=0; i<n1; i++)
            s1.add(A[i]);
        
        //filling the set2    
        for(int j=0; j<n2; j++)
            s2.add(B[j]);
            
        //filling the set3
        for(int k=0; k<n3; k++)
            s3.add(C[k]);
            
        
            
        //now filling the answer array list
        for(int i : s1){
            if(s2.contains(i) && s3.contains(i)){
                answer.add(i);
            }
            
        }
        
        return answer;
        
    }
}
