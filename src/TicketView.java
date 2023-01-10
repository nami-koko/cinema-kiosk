import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class TicketView {
    public TicketView(String msg) {
        String[] movieList = {"Avatar", "Avengers", "Harry Potter", "Parasite", "Notebook"};
        String[] timeList = {"10:30", "12:00", "2:30", "4:45", "7:20"};
        String font = "Roboto";
        final int[] fontSize = {12};

        JFrame jf = new JFrame(msg);
        JPanel titleTimePanel = new JPanel();
        titleTimePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel btnPanel = new JPanel();

        JComboBox<String> movieComboBox = new JComboBox<>(movieList);
        JComboBox<String> timeComboBox = new JComboBox<>(timeList);
        JButton increaseFont = new JButton("Increase Font");
        increaseFont.setFont(new Font("Roboto", Font.PLAIN, 25));
        JButton decreaseFont = new JButton("Decrease Font");
        decreaseFont.setFont(new Font("Roboto", Font.PLAIN, 25));


        /*FEAT: poster*/
        JLabel poster = new JLabel();

        ImageIcon icon = new ImageIcon("./src/images/Avatar.jpg");
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(220, 300, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        poster.setIcon(changeIcon);


        /*FEAT: thread clock*/
        JPanel timePanel = new JPanel();
        JLabel timeLabel = new JLabel();
        JLabel timeText = new JLabel();
        timePanel.setBackground(new Color(250, 200, 152));

        timeText.setText("🕰");
        timeText.setFont(new Font("Roboto", Font.BOLD,50));
        ThreadClock threadClock = new ThreadClock(timeLabel);
        threadClock.start();

        timePanel.add(timeText);
        timePanel.add(timeLabel);

        titleTimePanel.setLayout(new GridLayout(1, 3));
        titleTimePanel.add(movieComboBox);
        titleTimePanel.add(timeComboBox);
        titleTimePanel.add(timePanel);

        titleTimePanel.setBorder(new EmptyBorder(60, 20, 20, 50));
        titleTimePanel.setBackground(new Color(250, 200, 152));


        btnPanel.setBackground(new Color(250, 200, 152));
        btnPanel.add(increaseFont);
        btnPanel.add(decreaseFont);
        btnPanel.setLayout(new GridLayout(1, 2));
        poster.setBorder(new EmptyBorder(0, 50, 40, 10));


        /*FEAT: seat panel*/
        SeatPanel seatView = new SeatPanel();
        seatView.setBorder(new EmptyBorder(100, 300, 10, 10));
        seatView.setSize(200, 500);

        JPanel centerPanel = new JPanel();
        JPanel seatPanel = new JPanel();
        JPanel buttonPanel = new JPanel();

        buttonPanel.setLayout(new GridBagLayout());
        JButton purchaseBtn = new JButton("Buy Ticket");
        purchaseBtn.setPreferredSize(new Dimension(200, 150));
        purchaseBtn.setForeground(Color.orange);

        seatPanel.add(seatView);
        buttonPanel.add(purchaseBtn);

        centerPanel.setLayout(new GridLayout(1, 3));
        centerPanel.setBorder(new EmptyBorder(0, 50, 0, 0));
        centerPanel.add(poster);
        centerPanel.add(seatView);
        centerPanel.add(buttonPanel);

        jf.add(titleTimePanel, BorderLayout.NORTH);
        jf.add(btnPanel, BorderLayout.SOUTH);
        jf.add(centerPanel, BorderLayout.CENTER);
        jf.setExtendedState(JFrame.MAXIMIZED_BOTH);
        jf.setLocation(300, 110);
        jf.setVisible(true);

        //ActionListener
        movieComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //FEAT: set poster image size
                // - convert ImageIcon to Image in order to resize. Then, convert it back to ImageIcon to use it in JLabel.
                ImageIcon icon1 = new ImageIcon("./src/images/" + movieComboBox.getItemAt(movieComboBox.getSelectedIndex()) +".jpg");
                Image img1 = icon1.getImage();
                Image changeImage1 = img1.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
                ImageIcon changeIcon1 = new ImageIcon(changeImage1);
                poster.setIcon(changeIcon1);
            }
        });

        timeComboBox.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                SeatPanel seatView = new SeatPanel();
                seatPanel.add(seatView);}
        });

        //FEAT: Change font size
        increaseFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize[0] += 2;
                movieComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
                timeComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
                purchaseBtn.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
            }
        });

        decreaseFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize[0] -= 2;
                movieComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
                timeComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
                purchaseBtn.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
            }
        });

        purchaseBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                JOptionPane.showMessageDialog(null, "Please receive ticket from the machine.");
                jf.dispose();
            }
        });
    }
}
