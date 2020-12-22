package DataStructure.BinaryTree.HuffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//创建赫夫曼树
public class HuffmanTree {


    public static void main(String[] args) {
        int[] arr = {13,7,8,3,29,6,1};
        Node root = createHuffmanTree(arr);

        preOrder(root);

    }

    public static void preOrder(Node root){
        if(root !=null){
            root.preOrder();
        }else {
            System.out.println("是空树，不能遍历");
        }
    }

    //创建赫夫曼树的步骤：
    //1.从小到大进行排序，将每一个数据当成一个节点，将每一个节点看成一颗简单的二叉树
    //2.取出根节点权值最小的两棵二叉树
    //3.组成一颗新的二叉树，该二叉树的根节点的权值是前面两颗二叉树根节点的和
    //4.再将这颗新的二叉树，以根节点的权值大小再次排序，不断重复1234的步骤，直到数列中，所有的数据都被处理，就得到一颗赫夫曼树

    /**
     *   创建赫夫曼树的方法
     * @param arr 需要创建成赫夫曼树的数组
     * @return 创建好后的赫夫曼树的root节点
     */
    public static Node createHuffmanTree(int[] arr){
        //1.遍历arr数组
        //2.将arr的每个元素构成一个Node
        //3.将Node放入到ArrayList中
        List<Node> nodes = new ArrayList<Node>();
        for(int value:arr){
            nodes.add(new Node(value));
        }

        while(nodes.size()>1) {
            //排序 从小到大
            Collections.sort(nodes);
            System.out.println(nodes);

            //取出根节点权值最小的两颗二叉树
            //(1).取出权值最小的节点（二叉树）
            Node leftNode = nodes.get(0);
            //(2).取出权值第二小的节点（二叉树）
            Node rightNode = nodes.get(1);

            //(3).构建一颗新的二叉树
            Node parent = new Node(leftNode.value + rightNode.value);
            parent.left = leftNode;
            parent.right = rightNode;

            //(4).从ArrayList中删除处理过的二叉树
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //(5).将parent加入到nodes中
            nodes.add(parent);
        }
        return nodes.get(0);
    }

}


//创建节点类
//为了让Node对象支持Collections集合排序，让Node实现Comparable
class Node implements Comparable<Node>{
    int value; //节点权值
    Node left; //指向左子节点
    Node right; //指向右子节点


    //前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left!=null){
            this.left.preOrder();
        }
        if(this.right!=null){
            this.right.preOrder();
        }
    }


    public Node(int value){
        this.value = value;
    }


    @Override
    public String toString() {
        return "Node[value=" + value + "]";
    }

    public int compareTo(Node o) {
        //表示从小到大排序
        return this.value-o.value;
    }
}
