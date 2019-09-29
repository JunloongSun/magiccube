package org.fdh.cube.gui;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Scanner;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.event.CaretEvent;
import javax.swing.event.CaretListener;
import javax.swing.text.BadLocationException;

import com.sun.org.apache.bcel.internal.generic.NEW;

public class TestJTextArea extends JFrame implements ActionListener,Runnable,KeyListener{
    /** 命令提示符 */
    String command_prompt="[root@localhost ~]# ";
    JTextArea jTextArea;
    JButton jButton;
    int visiable=1;
    public TestJTextArea() {
      //设置窗口界面
        super.setTitle("3X3 Rubik's Cube Simulation Program");//题目
        super.setSize(1300,800);//大小
        super.setLocation(300,100);//位置
        super.setResizable(true);//是否可改变大小
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮即关闭程序
        
        super.getContentPane().setLayout(new BorderLayout());
        jTextArea=new JTextArea( command_prompt,20, 40);
        jTextArea.setLineWrap(true);//自动换行
        jTextArea.setBorder(new BevelBorder(0));
        jTextArea.setVisible(true);
        jTextArea.addKeyListener(this);
        
        jButton=new JButton();
        jButton.addActionListener(this);
        jButton.setSize(100, 20);
        JPanel jPanel=new JPanel();
        
        jPanel.setBackground(Color.green);
        jPanel.setVisible(true);
        jPanel.setLayout(new BorderLayout());
        jPanel.setSize(100, 100);
        super.getContentPane().add(jPanel,BorderLayout.SOUTH);
        jPanel.add(jTextArea);
        
        ImageIcon icon=new ImageIcon("F:\\arrow_bottom_down_downward_navigation_16px_1225446_easyicon.net.png");
        //System.out.println(icon.getIconHeight());
        jButton.setIcon(icon);
        //jButton.setMargin(new Insets(0, 0, 10, 0));
        jPanel.add(jButton,BorderLayout.NORTH);
        super.setVisible(true);
    }
    public static void main(String[] args) {
        Thread thread=new Thread(new TestJTextArea());
        //thread.start();
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        Object object=e.getSource();
        System.out.println(e.getSource());
        if(visiable==1) {
            visiable=0;
            jTextArea.setVisible(true);
            ImageIcon icon=new ImageIcon("F:\\arrow_bottom_down_downward_navigation_16px_1225446_easyicon.net.png");
            jButton.setIcon(icon);
        }
        else {
            visiable=1;
            jTextArea.setVisible(false);
            ImageIcon icon=new ImageIcon("F:\\above_arrow_navigation_top_up_16px_1225504_easyicon.net.png");
            jButton.setIcon(icon);
        }
    }
    @Override
    public void run() {
        //Scanner scanner=new Scanner((Readable) jTextArea);
        
        while(true) {
            //System.out.println(scanner.nextLine());
        }
    }
    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
            try {                
                int start=jTextArea.getLineStartOffset(jTextArea.getLineCount()-1);
                int end=jTextArea.getLineEndOffset(jTextArea.getLineCount()-1);
                if(end-start==command_prompt.length()) {
                    jTextArea.replaceRange(command_prompt+" ", start,end);
                }
            } catch (BadLocationException e1) {
                e1.printStackTrace();
            }
        }
    }
    @Override
    public void keyReleased(KeyEvent e) {
        //这里enter键释放事件处理后于textarea本身换行，相当于textarea处理enter键按下事件。
        if(e.getKeyCode()==KeyEvent.VK_ENTER) {
            if(jTextArea.getLineCount()>1) {//总行数大于1行
                try {
                    int start=jTextArea.getLineStartOffset(jTextArea.getLineCount()-2);
                    int end=jTextArea.getLineEndOffset(jTextArea.getLineCount()-1);
                    //读取命令提示符后的内容
                    if(end-start>command_prompt.length()+1&&jTextArea.getText(start,command_prompt.length()).equals(command_prompt)) {
                        System.out.println(jTextArea.getText(start+command_prompt.length(),end-start-(command_prompt.length()+1)));
                    }
                    jTextArea.append(command_prompt);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

}
