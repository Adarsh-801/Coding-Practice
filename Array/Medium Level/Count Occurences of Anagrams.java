QUESTION LINK - https://practice.geeksforgeeks.org/problems/count-occurences-of-anagrams5839/1

EXPLANATION LINK - https://www.youtube.com/watch?v=MW4lJ8Y0xXk&list=PL_z_8CaSLPWeM8BDJmIYDaoQ5zuwyxnfj&index=5

APPROACHES - 1.SLIDING WINDOW TECHNIQUE
             2.OPTIMIZED APPROACH
=================================================================ANSWER================================================================================================
  
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        
        int k = pat.length();  //window size
        int ans = 0;           //final ans
        
        //hashmap to store frequence of each character in pattern string
        HashMap<Character , Integer> hm = new HashMap<>();
        for(int i=0; i<k; i++){
            char ch = pat.charAt(i);
            if(hm.containsKey(ch)){
                hm.put( ch , hm.get(ch)-1);
            }
            else{
                hm.put(ch , 1);
            }
        }
        //now the hasmap is filled
        
        
        //NOW WE START THE SLIDING WINDOW ALGO
        int i=0;
        int j=0;
        int count = hm.size();
        
        while(j < txt.length()){
            char ch = txt.charAt(j);
            
            //calculation
            if(hm.containsKey(ch)){
                hm.put( ch , hm.get(ch) -1);
                
                if(hm.get(ch) == 0)  
                    count--;
            }
            
            //moving j until the window size is met
            if(j-i+i == k){
                j++;
            }
            
            //now we work when the window size is met
            else if(j-i+1 == k){
                
                //if count of hashmap == 0 it means we have founf an anagram 
                if(count == 0)
                    ans++ ;
                    
                //now before sliding i put back the frequency of the ith carachter
                char ch1 = txt.charAt(i);
                if(hm.containsKey(ch1)){
                    hm.put( ch1 , hm.get(ch1)+1);
                    
                    //the moment any element of the anagram has frequency more
                    //than one increment the count 
                    if(hm.get(ch1) == 1)
                        count++;
                }
                
                //now slide the window
                i++;
                j++;
            }
        }
        
        return ans;
    }
}

--------------------------------------------------------------------------------------------------------------------------------------------------------------------
  
  
  
//{ Driver Code Starts
// Initial Template for Java

import java.io.*;
import java.util.*;

class GFG {
    // Driver code
    public static void main(String[] args) throws Exception {
        BufferedReader br =
            new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while (t-- > 0) {
            String txt = br.readLine().trim();
            String pat = br.readLine().trim();

            int ans = new Solution().search(pat, txt);

            System.out.println(ans);
        }
    }
}
// } Driver Code Ends


// User function Template for Java

class Solution {

    int search(String pat, String txt) {
        
        HashMap<Character, Integer> patMap = new HashMap<>();
        
        for(char ch : pat.toCharArray()) {
            patMap.put(ch, patMap.getOrDefault(ch, 0)+1);
        }
        
        int uniqueCharsMatchingCnts = 0; // increase it only when all counts of a desired/pattern's 
                                         //character is found in window of size pat.length()..
                                         
        HashMap<Character, Integer> winMap = new HashMap<>();

        int left=0;
        int right=0;
        int answer=0;
        
        while(right<txt.length()) {
            char ch=txt.charAt(right);
            
            if(!patMap.containsKey(ch)) {
            // start another window from here..
                right++;
                left=right;
                uniqueCharsMatchingCnts=0;
                winMap.clear();
            } 
            
            else {
                int count=winMap.getOrDefault(ch, 0)+1;
                int patCnt=patMap.get(ch);
                
                if(count == patCnt) {
                    uniqueCharsMatchingCnts++;
                }
                
                winMap.put(ch, count);
                // remove until current character count becomes 0. i.e. slide window 
                //from left towards right until extra repeated character is removed.
                
                while(winMap.get(ch) > patCnt && left<right) {
                    char leftCh = txt.charAt(left);
                    
                    if(winMap.get(leftCh).equals(patMap.get(leftCh))) {
                    uniqueCharsMatchingCnts--; // this character's all counts 
                                               //will not match anymore with pattern's
                                               //count so number of matching chars drops by 1.
                    }
                    
                    winMap.put(leftCh, winMap.get(leftCh)-1);
                    left++;
                }
                
                if(uniqueCharsMatchingCnts == patMap.size()) {
                    
                    answer++;
                    // move left pointer forward. 
                    //i.e. remove characters from window from left..
                    
                    winMap.put(txt.charAt(left), winMap.get(txt.charAt(left))-1);
                    uniqueCharsMatchingCnts--; // because txt.charAt(left)'s count was matching 
                                               //with pattern's count. now its not 
                                               //as its dropped from window.
                    left++;
                }
                right++;
            }
        }
        return answer;
    }
}
