import javax.swing.*;
import java.awt.*;

public class Home {
    JFrame frame = new JFrame();

    public Home() {
        int height = 600;
        int width = 600;
        frame.setTitle("Snaky by KASSI");
        frame.setLocation(350, 0);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(width - 10, height + 110);
        frame.setResizable(false);

        // Main panel
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBackground(new Color(34, 45, 65)); // Dark background color
        mainPanel.setBorder(BorderFactory.createEmptyBorder(50, 50, 50, 50));

        // Title label
        JLabel title = new JLabel("WELCOME TO SNAKY");
        title.setFont(new Font("Arial", Font.BOLD, 25));
        title.setForeground(Color.WHITE);
        title.setHorizontalAlignment(JLabel.CENTER);
        title.setVerticalAlignment(JLabel.CENTER);
        title.setBorder(BorderFactory.createEmptyBorder(10, 10, 20, 10)); // Add some space below the title

        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 10, 20));
        buttonPanel.setBackground(new Color(34, 45, 65)); // Match background with the main panel

        JButton onePlayer = new JButton("1Player");
        onePlayer.setFont(new Font("Arial", Font.BOLD, 13));
        onePlayer.setForeground(Color.WHITE);
        onePlayer.setBackground(new Color(76, 175, 80)); // Green button color
        onePlayer.setFocusPainted(false); // Remove focus outline
        onePlayer.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding inside the button
        onePlayer.addMouseListener(new Listener(onePlayer));

        // JButton twoPlayers = new JButton("2Players");
        // twoPlayers.setFont(new Font("Arial", Font.BOLD, 13));
        // twoPlayers.setForeground(Color.WHITE);
        // twoPlayers.setBackground(new Color(76, 175, 80)); // Green button color
        // twoPlayers.setFocusPainted(false); // Remove focus outline
        // twoPlayers.setBorder(BorderFactory.createEmptyBorder(10, 20, 10, 20)); // Padding inside the button
        // twoPlayers.addMouseListener(new Listener(twoPlayers));

        buttonPanel.add(onePlayer);
        // buttonPanel.add(twoPlayers);
        mainPanel.add(title, BorderLayout.NORTH);
        mainPanel.add(buttonPanel, BorderLayout.CENTER);
        frame.add(mainPanel);
        frame.setVisible(true);
    }
}
// import javax.swing.*;
// import java.util.*;
// import java.awt.*;

// public class Home {
//     JFrame frame=new JFrame();

//     public Home() {
//         int height=600;
//         int width=600;
//         frame.setTitle("Snake game");
//         frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//         frame.setSize(width-10,height+110);
//         frame.setResizable(false);

//         JPanel but=new JPanel(new BorderLayout());
//         but.setBackground(new Color.BLUE);
//         JLabel title=new JLabel("WELCOME TO SNAKY:");
// title.setFont(new Font("Arial", Font.BOLD, 32));

//         JButton onePlayer=new JButton("onePlayer");
//         but.add(title);
//         but.add(onePlayer);
//         onePlayer.addMouseListener(new Listener(onePlayer));
//         frame.add(but, BorderLayout.CENTER);
//         frame.setVisible(true);
//     }
// }