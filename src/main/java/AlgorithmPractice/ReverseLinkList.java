package AlgorithmPractice;

/**
 * @ClassName AlgorithmPractice.ReverseLinkList
 * @Description 反转单链表
 * @Author sx-9608
 * @Date 2020/5/26 11:02
 */
public class ReverseLinkList {

    public static void main(String[] args) {
        System.out.println(ReverseList(readyNode()));

    }

    static Node readyNode() {
        Node linkNode1 = new Node();
        linkNode1.data = 1;
        Node linkNode2 = new Node();
        linkNode2.data = 2;
        Node linkNode3 = new Node();
        linkNode3.data = 3;
        Node linkNode4 = new Node();
        linkNode4.data = 4;
        Node linkNode5 = new Node();
        linkNode5.data = 5;
        Node linkNode6 = new Node();
        linkNode6.data = 6;
        linkNode1.next = linkNode2;
        linkNode2.next = linkNode3;
        linkNode3.next = linkNode4;
        linkNode4.next = linkNode5;
        linkNode5.next = linkNode6;
        return linkNode1;
    }


    static Node ReverseList(Node node) {
        Node pre = null;
        Node next = null;
        while (node != null) {
            next = node.next;
            node.next = pre;
            pre = node;
            node = next;
        }
        return pre;
    }


}


class Node {
    Integer data;
    Node next;
}




