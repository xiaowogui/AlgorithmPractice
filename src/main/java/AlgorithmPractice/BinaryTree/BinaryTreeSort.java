package AlgorithmPractice.BinaryTree;


import java.util.ArrayList;

//    题目描述
//        分别按照二叉树先序，中序和后序打印所有的节点。
public class BinaryTreeSort {
    ArrayList<Integer> pre = new ArrayList<Integer>();
    ArrayList<Integer> mid = new ArrayList<Integer>();
    ArrayList<Integer> last = new ArrayList<Integer>();
    public int[][] threeOrders (TreeNode root) {
        preTraversal(root);
        midTraversal(root);
        lastTraversal(root);
        int res[][] = {toIntArray(pre),toIntArray(mid),toIntArray(last)};
        return res;
    }

    //ArrayList 转 int[]
    public int[] toIntArray(ArrayList<Integer> list){
        if(list==null||list.size()<1){
            return new int[0];
        }
        int[] result=new int[list.size()];
        for(int i=0;i<list.size();i++){
            result[i]=list.get(i);
        }
        return result;
    }

    //前序遍历
    public void preTraversal(TreeNode root){
        if(root == null){
            return;
        }
            pre.add(root.val);
            preTraversal(root.left);
            preTraversal(root.right);

    }

    //中序遍历
    public void midTraversal(TreeNode root){
        if(root == null){
            return;
        }
        midTraversal(root.left);
        mid.add(root.val);
        midTraversal(root.right);
    }

    //后序遍历
    public void lastTraversal(TreeNode root){
        if(root == null){
            return;
        }
        lastTraversal(root.left);
        lastTraversal(root.right);
        last.add(root.val);
    }



    class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;
  }
}
