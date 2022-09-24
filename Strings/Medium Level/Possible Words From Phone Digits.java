QUESTION LINK - https://practice.geeksforgeeks.org/problems/possible-words-from-phone-digits-1587115620/1
EXPLANATION LINK - https://www.youtube.com/watch?v=3fjt19bjs3A&list=PL-Jc9J83PIiFxaBahjslhBD1LiJAV7nKs&index=27
  
======================================================================ANSWER===========================================================================================
  
  
class Solution
{
    static String[] logbook = {"" , "abc" , "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    
    //lets take an exaple of 234
    static ArrayList <String> possibleWords(int a[], int N)
    {       
            //base case
            if(a.length == 0){
                ArrayList<String> baseRes = new ArrayList<>();
                baseRes.add("");
                return baseRes;
            }
            
            int firstNo = a[0];     //separate 2
            
            //separate 34
            int smallNo[] = new int[N-1];   
            for(int i=0; i<smallNo.length; i++){
                smallNo[i] = a[i+1];
            }
            
            //get answer of 34 using recursion
            ArrayList<String> smallAns = possibleWords(smallNo , N-1);
            
            
            //now add the characters of 2 to 34 answer to get final ans
            ArrayList<String> ans = new ArrayList<>();
            
            String s = logbook[firstNo-1]; // s = "abc"
      
            for(String str : smallAns){
              
                for(int j=0; j<s.length(); j++){
                    ans.add(s.charAt(j) + str);
                }
            }

            Collections.sort(ans);
            return ans;
            
    }
}
