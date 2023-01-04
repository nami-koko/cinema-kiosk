import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {
    public static void main(String[] args) {
        JFrame jf = new JFrame("SMU Cinema");
        JButton movieBtn = new JButton("Buy Movie Ticket");
        JButton popcornBtn = new JButton("Buy Popcorn");

        jf.setLayout(new FlowLayout(FlowLayout.CENTER));
        movieBtn.setSize(400, 400);
        popcornBtn.setSize(400, 400);
        jf.add(movieBtn);
        jf.add(popcornBtn);
        jf.setSize(800, 600);
        jf.setLocationRelativeTo(null);
        jf.setVisible(true);


        movieBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new TicketView("Buy Movie Ticket!");
            }
        });

        popcornBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new PopcornView("Buy Popcorn!");
            }
        });

    }
}
