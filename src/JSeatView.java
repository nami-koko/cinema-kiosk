import javax.swing.*;
import javax.swing.plaf.metal.MetalButtonUI;
import java.awt.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.Random;

class JSeatView extends JPanel {
    public JSeatView(String msg) {
        String font = "Roboto";
        final int[] fontSize = {12};
        JFrame jf = new JFrame(msg);
        jf.setSize(800, 600);
        jf.setLocation(300, 150);
        jf.setVisible(true);

        /*FEAT: Ticket and price information*/
        JLabel ticketInfo = new JLabel();
        ticketInfo.setText("Information");
        jf.add(ticketInfo, BorderLayout.EAST);

        /*FEAT: movie seats*/

        JCheckBox[][] seats = new JCheckBox[12][12];
        JPanel panel_2 = new JPanel();
        JPanel seatPanel = new JPanel();
        JLabel seatInfo = new JLabel("seat info");
        panel_2.setBackground(Color.green);
//        panel_2.setBounds(12, 10, 150, 200);
        seatPanel.add(seatInfo);
        seatPanel.add(panel_2);
        panel_2.setLayout(null);
        seatPanel.setSize(400, 600);
        seatPanel.setVisible(true);
        jf.add(panel_2, BorderLayout.CENTER);

        class SeatCheckListener implements ItemListener {

            @Override
            public void itemStateChanged(ItemEvent e) {
                System.out.println(e.getStateChange());
                // 좌석 번호 뽑아내기.
                JCheckBox tempCheckbox = (JCheckBox) e.getSource();
                String test = tempCheckbox.getText().trim();
                System.out.println(test);
                String[] testArr = test.split(",", 0);

                // 행
                String row = testArr[0];
                String col = testArr[1];

                ticketInfo.setText("Ticket Information:" +col + row);
                System.out.println("col = " + col);
                System.out.println("row = " + row);
            }
        }
        // 열
        for (int i = 0; i < 12; i++) {
            JLabel seatColLabel = new JLabel();
            char input = (char) ('A' + i);
            seatColLabel.setText(Character.toString(input));
            seatColLabel.setFont(new Font(font, Font.PLAIN, fontSize[0]));
            seatColLabel.setBounds(25, (72 + (i * 20)), 22, 15);
            panel_2.add(seatColLabel);

        }

        // 행
        for (int i = 0; i < 12; i++) {
            JLabel seatRowLabel = new JLabel();
            String input = Integer.toString(i + 1);
            seatRowLabel.setText(input);
            seatRowLabel.setBounds(61 + (i * 22), 55, 22, 15);
            seatRowLabel.setFont(new Font(font, Font.PLAIN, fontSize[0]));
            panel_2.add(seatRowLabel);
        }

        // 좌석 checkBox
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
                    chkBox.setText("X");
                    chkBox.setEnabled(false);
                }
                seats[j][i] = chkBox;
                seats[j][i].addItemListener(new SeatCheckListener());
                char input = (char) (j + 65);
                seatInfo.setText(input + "," + Integer.toString(i + 1)); //set seat location
                panel_2.add(chkBox);
                panel_2.add(seatInfo);
            }
        }

    }
}