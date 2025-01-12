import javax.swing.*;
import javax.swing.Timer;
import java.awt.*;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Snake extends JPanel implements ActionListener {
    int gameSize;
    int tileSize = 25;
    int limit;
    Point snakeHead = new Point(1, 1);
    Vector<Point> snakeBody;
    Vector<Point> poisonList;
    Point food = new Point(10, 10);
    Point poison = new Point(5, 5);
    int velocityX = 0;
    int velocityY = 0;
    boolean gameOver = false;
    Random chooseFood = new Random();
    int cf = chooseFood.nextInt(4);
    int count = 0;
    int vitesse = 200;
    Score score = new Score();
    @SuppressWarnings("rawtypes")
    Vector bestScoreList = new Vector<>();
    int bestScore = 0;
    boolean yes=false;

    public Snake(int width, int height) {
        limit = width;
        gameSize = width - tileSize;
        setBackground(new Color(34, 45, 65));
        setFocusable(true);
        snakeBody = new Vector<>();
        poisonList = new Vector<>();
        bestScoreList = score.getScore();
        bestScore = score.getBestScore();
    }

    public void draw(Graphics g) {
        if (snakeBody.size() > bestScore) {
            bestScore = snakeBody.size();
            yes=true;
        }
        g.setColor(new Color(34, 45, 65));
        g.fillRect(0, 0, gameSize, gameSize);
        g.setColor(Color.WHITE);
        g.setFont(new Font("Arial", Font.ROMAN_BASELINE, 15));
        // snakeBody.size à mettre dans un fichier le stockant et mettre le meilleur
        // score
        g.drawString("Score:" + snakeBody.size(), 5, 600);
        g.drawString("Best score:" + bestScore, 460, 600);
        for (int i = 0; i < limit / tileSize; i++) {
            g.setColor(Color.BLACK);
            g.drawLine(0, i * tileSize, gameSize, i * tileSize);
            g.drawLine(i * tileSize, 0, i * tileSize, gameSize);
        }
        for (int i = 0; i < snakeBody.size(); i++) {
            Point body = snakeBody.elementAt(i);
            g.setColor(Color.GREEN);
            g.fill3DRect((int) body.getX() * tileSize, (int) body.getY() * tileSize, tileSize, tileSize, true);
        }
        g.setColor(Color.GREEN);
        g.fillRect((int) snakeHead.getX() * tileSize, (int) snakeHead.getY() * tileSize, tileSize, tileSize);
        String[] foodPic = new String[5];
        foodPic[0] = "Picture/R.png";
        foodPic[1] = "Picture/RR.png";
        foodPic[2] = "Picture/RRR.png";
        foodPic[3] = "Picture/RRRR.png";
        foodPic[4] = "Picture/th.png";
        Image pic = new ImageIcon(foodPic[cf]).getImage();
        g.drawImage(pic, (int) food.getX() * tileSize, (int) food.getY() * tileSize, tileSize, tileSize, null);
        Image pois = new ImageIcon("Picture/poison.png").getImage();
        if (poisonList.size() > 0) {
            for (int i = 0; i < poisonList.size(); i++) {
                g.drawImage(pois, (int) poisonList.get(i).getX() * tileSize, (int) poisonList.get(i).getY() * tileSize,
                        tileSize, tileSize, null);
            }
        }
    }

    public void paint(Graphics g) {
        super.paint(g);
        move();
        draw(g);
        if (snakeBody.size() > 20) {
            vitesse = 150;
        }
        if (snakeBody.size() > 30) {
            vitesse = 100;
        }
        try {
            Thread.sleep(vitesse);
        } catch (Exception e) {
        }
        if (!gameOver) {
            repaint();
        } 
        else 
        {
            if(snakeBody.size()>score.getBestScore())
            {
                score.writeScore(snakeBody.size());
            }
            g.setFont(new Font("Arial", Font.BOLD, 50));
            g.setColor(Color.RED);
            g.drawString("Game Over", 150, 300);
            if (yes) {
                g.setFont(new Font("Arial", Font.ITALIC, 18));
                g.setColor(Color.WHITE);
                g.drawString("New best score:"+snakeBody.size(), 210, 350);
            }
        }
    }

    public void move() {
        if (snakeHead.getX() == food.getX() && snakeHead.getY() == food.getY()) {
            snakeBody.add(food);
            placeFood();
            count++;
            if (count == 5) {
                placePoison();
                count = 0;
            }
            cf = chooseFood.nextInt(4);
        }
        if (poisonList.size() > 0) {
            for (int i = 0; i < poisonList.size(); i++) {
                if (snakeHead.getX() == poisonList.get(i).getX() && snakeHead.getY() == poisonList.get(i).getY()) {
                    gameOver = true;
                }
            }
        }
        for (int i = snakeBody.size() - 1; i >= 0; i--) {
            Point temp = snakeBody.get(i);
            if (i == 0) {
                temp.x = snakeHead.x;
                temp.y = snakeHead.y;
            } else {
                snakeBody.get(i).x = snakeBody.get(i - 1).x;
                snakeBody.get(i).y = snakeBody.get(i - 1).y;
            }
        }
        snakeHead.x += velocityX;
        snakeHead.y += velocityY;
        for (int i = 0; i < snakeBody.size(); i++) {
            if (snakeHead.equals(snakeBody.get(i))) {
                gameOver = true;
            }
        }
        if (snakeHead.x < 0 || snakeHead.getX() * tileSize > gameSize - tileSize || snakeHead.y < 0 ||
                snakeHead.getY() * tileSize > gameSize - tileSize) {
            gameOver = true;
        }
    }

    public void placeFood() {
        Random place = new Random();
        int a = place.nextInt(gameSize / tileSize);
        int b = place.nextInt(gameSize / tileSize);
        if (poisonList.size() > 0) {
            for (int j = 0; j < poisonList.size(); j++) {
                for (int i = 0; i < poisonList.size(); i++) {
                    if (a == poisonList.get(i).x && b == poisonList.get(i).y)
                        a = place.nextInt(gameSize / tileSize);
                    b = place.nextInt(gameSize / tileSize);
                }
            }
        }
        food = new Point(a, b);
    }

    public void placePoison() {
        poisonList.add(poison);
        Random place1 = new Random();
        int a1 = place1.nextInt(gameSize / tileSize);
        int b1 = place1.nextInt(gameSize / tileSize);
        if (a1 == poison.x && b1 == poison.y) {
            a1 = place1.nextInt(gameSize / tileSize);
            b1 = place1.nextInt(gameSize / tileSize);
        }
        poison = new Point(a1, b1);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
    }
}
