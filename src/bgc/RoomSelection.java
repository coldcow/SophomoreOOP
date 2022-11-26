package layout;

import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomSelection extends JFrame{
    public RoomSelection() {
        setBounds(100, 100, 821, 536);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("원하는 방을 선택하세요");
        lblNewLabel.setForeground(new Color(105, 170, 70));
        lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 27));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(12, 10, 781, 77);
        getContentPane().add(lblNewLabel);

        JLabel frameDeco1 = new JLabel("");
        frameDeco1.setIcon(new ImageIcon("C:\\Users\\rjsdn\\Documents\\GitHub\\SophomoreOOP\\img\\greenery.png"));
        frameDeco1.setBounds(12, 81, 781, 2);
        getContentPane().add(frameDeco1);

        JLabel frameDeco2 = new JLabel("");
        frameDeco2.setIcon(new ImageIcon("C:\\Users\\rjsdn\\Documents\\GitHub\\SophomoreOOP\\img\\greenery.png"));
        frameDeco2.setBounds(73, 338, 671, 2);
        getContentPane().add(frameDeco2);

        JButton btnNewButton = new JButton("1");
        btnNewButton.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.setBackground(new Color(133, 175, 75));
        btnNewButton.setBorderPainted(false);
        btnNewButton.setBounds(80, 124, 97, 35);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_1 = new JButton("2");
        btnNewButton_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.setBackground(new Color(133, 175, 75));
        btnNewButton_1.setBorderPainted(false);
        btnNewButton_1.setBounds(267, 124, 97,35);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_2 = new JButton("3");
        btnNewButton_2.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_2.setBackground(new Color(133, 175, 75));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.setBorderPainted(false);
        btnNewButton_2.setBounds(454, 124, 97, 35);
        getContentPane().add(btnNewButton_2);

        JButton btnNewButton_3 = new JButton("4");
        btnNewButton_3.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.setBackground(new Color(133, 175, 75));
        btnNewButton_3.setBorderPainted(false);
        btnNewButton_3.setBounds(641, 124, 97, 35);
        getContentPane().add(btnNewButton_3);

        JLabel lblNewLabel_1 = new JLabel("1번방");
        lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(80, 179, 97, 15);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("2번방");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(267, 179, 97, 15);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("3번방");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(454, 179, 97, 15);
        getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("4번방");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_3.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_3.setBounds(641, 179, 97, 15);
        getContentPane().add(lblNewLabel_1_3);

        JButton btnNewButton_4 = new JButton("5");
        btnNewButton_4.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_4.setForeground(Color.WHITE);
        btnNewButton_4.setBorderPainted(false);
        btnNewButton_4.setBackground(new Color(133, 175, 75));
        btnNewButton_4.setBounds(80, 229, 97, 35);
        getContentPane().add(btnNewButton_4);

        JButton btnNewButton_5 = new JButton("6");
        btnNewButton_5.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_5.setForeground(Color.WHITE);
        btnNewButton_5.setBorderPainted(false);
        btnNewButton_5.setBackground(new Color(133, 175, 75));
        btnNewButton_5.setBounds(267, 229, 97, 35);
        getContentPane().add(btnNewButton_5);

        JButton btnNewButton_6 = new JButton("7");
        btnNewButton_6.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_6.setForeground(Color.WHITE);
        btnNewButton_6.setBorderPainted(false);
        btnNewButton_6.setBackground(new Color(133, 175, 75));
        btnNewButton_6.setBounds(454, 229, 97, 35);
        getContentPane().add(btnNewButton_6);

        JButton btnNewButton_7 = new JButton("8");
        btnNewButton_7.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_7.setForeground(Color.WHITE);
        btnNewButton_7.setBorderPainted(false);
        btnNewButton_7.setBackground(new Color(133, 175, 75));
        btnNewButton_7.setBounds(641, 229, 97, 35);
        getContentPane().add(btnNewButton_7);

        JLabel lblNewLabel_1_4 = new JLabel("5번방");
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_4.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_4.setBounds(80, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("6번방");
        lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_5.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_5.setBounds(267, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("7번방");
        lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_6.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_6.setBounds(454, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_6);

        JLabel lblNewLabel_1_7 = new JLabel("8번방");
        lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_7.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_7.setBounds(641, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_7);

        JLabel lblNewLabel_2 = new JLabel("30분");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(80, 371, 97, 25);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("1시간\r\n");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2_1.setBounds(267, 371, 97, 25);
        getContentPane().add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("2시간");
        lblNewLabel_2_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setBounds(454, 371, 97, 25);
        getContentPane().add(lblNewLabel_2_2);

        JLabel lblNewLabel_2_3 = new JLabel("4시간");
        lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_3.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2_3.setBounds(641, 371, 97, 25);
        getContentPane().add(lblNewLabel_2_3);

        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
        chckbxNewCheckBox.setBounds(113, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
        chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_1.setBackground(Color.WHITE);
        chckbxNewCheckBox_1.setBounds(303, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
        chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_2.setBackground(Color.WHITE);
        chckbxNewCheckBox_2.setBounds(490, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox_2);

        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
        chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_3.setBackground(Color.WHITE);
        chckbxNewCheckBox_3.setBounds(677, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox_3);

        JButton btnNewButton_8 = new JButton("다음");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_8.setForeground(Color.WHITE);
        btnNewButton_8.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_8.setBorderPainted(false);
        btnNewButton_8.setBackground(new Color(164, 197, 120));
        btnNewButton_8.setBounds(361, 442, 97, 35);
        getContentPane().add(btnNewButton_8);
    }

    /**
     * Initialize the contents of the frame.
     */
}