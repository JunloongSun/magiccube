package org.fdh.cube;
/** 断言测试  2019-7-16
 * @author sunjianglong
 */
public class AssertlTest {
    public static void main(String[] args) {
        boolean a=true;
        assert a=false:"发生错误";
        System.out.println(a);
    }
}
