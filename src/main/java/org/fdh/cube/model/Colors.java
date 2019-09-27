package org.fdh.cube.model;

/** 颜色枚举 */
public enum Colors{
    /** 颜色枚举 */
    白(1),黄(2),红(3),橙(4),蓝(5),绿(6);
    /** 代码 */
    private final int value;
    /** 带构造器的枚举必须包含私有构造器和私有属性 
     * @param code 代码
     * */
    Colors(int value) {
        this.value=value;
    }
    public int getValue() {
        return value;
    }
}
