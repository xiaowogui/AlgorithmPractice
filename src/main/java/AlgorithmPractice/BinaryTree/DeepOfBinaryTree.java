package AlgorithmPractice.BinaryTree;


import java.util.LinkedList;
import java.util.Queue;

//    题目描述:
//        求给定二叉树的最大深度，
//            最大深度是指树的根结点到最远叶子结点的最长路径上结点的数量。
public class DeepOfBinaryTree {

    //递归实现
    public int maxDepth (TreeNode root) {
        if(root == null){
            return 0;
        }
        return 1+Math.max(maxDepth(root.left),maxDepth(root.right));
    }


    //非递归实现，利用queue进行层序遍历
    public int maxDepth_2(TreeNode root) {
        int res = 0;
        if (root == null)
            return res;
        Queue<TreeNode> queue = new LinkedList<TreeNode>();
        // 根节点入队
        queue.add(root);
        while (!queue.isEmpty()) {
            for (int i = 0; i < queue.size(); i++) {
                TreeNode curNode = queue.poll();
                if (curNode.left != null)
                    queue.add(curNode.left);
                if (curNode.right != null)
                    queue.add(curNode.right);
            }
            res++;
        }
        return res;
    }

}
