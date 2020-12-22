package AlgorithmPractice;

import java.util.ArrayList;

public class HelixArray {
//    给定一个m x n大小的矩阵（m行，n列），按螺旋的顺序返回矩阵中的所有元素。
//    示例1
//    输入
//
//    [[1,2,3],[4,5,6],[7,8,9]]
//
//    返回值
//    [1,2,3,6,9,8,7,4,5]

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        ArrayList<Integer> arr = new ArrayList<Integer>();
        arr=spiralOrder(matrix);
        for (Integer ma:arr) {
            System.out.print(ma.toString());
        }
    }


    //设定边界值，分别遍历四边
    public static ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> res = new ArrayList<Integer>();
        if(matrix.length==0){
            return res;
        }

        int rowBegin = 0;
        int rowEnd = matrix.length-1;
        int colBegin = 0;
        int colEnd = matrix[0].length-1;

        while(rowBegin <= rowEnd && colBegin<= colEnd){
            //遍历上边
            for (int j = colBegin; j <= colEnd; j ++) {
                res.add(matrix[rowBegin][j]);
            }
            rowBegin++;
            //遍历右边
            for(int j = rowBegin;j<=rowEnd;j++){
                res.add(matrix[j][colEnd]);
            }
            colEnd--;

            //遍历下边
            if(rowBegin<=rowEnd){
                for(int j = colEnd;j>=colBegin;j--){
                    res.add(matrix[rowEnd][j]);
                }
                rowEnd--;
            }
            //遍历左边
            if(colBegin<=colEnd){
                for(int j=rowEnd;j>=rowBegin;j--){
                    res.add(matrix[j][colBegin]);
                }
                colBegin++;
            }
        }
        return res;
    }
}
