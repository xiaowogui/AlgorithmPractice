package AlgorithmPractice.String;

public class ReverseString {
//    题目描述
//    写出一个程序，接受一个字符串，然后输出该字符串反转后的字符串。（字符串长度不超过1000）
//    示例1
//    输入：
//    "abcd"
//
//    返回值
//    "dcba"
    public static void main(String[] args) {
        String s = "dhfihwker";
        System.out.println(solve(s));
    }


    // 利用指针，进行前后交换
    public static String solve(String str) {
        char[] arr = str.toCharArray();
        char[] arr1 = new char[arr.length];
        int b = 0;
        for(int i = arr.length-1;i>=0;i--){
            arr1[b++] = arr[i];
        }
        return String.valueOf(arr1);
    }


    // 利用StringBuilder中的reverse函数
    public static String solve1 (String str) {
        if (str == null || str.length() == 0) {
            return str;
        }
        return new StringBuilder(str).reverse().toString();
    }

}
