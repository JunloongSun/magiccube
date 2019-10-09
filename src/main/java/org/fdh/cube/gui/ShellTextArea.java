package org.fdh.cube.gui;

import java.awt.Color;
import java.awt.Component;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import javax.swing.text.BadLocationException;

import org.fdh.cube.util.Environment;
import org.fdh.cube.util.OutPut;

public class ShellTextArea extends JTextArea implements KeyListener,OutPut{
    /** 命令提示符 */
    private String command_prompt="[root@localhost ~]# ";
    public ShellTextArea() {
        super();
        this.command_prompt=(String) Environment.get("command_prompt");
        super.setRows(12);
        super.setColumns(80);
        super.setText(this.command_prompt);
        super.setLineWrap(true);//自动换行
        super.setBorder(new BevelBorder(0));
        this.addKeyListener(this);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_BACK_SPACE) {
            try {                
                int start=this.getLineStartOffset(this.getLineCount()-1);
                int end=this.getLineEndOffset(this.getLineCount()-1);
                if(end-start==command_prompt.length()) {
                    this.replaceRange(command_prompt+" ", start,end);
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
            if(this.getLineCount()>1) {//总行数大于1行
                try {
                    int start=this.getLineStartOffset(this.getLineCount()-2);
                    int end=this.getLineEndOffset(this.getLineCount()-1);
                    //读取命令提示符后的内容
                    if(end-start>command_prompt.length()+1&&this.getText(start,command_prompt.length()).equals(command_prompt)) {
                        Environment.addcmd(this.getText(start+command_prompt.length(),end-start-(command_prompt.length()+1)));
                        synchronized (Environment.cmdBuffer) {
                            Environment.cmdBuffer.notify();
                        }
                    }
                    //this.append(command_prompt);
                } catch (BadLocationException e1) {
                    e1.printStackTrace();
                }
            }
        }
    }

    @Override
    public void print(String text) {
        System.out.print(text);
    }

    @Override
    public void println(String text) {
        this.append(text);
    }

}
