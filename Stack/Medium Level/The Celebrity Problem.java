QUESTION LINK - https://practice.geeksforgeeks.org/problems/the-celebrity-problem/1
EXPLANATION LINK - https://www.youtube.com/watch?v=CiiXBvrX-5A
  
======================================================================ANSWER===========================================================================================
  
class Solution
{ 
    //Function to find if there is a celebrity in the party or not.
    int celebrity(int M[][], int n)
    {
    	Stack<Integer> st = new Stack<>();
    	
    	for(int i=0; i<M.length; i++){
    	    st.push(i);
    	}
    	
    	while(st.size() >= 2){
    	    int i = st.pop();
    	    int j = st.pop();
    	    
    	    //if i knows j then i cannot be a celebrity
    	    if(M[i][j] == 1){
    	        st.push(j);
    	    }
    	    //if i does not knows j then j cannot be a celebrity;
    	    else{
    	        st.push(i);
    	    }
    	}
    	
    	int potentialCeleb = st.pop();
    	for(int i=0; i<M.length; i++){
    	    
    	    //now check complete row and column of potentialCeleb
    	    if(i != potentialCeleb){
    	        if( M[i][potentialCeleb] == 0 || M[potentialCeleb][i] == 1){
    	            return -1;
    	        }
    	    }
    	}
    	
    	return potentialCeleb;
    }
}
