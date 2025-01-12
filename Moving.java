import javax.swing.*;
import java.util.*;
import java.util.Timer;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Moving implements KeyListener,ActionListener{
    Snake snake;
    int vitesse=1;
    public Moving(Snake snake)
    {
        this.snake=snake;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        snake.move();
    }
    @Override
    public void keyPressed(KeyEvent e) {
        if(e.getKeyCode()==KeyEvent.VK_UP && snake.velocityY!=vitesse)
        {
            snake.velocityX=0;
            snake.velocityY=-vitesse;
        }
        else if(e.getKeyCode()==KeyEvent.VK_DOWN && snake.velocityY!=-vitesse)
        {
            snake.velocityX=0;
            snake.velocityY=vitesse;
        }
        else if(e.getKeyCode()==KeyEvent.VK_LEFT && snake.velocityX!=vitesse)
        {
            snake.velocityX=-vitesse;
            snake.velocityY=0;
        } 
        else if(e.getKeyCode()==KeyEvent.VK_RIGHT && snake.velocityX!=-vitesse)
        {
            snake.velocityX=vitesse;
            snake.velocityY=0;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
    @Override
    public void keyTyped(KeyEvent e) {
    }
}
