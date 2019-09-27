package org.fdh.cube.model;

/** 公式枚举。先定义单层转，后面的都能又单层转组合。 */
public enum Turns{
    /** 旋转方式枚举 */
    U(1),D(2),F(3),B(4),L(5),R(6),E(7),M(8),S(9),x(10),y(11),z(12),
    /** 旋转方式枚举 */
    U2(13),D2(14),B2(15),L2(16),R2(17),E2(18),M2(19),S2(20),x2(21),y2(22),z2(23),
    /** 旋转方式枚举 */
    Un(24),Dn(25),Bn(26),Ln(27),Rn(28),En(29),Mn(30),Sn(31),xn(32),yn(33),zn(34),
    /** 旋转方式枚举 */
    Un2(35),Dn2(36),Bn2(37),Ln2(38),Rn2(39),En2(40),Mn2(41),Sn2(42),xn2(43),yn2(44),zn2(45),
    /** 旋转方式枚举 */
    u(46),d(47),f(48),b(49),l(50),r(51),
    /** 旋转方式枚举 */
    u2(52),d2(53),f2(54),b2(55),l2(56),r2(57),
    /** 旋转方式枚举 */
    un(58),dn(59),fn(60),bn(61),ln(62),rn(63),
    /** 旋转方式枚举 */
    un2(64),dn2(65),fn2(66),bn2(67),ln2(68),rn2(69),F2(70),Fn(71),Fn2(72),ERROR(73);     
    /** 带构造器的枚举必须包含私有构造器和私有属性 */
    private final int value;
    /** 带构造器的枚举必须包含私有构造器和私有属性 
     * @param value value
     * */
    Turns(int value) {
        this.value=value;
    }
    public int getValue() {
        return value;
    }
    public static Turns getEnumType (int val) {
        for (Turns type : Turns .values()) {
            if (type.getValue() == val) {
                return type;
            }
        }
        return null;
    }
}
