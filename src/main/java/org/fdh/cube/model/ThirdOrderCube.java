package org.fdh.cube.model;



/** 自定义三阶魔方,包含转动方式，固定视角，面优先级：上下>前后>左右；所有旋转方向都是以正对面看的方向为基准。
 * 总共单层转18种，其它都是由单层转复合而成。
 * @author sunjianglong 2019-7-3
 * */
public class ThirdOrderCube {
    /** 矩阵操作 */
    private static MyMatrix myMatrix=new MyMatrix();
    /** 后面 */
    private ThirdOrderFlat behind;
    /** 下面 */
    private ThirdOrderFlat down;
    /** 前面 */
    private ThirdOrderFlat front;
    /** Cache the hash code for the ThirdOrderFlat */
    private int hash;
    /** 左面 */
    private ThirdOrderFlat left;
    /** 右面 */
    private ThirdOrderFlat right;
    /** 上面 */
    private ThirdOrderFlat up;
    /** 无参构造器，默认白色在下，红色在前 */
    public ThirdOrderCube() {
        up=new ThirdOrderFlat(Colors.黄);
        down=new ThirdOrderFlat(Colors.白);
        front=new ThirdOrderFlat(Colors.红);
        behind=new ThirdOrderFlat(Colors.橙);
        left=new ThirdOrderFlat(Colors.蓝);
        right=new ThirdOrderFlat(Colors.绿);
        hash=hashCode();
    }
    
