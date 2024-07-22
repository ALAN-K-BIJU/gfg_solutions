//{ Driver Code Starts
//Initial Template for Java

/*package whatever //do not write package name here */

import java.io.*;
import java.util.*;
import java.math.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the curr node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the curr node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the curr node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine();
            Node root = buildTree(s);
            
            Solution T = new Solution();
            System.out.println(T.largestBst(root));
            
            t--;
        }
    }
}


// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right; 
   
//     public Node(int d)  
//     { 
//         data = d; 
//         left = right = null; 
//     } 
// }


class Solution {
    static class SubtreeInfo {
        boolean isBST;
        int size;
        int minValue;
        int maxValue;
        SubtreeInfo(boolean isBST, int size, int minValue, int maxValue) {
            this.isBST = isBST;
            this.size = size;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }
    }
    static int largestBst(Node root) {
        return largestBstUtil(root).size;
    }
    static SubtreeInfo largestBstUtil(Node node) {
        if (node == null) {
            return new SubtreeInfo(true, 0, Integer.MAX_VALUE, Integer.MIN_VALUE);
        }

        SubtreeInfo left = largestBstUtil(node.left);
        SubtreeInfo right = largestBstUtil(node.right);

        if (left.isBST && right.isBST && node.data > left.maxValue && node.data < right.minValue) {
            int size = left.size + right.size + 1;
            int minValue = Math.min(node.data, left.minValue);
            int maxValue = Math.max(node.data, right.maxValue);
            return new SubtreeInfo(true, size, minValue, maxValue);
        } else {
            return new SubtreeInfo(false, Math.max(left.size, right.size), 0, 0);
        }
    }
}