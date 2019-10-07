package org.fdh.cube.gui;

import org.fdh.cube.util.Environment;


public class Test{
    public static void main(String[] args) throws ClassNotFoundException {
//        //KeyboardLitenerTest Test = new KeyboardLitenerTest();
//        CMDThread runnable=new CMDThread();
//        Thread thread=new Thread(runnable);
//        thread.start();
        ClassLoader.getSystemClassLoader().loadClass("org.fdh.cube.util.Environment");
        System.out.println(Environment.get("workspace"));
    }
}
