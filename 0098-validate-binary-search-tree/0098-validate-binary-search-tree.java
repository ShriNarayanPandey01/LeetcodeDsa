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
    
    public boolean isValidBST(TreeNode root) {
        return hlp(root , Long.MAX_VALUE , Long.MIN_VALUE);
    }
    public boolean hlp( TreeNode node , long max , long min){
        if( node == null) return true;
        if( node.val <= min || node.val >= max) return false;
        return hlp( node.left , node.val , min ) && hlp( node.right , max , node.val );
        
    }
}