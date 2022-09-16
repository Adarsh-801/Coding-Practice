QUESTION LINK - https://practice.geeksforgeeks.org/problems/zigzag-tree-traversal/1
EXPLANATION LINK - https://www.youtube.com/watch?v=eDdPZ05y4Os
  
======================================================================ANSWER===========================================================================================
  
class GFG
{

	ArrayList<Integer> zigZagTraversal(Node root)
	{
	    
	    ArrayList<Integer> ans = new ArrayList<>();
	    
        Stack<Node> mainStack = new Stack<>();
        mainStack.push(root);
        
        Stack<Node> childStack = new Stack<>();
        int currentLevel = 1;
        
        while(!mainStack.isEmpty()){
            
            Node temp = mainStack.pop();
            ans.add(temp.data);
            
            //odd level
            if(currentLevel % 2 == 1){
                if(temp.left != null) childStack.push(temp.left);
                if(temp.right != null) childStack.push(temp.right);
            }
            //even level
            else{
                if(temp.right != null) childStack.push(temp.right);
                if(temp.left != null) childStack.push(temp.left);
            }
            
            if(mainStack.size() == 0){
                mainStack = childStack;
                childStack = new Stack<>();
                currentLevel++;
            }
        }
        
        return ans;
	}
}
