import java.util.ArrayList;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
 class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
 }

class Solution {
    public boolean recursive(ArrayList<TreeNode> nodesInDepth, int depth, boolean isPreNull) {

        int numOfNull = 0;

        for(int i = 0; i < nodesInDepth.size(); i++){
            boolean isNowNull = true;

            if(nodesInDepth.get(i) != null) {
                isNowNull = false;
            }else{
                numOfNull++;
            }

            if(isPreNull == true && isNowNull == false){
                return false;
            }

            isPreNull = isNowNull;
        }

        if(numOfNull == nodesInDepth.size()) return true;

        ArrayList<TreeNode> NewNodesInDepth= new ArrayList<>();

        for(TreeNode node : nodesInDepth){
            if(node == null)
                continue;
            NewNodesInDepth.add(node.left);
            NewNodesInDepth.add(node.right);
        }

        return recursive(NewNodesInDepth, ++depth, isPreNull);
    }

    public boolean isCompleteTree(TreeNode root) {

        if(root == null) return false;

        ArrayList<TreeNode> nodesInDepth = new ArrayList<>();

        nodesInDepth.add(root.left);
        nodesInDepth.add(root.right);

        return recursive(nodesInDepth, 1, false);

    }
}