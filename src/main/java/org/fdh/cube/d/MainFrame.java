package org.fdh.cube.d;

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JLabel;

import org.fdh.cube.d.math3D.VTs;


public class MainFrame extends JFrame implements Runnable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	//Canvas canvas=new Canvas();
	
	
  VTs vTs = new VTs();

  
  Point oldPoint;
  double angleX,angleY;
  
  
  private Canvas_Cube canvas_Cube=new Canvas_Cube();

  public static void main(String args[]) {
    MainFrame workStart=new MainFrame();
  }
    
  public MainFrame() {
    super("ħ����Ϸ");
    setSize(700, 700);
    
    //enableEvents(AWTEvent.WINDOW_EVENT_MASK);

    setVisible(true);
    setResizable(false);
    addKeyListener(new MyKeyListenner());
    JLabel label=new JLabel("�����ѡ��Ҫ��ת���档��D�������˳ʱ����ת����S���������ʱ����ת��");
    canvas_Cube.add(label);
    add(canvas_Cube);
    }

  public void processWindowEvent(WindowEvent e) {
    if(e.getID() == WindowEvent.WINDOW_CLOSING) {
       System.exit(0);
    }
  }

  public void run() {
    while(true) {
    }
  }

  public void paint(Graphics g) {
	  Graphics2D graphics2D=(Graphics2D)g;
	  paintComponents(graphics2D);
  }
  
  private class MyKeyListenner extends KeyAdapter{
	  @Override
	public void keyPressed(KeyEvent e) {
		super.keyPressed(e);
		if (e.getKeyCode()==KeyEvent.VK_CONTROL) {
			System.out.println("�Ʊ��");
			
		} else if((e.getKeyCode()==KeyEvent.VK_LEFT||e.getKeyCode()==KeyEvent.VK_A)&&!canvas_Cube.isRotating()) {
			System.out.println("��");
			if (canvas_Cube.selected==canvas_Cube.BLUE) {
				canvas_Cube.rotateBlue90(false);
			}else if (canvas_Cube.selected==canvas_Cube.ORANGE) {
				canvas_Cube.rotateOrange90(false);
			}else if (canvas_Cube.selected==canvas_Cube.GREEN) {
				canvas_Cube.rotateGreen90(false);
			}else if (canvas_Cube.selected==canvas_Cube.RED) {
				canvas_Cube.rotateRed90(false);
			}else if (canvas_Cube.selected==canvas_Cube.YELLOW) {
				canvas_Cube.rotateYellow90(false);
			}else if (canvas_Cube.selected==canvas_Cube.WHITE) {
				canvas_Cube.rotateWhite90(false);
			}
			canvas_Cube.update(canvas_Cube.getGraphics());
		}else if((e.getKeyCode()==KeyEvent.VK_RIGHT||e.getKeyCode()==KeyEvent.VK_D)&&!canvas_Cube.isRotating()) {
			System.out.println("��");
			if (canvas_Cube.selected==canvas_Cube.BLUE) {
				canvas_Cube.rotateBlue90(true);
			}else if (canvas_Cube.selected==canvas_Cube.ORANGE) {
				canvas_Cube.rotateOrange90(true);
			}else if (canvas_Cube.selected==canvas_Cube.GREEN) {
				canvas_Cube.rotateGreen90(true);
			}else if (canvas_Cube.selected==canvas_Cube.RED) {
				canvas_Cube.rotateRed90(true);
			}else if (canvas_Cube.selected==canvas_Cube.YELLOW) {
				canvas_Cube.rotateYellow90(true);
			}else if (canvas_Cube.selected==canvas_Cube.WHITE) {
				canvas_Cube.rotateWhite90(true);
			}
			canvas_Cube.update(canvas_Cube.getGraphics());
		}
	}
  }
}





