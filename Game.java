import javax.swing.*;
import java.awt.*;

public class Game {
    static JFrame frame;
    Snake snake;

    public Game() {
        frame = new JFrame();
        frame.setTitle("Snaky by KASSI");
        frame.setLocation(350, 0);
        frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        frame.setSize(590, 710);
        frame.setResizable(false);

        snake = new Snake(600, 600);
        snake.addKeyListener(new Moving(snake));
        frame.add(snake);

        JPanel but = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 15));
        // but.setBackground(Color.BLACK);
        but.setBackground(new Color(34, 45, 65));
        JButton tryAgain = new JButton("TRYAGAIN");
        tryAgain.setFont(new Font("Arial", Font.BOLD, 13));
        tryAgain.setForeground(Color.WHITE);
        tryAgain.setBackground(new Color(76, 205, 100)); // Green button color
        tryAgain.setFocusPainted(false); // Remove focus outline
        tryAgain.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding inside the button
        but.add(tryAgain);
        tryAgain.addMouseListener(new Listener(tryAgain));
        frame.add(but, BorderLayout.SOUTH);
        frame.setVisible(true);
    }

    public static void dispose() {
      System.out.println("exit");
      frame.dispose();
    }
}