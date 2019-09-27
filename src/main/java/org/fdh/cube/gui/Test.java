package org.fdh.cube.gui;


import java.util.HashMap;

import org.fdh.cube.model.FormulaThread;
import org.fdh.cube.model.KeyboardLitenerTest;
import org.fdh.cube.model.ThirdOrderCube;
import org.fdh.cube.thread.CMDThread;

import com.alibaba.fastjson.JSONObject;


public class Test{
    public static void main(String[] args) {
        //KeyboardLitenerTest Test = new KeyboardLitenerTest();
        CMDThread runnable=new CMDThread();
        Thread thread=new Thread(runnable);
        thread.start();
    }
}
