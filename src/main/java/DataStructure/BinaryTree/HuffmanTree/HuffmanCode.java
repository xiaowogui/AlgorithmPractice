package DataStructure.BinaryTree.HuffmanTree;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class HuffmanCode {
    public static void main(String[] args) {
        String content = "i like like like java do you like a java";
        byte[] contentBytes = content.getBytes();
        byte[] huffmanBytes = huffmanZip(contentBytes);
        System.out.println("压缩后的结果："+Arrays.toString(huffmanBytes));
//        System.out.println(contentBytes.length); //40
//
//        List<Node> nodes = getNodes(contentBytes);
//        System.out.println(nodes);
//
//        //输出测试创建的赫夫曼树
//        System.out.println("赫夫曼树：");
//        Node huffmanTree = createHuffmanTree(nodes);
//        System.out.println("前序遍历");
//        preOrder(huffmanTree);
//
//        //输出测试生成的赫夫曼树对应的赫夫曼树编码
//        Map<Byte,String> huffCodes = getCodes(huffmanTree,"",stringBuilder);
//        System.out.println("生成的赫夫曼树编码表: "+huffCodes);
//
//        //测试
//        byte[] huffmanCodeBytes = zip(contentBytes,huffCodes);
//        System.out.println("huffmanCodeBytes = "+ Arrays.toString(huffmanCodeBytes)); //17
//
//        //发送huffmanCodesBytes 数组
    }


    /**
     *
     * @param bytes 原始的字符串对应的字节数组
     * @return 是经过赫夫曼编码处理后的字节数组（压缩后的数组）
     */
    //使用一个方法，将前面的方法封装起来，方便我们调用
    private static byte[] huffmanZip(byte[] bytes){
        //将bytes转成List
        List<Node> nodes = getNodes(bytes);
        //根据nodes创建赫夫曼树
        Node huffmanTree = createHuffmanTree(nodes);
        //根据赫夫曼树生成对应的赫夫曼编码
        Map<Byte,String> huffmanCodes = getCodes(huffmanTree,"",stringBuilder);
        //根据生成的赫夫曼编码，压缩得到压缩后的赫夫曼编码字节数组
        byte[] huffmanCodeBytes = zip(bytes,huffmanCodes);
        return huffmanCodeBytes;
    }



    //编写一个方法，将字符串对应的byte[] 数组，通过生成的赫夫曼编码表，返回一个赫夫曼编码压缩后的byte[]
    /**
     *
     * @param bytes 这是原始的字符串对应的byte[]
     * @param huffmanCodes 生成的赫夫曼编码map
     * @return 返回赫夫曼编码处理后的byte[]
     * 举例：String content = "i like like like java do you like a java"；=》byte[] contentBytes = content.getBytes();
     * 返回的字符串"101010001011111111001000101111111100100010111111110010010100110111000111000001101110....."
     * =>对应的byte[] huffmanCodeBytes,即8位对应一个byte放入huffmanCodeBytes
     * huffmanCodeBytes[0] = 10101000(补码) => byte [推导 10101000=> 10101000-1 =>10100111(反码)=>11011000 = -88]
     */
    private static byte[] zip(byte[] bytes,Map<Byte,String> huffmanCodes){
        //1.利用huffmanCodes 将bytes 转成 赫夫曼编码对应的字符串
        StringBuilder stringBuilder = new StringBuilder();
        //遍历bytes 数组
        for(byte b:bytes){
            stringBuilder.append(huffmanCodes.get(b));
        }
        //将"1010100010111111110010001011111..." 转成byte[]
        //统计返回的byte[] huffmanCodeBytes的长度
        int len;
        if(stringBuilder.length()%8 ==0){
            len = stringBuilder.length()/8;
        }else {
            len = stringBuilder.length()/8+1;
        }
        //创建 存储压缩后的byte数组
        byte[] huffmanCodeBytes = new byte[len];
        int index = 0; //记录是第几个byte
        for(int i = 0; i< stringBuilder.length();i +=8){  //因为没8位对应一个byte,所以步长+8
            String strByte;
            if(i+8 > stringBuilder.length()){  //不够8位
                strByte = stringBuilder.substring(i);
            }else {
                strByte = stringBuilder.substring(i,i+8);
            }
            //将strByte 转成一个byte,放入到huffmanCodeBytes;
            huffmanCodeBytes[index] = (byte) Integer.parseInt(strByte,2);
            index++;
        }

        return huffmanCodeBytes;
    }




    //生成赫夫曼树对应的赫夫曼树编码
    //思路：1.将赫夫曼树编码表存放在Map<Byte,String>
    // 形式： {32=01, 97=100, 100=11000, 117=11001, 101=1110, 118=11011, 105=101, 121=11010, 106=0010, 107=1111, 108=000, ...}
    static Map<Byte,String> huffmanCodes =  new HashMap<Byte,String>();
    //2.在生成赫夫曼树编码表时，需要去拼接路径，定义一个StringBuilder存储某个叶子节点的路径
    static  StringBuilder stringBuilder =  new StringBuilder();


    /**
     * 功能：将传入的node节点的所有叶子节点的赫夫曼编码得到，并放入到huffmanCodes集合中
     * @param node 传入节点
     * @param code 路径：左子节点表示为0，右子节点表示为1
     * @param stringBuilder 用于拼接路径
     */
    private static Map<Byte,String> getCodes(Node node,String code,StringBuilder stringBuilder){
        StringBuilder stringBuilder2 = new StringBuilder(stringBuilder);
        //将code加入到stringBuilder2中
        stringBuilder2.append(code);
        if(node !=null ){ //如果node==null不处理
            //判断当前node是叶子节点还是非叶子节点
            if(node.data==null){ //非叶子节点
                //递归处理
                //向左递归
                getCodes(node.left,"0",stringBuilder2);
                //向右递归
                getCodes(node.right,"1",stringBuilder2);
            }else { //说明是一个叶子节点
                //就表示找到了某个叶子节点的最后,将data值跟编码加入huffmanCodes
                huffmanCodes.put(node.data,stringBuilder2.toString());
            }
        }
        return huffmanCodes;
    }


    //前序遍历的方法
    private static void preOrder(Node root){
        if(root!=null){
            root.preOrder();
        }else {
            System.out.println("赫夫曼树为空");
        }
    }

    /**
     *
     * @param bytes 接受字节数组
     * @return  返回List形式[Node[data = '97',weight = '5'],Node[data = '32',weight = '9']........]
     */
    public static List<Node> getNodes(byte[] bytes){
        //1.创建一个ArrayList
        ArrayList<Node> nodes = new ArrayList<Node>();

        //遍历bytes,统计每一个byte出现的次数，用mao[key,value]存储
        HashMap<Byte,Integer> counts = new HashMap<Byte,Integer>();
        for (byte b:bytes) {
            Integer count = counts.get(b);
            if(count==null){  //map没有这个字符数据
                counts.put(b,1);
            }else {
                counts.put(b,count+1);
            }
        }

        //把每个键值对转成一个Node对象，并加入到nodes集合中
        //遍历map
        for(Map.Entry<Byte,Integer> entry:counts.entrySet()){
            nodes.add(new Node(entry.getKey(),entry.getValue()));
        }

        return nodes;
    }

    //可以通过List 创建对应的赫夫曼树
    private static Node createHuffmanTree(List<Node> nodes){
        while(nodes.size()>1){
            //从小到大排序
            Collections.sort(nodes);
            //取出第一颗最小的二叉树
            Node leftNode = nodes.get(0);
            //取出第二颗最小的二叉树
            Node rightNode = nodes.get(1);
            //创建一颗新的二叉树,它的根节点没有data,只有权值，因为字符data都放在叶子节点的

            Node parent = new Node(null,leftNode.weight+rightNode.weight);
            parent.left = leftNode;
            parent.right = rightNode;

            //将已经处理的两颗二叉树从nodes中移除
            nodes.remove(leftNode);
            nodes.remove(rightNode);
            //将新的二叉树加入nodes
            nodes.add(parent);
        }
        //循环完后只剩nodes最后的节点，就是赫夫曼树的根节点
        return nodes.get(0);
    }


    //创建Node,放数据和权值
    static class Node implements Comparable<Node>{
        Byte data; //存放数据（字符）本身，比如'a' => 97 ' '=>32
        int weight; //权值，表示字符出现的次数
        Node left;
        Node right;
        public Node(Byte data, int weight){

            this.data = data;
            this.weight = weight;
        }

        @Override
        public int compareTo(Node o) {
            return this.weight-o.weight;
        }

        @Override
        public String toString() {
            return "Node [data = "+data+" weight = "+weight+"]";
        }

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
    }
}
