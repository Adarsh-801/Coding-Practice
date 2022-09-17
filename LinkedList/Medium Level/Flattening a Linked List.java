QUESTION LINK - https://practice.geeksforgeeks.org/problems/flattening-a-linked-list/1
EXPLANATION LINK - https://www.youtube.com/watch?v=97rrJF7qYTo
  
======================================================================ANSWER===========================================================================================
  
class GfG
{
    Node flatten(Node root)
    {
	    if(root == null || root.next == null)   
	        return root;
	        
	    return merge( root , flatten(root.next));
    }
    
    Node merge(Node h1, Node h2){
        
        if(h1 == null) return h2;
        if(h2 == null) return h1;
        
        Node result = null;
        
        if(h1.data < h2.data){
            result = h1;
            h1 = h1.bottom;
            result.bottom = merge(h1 , h2);
        }
        
        else{
            result = h2;
            h2 = h2.bottom;
            result.bottom = merge(h1 , h2);
        }
        
        result.next = null;
        return result;
    }
}
