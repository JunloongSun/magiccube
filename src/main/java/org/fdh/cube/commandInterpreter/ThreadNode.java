package org.fdh.cube.commandInterpreter;

import java.util.HashMap;
import java.util.Map;

public class ThreadNode extends Thread{
    private ThreadNode father=null;
    private Thread itself=null;
    private ThreadNode[] child=null;
    public int count=0;
    public ThreadNode(Runnable runnable) {
        itself=new Thread(runnable);
    }
    public ThreadNode(Thread thread) {
        itself=thread;
    }
    public ThreadNode getFather() {
        return father;
    }
    public ThreadNode[] getChild() {
        return child;
    }
    public ThreadNode getChild(long pid) {
        for (ThreadNode item : child) {
            if(item.getId()==pid) {
                return item;
            }
        }
        return null;
    }
    /** 添加子线程，返回pid */
    public long addChild(Runnable runnable) {
        if(child==null) {
            child=new ThreadNode[5];
        }
        if(count<5) {
            child[count]=new ThreadNode(runnable);
            count++;
            return child[count-1].getId();
        }
        else {
            for (int i=0;i<count;i++) {
                if(child[i].getItself().isAlive()) {
                    continue;
                }
                else {
                    child[i]=new ThreadNode(runnable);
                    return child[i].getId();
                }
            }
            return -1;
        }
        
    }
    public Thread getItself() {
        return itself;
    }
    
}
