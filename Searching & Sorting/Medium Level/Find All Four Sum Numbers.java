QUESTION LINK - https://practice.geeksforgeeks.org/problems/find-all-four-sum-numbers1732/1
EXPLANATION LINK - https://www.youtube.com/watch?v=YkkReNbJdMg
  
======================================================================ANSWER===========================================================================================
  
class Solution {
    public ArrayList<ArrayList<Integer>> fourSum(int[] a, int k){
        
        ArrayList<ArrayList<Integer>> ans = new ArrayList<ArrayList<Integer>>();
        Arrays.sort(a);
        
        int n = a.length;
        
        for(int i=0; i<n-3; i++){
            int p=a[i];
            
            for(int j=i+1; j<n-2; j++){
                
                int q=a[j];
                int l=j+1 , r=n-1;
                
                while(l<r){
                    int sum = p+q+a[l]+a[r];
                    
                    if(sum==k){
                        ArrayList<Integer> ar = new ArrayList<Integer>();
                        ar.add(p);
                        ar.add(q);
                        ar.add(a[l]);
                        ar.add(a[r]);
                        Collections.sort(ar);
                        
                        if(!ans.contains(ar)) 
                            ans.add(ar);
                            
                        l++;
                        r--;
                    }
                    
                    else if(sum>k) r--;
                    
                    else l++;
                }
            }
        }
        return ans;
    }
}
