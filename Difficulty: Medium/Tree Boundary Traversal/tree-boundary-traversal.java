/*
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
*/

class Solution {
    ArrayList<Integer> boundaryTraversal(Node node) {
        // code here
        ArrayList<Integer> ans = new ArrayList<>();
        ans.add(node.data);
        solve_left(node.left, ans);
        solve_leaf(node, ans);
        solve_right(node.right, ans);
        return ans;
    }
    void solve_left(Node c, ArrayList<Integer> ans){
        if(c == null) return;
        ans.add(c.data);
        if(c.left != null) solve_left(c.left, ans);
        else solve_left(c.right,ans);
    }
    void solve_leaf(Node c, ArrayList<Integer> ans){
        if(c == null) return;
        if(c.left == null && c.right == null){
            if(!ans.isEmpty() && ans.get(ans.size() - 1) != c.data){
                ans.add(c.data);
            }
        }
        solve_leaf(c.left, ans);
        solve_leaf(c.right, ans);
    }
    void solve_right(Node c, ArrayList<Integer> ans){
        if(c == null) return;
        if(c.right != null) solve_right(c.right, ans);
        else solve_right(c.left, ans);
        if(!ans.isEmpty() && ans.get(ans.size() - 1) != c.data){
            ans.add(c.data);
        }
    }
}