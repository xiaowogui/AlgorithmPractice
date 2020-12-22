package AlgorithmPractice.BinaryTree;

import sun.reflect.generics.tree.Tree;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

//    题目描述
//        给定一个二叉树，返回该二叉树层序遍历的结果，（从左到右，一层一层地遍历）
//        例如：
//        给定的二叉树是{3,9,20,#,#,15,7},
//
//        该二叉树层序遍历的结果是
//        [
//        [3],
//        [9,20],
//        [15,7]
//        ]
//
//        示例1
//        输入
//        {1,2}
//
//        返回值
//        [[1],[2]]
//
//        示例2
//        输入
//        {1,2,3,4,#,#,5}
//
//        返回值
//        [[1],[2,3],[4,5]]
public class LevelTraversal {
    ArrayList<ArrayList<Integer>> res = new ArrayList<ArrayList<Integer>>();
    public ArrayList<ArrayList<Integer>> levelOrder (TreeNode root) {
        if(root==null){
            return res;
        }
        count(root,0);
        return res;
    }

    public void count(TreeNode node, int level){
        if(level == res.size()){
            res.add(new ArrayList<Integer>()); //为每一个层级创建一个list用来放数据
        }

        ArrayList<Integer> list = res.get(level);
        list.add(node.val);   //向层级中的list中添加数据

        if(node.left != null){  //继续向左边递归
            count(node.left,level+1);
        }
        if(node.right != null){  //继续向右边递归
            count(node.right,level+1);
        }
    }

}
