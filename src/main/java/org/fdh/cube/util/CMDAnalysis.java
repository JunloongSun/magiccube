package org.fdh.cube.util;

import java.util.ArrayList;
import java.util.logging.Logger;

public class CMDAnalysis {
    /** "cmd -options" */
    private String value;
    
    public CMDAnalysis() {
    }
    public void except(String value) {
        this.value=value;
    }
    public void process() {
        String cmd;
        ArrayList<String> options=new ArrayList<String>();
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i)!=' '&&value.charAt(i+1)==' ') {//遇到空格分隔
                cmd=value.substring(0,i+1);
                value=value.substring(i+1,value.length());
            }
        }
        int count=0;//options计数
        for (int i = 0; i < value.length(); i++) {
            if(value.charAt(i)!=' '&&(value.charAt(i+1)==' '||value.charAt(i+1)=='\n')) {//遇到空格或结束符分隔
                options.get(count).=value.substring(0,i+1);
                count++;
            }
        }
        System.out.println(cmd);
        for (int i = 0; i < options.size(); i++) {
            System.out.println(options.get(i));
        }
//        switch (command) {
//        case "help":System.out.println("show some help info.");
//            break;
//        case "exit":
//            System.out.println("{pid:"+Thread.currentThread().getName()+","+"pname:"+Thread.currentThread().getId()+
//                    "} The main command thread has been stoped.");
//            //interrupt并不会直接中断线程，而是给线程一个中断标记。需要在线程处理方法中判断这个标记来终止线程。
//            Thread.currentThread().interrupt();
//            break;
//
//        default:
//            System.out.println("ERROR:No such command finded.You can use help to get command help info.");
//            break;
//        }
    }
    public void clear() {
        value=null;
    }
    public synchronized void runCMD(String value) { 
        except(value);
        process();
        clear();
    }
}
