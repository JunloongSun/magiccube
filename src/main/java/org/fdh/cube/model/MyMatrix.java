package org.fdh.cube.model;


/** 自定义矩阵操作
 * @author sunjianglong 2019-7-3
 * */
public class MyMatrix {
    /** 得到指定行 
     * @param matrix 二维数组
     * @param row 行数，从1开始
     * @return 行数组
     * */
    public Object[] getRow(Object[][] matrix,int row) {
        Object[] result=new Object[matrix[row-1].length];
        for(int i=0;i<matrix[row-1].length;i++) {
            result[i]=matrix[row-1][i];
        }
        return result;
    }
    /** 得到指定列 
     * @param matrix 二维数组
     * @param column 列数，从1开始
     * @return 列数组
     * */
    public Object[] getColumn(Object[][] matrix,int column) {
        Object[] result=new Object[matrix.length];
        for(int i=0;i<matrix.length;i++) {
            result[i]=matrix[i][column-1];
        }
        return result;
    }
    /** 将一维数组倒序 
     * @param source 原一维数组
     * @return 倒序后的新一维数组
     * */
    public Object[] reverseOrder(Object[] source) {
        Object[] result=new Object[source.length];
        for(int i=source.length-1;i>=0;i--) {
            result[result.length-1-i]=source[i];
        }
        return result;
    }
    /** 替换某一行 
     * @param matrix 被修改的二维数组
     * @param row 要替换的行
     * @param source 目标行
     * */
    public void setRow(Object[][] matrix,int row,Object[] source) {
        if(matrix[row-1].length!=source.length) { System.out.println("行数不一致");return ;}
        for(int i=0;i<source.length;i++) {
            matrix[row-1][i]=source[i];
        }
    }
    /** 替换某一列 
     * @param matrix 被修改的二维数组
     * @param column 要替换的列
     * @param source 目标列
     * */
    public void setColumn(Object[][] matrix,int column,Object[] source) {
        if(matrix.length!=source.length) { System.out.println("列数不一致"); return ;}
        for(int i=0;i<source.length;i++) {
            matrix[i][column-1]=source[i];
        }
    }
    /** 将矩阵顺时针旋转90° *
     * @param temp 二维数组
     * */
    public void rotate(Object[][] temp){
        //有两种方法实现
        //方法一：观察法，从旋转后得到的新矩阵观察得到规律
        //方法二：得到转置矩阵，再将1列与3列交换
        int len=temp.length;
        Object[][] b=new Object[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                b[j][len-1-i]=temp[i][j];
            }
        }
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                temp[i][j]=b[i][j];
            }
        }      
    }
    /** 将矩阵逆时针旋转90° 
     * @param temp 二维数组
     * */
    public void rotateN(Object[][] temp) {
        int len=temp.length;
        Object[][] b=new Object[len][len];
        for(int i=0;i<len;i++){
            for(int j=0;j<len;j++){
                b[len-1-j][i]=temp[i][j];
            }
        }
        for(int i=0;i<len;i++) {
            for(int j=0;j<len;j++) {
                temp[i][j]=b[i][j];
            }
        }  
    }
    /** 将矩阵旋转180° 
     * @param temp 二维数组
     * */
    public void rotate2(Object[][] temp) {
        rotate(temp);
        rotate(temp);
    }
    /** 复制二维数组 
     * @param array 二维数组（可不为方阵，即列不整齐）
     * @return 新二维数组
     * */
    public Object[][] copyArray(Object[][] array){
        Object[][] newArray=new Object[array.length][];
        for(int i=0;i<array.length;i++){
            newArray[i]=copyArray(array[i]);
        }
        return newArray;
    }
    /** 复制一维数组 
     * @param array 一维数组
     * @return 新一维数组
     * */
    public Object[] copyArray(Object[] array) {
        Object[] newArray=new Object[array.length];
        for(int i=0;i<array.length;i++){
            newArray[i]=array[i];
        }
        return newArray;
    }
}
