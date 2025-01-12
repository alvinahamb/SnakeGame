import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import java.util.*;
import java.awt.*;
import javax.swing.JButton;

public class Listener implements MouseMotionListener,MouseListener{

    JButton home=new JButton();
    public Listener(JButton home)
    {
        this.home=home;
    }
    @Override
    public void mouseClicked(MouseEvent e) {
        if (home.getText().equals("1Player")) {
            try {
                new Game(); 
                // homeFrame.dispose();
            } catch (Exception h) {
            System.out.println("error");
            }
        }
        else if (home.getText().equals("TRYAGAIN")) {
            // System.out.println("tryagain");
            try {
                // new Home();
                Game.dispose();
            } catch (Exception g) {
                // TODO: handle exception
            }
            
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }
    
}
