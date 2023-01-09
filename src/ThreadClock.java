import javax.swing.*;
import java.awt.*;
import java.util.Calendar;

public class ThreadClock extends Thread {
    JLabel timeLabel;

    //constructor
    public ThreadClock(JLabel label) {
        timeLabel = label;
    }

    public void run() {
        Calendar time = Calendar.getInstance();
        int hour = time.get(Calendar.HOUR_OF_DAY);
        int min = time.get(Calendar.MINUTE);
        int sec = time.get(Calendar.SECOND);

        while (true) {
            timeLabel.setFont(new Font("Roboto", Font.BOLD, 50));
            timeLabel.setText((Integer.toString(hour))+" : "+(Integer.toString(min))+" : "+(Integer.toString(sec)));
        sec ++;
            if (sec == 60) {
                sec = 0;
                min++;
            }
            if (min == 60) {
                min = 0;
                hour++;
            }
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                return;
            }
        }
    }
}
