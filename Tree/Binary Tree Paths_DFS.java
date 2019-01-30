//Leetcode 257

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> result = new ArrayList<String>();
        if(root == null){
            return result;
        }
        String path = String.valueOf(root.val);
        DFS(root, result, path);
        return result;
    }
    public void DFS(TreeNode root, List<String> Result, String path){
        if(root.left == null && root.right == null){ //leaf
            Result.add(path);
            return;
        }
        String temp = path;
        if(root.left != null){
            path = temp+ "->" + String.valueOf(root.left.val);
            DFS(root.left, Result, path);
        }
        if(root.right != null){
            path = temp+ "->" + String.valueOf(root.right.val);
            DFS(root.right, Result, path);
        }
    }
}

#Time complexity : we visit each node exactly once, thus the time complexity is \mathcal{O}(N)O(N), where NN is the number of nodes.

#Space complexity : \mathcal{O}(N)O(N). Here we use the space for a stack call and for a paths list to store the answer. paths contains as many elements as leafs in the tree and hence couldn't be larger than log(N)log(N) for the trees containing more than one element. Hence the space complexity is determined by a stack call. In the worst case, when the tree is completely unbalanced, e.g. each node has only one child node, the recursion call would occur NN times (the height of the tree), therefore the storage to keep the call stack would be \mathcal{O}(N)O(N). But in the best case (the tree is balanced), the height of the tree would be \log(N)log(N). Therefore, the space complexity in this case would be \mathcal{O}(\log(N))O(log(N)). 

#Others

class Solution {
    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        if (root == null)
            return paths;
        
        LinkedList<TreeNode> node_stack = new LinkedList();
        LinkedList<String> path_stack = new LinkedList();
        node_stack.add(root);
        path_stack.add(Integer.toString(root.val));
        TreeNode node;
        String path;
        while ( !node_stack.isEmpty() ) {
            node = node_stack.pollLast();
            path = path_stack.pollLast();
            if ((node.left == null) && (node.right == null))
                paths.add(path);
            if (node.left != null) {
                node_stack.add(node.left);
                path_stack.add(path + "->" + Integer.toString(node.left.val));
            }
            if (node.right != null) {
                node_stack.add(node.right);
                path_stack.add(path + "->" + Integer.toString(node.right.val));
            }
        }
        return paths;
    }
}

Time complexity : \mathcal{O}(N)O(N) since each node is visited exactly once.
Space complexity : \mathcal{O}(N)O(N) as we could keep up to the entire tree.
