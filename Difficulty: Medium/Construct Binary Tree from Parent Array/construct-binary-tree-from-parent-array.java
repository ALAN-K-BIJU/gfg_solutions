//{ Driver Code Starts
import java.lang.*;
import java.util.*;

class Node {
    int data;
    Node left, right;

    Node(int key) {
        data = key;
        left = right = null;
    }
}

class CreateTree {
    static ArrayList<Integer> result = new ArrayList<Integer>();

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int arr[] = new int[n];

            for (int i = 0; i < n; i++) arr[i] = sc.nextInt();

            Solution ob = new Solution();
            Node root = ob.createTree(arr);

            printLevelOrder(root);
            System.out.println();
        }
    }

    public static void printList(Node root) {
        while (root != null) {
            System.out.print(root.data + " ");
        }
    }

    public static void printLevelOrder(Node root) {
        int h = height(root);
        int i;
        for (i = 1; i <= h; i++) {
            result.clear();
            printGivenLevel(root, i);
            Collections.sort(result);
            for (int j = 0; j < result.size(); j++)
                System.out.print(result.get(j) + " ");
        }
    }

    public static int height(Node root) {
        if (root == null)
            return 0;

        else {

            int lheight = height(root.left);
            int rheight = height(root.right);

            if (lheight > rheight)
                return (lheight + 1);
            else
                return (rheight + 1);
        }
    }

    public static void printGivenLevel(Node node, int level) {
        if (node == null) return;
        if (level == 1)
            result.add(node.data);
        else if (level > 1) {
            printGivenLevel(node.left, level - 1);
            printGivenLevel(node.right, level - 1);
        }
    }
}

// } Driver Code Ends


/*node class of the binary tree
class Node
{
    int data;
    Node left, right;
    Node(int key)
    {
        data = key;
        left = right = null;
    }
}*/
class Solution {
    // Function to construct binary tree from parent array.
    public Node createTree(int parent[]) {
        int n = parent.length;
        Node[] created = new Node[n];
        
        // Initialize nodes
        for (int i = 0; i < n; i++) {
            created[i] = new Node(i);
        }
        
        Node root = null;
        
        for (int i = 0; i < n; i++) {
            // If parent[i] is -1, then i is the root
            if (parent[i] == -1) {
                root = created[i];
            } else {
                // Find parent node
                Node parentNode = created[parent[i]];
                
                // If this is the first child
                if (parentNode.left == null) {
                    parentNode.left = created[i];
                } else {
                    parentNode.right = created[i];
                }
            }
        }
        
        return root;
    }
    
    // Helper function to print level order traversal
    public void printLevelOrder(Node root) {
        if (root == null) return;
        
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        
        while (!queue.isEmpty()) {
            Node tempNode = queue.poll();
            System.out.print(tempNode.data + " ");
            
            if (tempNode.left != null) {
                queue.add(tempNode.left);
            }
            
            if (tempNode.right != null) {
                queue.add(tempNode.right);
            }
        }
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        
        int parent1[] = {-1, 0, 0, 1, 1, 3, 5};
        Node root1 = sol.createTree(parent1);
        sol.printLevelOrder(root1); // Expected Output: 0 1 2 3 4 5 6
        
        System.out.println();
        
        int parent2[] = {2, 0, -1};
        Node root2 = sol.createTree(parent2);
        sol.printLevelOrder(root2); // Expected Output: 2 0 1
    }
}