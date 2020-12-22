package AlgorithmPractice.BinarySearch;

public class Sqrt {
//    实现函数 int sqrt(int x).
//    计算并返回x的平方根（向下取整）
//    示例1
//    输入
//    2
//
//    返回值
//    1
    public static void main(String[] args) {
        System.out.println(sqrt(9));
    }

    //二分查找法
    public static int sqrt1 (int x) {
        // write code here
        if (x <= 0)
            return x;
        long left = 1;
        long right = x;
        while(left < right) {
            long middle = (left + right) / 2;
            if (middle * middle <= x && (middle + 1) * (middle + 1) > x) {
                return (int)middle;
            } else if (middle * middle < x) {
                left = middle;
            } else {
                right = middle;
            }
        }
        return (int) left;
    }

    //i从1循环判断到数字的一半，如果i+1的平方大于这个数字，则说明平方根为i
    public static int sqrt (int x) {
        if(x==1||x==2){
            return 1;
        }
        for(int i = 1; i<=x/2;i++){
            if((i+1)*(i+1)>x){
                return i;
            }
        }
        return x;
    }



}
