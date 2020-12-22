package AlgorithmPractice; /**
 * @ClassName TwoStackImplemensQueue
 * @Description 用两个栈实现队列的先进先出
 * @Author sx-9608
 * @Date 2020/5/25 16:08
 */
import java.util.Stack;

public class TwoStackImplementsQueue {
    Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();

    /**
     * 进队列的方法
     * @param node
     */
    public void push(int node) {
        stack1.push(node);
    }

    /**
     * 返回栈顶的值并删除值
     * 弹出并删除元素
     * @return
     */
    public int pop() {
        if (stack2.size() == 0) {
            while (!stack1.isEmpty()) {
                int temp = stack1.peek();//返回栈顶的值
                stack2.push(temp);
                stack1.pop();
            }
        }
        int res = stack2.peek();//返回栈顶的值
        stack2.pop();
        return res;
    }

    /**
     * @param args
     */
    /**
     * @param args
     */
    public static void main(String[] args) {
        TwoStackImplementsQueue queue = new TwoStackImplementsQueue();
        queue.push(4);
        queue.push(1);
        queue.push(2);
        queue.push(3);
        System.out.println(queue.pop());
        System.out.println(queue.pop());
    }
}

