package AlgorithmPractice.String;

import java.math.BigInteger;

//    题目描述:
//    以字符串的形式读入两个数字，编写一个函数计算它们的和，以字符串形式返回。
//        （字符串长度不大于100000，保证字符串仅由'0'~'9'这10种字符组成）
public class SumOfString {
    public static void main(String[] args) {
        String s = "646316476434674321354";
        String t = "2124164346796359783467663";
        System.out.println(solve1(s,t));
    }

    public static String solve (String s, String t) {
        StringBuilder sb=new StringBuilder();
        int i=s.length()-1,j=t.length()-1;
        int tmp=0;
        while(i>=0||j>=0||tmp==1){
            int ii=i>=0?(s.charAt(i--)-'0'):0;
            int jj=j>=0?(t.charAt(j--)-'0'):0;
            int plus=ii+jj+tmp;
            tmp=plus/10;
            sb.insert(0,(char)('0'+(plus%10)));

        }
        return sb.toString();
    }

    public static String solve1 (String s,String t){
        return new BigInteger(s).add(new BigInteger(t)).toString();
    }
}
