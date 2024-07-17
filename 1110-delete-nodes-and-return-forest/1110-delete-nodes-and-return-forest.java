/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    public List<TreeNode> delNodes(TreeNode root, int[] to_delete) {
        List<TreeNode> ret = new LinkedList<>();
        TreeNode ad = dfs(root,to_delete,ret);
        if(ad!=null)
        ret.add(ad);
        return ret;
        
    }
    public TreeNode dfs(TreeNode root , int[] delete, List<TreeNode> ret){
        if(root==null)
        return null;

        root.left = dfs(root.left,delete,ret);
        root.right = dfs(root.right,delete,ret);

        for(int i:delete)
        if(i==root.val){
            if(root.left!=null)
            ret.add(root.left);
            if(root.right!=null)
            ret.add(root.right);
            return null;
        }
        return root;
    }
}