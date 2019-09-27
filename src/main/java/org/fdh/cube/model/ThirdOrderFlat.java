package org.fdh.cube.model;


/** 自定义三阶魔方面
 * @author sunjianglong 2019-7-3
 * */
public class ThirdOrderFlat {
    /** 单面的方块 */
    private Colors[][] squres;
    /** Cache the hash code for the ThirdOrderFlat */
    private int hash;
    {
        squres=new Colors[3][3];
    }
    /** 无参构造器，默认白色 */
    public ThirdOrderFlat() {
        for(int i=0;i<squres.length;i++) {
            for(int j=0;j<squres[i].length;j++) {
                squres[i][j]=Colors.白;
            }
        } 
        hash=hashCode();
    }
    /** 构造器，将三阶面的值一一复制
     * @param thirdOrderFlat 三阶面
     *  */
    public ThirdOrderFlat(ThirdOrderFlat thirdOrderFlat) {
        for(int i=0;i<thirdOrderFlat.getSqures().length;i++) {
            for(int j=0;j<thirdOrderFlat.getSqures()[i].length;j++) {
                squres[i][j]=thirdOrderFlat.getSqures()[i][j];
            }
        }
        hash=hashCode();
    }
    /** 构造器
     * @param color 颜色
     *  */
    public ThirdOrderFlat(Colors color) {
        for(int i=0;i<squres.length;i++) {
            for(int j=0;j<squres[i].length;j++) {
                squres[i][j]=color;
            }
        }    
        hash=hashCode();
    }
    /** 返回存放魔方块数据的二维数组 */
    public Colors[][] getSqures(){
        return squres;
    }
    /** 赋值3X3方块
     * @param squres 二维数组
     *  */
    public void setSqures(Object[][] squres) {
        for(int i=0;i<squres.length;i++) {
            for(int j=0;j<squres[i].length;j++) {
                this.squres[i][j]=(Colors) squres[i][j];
            }
        }
    }
    /** 判断单个面是否状态一致 
     * //判断面的中心块与四周块状态是否一致
     * */
    public boolean doesFlatStatusSame() {
        
        for(int i=0;i<squres.length;i++) {
            for(int j=0;j<squres[i].length;j++) {
                if(squres[1][1]!=squres[i][j]) {
                    return false;
                }
            }
        }
        return true;
    }
    /** 打印某一行的状态,row>0 */
    public void print(int row) {
        for (int i = 0; i < squres[row-1].length; i++) {
            System.out.print(squres[row-1][i]+"  ");
        }
        System.out.print("|  ");
    }
    @Override
    public String toString() {
        StringBuffer stringBuffer=new StringBuffer();
        stringBuffer.append(" -------");
        for(int i=0;i<squres.length;i++) {
            stringBuffer.append("\n").append("|   ");
            for(int j=0;j<squres[i].length;j++) {
                stringBuffer.append(squres[i][j]).append("   ");
            }
            stringBuffer.append("|");
        }  
        stringBuffer.append("\n -------\n");
        return stringBuffer.toString();
    }
    @Override
    public int hashCode() {
        int h = hash;
        if(h==0&&squres.length>0) {
            Colors[][] val=squres;
            for(int i=0;i<squres.length;i++) {
                for(int j=0;j<squres[i].length;j++) {
                    h = 31 * h + val[i][j].getValue();//就这一句循环
                }
            }
            hash=h;
        }
        return h;
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) {//比较对象引用地址
            return true;
        }
        if(obj instanceof ThirdOrderFlat) {//比较对象类型
            
            ThirdOrderFlat flat=(ThirdOrderFlat)obj;
            if(hashCode()!=flat.hashCode()) {//比较对象hashcode
                return false;
            }
            else {//比较对象的完整内容
                Colors[][] val=flat.getSqures();
                for(int i=0;i<squres.length;i++) {
                    for(int j=0;j<squres[i].length;j++) {
                        if(squres[i][j]!=val[i][j]) return false;
                    }
                }
                return true;
            }
        }
        return false;
    }
}
