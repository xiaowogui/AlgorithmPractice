package AlgorithmPractice.LinkdList;

//  题目描述:
//        判断给定的链表中是否有环。如果有环则返回true，否则返回false。
//        你能给出空间复杂度的解法么？
public class IsHasCycle {
    public static void main(String[] args) {
        ListNode listNode = new ListNode(100);
        System.out.println(hasCycle(listNode));
    }

    //快慢指针，若能相遇说明有环
    public static boolean hasCycle(ListNode head) {
        if(head == null){
            return false;
        }
        ListNode fast = head; //快指针
        ListNode slow = head; //慢指针
        while(fast!=null&&fast.next!=null){
            fast = fast.next.next;
            slow = slow.next;
            if(fast==slow){
                return true;
            }
        }
        return false;
    }

    static class ListNode {
      int val;
      ListNode next;
      ListNode(int x) {
          val = x;
          next = null;
      }


    }
}
