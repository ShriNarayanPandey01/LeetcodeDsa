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
    int count = 0;

    public int countPairs(TreeNode root, int distance) {
        dfs(root, distance);
        return count;
    }

    public List<Integer> dfs(TreeNode root, int dist) {
        if (root == null) {
            return new ArrayList<>();
        }

        if (root.left == null && root.right == null) {
            List<Integer> leafDistances = new ArrayList<>();
            leafDistances.add(1); // leaf node distance is 1 to itself
            return leafDistances;
        }

        List<Integer> leftDistances = dfs(root.left, dist);
        List<Integer> rightDistances = dfs(root.right, dist);

        // Count good leaf node pairs
        for (int leftDist : leftDistances) {
            for (int rightDist : rightDistances) {
                if (leftDist + rightDist <= dist) {
                    count++;
                }
            }
        }

        // Increase all distances by 1 (moving up one level in the tree)
        List<Integer> allDistances = new ArrayList<>();
        for (int d : leftDistances) {
            allDistances.add(d + 1);
        }
        for (int d : rightDistances) {
            allDistances.add(d + 1);
        }

        return allDistances;
    }
}