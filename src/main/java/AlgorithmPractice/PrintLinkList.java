package AlgorithmPractice;

import java.util.ArrayList;

/**
 * @ClassName AlgorithmPractice.PrintLinkList
 * @Description 从尾到头打印链表
 * @Author sx-9608
 * @Date 2020/5/25 16:25
 */
public class PrintLinkList {

    public static void main(String[] args){
        ListNode ln = new ListNode(3);
        System.out.println(printListFromTailToHead(ln));
    }


    
    public static ArrayList<Integer> printListFromTailToHead(ListNode listNode){
        ArrayList<Integer> list = new ArrayList<Integer>();
        if(listNode==null) {
            return list;
        }
        while (listNode!=null){
            list.add(listNode.value);
            listNode = listNode.next;
        }
        ArrayList<Integer> list1 = new ArrayList<Integer>();
        for (int i = list.size()-1;i>=0;i--){
            list1.add(list.get(i));
        }
        return list1;
    }
}



 class ListNode{
    int value;
    ListNode next = null;
    ListNode(int value){
        this.value = value;
    }
}