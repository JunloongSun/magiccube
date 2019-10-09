package org.fdh.cube.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import org.fdh.cube.commandInterpreter.ReadCMD;
import org.fdh.cube.commandInterpreter.ShellCMD;
import org.fdh.cube.commandInterpreter.ThreadNode;

public class Environment{
    private static OutPut outPut;
    /** 基于数组的阻塞队列，大小20。 */
    public static List<String> cmdBuffer=new LinkedList<String>();
    private static Map<String, Object> prameters=new HashMap<String, Object>();
    public static ThreadNode rootThread;
    static {
        cmdBuffer.add("null");
        rootThread=new ThreadNode(new ReadCMD());
        rootThread.getItself().start();
        //初始化一些变量
        prameters.put("command_prompt", "[root@localhost ~]# ");//命令提示符
        prameters.put("workspace", System.getProperty("user.dir"));//当前工作路径(项目路径)
    }
    public static void setOutPut(OutPut outPut) {
        Environment.outPut = outPut;
    }
    public static Object get(String key) {
        return prameters.get(key);
    }
    public static void print(String text) {
        outPut.print(text);
    }
    public static void println(String text) {
        outPut.println(text);
    }
    public static void addcmd(String text) {
        cmdBuffer.add(text);
        if(cmdBuffer.size()>20) {
            cmdBuffer.remove(0);//删除first
        }
    }
    public static String getcmd() {
        return cmdBuffer.get(cmdBuffer.size()-1);
    }
    public static void threadInfo() {
        ThreadNode currentNode=rootThread;
        outPut.println("pid    pname    state");
        while(currentNode.getChild()!=null) {
            for (int i = 0; i < currentNode.count; i++) {
                outPut.print(Long.toString(currentNode.getChild()[i].getId())+"    ");
                outPut.print(currentNode.getChild()[i].getName()+"    ");
                outPut.println(currentNode.getChild()[i].getState().toString());
            }
            currentNode=currentNode.getChild()[currentNode.count-1];
        }
        
    }
    public static void resolveCMD(String cmdString) {
        //命令格式:cube [命令] [-options]/命令   //是否动态展现过程
        //应该由该进程来创建子进程，主进程销毁，子进程也要销毁。
        if(cmdString.length()<5) {
            ShellCMD shellCMD=new ShellCMD(cmdString);
            shellCMD.resolveCMD(cmdString);
            Environment.println(get("command_prompt").toString());
        }
        else {
            if (cmdString.substring(0, 5).equals("cube")) {
                //CubeCMD.getQueue().add(cmdString.substring(5,cmdString.length()));
                System.out.println("nothing to process");
            }
            else {
                ShellCMD shellCMD=new ShellCMD(cmdString);
                shellCMD.resolveCMD(cmdString);
            }
        }
    }
}
