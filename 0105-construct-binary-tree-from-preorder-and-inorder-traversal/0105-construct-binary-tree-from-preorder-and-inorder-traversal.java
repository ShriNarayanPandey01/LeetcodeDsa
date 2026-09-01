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
    int k = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        return hlp(preorder , inorder , 0 , inorder.length-1);
    }
    public TreeNode hlp( int[] preorder , int[] inorder , int i , int j){
        if( i > j || k >= inorder.length){
            k--;
            return null;
        }
        if(i == j){
            return new TreeNode(inorder[i]);
        }
        TreeNode root = new TreeNode(preorder[k]);
        for( int a = i ; a <= j ; a++){
            if( preorder[k] == inorder[a]){
                k++;
                root.left = hlp(preorder , inorder , i , a-1);
                k++;
                root.right = hlp(preorder , inorder , a+1 , j);
                break;
            }
        }
        return root;

    }

    
}