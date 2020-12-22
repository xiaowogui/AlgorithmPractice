package AlgorithmPractice.Array;

import java.util.Arrays;

//    题目描述
//        给出两个有序的整数数组 和 ，请将数组 合并到数组 中，变成一个有序的数组
//        注意：
//        可以假设 数组有足够的空间存放 数组的元素， 和 中初始的元素数目分别为 和
public class MergeArray {

    //将B放入A中，再对A排序
    public void merge(int A[], int m, int B[], int n) {
        for (int i = 0; i < n; i++) {
            if(B.length == 0){
                return;
            }
            A[m+i] = B[i];
        }
        Arrays.sort(A);
    }
}
