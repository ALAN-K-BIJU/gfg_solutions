/* A Binary Tree node
class Node
{
    int data;
    Node left, right;

    Node(int item)
    {
        data = item;
        left = right = null;
    }
}*/
class Solution {
    // Function to return list containing elements of left view of binary tree.
    ArrayList<Integer> leftView(Node root) {
        // code here
        ArrayList<Integer> list = new ArrayList<>();
        solve(root, list, 0);
        return list;
    }
    private void solve(Node root, ArrayList<Integer> list, int level){
        if(root == null) return;
        if(list.size() == level) list.add(root.data);
        solve(root.left, list, level + 1);
        solve(root.right, list, level + 1);
    }
}