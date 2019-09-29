package org.fdh.cube.thread;

import java.util.Scanner;

import javax.swing.JTextArea;

import org.fdh.cube.util.CMDAnalysis;

public class CMDThread implements Runnable{
    private String command;
    private Scanner scanner;
    private CMDAnalysis cmdAnalysis;
    public CMDThread() {
        scanner=new Scanner(System.in);
        cmdAnalysis=new CMDAnalysis();
    }
    @Override
    public void run() {
        while(true) {
            System.out.print("[]#");//[root@localhost ~]
            command=scanner.nextLine()+"\n";System.out.print(command);
            
            cmdAnalysis.runCMD(command);
            if(Thread.currentThread().isInterrupted()) {
                break;
            }
            
        }
    }

}
