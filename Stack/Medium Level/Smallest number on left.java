QUESTION LINK - https://practice.geeksforgeeks.org/problems/smallest-number-on-left3403/1
EXPLANATION - dry run
  
======================================================================ANSWER===========================================================================================
  
class Solution{
    static List<Integer> leftSmaller(int n, int a[])
    {
        List<Integer> ans = new ArrayList<>();
        Stack<Integer> s = new Stack<>();
        
        ans.add(-1); //for first element there is no left so it will always be -1
        s.push(a[0]); //push the first element in stack
        
        for(int i=1; i<a.length; i++){
            
            while(!s.isEmpty() &&  s.peek() >= a[i]){
                s.pop();
            }
            
            if(s.isEmpty()) ans.add(-1);
            
            else if(a[i] > s.peek()) ans.add(s.peek());
            
            s.push(a[i]);
        }
        
        return ans;
    }
}
