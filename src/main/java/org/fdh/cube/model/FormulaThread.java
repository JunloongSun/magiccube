package org.fdh.cube.model;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;


/** 
 * 用于执行公式的相关线程
 * @author sunjianglong 2019-7-19
 *  */
public class FormulaThread implements Runnable{
    /** 存放待执行的公式的队列 */
    private Queue<Turns> formulaQueue=new ArrayBlockingQueue<Turns>(200);
    /** 记录步骤 */
    private Queue<Turns> record=new ArrayBlockingQueue<Turns>(200);
    /** 线程，以t时间间隔从公式队列取公式执行 */
    public Thread formulaThread;
    /** 执行时间间隔ms */
    private Long interval;
    /** 公式解析、执行类 */
    private FormulaAnalysis formulaAnalysis;
    /** 线程终止标志 */
    private boolean endFlag;
    /** 输出魔方状态标志 */
    private boolean printFlag;
    /** 是否可访问，false可访问 */
    private boolean block;
    /** cube */
    private ThirdOrderCube cube;
    {
        formulaThread=new Thread(this);
        interval=new Long(200);
        formulaAnalysis=new FormulaAnalysis();
        endFlag=false;
        printFlag=false;
        block=false;//初始可访问
    }
    public FormulaThread(ThirdOrderCube cube) {
        this.cube=cube;
    }
    /** 开始线程 */
    public void start() {
        formulaThread.start();
    }
    /** 将公式转化成集合，并添加到队列 
     * @param list 公式集合
     * */
    public void addIntoQueue(String source) {
        formulaQueue.addAll(formulaAnalysis.extract(source));
    }
    public void addIntoQueue(List<Turns> list) {
        formulaQueue.addAll(list);
    }
    public Queue<Turns> getFormulaQueue() {
        return formulaQueue;
    }
    /** 执行完队列中所有公式后，终止线程 */
    public void setForTerminate() {
        endFlag=true;
        synchronized (formulaQueue) {
            formulaQueue.notify();
        }
    }
    /** 输出魔方状态,因为要保证不能输出错乱的魔方状态，所以交给转动线程来打印。完成完整的转动后，会打印状态。 */
    public void setForPrintStatus() {
        printFlag=true;
        synchronized (formulaQueue) {
            formulaQueue.notify();
        }
    }
    public void setForBlock() {
        block=false;
    }
    /** 公式未执行完毕，不能输出公式记录 */
    public void outRecord() {
        StringBuilder stringBuilder=formulaAnalysis.convert(record);
        System.out.print(stringBuilder);
    }
    /** 记录分段 */
    public void cutRecord() {
        record.add(Turns.ERROR);
    }
    @Override
    public void run() {
        System.out.println("----thread run----");
        while(true) {
            
            if(endFlag==true) {
                System.out.println("---thread end---");
                outRecord();
                break;
            }
            if(block==false&&printFlag==true) {
                cube.println();
                printFlag=false;
            }
            block=true;
            if(!formulaQueue.isEmpty()) {
                try {//以t时间间隔从公式队列取公式执行
                    Thread.sleep(interval);
                    if(formulaQueue.peek()!=Turns.ERROR) {
                        System.out.println("turn "+formulaAnalysis.convert(formulaQueue.peek()));
                    }
                    record.add(formulaQueue.peek());
                    formulaAnalysis.execute(cube, formulaQueue.poll());
                    
                    block=false;
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            else {
                synchronized (formulaQueue) {
                    try {
                        System.out.println("----thread wait----");
                        block=false;
                        formulaQueue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
            
        }
    }
    
}
