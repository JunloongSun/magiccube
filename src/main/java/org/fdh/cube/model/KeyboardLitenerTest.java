package org.fdh.cube.model;


import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;


public class KeyboardLitenerTest extends JFrame{    
    private MyPanel1 myPanle;    
    //需不需要这个呢？父容器的事件监听器会监听子元素的事件吗？
    //private int controlPattern=0;//0表示键盘直接控制，1表示输入文本执行。
    
    
    public KeyboardLitenerTest() {
        myPanle = new MyPanel1();
        this.add(myPanle);
        this.addKeyListener(myPanle);
        this.setSize(400, 300);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setVisible(true);
    }

}
/** main panel */
class MyPanel1 extends JPanel implements KeyListener{
    ThirdOrderCube cube;
    FormulaAnalysis formulaAnalysis;
    private FormulaThread thread;
    
    public MyPanel1() {
        super();
        System.out.println("生成魔方..");
        cube=new ThirdOrderCube();
        System.out.println("创建公式符号处理对象..");
        formulaAnalysis=new FormulaAnalysis();
        System.out.println("创建执行线程...");
        thread=new FormulaThread(cube);
        System.out.print("生成打乱公式...");
        List<Turns> list=formulaAnalysis.randomFormula(30);
        thread.addIntoQueue(list);
        System.out.print(formulaAnalysis.convert(list));
        System.out.println("打乱中...");
        thread.start();
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(Thread.State.WAITING==thread.formulaThread.getState()) {
            if(Turns.ERROR==formulaAnalysis.convert(String.valueOf(e.getKeyChar()))) {//非公式输入
                if(e.getKeyChar()=='p'||e.getKeyChar()=='P') {//输出状态
                    thread.setForPrintStatus();
                    thread.setForBlock();
                    synchronized (thread.getFormulaQueue()) {
                        thread.getFormulaQueue().notifyAll();
                    }
                }
                if(e.getKeyChar()=='t'||e.getKeyChar()=='T') {//终止线程
                    thread.setForTerminate();
                    synchronized (thread.getFormulaQueue()) {
                        thread.getFormulaQueue().notifyAll();
                    }
                }
                if(e.getKeyChar()=='o'||e.getKeyChar()=='O') {
                    thread.outRecord();
                }
            }
            else {//公式输入,逆时针和双层转逆时针要特殊处理
                thread.addIntoQueue(formulaAnalysis.extract(String.valueOf(e.getKeyChar())));
                synchronized (thread.getFormulaQueue()) {
                    thread.getFormulaQueue().notifyAll();
                } 
                if(e.getKeyCode()==KeyEvent.VK_Z&&e.isControlDown()) {//同时按下ctrl+z
                    System.out.println("pressed ctrl+z");
                }
                if(e.getKeyCode()==KeyEvent.VK_Z&&e.isShiftDown()) {//同时按下shift+z
                    System.out.println("pressed shift+z");
                }
            }
            
            
        }
        else if(Thread.State.TERMINATED==thread.formulaThread.getState()){
            System.out.println("线程已结束");
        }
        else {
            if(Turns.ERROR==formulaAnalysis.convert(String.valueOf(e.getKeyChar()))&&e.getKeyChar()!='o'&&e.getKeyChar()!='O') {//非公式输入且不为o
                if(e.getKeyChar()=='p'||e.getKeyChar()=='P') {//输出状态
                    thread.setForPrintStatus();
                    thread.setForBlock();
//                    synchronized (thread.getFormulaQueue()) {
//                        thread.getFormulaQueue().notifyAll();
//                    }
                }
                if(e.getKeyChar()=='t'||e.getKeyChar()=='T') {//终止线程
                    thread.setForTerminate();
                }
            }
            else {//公式输入
                System.out.println("公式未执行完毕，请稍等...");
            }
        }
    }

    @Override
    public void keyReleased(KeyEvent e) { 
    }


}