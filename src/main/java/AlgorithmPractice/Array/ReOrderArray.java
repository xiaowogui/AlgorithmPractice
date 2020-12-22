package AlgorithmPractice.Array;

import java.util.ArrayList;

/**
 * @ClassName AlgorithmPractice.Array.ReOrderArray
 * @Description 输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，
 *              所有的偶数位于数组的后半部分，并保证奇数和奇数，偶数和偶数之间的相对位置不变。
 * @Author sx-9608
 * @Date 2020/5/26 15:06
 */
public class ReOrderArray {


    public static void main(String[] args) {
        int[] arr = new int[]{1,2,3,4,5,6,7};
        for(int i = 0;i<arr.length;i++){
            System.out.println(reOrderArray(arr)[i]);

        }
    }


        public static int[] reOrderArray(int[] array) {
            int[] array1 = new int[array.length];
            int jicount = 0;
            int a=0;
            for(int i = 0;i<array.length;i++){
                if(array[i]%2==1){
                    jicount++;
                }
            }
            for(int i = 0;i<array.length;i++){
                if(array[i]%2==1){
                    array1[a]=array[i];
                    a++;
                }else{
                    array1[jicount]=array[i];
                    jicount++;
                }
            }

            return array1;
        }

}
