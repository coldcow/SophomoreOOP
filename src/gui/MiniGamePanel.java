package gui;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import bgc.Main;

public class MiniGamePanel extends JPanel {
    GoEgg goEgg[][];
    ImageIcon img = new ImageIcon("img//empty.png");
    ImageIcon white = new ImageIcon("img//white.png");
    ImageIcon black = new ImageIcon("img//black2.png");
    ImageIcon turn = black;

    public MiniGamePanel() {
        //setTitle("오목");
        //setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        //Container c = getContentPane();
        setLayout(new GridLayout(26, 26));
        /*JButton btnNewButton = new JButton("<-");
        btnNewButton.setBackground(new Color(133, 175, 75));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(true);*/
        //getContentPane().add(btnNewButton);

        goEgg = new GoEgg[26][];

        myActionListener goAction = new myActionListener();
        for (int i = 0; i < 26; i++) {
            goEgg[i] = new GoEgg[26];
            for (int j = 0; j < 26; j++) {
                goEgg[i][j] = new GoEgg(i, j, img);
                add(goEgg[i][j]);
                goEgg[i][j].addActionListener(goAction);
                goEgg[i][j].setBorderPainted(false);
            }
        }

        //setSize(300, 240);
        setVisible(true);
    }

    class myActionListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            // TODO Auto-generated method stub
            GoEgg wi = (GoEgg) e.getSource();
            if (turn == white) {
                wi.setIcon(white);
                wi.state = "W";
                turn = black;

            } else {
                wi.setIcon(black);
                wi.state = "B";
                turn = white;
            }
            checkWin(wi);
            wi.removeActionListener(this);
        }

    }

    public void checkWin(GoEgg e) {
        //좌우 탐색
        int checkx = e.x;
        int checky = e.y;
        int count = 0;
        while (checky >= 0 && goEgg[checkx][checky].state.equals(e.state)) {
            checky -= 1;
        }
        checky += 1;
        while (checky < 26 && goEgg[checkx][checky].state.equals(e.state)) {
            checky += 1;
            count++;
        }
        if (count == 5) {
            if (e.state.equals("B")) {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("흑돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                //JOptionPane.showMessageDialog(null, "흑돌 승리", "흑돌 승리", JOptionPane.QUESTION_MESSAGE);
                //dispose();
            } else {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("백돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                //JOptionPane.showMessageDialog(null, "백돌 승리", "백돌 승리", JOptionPane.QUESTION_MESSAGE);
                //dispose();
            }

        }
        /////////////////////////////////
        checkx = e.x;
        checky = e.y;
        count = 0;

        while (checkx >= 0 && goEgg[checkx][checky].state.equals(e.state)) {
            checkx -= 1;
        }
        checkx += 1;
        while (checkx < 26 && goEgg[checkx][checky].state.equals(e.state)) {
            checkx += 1;
            count++;
        }
        if (count == 5) {
            if (e.state.equals("B")) {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("흑돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                //JOptionPane.showMessageDialog(null, "흑돌 승리", "흑돌 승리", JOptionPane.QUESTION_MESSAGE);
                //dispose();
            } else {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("백돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                //JOptionPane.showMessageDialog(null, "백돌 승리", "백돌 승리", JOptionPane.QUESTION_MESSAGE);
                //dispose();
            }
        }
        ////////////////////
        checkx = e.x;
        checky = e.y;
        count = 0;

        while (checkx >= 0 && checky >= 0 && goEgg[checkx][checky].state.equals(e.state)) {
            checkx -= 1;
            checky -= 1;
        }
        checkx += 1;
        checky += 1;
        while (checkx < 26 && checky < 26 && goEgg[checkx][checky].state.equals(e.state)) {
            checkx += 1;
            checky += 1;
            count++;
        }
        if (count == 5) {
            if (e.state.equals("B")) {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("흑돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                //JOptionPane.showMessageDialog(null, "흑돌 승리", "흑돌 승리", JOptionPane.QUESTION_MESSAGE);
                //dispose();
            } else {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("백돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                //JOptionPane.showMessageDialog(null, "백돌 승리", "백돌 승리", JOptionPane.QUESTION_MESSAGE);
                //dispose();
            }
        }
        //		//////////////////
        checkx = e.x;
        checky = e.y;
        count = 0;

        while (checkx >= 0 && checky < 26 && goEgg[checkx][checky].state.equals(e.state)) {
            checkx -= 1;
            checky += 1;
        }
        checkx += 1;
        checky -= 1;
        while (checkx < 26 && checky >= 0 && goEgg[checkx][checky].state.equals(e.state)) {
            checkx += 1;
            checky -= 1;
            count++;
        }

        if (count == 5) {
            if (e.state.equals("B")) {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("흑돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
               
                //dispose();
            } else {
            	UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("백돌 승리");
				label.setBackground(Color.WHITE);
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(Color.WHITE);
				button.setBackground(Main.THEMECOLOR);
				button.setBorderPainted(false);
				button.addActionListener(new ActionListener() {
				   @Override
				   public void actionPerformed(ActionEvent actionEvent) {
				       JOptionPane.getRootFrame().dispose();
				   }
				});
				JButton[] buttons = { button };
				JOptionPane.showOptionDialog(null, label, "WIN", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                
                //dispose();
            }

        }

    }

    /*public static void main(String[] args) {
        new MiniGamePanel();
    }*/
}

class GoEgg extends JButton {
    int x;
    int y;
    String state;

    public GoEgg(int x, int y, ImageIcon image) {
        super(image);
        this.x = x;
        this.y = y;
        state = "N";
    }
}