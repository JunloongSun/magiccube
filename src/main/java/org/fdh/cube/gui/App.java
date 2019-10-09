package org.fdh.cube.gui;

import org.fdh.cube.commandInterpreter.ReadCMD;

/** 应该将执行程序与界面（外壳）分开，并且不是由界面来控制执行，执行与界面都是独立开始运行的，由中间桥梁进行沟通。 */
public class App{
    
    public static void main(String[] args) throws ClassNotFoundException{
        //1.开启程序运行的必要进程
        //2.开启关联的界面
        ClassLoader.getSystemClassLoader().loadClass("org.fdh.cube.util.Environment");
        MainFrame mainFrame=new MainFrame();
    }
}
