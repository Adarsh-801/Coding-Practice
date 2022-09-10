QUESTION LINK - https://practice.geeksforgeeks.org/problems/special-stack/1
  
======================================================================ANSWER===========================================================================================
  
class GfG{
	public void push(int a,Stack<Integer> s)
	{
	    s.push(a);
	}
	public int pop(Stack<Integer> s)
    {
        int a = -1;
        if(!s.isEmpty())  a = s.pop();
        return a;
	}
	public int min(Stack<Integer> s)
    {
           int min = Integer.MAX_VALUE;
           while(!s.isEmpty()){
               int a = s.pop();
               min = Math.min(a , min);
           }
           return min;
	}
	public boolean isFull(Stack<Integer>s, int n)
    {
        if(s.size() >= n)  return true;
        else return false;
	}
	public boolean isEmpty(Stack<Integer>s)
        {
           if(s.size() == 0)  return true;
           else return false;
	}
}
