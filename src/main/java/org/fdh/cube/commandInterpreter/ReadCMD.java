package org.fdh.cube.commandInterpreter;

import org.fdh.cube.util.Environment;

/** 从Enviroment消息队列中取命令，辨别类型然后送到CubeCMD和ReadCMD */
public class ReadCMD implements Runnable{
    private String cmdString;
    @Override
    public void run() {
        while(true) {
            cmdString=Environment.getcmd();
            if(cmdString.equals("null")) {
                synchronized (Environment.cmdBuffer) {
                    try {
                        System.out.println("roothread start,nothing to do,wait.");
                        Environment.cmdBuffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            else {
                Environment.resolveCMD(cmdString);
                synchronized (Environment.cmdBuffer) {
                    try {
                        Environment.cmdBuffer.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
    
    
    

}
