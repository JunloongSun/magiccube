package org.fdh.cube.commandInterpreter;

import java.awt.Component;
import java.util.LinkedList;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JPanel;

import org.fdh.cube.model.ThirdOrderCube;
import org.fdh.cube.util.Environment;

/** 包含魔方公式和进程，需要操作的魔方和视图 */
public class CubeCMD implements Runnable{
    private String cmdString;
    private ThirdOrderCube thirdOrderCube;
    private Component component;
    public CubeCMD(String cmdString, ThirdOrderCube thirdOrderCube,
            Component component) {
        super();
        this.cmdString = cmdString;
        this.thirdOrderCube = thirdOrderCube;
        this.component = component;
    }
    @Override
    public void run() {
        
    }
    public void resolveCMD(String cmdString) {
        
    }
    
}
