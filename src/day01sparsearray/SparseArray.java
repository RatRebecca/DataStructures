package day01sparsearray;

/**
 * 稀疏数组的代码实现
 * @Author weipeng
 * @Date 2022/12/14 20:49
 */

public class SparseArray {

    public static void main(String[] args) {
        //创建一个原始 二维数组 11*11
        //0 表示无子 1表示黑子 2表示蓝子
        int[][] chessArr1 = new int[11][11];
        chessArr1[1][2] = 1;
        chessArr1[2][3] = 2;
        //输出原始二维数组
        for (int[] row : chessArr1) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
        //将二维数组 转化为 稀疏数组
        //1.先遍历 二维数组 获得非 0 数据的个数
        int sum = 0;
        for (int i = 0; i<chessArr1.length; i++){
            for (int j = 0; j<chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0){
                    sum++;
                }
            }
        }
        //2.创建对应的稀疏数组
        int[][] sparseArr = new int[sum+1][3];
        //给稀疏数组赋值
        sparseArr[0][0] = chessArr1.length;
        sparseArr[0][1] = chessArr1[0].length;
        sparseArr[0][2] = sum;
        //遍历二维数组将非0的值存到稀疏数组中
        int count = 0; //用于记录是第几个非0数据
        for (int i = 0; i<chessArr1.length; i++){
            for (int j = 0; j<chessArr1[i].length; j++){
                if (chessArr1[i][j] != 0){
                    count++;
                    sparseArr[count][0] = i;
                    sparseArr[count][1] = j;
                    sparseArr[count][2] = chessArr1[i][j];
                }
            }
        }

        //输出 稀疏数组
        System.out.println("得到的稀疏数组");
        for (int[] ints : sparseArr) {
            System.out.printf("%d\t%d\t%d\t\n", ints[0], ints[1], ints[2]);
        }

        //3.将稀疏数组 恢复成 原始的二维数组
        // 读取 稀疏数组 第一行, 创建 二维数组
        int[][] chessArr2 = new int[sparseArr[0][0]][sparseArr[0][1]];
        for(int i = 1;i<sparseArr.length;i++){
            chessArr2[sparseArr[i][0]][sparseArr[i][1]] = sparseArr[i][2];
        }
        System.out.println("恢复后的二维数组");
        for (int[] row : chessArr2) {
            for (int data : row) {
                System.out.printf("%d\t",data);
            }
            System.out.println();
        }
    }
}
