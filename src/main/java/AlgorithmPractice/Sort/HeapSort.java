package AlgorithmPractice.Sort;

import java.util.Arrays;
//堆排序时间复杂度 O(nlogn)
//升序用大顶堆，降序用小顶堆
public class HeapSort {
    public static void main(String[] args) {
        int arr[]  ={5,9,14,4,24,87,};
        heapSort(arr);
    }


    //堆排序方法
    public static void heapSort(int[] arr){
        int temp = 0;
        // 1）.将无序序列构建成一个堆，根据升序降序需求选择大顶堆或小顶堆
        for(int i = arr.length/2-1; i >= 0;i--){
            adjustHeap(arr,i,arr.length);
        }

        // 2).将堆顶元素与末尾元素交换，将最大元素“沉”到数组末端
        // 3）.重新调整结构，使其满足堆定义，然后继续交换堆顶元素与当前末尾元素，反复执行调整+交换步骤，直到整个序列有序。
        for(int j = arr.length-1;j > 0;j--){
            //交换
            temp = arr[j];
            arr[j] = arr[0];
            arr[0] = temp;
            adjustHeap(arr,0,j);
        }
        System.out.println(Arrays.toString(arr));
    }



    //将一个数组（二叉树）调整成一个大顶堆
    /**
     *功能：完成将以i对应的非叶子节点的树调整成大顶堆
     *
     * @param arr 待调整的数组
     * @param i  表示非叶子节点在数组中的索引
     * @param length 表示对多少个元素进行调整，length是在逐渐的减少
     */
    public static void adjustHeap(int arr[],int i,int length){
        int temp = arr[i];
        //开始调整，K = i*2+1 ,K是i节点的左子节点
        for(int k = i*2+1;k<length;k = k*2+1){
            if(k+1<length && arr[k]<arr[k+1]){ //说明左子节点的值小于右子节点的值(大顶堆)  arr[k]>arr[k+1](小顶堆)
                k++;  //k指向右子节点
            }
            if(arr[k] > temp){ // 如果子节点大于父子节点（大顶堆）  arr[k]<temp(小顶堆)
                arr[i] = arr[k]; //把较大的值赋给当前的节点
                i = k;   //i指向K，继续循环比较
            }else {
                break;
            }
        }
        //当for循环结束后，我们已经将以i为父节点的树的最大值，放在了最顶上
        arr[i] = temp;  //将temp的值放在调整后的位置
    }


}
