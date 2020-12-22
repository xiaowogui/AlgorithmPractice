package AlgorithmPractice.Numbers;

import java.math.BigInteger;

public class ReverseNumber {
//    题目描述
//    将给出的32位整数x翻转。
//    例1:x=123，返回321
//    例2:x=-123，返回-321
//
//    你有注意到翻转后的整数可能溢出吗？因为给出的是32位整数，则其数值范围为[−2^{31}, 2^{31} − 1]。翻转可能会导致溢出，如果反转后的结果会溢出就返回 0。
//
//    示例1
//    输入
//
//    -123
//
//    返回值
//    -321
    public static void main(String[] args) {
        System.out.println(reverse(264326155));
    }

    public static int reverse (int x) {
        int  res = 0;
        while (x!=0) {
            res = res*10 + x%10; //取模取最后一个数字，除法降位
            x /= 10;
        }
        if (res < Integer.MIN_VALUE || res > Integer.MAX_VALUE) {  //判断是否溢出
            res = 0;
        }
        return res;

    }
}
