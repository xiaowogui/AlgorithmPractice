package AlgorithmPractice;

/**
 * @ClassName AlgorithmPractice.ReverseLinkList
 * @Description 反转单链表
 * @Author sx-9608
 * @Date 2020/5/26 11:02
 */
public class ReverseLinkList {

    ListNode reverse(ListNode head) {
        ListNode cur = head;
        ListNode pre = null;
        while(cur != null) {
            ListNode temp = cur.next;
            cur.next = pre;
            pre = cur;
            cur = temp;
        }
        return pre;
    }


}






