package org.fdh.cube.gui;

import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import org.fdh.cube.util.Environment;

/** 控制textarea是否可见 */
public class ViewButton extends JButton implements MouseListener{
    private ImageIcon ArrowUp;
    private ImageIcon ArrowDown;
    private String workspace;
    private JPanel shellToolPanel;
    public ViewButton(JPanel shellToolPanel) {
        this.shellToolPanel=shellToolPanel;
        this.setMargin(new Insets(0, 0, 0, 0));
        workspace=(String) Environment.get("workspace");
        ArrowUp=new ImageIcon(workspace+"\\resources\\img\\arrow_up.png");
        ArrowDown=new ImageIcon(workspace+"\\resources\\img\\arrow_down.png");
        this.setIcon(ArrowDown);
        this.addMouseListener(this);
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if(shellToolPanel.isVisible()) {
            shellToolPanel.setVisible(false);
            this.setIcon(ArrowUp);
        }
        else {
            shellToolPanel.setVisible(true);
            this.setIcon(ArrowDown);
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub
        
    }

}
