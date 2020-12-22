package AlgorithmPractice;

/**
 * @ClassName LinkNode
 * @Description 输入一个链表，输出该链表中倒数第k个结点。
 * @Author sx-9608
 * @Date 2020/5/27 15:20
 */
public class DaoShuListNode {

    public static void main(String[] args) {
        System.out.println(FindKthToTail(readyNode(),3).data);

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


    public static Node FindKthToTail(Node head,int k) {
        if(head == null)
            return null;
        int count = 1;
        Node temp = head;
        while(temp.next!=null){
            count++;
            temp = temp.next;
        }
        if(k>count)
            return null;
        System.out.println(count);
        //一共有count个，倒数第k个就是正数第count-k+1,下标是count-k
        for(int i = 0;i<count-k;i++){
            head = head.next;
        }
        return head;
    }

}

