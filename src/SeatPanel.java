import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

class SeatPanel extends JPanel {
    public SeatPanel() {
        String font = "Roboto";
        final int[] fontSize = {12};

        /*FEAT: Ticket and price information*/

        /*FEAT: movie seats*/
        JCheckBox[][] seats = new JCheckBox[12][12];
        JLabel seatInfo = new JLabel();
        JLabel warning = new JLabel("You can't choose disabled seats");
        add(warning);
        setBounds(200, 250, 400, 400);
        setBorder(new EmptyBorder(100, 0,0,0));
        setLayout(null);

        class SeatCheckListener implements ItemListener {
            String[] seatArr = new String[5];
            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                JCheckBox tempCheckbox = (JCheckBox) e.getSource();
                String test = tempCheckbox.getText().trim();
                System.out.println(test);
                String[] testArr = test.split(",", 0);
            }
        }
        for (int i = 0; i < 12; i++) {
            JLabel seatColLabel = new JLabel();
            char input = (char) ('A' + i);
            seatColLabel.setText(Character.toString(input));
            seatColLabel.setFont(new Font(font, Font.PLAIN, fontSize[0]));
            seatColLabel.setBounds(25, (72 + (i * 20)), 22, 15);
            add(seatColLabel);
        }
        for (int i = 0; i < 12; i++) {
            JLabel seatRowLabel = new JLabel();
            String input = Integer.toString(i + 1);
            seatRowLabel.setText(" "+ input);
            seatRowLabel.setBounds(61 + (i * 22), 55, 22, 15);
            seatRowLabel.setFont(new Font(font, Font.PLAIN, fontSize[0]));
            add(seatRowLabel);
        }

        for (int j = 0; j < 12; j++) {
            for (int i = 0; i < 12; i++) {
                JCheckBox chkBox = new JCheckBox("");
                chkBox.setBackground(Color.WHITE);
                chkBox.setForeground(Color.WHITE);
                chkBox.setBounds(61 + (i * 22), 72 + (j * 20), 22, 15);
                char seatLetter= (char) (j + 65);
                chkBox.setText(seatLetter + "," + Integer.toString(i + 1));
                //disable random seats
                Random random = new Random();
                int n = random.nextInt(20);
                if(n == i) {
                    chkBox.setBorderPainted(true);
                    chkBox.setEnabled(false);
                }
                seats[j][i] = chkBox;
                seats[j][i].addItemListener(new SeatCheckListener());
                char input = (char) (j + 65);
                seatInfo.setText(input + "," + Integer.toString(i + 1)); //set seat location
                add(chkBox);
            }
        }

    }
}