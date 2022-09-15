QUESTION LINK - https://practice.geeksforgeeks.org/problems/sort-a-stack/1
EXPLANATION LINK - https://www.youtube.com/watch?v=MOGBRkkOhkY
                   https://www.youtube.com/watch?v=lDThYwMDNTU
  
======================================================================ANSWER===========================================================================================
  
class GfG{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		//base case
		if(s.isEmpty()) return s;
		
		int temp = s.pop();
		
		sort(s);
		
		insert_at_correct_position(s , temp);
		
		return s;
	}
	
	public static void insert_at_correct_position(Stack<Integer> s ,int temp){
	    
	    if(s.isEmpty() || s.peek() < temp)  {
	        s.push(temp);
	        return;
	    }
	    
	    int temp2 = s.pop();
	    insert_at_correct_position(s , temp);
	    s.push(temp2);
	    
	   // return s;
	}
	
}
