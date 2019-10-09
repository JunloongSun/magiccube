package org.fdh.cube.gui;

import java.awt.BorderLayout;
import java.awt.Color;

import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fdh.cube.util.Environment;

public class ShellPanel extends JPanel{
    private JScrollPane jScrollPane;
    private ViewButton viewButton;
    private JPanel shellToolPanel;
    public ShellPanel() {
        super();
        super.setBackground(Color.black);
        super.setLayout(new BorderLayout());
        ShellTextArea shellTextArea=new ShellTextArea();
        Environment.setOutPut(shellTextArea);//设置输出位置
        jScrollPane=new JScrollPane(shellTextArea);
        shellToolPanel=new JPanel();
        shellToolPanel.add(jScrollPane);
        viewButton=new ViewButton(shellToolPanel);
        this.add(shellToolPanel,BorderLayout.SOUTH);
        this.add(viewButton,BorderLayout.NORTH);
    }
}
