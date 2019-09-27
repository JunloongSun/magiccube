package org.fdh.cube;

import java.lang.reflect.AnnotatedType;

import org.fdh.cube.model.FormulaAnalysis;
import org.fdh.cube.model.FormulaThread;
import org.fdh.cube.model.ThirdOrderCube;

import junit.framework.TestCase;

public class AppletTest extends TestCase{
    
//    public void testCase1() {
//        ThirdOrderCube cube=new ThirdOrderCube();
//        System.out.println(cube.doesCubeStatusCorrect());
//    }
    
    /** 不以test开头的方法名会被忽略 */
    public void sdfsdf() {
        ObjectHelper objectHelper=new ObjectHelper();
        Class<? extends ObjectHelper> class1=objectHelper.getClass();
        AnnotatedType[] annotatedTypes=class1.getAnnotatedInterfaces();
        for (AnnotatedType annotatedType : annotatedTypes) {
            System.out.println(annotatedType.getType().getTypeName());
            
        }
    }
    
    
}
