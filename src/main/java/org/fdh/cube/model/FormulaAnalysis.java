package org.fdh.cube.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** 自定义公式解析类
 * @author sunjianglong 2019-7-5 
 * */
public class FormulaAnalysis{
    /** 正则表达式pattern-公式格式 */
    private static final String REGEX=new String("[UuDdLlRrFfBbEMSxyz]'?2?");
    /** 提取符合公式规则的字符串，并拆分至字符集合。 
     * @param source 原字符串
     * @return 提取出的字符串集合
     * */
    public List<Turns> extract(String source) {
        List<Turns> result=new LinkedList<Turns>();
        Pattern pattern = Pattern.compile(REGEX);  
        Matcher matcher = pattern.matcher(source); 
        while (matcher.find()) {  
            result.add(convert(matcher.group()));
        } 
        return result;
    }
    /** 产生指定范围的随机整数，包括边界 */
    private int randomInt(int min,int max) {
        return new Random().nextInt(max-min)+min;//nextInt(parm)表示产生0-parm类均匀分布的伪随机数
    }
    /** 生成打乱公式
     * @param count 单元个数
     *  */
    public List<Turns> randomFormula(int count){
        List<Turns> list=new ArrayList<Turns>();
        int random;
        for (int i = 0; i < count; i++) {
            random=randomInt(1,72);
            list.add(Turns.getEnumType(random));
        }
        list.add(Turns.ERROR);//用作分割作用
        return list;
    }
    
