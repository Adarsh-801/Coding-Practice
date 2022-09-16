QUESTION LINK - https://practice.geeksforgeeks.org/problems/leaf-at-same-level/1
  
======================================================================ANSWER===========================================================================================
  
class Solution
{
    boolean check(Node root)
    {
	    if(root == null)	return true;
	    Set<Integer> set = new HashSet<>();
	    
	    help(root , 0 , set);
	    
       //if all leaf are at same level then size of set would be 1 coz in 
	    //set there can be no duplicates
	    //if the size of set is more than 1 it means there exists leaves that
	    //are not at the same level sp we return false in that case
	    if(set.size() == 1)     return true;
	    else                    return false;
    }
    
    void help(Node root , int level, Set<Integer> set){
        
        if(root == null) return;
        
        if(root.left == null & root.right == null){
            set.add(level);
            return;
        }
        
        help(root.left , level+1 , set);
        help(root.right , level+1 , set);
    }
}
