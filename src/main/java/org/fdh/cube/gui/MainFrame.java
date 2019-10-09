package org.fdh.cube.gui;

import java.awt.BorderLayout;
import java.awt.Image;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import org.fdh.cube.util.Environment;

public class MainFrame extends JFrame{
    public MainFrame() {
        //设置窗口界面
        super.setTitle("3X3 Rubik's Cube Simulation Program");//题目
        super.setSize(1300,800);//大小
        super.setLocation(300,100);//位置
        super.setResizable(false);//是否可改变大小
        super.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//关闭按钮即关闭程序
        super.getContentPane().setLayout(new BorderLayout());
        super.getContentPane().add(new ShellPanel(),BorderLayout.SOUTH);
        super.setVisible(true);
        try {
            super.setIconImage(ImageIO.read(new File(Environment.get("workspace")+"\\resources\\img\\smallCubeIcon.png")));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
