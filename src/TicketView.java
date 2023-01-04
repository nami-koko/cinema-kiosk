import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;
import java.util.Vector;

public class TicketView {
    public TicketView(String msg) {
        String[] movieList = {"Avatar", "Avengers", "Harry Potter", "Parasite", "Notebook"};
        String[] timeList = {"10:30", "12:00", "2:30", "4:45", "7:20"};
        String font = "Roboto";
        final int[] fontSize = {12};
        Vector<String> seatsNumber = new Vector<String>(); // 여기에 check한 좌석이 저장된다.
        Vector<JLabel> seatDetails = new Vector<>();

        JFrame jf = new JFrame(msg);
        JPanel titleTimePanel = new JPanel();
        titleTimePanel.setLayout(new FlowLayout(FlowLayout.LEADING));
        JPanel btnPanel = new JPanel();
        JPanel posterPanel = new JPanel();
        JPanel seatsPanel = new JPanel();
        //TODO: seatInfo 화면에 출력하기


        JComboBox<String> movieComboBox = new JComboBox<>(movieList);
        JComboBox<String> timeComboBox = new JComboBox<>(timeList);

        JButton viewSeats = new JButton("View Seats");
        JButton increaseFont = new JButton("Increase Font");
        JButton decreaseFont = new JButton("Decrease Font");

        /*FEAT: poster*/
        JLabel poster = new JLabel();

        ImageIcon icon = new ImageIcon("./src/images/Avatar.jpg");
        Image img = icon.getImage();
        Image changeImage = img.getScaledInstance(200, 300, Image.SCALE_SMOOTH);
        ImageIcon changeIcon = new ImageIcon(changeImage);
        poster.setIcon(changeIcon);

        titleTimePanel.add(movieComboBox);
        titleTimePanel.add(timeComboBox);
        titleTimePanel.add(viewSeats);
        btnPanel.add(increaseFont);
        btnPanel.add(decreaseFont);
        posterPanel.add(poster);
//        seatsPanel.add(seats);

        jf.add(titleTimePanel, BorderLayout.NORTH);
        jf.add(btnPanel, BorderLayout.SOUTH);
        jf.add(posterPanel, BorderLayout.WEST);




        jf.setSize(800, 600);
        jf.setLocation(300, 150);
        jf.setVisible(true);

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

        viewSeats.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new JSeatView("View Seats");
            }
        });

        //FEAT: Change font size
        increaseFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize[0] += 2;
                movieComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
                timeComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));

            }
        });
        decreaseFont.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                fontSize[0] -= 2;
                movieComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
                timeComboBox.setFont(new FontUIResource(font,Font.PLAIN,fontSize[0]));
            }
        });


    }
}
