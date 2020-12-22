package AlgorithmPractice;

public class FibonacciSequence {
//    斐波那契数列:  0、1、1、2、3、5、8、13、21、34
//    F(n)=F(n - 1)+F(n - 2)（n ≥ 2，n ∈ N*）
//    题目描述
//    大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项（从0开始，第0项为0，第1项是1）。
//    n≤39
//
//    示例1
//    输入
//    4
//
//    返回值
//    3
    public static void main(String[] args) {
        System.out.println(Fibonacci(6));
    }

    //非递归实现
    public static int Fibonacci(int n) {
        int preNum = 1;
        int prePreNum = 0;
        int result = 0;
        if(n==0){
            return 0;
        }
        if(n==1){
            return 1;
        }
        for(int i=2;i<=n;i++){
            result = preNum+prePreNum;
            prePreNum = preNum;
            preNum = result;
        }
        return result;
    }


    // 递归实现
    public static int Fibonacci1(int n) {
        if(n==1){
            return 1;
        }
        else if(n==0){
            return 0;
        }
        else
            return Fibonacci(n-1) + Fibonacci(n-2);
    }


}
