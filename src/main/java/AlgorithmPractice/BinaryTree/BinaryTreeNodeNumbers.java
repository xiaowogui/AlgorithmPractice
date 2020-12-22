package AlgorithmPractice.BinaryTree;

//    题目描述
//        给定一棵完全二叉树的头节点head，返回这棵树的节点个数。如果完全二叉树的节点数为N，请实现时间复杂度低于O(N)的解法。
//        示例1
//        输入
//        {1,2,3}
//
//        返回值
//        3
public class BinaryTreeNodeNumbers {
    public static void main(String[] args) {

    }

    public int nodeNum(TreeNode head) {
        if(head==null){
            return 0;
        }
        if(head.right==null&&head.left!=null){  //右边为空，遍历左边
            return 1+nodeNum(head.left);  //遍历一次加一
        }
        if(head.right!=null&&head.left==null){  //左边为空，遍历右边，
            return 1+nodeNum(head.right); //遍历一次加一
        }

        return 1+nodeNum(head.left)+nodeNum(head.right); //遍历一次加一
    }

}
