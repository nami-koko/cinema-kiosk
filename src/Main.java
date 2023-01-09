import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Main {

    //function to resize button icons
    private static ImageIcon getResizedIcon(Image img) {
        Image newimg = img.getScaledInstance( 150, 150,  java.awt.Image.SCALE_SMOOTH ) ;
        return new ImageIcon(newimg);
    }

    public static void main(String[] args) {
        JFrame jf = new JFrame("SMU Cinema");
        JButton movieBtn = new JButton("Buy Movie Ticket");
        JButton popcornBtn = new JButton("Buy Popcorn");

        ImageIcon movieIcon = new ImageIcon("./src/images/movie.jpg");
        ImageIcon popcornIcon = new ImageIcon("./src/images/popcorn.jpg");

        //Resize icons to fit button using function
        movieBtn.setIcon(getResizedIcon(movieIcon.getImage()));
        movieBtn.setLayout(new GridLayout(1, 2));

        popcornBtn.setIcon(getResizedIcon(popcornIcon.getImage()));
        popcornBtn.setAlignmentX(Component.CENTER_ALIGNMENT);

        jf.setLayout(new GridLayout(1, 2));
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
