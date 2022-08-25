QUESTION LINK - 
  
APPRAOCH - Create a hashmap and store the frequency of each element of the array. Now search for all the keys in the hashmap with frequency greator than 1
           then add them all in an arraylist. If the size of array list is 0 then add -1 to the arraylist. Finally SORT the arraylist and return it.
  
=======================================================================ANSWER==========================================================================================
  
//{ Driver Code Starts
import java.io.*;
import java.util.*;
import java.util.Map.Entry;

class GFG {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while (t-- > 0) {
            int n = sc.nextInt();
            int[] a = new int[n];
            for (int i = 0; i < n; i++) a[i] = sc.nextInt();
            Solution g = new Solution();
            ArrayList<Integer> ans = g.duplicates(a, n);
            for (Integer val : ans) System.out.print(val + " ");
            System.out.println();
        }
    }
}

// } Driver Code Ends

class Solution {
    public static ArrayList<Integer> duplicates(int arr[], int n) {
        
        HashMap<Integer , Integer> map = new HashMap<>();
        
        for(int i=0; i<arr.length; i++){
            
            if(map.containsKey(arr[i])){
                int oldFreq = map.get(arr[i]);
                int newFreq = oldFreq + 1;
                map.put(arr[i] , newFreq);
            }
            else{
                map.put(arr[i] , 1);
            }
        }
        
        ArrayList<Integer> list = new ArrayList<>();
        
        for(int key : map.keySet()){
            if(map.get(key) > 1){
                list.add(key);
            }
        }
        
        if(list.size() == 0){
            list.add(-1);
        }
        
        Collections.sort(list);
        
        return list;
    }
}
