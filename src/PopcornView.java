import javax.swing.*;
import javax.swing.plaf.FontUIResource;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class PopcornView {
    int menuCounts = 4;
    int count[] = new int[menuCounts];
    String show = "";
    public PopcornView() {
        Dimension res = Toolkit.getDefaultToolkit().getScreenSize();
        JFrame frame = new JFrame("Buy popcorn");
        frame.setBounds(0, 0, res.width, res.height);
        frame.setBackground(Color.black);

        Font font = new Font("Roboto", Font.PLAIN, 12);
        Font font1 = new Font("Roboto", Font.CENTER_BASELINE, 12);
        Panel NorthPanel = new Panel();
        NorthPanel.setBackground(new Color(250, 200, 152));
        NorthPanel.setLayout(null);
        NorthPanel.setSize(res.width, 500);
        NorthPanel.setFont(font);
        Panel centerPanel = new Panel();
        centerPanel.setBackground(new Color(250, 200, 152));
        Panel SouthPanel = new Panel();
        SouthPanel.setFont(font1);
        SouthPanel.setBackground(new Color(250, 200, 152));
        SouthPanel.setLayout(null);
        SouthPanel.setSize(res.width, 200);

        String menu[] = {"Popcorn(C)", "Popcorn", "Coke", "Squid"};
        int price[] = {7500, 7000, 3000, 6000};
        JButton[] menuButton = new JButton[menu.length];
        JButton[] menuBox = new JButton[menu.length];
        ImageIcon icon[] = new ImageIcon[menu.length];
        Image Img[] = new Image[menu.length];
        Image changedIcon[] = new Image[menu.length];
        ImageIcon picture[] = new ImageIcon[menu.length];
        TextField number[] = new TextField[menu.length];
        Button minus[] = new Button[menu.length];
        Button plus[] = new Button[menu.length];
        Label priceShow[] = new Label[menu.length];
        JButton[] ok = new JButton[menu.length];
        String list = "\t name \t  price  \t quantity \t  total\n";

        for (int i = 0; i < menu.length; i++) {
            menuButton[i] = new JButton(menu[i]);
            menuButton[i].setBounds(240 + i * 260, 110, 150, 150);
            icon[i] = new ImageIcon("./src/images/menu" + i + ".jpg");
            Img[i] = icon[i].getImage();
            changedIcon[i] = Img[i].getScaledInstance(160, 160, Image.SCALE_SMOOTH);
            picture[i] = new ImageIcon(changedIcon[i]);
            menuButton[i].setIcon(picture[i]);
            number[i] = new TextField("0");
            number[i].setBackground(Color.white);
            number[i].setEditable(false);
            number[i].setBounds(menuButton[i].getX() + 30, menuButton[i].getY() + 180, 90, 30);
            minus[i] = new Button("-");
            minus[i].setBounds(menuButton[i].getX() - 2, menuButton[i].getY() + 180, 28, 28);
            minus[i].setEnabled(true);
            plus[i] = new Button("+");
            plus[i].setBounds(menuButton[i].getX() + 122, menuButton[i].getY() + 179, 28, 28);
            plus[i].setEnabled(true);
            priceShow[i] = new Label(price[i] + "₩");
            priceShow[i].setBounds(menuButton[i].getX() + 48, menuButton[i].getY() + 150, 100, 30);
            ok[i] = new JButton("OK");
            ok[i].setBounds(menuButton[i].getX(), menuButton[i].getY() + 220, 150, 30);
            ok[i].setEnabled(true);

            menuBox[i] = new JButton(menu[i]);
            menuBox[i].setBounds(240 + i * 260, 30, 150, 50);
            NorthPanel.add(number[i]);
            NorthPanel.add(minus[i]);
            NorthPanel.add(plus[i]);
            NorthPanel.add(priceShow[i]);
            NorthPanel.add(ok[i]);
            NorthPanel.add(menuBox[i]);
            NorthPanel.add(menuButton[i]);
        }
        TextArea orderList = new TextArea("", 30, 70, TextArea.SCROLLBARS_BOTH);
        orderList.setFont(new Font("Roboto", Font.PLAIN, 25));
        JScrollPane orderScroll = new JScrollPane(orderList);
        orderScroll.setFont(new Font("Roboto", Font.PLAIN, 25));

        orderList.setText(list);
        orderList.setBackground(Color.white);
        orderList.setEditable(true);
        centerPanel.add(orderList);
        JButton orderButton = new JButton("order");
        JButton resetButton = new JButton("reset");
        JButton increaseFontBtn = new JButton("font+");
        JButton decreaseFontBtn = new JButton("font -");
        orderList.setFont(font1);
        orderButton.setBounds(200, 32, 150, 50);
        resetButton.setBounds(500, 32, 150, 50);
        increaseFontBtn.setBounds(800, 32, 150, 50);
        decreaseFontBtn.setBounds(1100, 32, 150, 50);

        SouthPanel.add(orderButton);
        SouthPanel.add(resetButton);
        SouthPanel.add(increaseFontBtn);
        SouthPanel.add(decreaseFontBtn);

        frame.add(NorthPanel, BorderLayout.NORTH);
        frame.add(centerPanel, BorderLayout.CENTER);
        frame.add(SouthPanel, BorderLayout.SOUTH);
        frame.setVisible(true);

        orderButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String str = orderList.getText();
                str = str.replace("\t", "");
                Random random = new Random();
                int orderNumber = random.nextInt(20);
                JOptionPane.showMessageDialog(null, "Order Number: " + orderNumber + "\nYour order is complete.");
                for (int i = 0; i < menu.length; i++) {
                    menuButton[i].setEnabled(true);
                    minus[i].setEnabled(true);
                    plus[i].setEnabled(true);
                    number[i].setText("0");
                    orderList.setText(list);
                    for (int k = 0; k < menuCounts; k++) {
                        count[k] = 0;
                    }
                }
                frame.dispose();

            }
        });

        resetButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                for (int i = 0; i<menu.length;i++) {
                    menuButton[i].setEnabled(true);
                    minus[i].setEnabled(true);
                    plus[i].setEnabled(true);
                    number[i].setText("0");
                    orderList.setText(list);
                    for(int k = 0; k<menuCounts; k++) { count[k] = 0;}
                }

                }
            });

        final int[] fontSize = {12};
        String fontKind = "Roboto";

        increaseFontBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                fontSize[0] += 2;
                for (int i = 0; i<menu.length;i++) {
                    number[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    orderScroll.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    menuBox[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    priceShow[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    orderList.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0] - 1));
                    orderButton.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    resetButton.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    increaseFontBtn.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    decreaseFontBtn.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    ok[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));

                }
            }
        });

        decreaseFontBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed (ActionEvent e) {
                fontSize[0] -= 2;
                for (int i = 0; i<menu.length;i++) {
                    number[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    orderScroll.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    menuBox[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    priceShow[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    orderList.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0] - 1));
                    orderButton.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    resetButton.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    increaseFontBtn.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    decreaseFontBtn.setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));
                    ok[i].setFont(new FontUIResource(fontKind,Font.PLAIN,fontSize[0]));

                }
            }
        });

        for (int i = 0; i < menu.length; i++) {
            int j = i;
            plus[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    count[j] = count[j] + 1;
                    number[j].setText(count[j] + "");
                    ok[j].setEnabled(true);
                    if (count[j] > 0) {
                        minus[j].setEnabled(true);
                    }
                }
            });

            minus[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    if (count[j] > 0) {
                        count[j] = count[j] -1;
                        minus[j].setEnabled(true);
                    } else {
                        minus[j].setEnabled(false);
                    }
                }
            });

            ok[j].addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    show = menuButton[j].getActionCommand() ;
                    if(show.length()< 5 & show.length()>3) {
                        show = show + "  ";
                    }
                    else if(show.length()<4 & show.length()>2){
                        show = show + "  ";
                    }
                    else if(show.length()<3 & show. length()>1){
                        show = show+ "    ";
                    }
                    orderList.append("\t" + show+ "\t" +price[j] + "\t" +count[j]+"\t"+ price[j]*count[j] +"₩\n");
                    ok[j].setEnabled(true);
                    count[j] = 0;
                    number[j].setText("0");
                }
            });
        }

    }
}

