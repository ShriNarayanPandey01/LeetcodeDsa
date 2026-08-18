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
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> trav =  new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if(root!=null)
        q.offer(root);
        while( q.size() > 0){
            List<Integer> temp = new LinkedList<>();
            Queue<TreeNode> t = new LinkedList<>();
            while(q.size()>0){
                TreeNode node = q.poll();
                temp.add(node.val);
                if( node.left!= null)
                t.offer(node.left);
                if( node.right != null)
                t.offer(node.right);
            }
            q.addAll(t);
            trav.add(temp);

        }
        return trav;
    }
}