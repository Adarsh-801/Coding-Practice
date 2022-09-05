QUESTION LINK - https://practice.geeksforgeeks.org/problems/majority-element-1587115620/1
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    static int majorityElement(int a[], int size)
    {
        int k = size/2;
        int ans = -1;
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //filling the hashmap;
        for(int i=0; i<size; i++){
            if(hm.containsKey(a[i])){
                int of = hm.get(a[i]);
                hm.put(a[i] , of+1);
            }
            else{
                hm.put(a[i] , 1);
            }
        }
        
        for(int key : hm.keySet()){
            if(hm.get(key) > k){
                ans = key;
                break;
            }
        }
        
        return ans;
    }
}