    /** 后两层顺时针转90° */
    public void b() {
        B();Sn();
    }
    /** B层顺时针转90° */
    public void B() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotate(behind.getSqures());
        exchange1=myMatrix.getRow(up.getSqures(),1);
        myMatrix.setRow(up.getSqures(),1,myMatrix.getColumn(right.getSqures(), 3));
        exchange2=myMatrix.getColumn(left.getSqures(), 1);
        myMatrix.setColumn(left.getSqures(), 1, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getRow(down.getSqures(),3);
        myMatrix.setRow(down.getSqures(),3,exchange2);
        myMatrix.setColumn(left.getSqures(),3, myMatrix.reverseOrder(exchange1));
    }
    /** 后两层顺时针转180° */
    public void b2() {
        b();b();
    }
    /** B层顺时针转180° */
    public void B2() {
        B();B();
    }
    /** 后两层逆时针转90° */
    public void bn() {
        Bn();S();
    }
    /** B层逆时针转90° */
    public void Bn() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotateN(behind.getSqures());
        exchange1=myMatrix.getRow(up.getSqures(), 1);
        myMatrix.setRow(up.getSqures(), 1, myMatrix.reverseOrder(myMatrix.getColumn(left.getSqures(), 1)));
        exchange2=myMatrix.getColumn(right.getSqures(), 3);
        myMatrix.setColumn(right.getSqures(), 3, exchange1);
        exchange1=myMatrix.getRow(down.getSqures(), 3);
        myMatrix.setRow(down.getSqures(), 3, myMatrix.reverseOrder(exchange1));
        myMatrix.setColumn(left.getSqures(), 1, exchange2);
    }
    /** 后两层逆时针转180° */
    public void bn2() {
        bn();bn();
    }
    /** B层逆时针转180° */
    public void Bn2() {
        Bn();Bn();
    }
    /** 下两层顺时针转90° */
    public void d() {
        D();E();
    }
    /** D层顺时针转90° */
    public void D(){
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotate(down.getSqures());
        exchange1=myMatrix.getRow(front.getSqures(),3);
        myMatrix.setRow(front.getSqures(), 3, myMatrix.getRow(right.getSqures(), 3));
        exchange2=myMatrix.getRow(left.getSqures(),3);
        myMatrix.setRow(left.getSqures(), 3,exchange1);
        exchange1=myMatrix.getRow(behind.getSqures(),3);
        myMatrix.setRow(behind.getSqures(), 3,exchange2);
        myMatrix.setRow(right.getSqures(), 3,exchange1);
    }
    /** 下两层顺时针转180° */
    public void d2() {
        d();d();
    }
    /** D层顺时针转180° */
    public void D2(){
        D();D();
    }
    /** 下两层逆时针转90° */
    public void dn() {
        Dn();En();
    }
    /** D层逆时针转90° */
    public void Dn() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotateN(down.getSqures());
        exchange1=myMatrix.getRow(front.getSqures(), 3);
        myMatrix.setRow(front.getSqures(), 3, myMatrix.getRow(left.getSqures(), 3));
        exchange2=myMatrix.getRow(right.getSqures(), 3);
        myMatrix.setRow(right.getSqures(), 3, exchange1);
        exchange1=myMatrix.getRow(behind.getSqures(), 3);
        myMatrix.setRow(behind.getSqures(), 3, exchange2);
        myMatrix.setRow(left.getSqures(), 3, exchange1);
    }
    /** 下两层逆时针转180° */
    public void dn2() {
        dn();dn();
    }
    /** D层逆时针转180° */
    public void Dn2() {
        Dn();Dn();
    }
    /** 判断魔方是否处于正确的状态  */
    public boolean doesCubeStatusCorrect() {
        if(!up.doesFlatStatusSame()) return false;
        if(!down.doesFlatStatusSame()) return false;
        if(!front.doesFlatStatusSame()) return false;
        if(!behind.doesFlatStatusSame()) return false;
        if(!left.doesFlatStatusSame()) return false;
        if(!right.doesFlatStatusSame()) return false;
        return true;
    }
    /** 中间层从上往下看逆时针转90° */
    public void E() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        exchange1=myMatrix.getRow(right.getSqures(),2);
        myMatrix.setRow(right.getSqures(), 2,myMatrix.getRow(front.getSqures(), 2));
        exchange2=myMatrix.getRow(behind.getSqures(), 2);
        myMatrix.setRow(behind.getSqures(), 2,exchange1);
        exchange1=myMatrix.getRow(left.getSqures(), 2);
        myMatrix.setRow(left.getSqures(), 2,exchange2);
        myMatrix.setRow(front.getSqures(), 2,exchange1);
    }
    /** 中间层从上往下看顺时针转180° */
    public void E2() {
        E();E();
    }
    /** 中间层从上往下看顺时针转90° */
    public void En() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        exchange1=myMatrix.getRow(left.getSqures(), 2);
        myMatrix.setRow(left.getSqures(), 2, myMatrix.getRow(front.getSqures(), 2));
        exchange2=myMatrix.getRow(behind.getSqures(), 2);
        myMatrix.setRow(behind.getSqures(), 2, exchange1);
        exchange1=myMatrix.getRow(right.getSqures(), 2);
        myMatrix.setRow(right.getSqures(), 2, exchange2);
        myMatrix.setRow(front.getSqures(), 2, exchange1);
    }
    /** 中间层从上往下看逆时针转180° */
    public void En2() {
        En();En();
    }
    @Override
    public boolean equals(Object obj) {
        if(this==obj) {//比较对象引用地址
            return true;
        }
        if(obj instanceof ThirdOrderCube) {//比较对象类型
            
            ThirdOrderCube cube=(ThirdOrderCube)obj;
            if(hashCode()!=cube.hashCode()) {//比较对象hashcode
                return false;
            }
            else {//比较对象的完整内容
                boolean flag=true;
                if(cube.getUp().equals(up)&&cube.getUp().equals(down)&&cube.getUp().equals(front)&&
                   cube.getUp().equals(behind)&&cube.getUp().equals(left)&&cube.getUp().equals(right)){
                    return true;
                }
                else return flag;
            }
        }
        return false;
    }
    /** 前两层顺时针转90° */
    public void f() {
        F();S();
    }
    /** F层顺时针转90° */
    public void F() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotate(front.getSqures());
        exchange1=myMatrix.getRow(up.getSqures(),3);
        myMatrix.setRow(up.getSqures(), 3,myMatrix.reverseOrder(myMatrix.getColumn(left.getSqures(), 3)));
        exchange2=myMatrix.getColumn(right.getSqures(), 1);
        myMatrix.setColumn(right.getSqures(), 1,exchange1);
        exchange1=myMatrix.getRow(down.getSqures(),1);
        myMatrix.setRow(down.getSqures(),1,myMatrix.reverseOrder(exchange2));
        myMatrix.setColumn(left.getSqures(),3, exchange1);
    }
    /** 前两层顺时针转180° */
    public void f2() {
        f();f();
    }
    /** F层顺时针转180° */
    public void F2() {
        F();F();
    }
    /** 前两层逆时针转90° */
    public void fn() {
        Fn();Sn();
    }
    /** F层逆时针转90° */
    public void Fn() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotateN(front.getSqures());
        exchange1=myMatrix.getRow(up.getSqures(), 3);
        myMatrix.setRow(up.getSqures(), 3,myMatrix.getColumn(right.getSqures(), 1));
        exchange2=myMatrix.getColumn(left.getSqures(), 3);
        myMatrix.setColumn(left.getSqures(), 3, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getRow(down.getSqures(), 1);
        myMatrix.setRow(down.getSqures(), 1, exchange2);
        myMatrix.setColumn(right.getSqures(), 1, myMatrix.reverseOrder(exchange1));
    }
    /** 前两层逆时针转180° */
    public void fn2() {
        fn();fn();
    }
    /** F层逆时针转180° */
    public void Fn2() {
        Fn();Fn();
    }
    public ThirdOrderFlat getBehind() {
        return behind;
    }
    public ThirdOrderFlat getDown() {
        return down;
    }
    public ThirdOrderFlat getFront() {
        return front;
    }
    public int getHash() {
        return hash;
    }
    public ThirdOrderFlat getLeft() {
        return left;
    }
    public ThirdOrderFlat getRight() {
        return right;
    }
    public ThirdOrderFlat getUp() {
        return up;
    }
    @Override
    public int hashCode() {
        int h = hash;
        if(h==0){
            h+=up.hashCode();
            h+=down.hashCode();
            h+=front.hashCode();
            h+=behind.hashCode();
            h+=left.hashCode();
            h+=right.hashCode();
            hash=h;
        }
        return h;
    }
    /** 左两层顺时针转90° */
    public void l() {
        L();M();
    }
    /** L层顺时针转90° */
    public void L() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotate(left.getSqures());
        exchange1=myMatrix.getColumn(up.getSqures(), 1);
        myMatrix.setColumn(up.getSqures(), 1, myMatrix.reverseOrder(myMatrix.getColumn(behind.getSqures(), 3)));
        exchange2=myMatrix.getColumn(front.getSqures(), 1);
        myMatrix.setColumn(front.getSqures(), 1, exchange1);
        exchange1=myMatrix.getColumn(down.getSqures(), 1);
        myMatrix.setColumn(down.getSqures(), 1, exchange2);
        myMatrix.setColumn(behind.getSqures(), 3, myMatrix.reverseOrder(exchange1));
    }
    /** 左两层顺时针转180° */
    public void l2() {
        l();l();
    }
    /** L层顺时针转180° */
    public void L2() {
        L();L();
    }
    /** 左两层逆时针转90° */
    public void ln() {
        Ln();Mn();
    }
    /** L层逆时针转90° */
    public void Ln() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotateN(left.getSqures());
        exchange1=myMatrix.getColumn(up.getSqures(), 1);
        myMatrix.setColumn(up.getSqures(), 1, myMatrix.getColumn(front.getSqures(), 1));
        exchange2=myMatrix.getColumn(behind.getSqures(), 3);
        myMatrix.setColumn(behind.getSqures(), 3, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getColumn(down.getSqures(), 1);
        myMatrix.setColumn(down.getSqures(), 1, myMatrix.reverseOrder(exchange2));
        myMatrix.setColumn(front.getSqures(), 1, exchange1);
    }
    /** 左两层逆时针转180° */
    public void ln2() {
        ln();ln();
    }
    /** L层逆时针转180° */
    public void Ln2() {
        Ln();Ln();
    }
    /** 中间层从左往右看顺时针转90° */
    public void M() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        exchange1=myMatrix.getColumn(front.getSqures(), 2);
        myMatrix.setColumn(front.getSqures(), 2,myMatrix.getColumn(up.getSqures(), 2));
        exchange2=myMatrix.getColumn(down.getSqures(), 2);
        myMatrix.setColumn(down.getSqures(), 2,exchange1);
        exchange1=myMatrix.getColumn(behind.getSqures(), 2);
        myMatrix.setColumn(behind.getSqures(), 2,myMatrix.reverseOrder(exchange2));
        myMatrix.setColumn(up.getSqures(), 2,myMatrix.reverseOrder(exchange1));
    }
    /** 中间层从左往右看顺时针转180° */
    public void M2() {
        M();M();
    }
    /** 中间层从左往右看逆时针转90° */
    public void Mn() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        exchange1=myMatrix.getColumn(up.getSqures(), 2);
        myMatrix.setColumn(up.getSqures(), 2, myMatrix.getColumn(front.getSqures(), 2));
        exchange2=myMatrix.getColumn(behind.getSqures(), 2);
        myMatrix.setColumn(behind.getSqures(), 2, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getColumn(down.getSqures(), 2);
        myMatrix.setColumn(down.getSqures(), 2, myMatrix.reverseOrder(exchange2));
        myMatrix.setColumn(front.getSqures(), 2, exchange1);
    }
    /** 中间层从左往右看逆时针转180° */
    public void Mn2() {
        Mn();Mn();
    }
    /** 以文本方式输出六个面状态 */
    public void println() {
        System.out.println("--上-- --下-- --左-- --前-- --右-- --后--");
        //第一行
        up.print(1);
        down.print(1);
        left.print(1);
        front.print(1);
        right.print(1);
        behind.print(1);
        System.out.println();
        //第二行
        up.print(2);
        down.print(2);
        left.print(2);
        front.print(2);
        right.print(2);
        behind.print(2);
        System.out.println();
        //第三行
        up.print(3);
        down.print(3);
        left.print(3);
        front.print(3);
        right.print(3);
        behind.print(3);
        System.out.println();
        //System.out.println("面以[上下左前右后]排列");
    }
    /** 右两层顺时针转90° */
    public void r() {
        R();Mn();
    }
    /** R层顺时针转90° */
    public void R() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotate(right.getSqures());
        exchange1=myMatrix.getColumn(up.getSqures(), 3);
        myMatrix.setColumn(up.getSqures(), 3,myMatrix.getColumn(front.getSqures(), 3));
        exchange2=myMatrix.getColumn(behind.getSqures(), 1);
        myMatrix.setColumn(behind.getSqures(), 1, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getColumn(down.getSqures(), 3);
        myMatrix.setColumn(down.getSqures(), 3, myMatrix.reverseOrder(exchange2));
        myMatrix.setColumn(front.getSqures(), 3, exchange1);
    }
    /** 右两层顺时针转180° */
    public void r2() {
        r();r();
    }
    /** R层顺时针转180° */
    public void R2() {
        R();R();
    }
    /** 右两层逆时针转90° */
    public void rn() {
        Rn();M();
    }
    /** R层逆时针转90° */
    public void Rn() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotateN(right.getSqures());
        exchange1=myMatrix.getColumn(up.getSqures(), 3);
        myMatrix.setColumn(up.getSqures(), 3, myMatrix.reverseOrder(myMatrix.getColumn(behind.getSqures(), 1)));
        exchange2=myMatrix.getColumn(front.getSqures(), 3);
        myMatrix.setColumn(front.getSqures(), 3, exchange1);
        exchange1=myMatrix.getColumn(down.getSqures(), 3);
        myMatrix.setColumn(down.getSqures(), 3, exchange2);
        myMatrix.setColumn(behind.getSqures(), 1, myMatrix.reverseOrder(exchange1));
    }
    /** 右两层逆时针转180° */
    public void rn2() {
        rn();rn();
    }
    /** R层逆时针转180° */
    public void Rn2() {
        Rn();Rn();
    }
    /** 中间层从前往后看顺时针转90° */
    public void S() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        exchange1=myMatrix.getColumn(right.getSqures(), 2);
        myMatrix.setColumn(right.getSqures(), 2, myMatrix.getRow(up.getSqures(), 2));
        exchange2=myMatrix.getRow(down.getSqures(), 2);
        myMatrix.setRow(down.getSqures(), 2, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getColumn(left.getSqures(), 2);
        myMatrix.setColumn(left.getSqures(), 2, exchange2);
        myMatrix.setRow(up.getSqures(), 2, myMatrix.reverseOrder(exchange1));
        
    }
    /** 中间层从前往后看顺时针转180° */
    public void S2() {
        S();S();
        
    }
    public void setBehind(ThirdOrderFlat behind) {
        this.behind = behind;
    }
    public void setDown(ThirdOrderFlat down) {
        this.down = down;
    }
    public void setFront(ThirdOrderFlat front) {
        this.front = front;
    }
    public void setHash(int hash) {
        this.hash = hash;
    }
    public void setLeft(ThirdOrderFlat left) {
        this.left = left;
    }
    public void setRight(ThirdOrderFlat right) {
        this.right = right;
    }
    public void setUp(ThirdOrderFlat up) {
        this.up = up;
    }
    /** 中间层从前往后看逆时针转90° */
    public void Sn() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        exchange1=myMatrix.getRow(up.getSqures(), 2);
        myMatrix.setRow(up.getSqures(), 2, myMatrix.getColumn(right.getSqures(), 2));
        exchange2=myMatrix.getColumn(left.getSqures(), 2);
        myMatrix.setColumn(left.getSqures(), 2, myMatrix.reverseOrder(exchange1));
        exchange1=myMatrix.getRow(down.getSqures(), 2);
        myMatrix.setRow( down.getSqures(), 2, exchange2);
        myMatrix.setColumn(right.getSqures(), 2, myMatrix.reverseOrder(exchange1));
    }
    /** 中间层从前往后看逆时针转180° */
    public void Sn2() {
        Sn();Sn();
    }
    @Override
    public String toString() {
        StringBuffer result=new StringBuffer();
        result.append("上面：\n").append(up.toString());
        result.append("下面：\n").append(down.toString());
        result.append("前面：\n").append(front.toString());
        result.append("后面：\n").append(behind.toString());
        result.append("左面：\n").append(left.toString());
        result.append("右面：\n").append(right.toString());
        return result.toString();
    }
    //双层转
    /** 上两层顺时针转180° */
    public void u() {
        U();En();
    }
    //单层转
    /** U层顺时针转90° */
    public void U(){
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotate(up.getSqures());
        exchange1=myMatrix.getRow(front.getSqures(),1);
        myMatrix.setRow(front.getSqures(), 1, myMatrix.getRow(right.getSqures(), 1));
        exchange2=myMatrix.getRow(left.getSqures(),1);
        myMatrix.setRow(left.getSqures(), 1,exchange1);
        exchange1=myMatrix.getRow(behind.getSqures(),1);
        myMatrix.setRow(behind.getSqures(), 1,exchange2);
        myMatrix.setRow(right.getSqures(), 1,exchange1);
    }
    /** 上两层顺时针转180° */
    public void u2() {
        u();u();
    }
    /** U层顺时针转180° */
    public void U2(){
        U();U();
    }
    /** 上两层逆时针转90° */
    public void un() {
        Un();E();
    }
    /** U层逆时针转90° */
    public void Un() {
        Object[] exchange1=null;
        Object[] exchange2=null;
        myMatrix.rotateN(up.getSqures());
        exchange1=myMatrix.getRow(front.getSqures(), 1);
        myMatrix.setRow(front.getSqures(), 1, myMatrix.getRow(left.getSqures(), 1));
        exchange2=myMatrix.getRow(right.getSqures(), 1);
        myMatrix.setRow(right.getSqures(), 1, exchange1);
        exchange1=myMatrix.getRow(behind.getSqures(), 1);
        myMatrix.setRow(behind.getSqures(), 1, exchange2);
        myMatrix.setRow(left.getSqures(), 1, exchange1);
    }

    /** 上两层逆时针转180° */
    public void un2() {
        un();un();
    }

    /** U层逆时针转180° */
    public void Un2() {
        Un();Un();
    }

    //整体转
    /** 整个魔方按R方向旋转90° */
    public void x() {
        ln();R();
    }

    /** 整个魔方按R方向旋转180° */
    public void x2() {
        x();x();
    }

    /** 整个魔方按R'方向旋转90° */
    public void xn() {
        l();Rn();
    }

    /** 整个魔方按R'方向旋转180° */
    public void xn2() {
        xn();xn();
    }

    /** 整个魔方按U方向旋转90° */
    public void y() {
        u();Dn();
    }

    /** 整个魔方按U方向旋转180° */
    public void y2() {
        y();y();
    }

    /** 整个魔方按U'方向旋转90° */
    public void yn() {
        un();D();
    }

    /** 整个魔方按U'方向旋转180° */
    public void yn2() {
        yn();yn();
    }

    /** 整个魔方按F方向旋转90° */
    public void z() {
        f();Bn();
    }

    /** 整个魔方按F方向旋转180° */
    public void z2() {
        z();z();
    }

    /** 整个魔方按F'方向旋转90° */
    public void zn() {
        fn();B();
    }

    /** 整个魔方按F'方向旋转180° */
    public void zn2() {
        zn();zn();
    }
    
}
