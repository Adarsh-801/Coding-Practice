QUESTION LINK - https://practice.geeksforgeeks.org/problems/904237fa926d79126d42c437802b04287ea9d1c8/1
  
======================================================================ANSWER===========================================================================================
  
  
class Solution { 
    public int minLength(String s, int n) { 
    	
    	 String arr[] = {"12", "21", "34", "43", "56", "65", "78", "87", "09", "90"};
    	 
    	 for(int i=0; i<=s.length()-2; i++){
    	     String st = s.substring(i, i+2);
    	     for(String y : arr){
    	         if(st.equals(y)){
    	             s = s.replace( st, "");
    	             i = -1;
    	             break;
    	         }
    	     }
    	 }
    	 return s.length();
    }
}
