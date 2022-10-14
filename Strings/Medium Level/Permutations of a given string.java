QUESTION LINK - https://practice.geeksforgeeks.org/problems/permutations-of-a-given-string2041/1
EXPLANATION LINK - https://www.youtube.com/watch?v=sPAT_DbvDj0
  
======================================================================ANSWER===========================================================================================
  
  
class Solution {
    
    List<String> ans = new ArrayList<>();
    HashSet<String> hs = new HashSet<>();
    
    public List<String> find_permutation(String S) {
        
        helper(S , "" , hs);
        
        for(String s : hs){
            ans.add(s);
        }
        
        Collections.sort(ans);
        return ans;
        
    }
    
    
    public static void helper(String S, String ans_so_far, HashSet<String> hs){
        
        if(S.length() == 0){
            hs.add(ans_so_far);
            return;
        }
        
        for(int i=0; i<S.length(); i++){
            char ch = S.charAt(i);
            String left_part = S.substring(0 , i);
            String right_part = S.substring(i+1);
            
            String small_question = left_part + right_part;
            
            helper(small_question , ans_so_far+ch , hs);
        }
    }
}
