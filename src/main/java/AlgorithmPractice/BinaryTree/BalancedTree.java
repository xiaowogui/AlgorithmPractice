package AlgorithmPractice.BinaryTree;


//    题目描述
//        给出一个升序排序的数组，将其转化为平衡二叉搜索树（BST）.
//        示例1
//        输入
//        [-1,0,1,2]
//
//        返回值
//        {1,0,2,-1}
public class BalancedTree {
    public static void main(String[] args) {

    }

    /**
     * 这道题是二分查找树的题目，要把一个有序数组转换成一颗二分查找树。
     * 从本质来看，如果把一个数组看成一棵树（也就是以中点为根，左右为左右子树，依次下去）
     * 数组就等价于一个二分查找树。
     * 所以如果要构造这棵树，那就是把中间元素转化为根，然后递归构造左右子树。
     * 所以我们还是用二叉树递归的方法来实现，以根作为返回值，每层递归函数取中间元素，
     * 作为当前根和赋上结点值，然后左右结点接上左右区间的递归函数返回值。
     * \时间复杂度还是一次树遍历O(n)，
     * 总的空间复杂度是栈空间O(logn)加上结果的空间O(n)，额外空间是O(logn)，总体是O(n)
     * @param num
     * @return
     */
    public TreeNode sortedArrayToBST (int[] num) {
        // write code here
        if(num == null||num.length==0){
            return null;
        }
        return sortedArrayToBST(num,0,num.length-1);
    }

    private TreeNode sortedArrayToBST(int[] nums,int left,int right){
        if(right<left){
            return null;
        }
        if(left == right){
            return new TreeNode(nums[left]);
        }
        int mid = left+(right-left+1)/2;            //r-l+1是把较大值放到根节点，r-l是把较小值放到根节点,
                                                    // r-l+1时例如【1，3】，变成右空【3，1，#】，而不是左空【1，#，3】
        TreeNode root = new TreeNode(nums[mid]);

        root.left = sortedArrayToBST(nums,left,mid-1);
        root.right = sortedArrayToBST(nums,mid+1,right);
        return root;
    }

}


class TreeNode {
    int val = 0;
    TreeNode left = null;
    TreeNode right = null;

    public TreeNode(int num) {
    }
}
