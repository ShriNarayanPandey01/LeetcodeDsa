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
    HashMap<Integer , Integer> map;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        map = new HashMap<>();
        for( int i = 0 ; i< inorder.length ; i++)
            map.put(inorder[i], i);
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
        int a = map.get(preorder[k]);
        if( a >= i && a <= j){
            k++;
            root.left = hlp(preorder , inorder , i , a - 1);
            k++;
            root.right = hlp(preorder , inorder , a + 1 , j);
        }
        return root;

    }

    
}