package AlgorithmPractice.Array;

import java.util.ArrayList;
import java.util.List;

public class SeekPeak {
//    题目描述
//    山峰元素是指其值大于或等于左右相邻值的元素。给定一个输入数组nums，任意两个相邻元素值不相等，数组可能包含多个山峰。找到索引最大的那个山峰元素并返回其索引。
//
//    假设 nums[-1] = nums[n] = -∞。
//
//    示例1
//    输入
//    [2,4,1,2,7,8,4]
//
//    返回值
//    5
    public static void main(String[] args) {
        int[] b = {1,2,4,5,3,7,9,11,2,33,8,7,10,9};
        int m = solve(b);
        System.out.println(m);
    }

    public static int solve (int[] a) {
        int index=0;
        for(int i=1;i<a.length;i++){
            if(a[i-1]<a[i]){
                index=i;
            }
        }
        return index;
    }
}
