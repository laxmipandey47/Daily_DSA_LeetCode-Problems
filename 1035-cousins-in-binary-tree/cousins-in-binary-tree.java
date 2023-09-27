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
    public boolean isCousins(TreeNode root, int x, int y) {
        if(root == null) {
            return false;
        }

        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while(!queue.isEmpty()) {
            int levelSize = queue.size();
            boolean Xexist = false;
            boolean Yexist = false;

            for(int i = 0; i < levelSize; i++) {
                TreeNode currNode = queue.poll();
                if(currNode.val == x) {
                    Xexist = true;
                }
                
                if(currNode.val == y) {
                    Yexist = true;
                }

                if(currNode.left != null && currNode.right != null) {
                    if(currNode.left.val == x && currNode.right.val == y) {
                        return false;
                    }

                    if(currNode.left.val == y && currNode.right.val == x) {
                        return false;
                    }
                }

                if(currNode.left != null) {
                    queue.offer(currNode.left);
                }

                if(currNode.right != null) {
                    queue.offer(currNode.right);
                }
            }

            if(Xexist && Yexist) {
                return true;
            }
        }
        return false;    
    }
}