package AlgorithmPractice.Numbers;

import com.sun.deploy.util.StringUtils;

public class SumOfTwoNumbers {
//    题目描述
//    给出一个整数数组，请在数组中找出两个加起来等于目标值的数，
//    你给出的函数twoSum 需要返回这两个数字的下标（index1，index2），需要满足 index1 小于index2.。注意：下标是从1开始的
//            假设给出的数组中只存在唯一解
//    例如：
//    给出的数组为 {20, 70, 110, 150},目标值为90
//    输出 index1=1, index2=2
//
//    示例1
//    输入
//    [3,2,4],6
//
//    返回值
//    [2,3]


    public static void main(String[] args) {
        int[] arr = {5,8,9,23,4};
        int[] arr1 = twoSum(arr,27);
        for(int i = 0;i<arr1.length;i++){
            System.out.println(arr1[i]);
        }

    }

    //暴力破解，两层循环
    public static int[] twoSum (int[] numbers, int target) {
        // write code here
        int[] arr = new int[2];
        for(int i=0;i<numbers.length;i++){
            for(int j=i+1;j<numbers.length;j++){
                if(target == numbers[i]+numbers[j]){
                    arr[0]=i+1;
                    arr[1]=j+1;
                }
            }
        }
        return arr;
    }

    //二分查找
    public static int[] twoSum1(int[] nums,int target){
        int left = 0, right = nums.length - 1;
        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                // 题目要求的索引是从 1 开始的
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // 让 sum 大一点
            } else if (sum > target) {
                right--; // 让 sum 小一点
            }
        }
        return new int[]{-1, -1};
    }
}
