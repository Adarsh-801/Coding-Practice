QUESTION LINK - https://practice.geeksforgeeks.org/problems/find-missing-and-repeating2512/1
APPROACH - 1. Using hashmap (got TLE at 326/340 test cases)
           2. Using arrays only.
  
======================================================================ANSWER===========================================================================================
  
class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        Arrays.sort(arr);
        int[] ans = new int[2];
        HashMap<Integer, Integer> hm = new HashMap<>();
        
        //filling the hashmap
        for(int i=0; i<n; i++){
            if(hm.containsKey(arr[i])){
                int of = hm.get(arr[i]);
                hm.put(arr[i] , of+1);
            }
            else{
                hm.put( arr[i] , 1);
            }
        }
        
        //finding the repeating element
        for(int key : hm.keySet()){
            if( hm.get(key) > 1){
                ans[0] = key;
                break;
            }
        }
        
        //finding the missing element
        for(int i=1; i<=n; i++){
            if(!hm.containsKey(i)){
                ans[1] = i;
                break;
            }
        }
        
        return ans;
    }
}


  
-----------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
class Solve {
    int[] findTwoElement(int arr[], int n) {
        
        int ans[] = new int[2];
        Arrays.sort(arr);
        int a = 0; 
        int b = 1;
        
        for(int i=0; i<n-1; i++){
            if(arr[i] == arr[i+1]){
                ans[0] = arr[i];
                break;
            }
        }
        
        for(int i=0; i<n; i++){
            
            while(b == arr[i]){
                b++;
            }
        }
        
        ans[1] = b;
        
        return ans;
    }
}