    /** 字符公式转化为枚举。
     * switch 语句中的变量类型可以是： byte、short、int 或者 char。从 Java SE 7 开始，switch 支持字符串 String 类型了，同时 case 标签必须为字符串常量或字面量。
     * @param formula 字符公式
     * @return 转化后的公式
     * */
    public Turns convert(String formula){
        switch (formula) {
            case "U":return Turns.U;
            case "D":return Turns.D;
            case "F":return Turns.F;
            case "B":return Turns.B;
            case "L":return Turns.L;
            case "R":return Turns.R;
            case "E":return Turns.E;
            case "M":return Turns.M;
            case "S":return Turns.S;
            case "x":return Turns.x;
            case "y":return Turns.y;
            case "z":return Turns.z;
            case "U2":return Turns.U2;
            case "D2":return Turns.D2;
            case "F2":return Turns.F2;
            case "B2":return Turns.B2;
            case "L2":return Turns.L2;
            case "R2":return Turns.R2;
            case "E2":return Turns.E2;
            case "M2":return Turns.M2;
            case "S2":return Turns.S2;
            case "x2":return Turns.x2;
            case "y2":return Turns.y2;
            case "z2":return Turns.z2;
            case "U'":return Turns.Un;
            case "D'":return Turns.Dn;
            case "F'":return Turns.Fn;
            case "B'":return Turns.Bn;
            case "L'":return Turns.Ln;
            case "R'":return Turns.Rn;
            case "E'":return Turns.En;
            case "M'":return Turns.Mn;
            case "S'":return Turns.Sn;
            case "x'":return Turns.xn;
            case "y'":return Turns.yn;
            case "z'":return Turns.zn;
            case "U'2":return Turns.Un2;
            case "D'2":return Turns.Dn2;
            case "F'2":return Turns.Fn2;
            case "B'2":return Turns.Bn2;
            case "L'2":return Turns.Ln2;
            case "R'2":return Turns.Rn2;
            case "E'2":return Turns.En2;
            case "M'2":return Turns.Mn2;
            case "S'2":return Turns.Sn2;
            case "x'2":return Turns.xn2;
            case "y'2":return Turns.yn2;
            case "z'2":return Turns.zn2;
            case "u":return Turns.u;
            case "d":return Turns.d;
            case "f":return Turns.f;
            case "b":return Turns.b;
            case "l":return Turns.l;
            case "r":return Turns.r;
            case "u2":return Turns.u2;
            case "d2":return Turns.d2;
            case "f2":return Turns.f2;
            case "b2":return Turns.b2;
            case "l2":return Turns.l2;
            case "r2":return Turns.r2;
            case "u'":return Turns.un;
            case "d'":return Turns.dn;
            case "f'":return Turns.fn;
            case "b'":return Turns.bn;
            case "l'":return Turns.ln;
            case "r'":return Turns.rn;
            case "u'2":return Turns.un2;
            case "d'2":return Turns.dn2;
            case "f'2":return Turns.fn2;
            case "b'2":return Turns.bn2;
            case "l'2":return Turns.ln2;
            case "r'2":return Turns.rn2;
            default:return Turns.ERROR;
        }
    }
    /** 执行公式 
     * @param formula 公式，枚举类型
     * */
    public void execute(ThirdOrderCube cube,Turns formula) {
        switch (formula) {
        case U:cube.U();break;
        case D:cube.D();break;
        case F:cube.F();break;
        case B:cube.B();break;
        case L:cube.L();break;
        case R:cube.R();break;
        case E:cube.E();break;
        case M:cube.M();break;
        case S:cube.S();break;
        case x:cube.x();break;
        case y:cube.y();break;
        case z:cube.z();break;
        case U2:cube.U2();break;
        case D2:cube.D2();break;
        case F2:cube.F2();break;
        case B2:cube.B2();break;
        case L2:cube.L2();break;
        case R2:cube.R2();break;
        case E2:cube.E2();break;
        case M2:cube.M2();break;
        case S2:cube.S2();break;
        case x2:cube.x2();break;
        case y2:cube.y2();break;
        case z2:cube.z2();break;
        case Un:cube.Un();break;
        case Dn:cube.Dn();break;
        case Fn:cube.Fn();break;
        case Bn:cube.Bn();break;
        case Ln:cube.Ln();break;
        case Rn:cube.Rn();break;
        case En:cube.En();break;
        case Mn:cube.Mn();break;
        case Sn:cube.Sn();break;
        case xn:cube.xn();break;
        case yn:cube.yn();break;
        case zn:cube.zn();break;
        case Un2:cube.Un2();break;
        case Dn2:cube.Dn2();break;
        case Fn2:cube.Fn2();break;
        case Bn2:cube.Bn2();break;
        case Ln2:cube.Ln2();break;
        case Rn2:cube.Rn2();break;
        case En2:cube.En2();break;
        case Mn2:cube.Mn2();break;
        case Sn2:cube.Sn2();break;
        case xn2:cube.xn2();break;
        case yn2:cube.yn2();break;
        case zn2:cube.zn2();break;
        case u:cube.u();break;
        case d:cube.d();break;
        case f:cube.f();break;
        case b:cube.b();break;
        case l:cube.l();break;
        case r:cube.r();break;
        case u2:cube.u2();break;
        case d2:cube.d2();break;
        case f2:cube.f2();break;
        case b2:cube.b2();break;
        case l2:cube.l2();break;
        case r2:cube.r2();break;
        case un:cube.un();break;
        case dn:cube.dn();break;
        case fn:cube.fn();break;
        case bn:cube.bn();break;
        case ln:cube.ln();break;
        case rn:cube.rn();break;
        case un2:cube.un2();break;
        case dn2:cube.dn2();break;
        case fn2:cube.fn2();break;
        case bn2:cube.bn2();break;
        case ln2:cube.ln2();break;
        case rn2:cube.rn2();break;
        default :break;
        }
    }
    /** 将枚举转化为字符串 */
    public String convert(Turns turn){
        switch (turn) {
            case U:return "U";
            case D:return "D";
            case F:return "F";
            case B:return "B";
            case L:return "L";
            case R:return "R";
            case E:return "E";
            case M:return "M";
            case S:return "S";
            case x:return "x";
            case y:return "y";
            case z:return "z";
            case U2:return "U2";
            case D2:return "D2";
            case F2:return "F2";
            case B2:return "B2";
            case L2:return "L2";
            case R2:return "R2";
            case E2:return "E2";
            case M2:return "M2";
            case S2:return "S2";
            case x2:return "x2";
            case y2:return "y2";
            case z2:return "z2";
            case Un:return "U'";
            case Dn:return "D'";
            case Fn:return "F'";
            case Bn:return "B'";
            case Ln:return "L'";
            case Rn:return "R'";
            case En:return "E'";
            case Mn:return "M'";
            case Sn:return "S'";
            case xn:return "x'";
            case yn:return "y'";
            case zn:return "z'";
            case Un2:return "U'2";
            case Dn2:return "D'2";
            case Fn2:return "F'2";
            case Bn2:return "B'2";
            case Ln2:return "L'2";
            case Rn2:return "R'2";
            case En2:return "E'2";
            case Mn2:return "M'2";
            case Sn2:return "S'2";
            case xn2:return "x'2";
            case yn2:return "y'2";
            case zn2:return "z'2";
            case u:return "u";
            case d:return "d";
            case f:return "f";
            case b:return "b";
            case l:return "l";
            case r:return "r";
            case u2:return "u2";
            case d2:return "d2";
            case f2:return "f2";
            case b2:return "b2";
            case l2:return "l2";
            case r2:return "r2";
            case un:return "u'";
            case dn:return "d'";
            case fn:return "f'";
            case bn:return "b'";
            case ln:return "l'";
            case rn:return "r'";
            case un2:return "u'2";
            case dn2:return "d'2";
            case fn2:return "f'2";
            case bn2:return "b'2";
            case ln2:return "l'2";
            case rn2:return "r'2";
            default:return "\n";
        }
    }
    public StringBuilder convert(List<Turns> list) {
        StringBuilder stringBuilder=new StringBuilder();
        for (Turns item : list) {
            stringBuilder.append(convert(item));
        }
        return stringBuilder;
    }
    public StringBuilder convert(Queue<Turns> queue) {
        StringBuilder stringBuilder=new StringBuilder();
        for (Turns turns : queue) {
            stringBuilder.append(convert(turns));
        }
//        while(!queue.isEmpty()) {
//            stringBuffer.append(convert(queue.poll()));
//        }
        return stringBuilder;
    }
}
