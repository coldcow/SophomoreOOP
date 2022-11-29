package gui;

import java.awt.*;
import java.awt.event.*;

import javax.swing.*;

import bgc.*;

public class MenuFrame extends JFrame {
	JPanel contentPane;

	public MenuFrame() {
		setTitle("메뉴 선택");
		setLocationRelativeTo(null);
		setSize(1600, 900);
		setLocation(0, 0);
		setForeground(Color.WHITE);
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		contentPane.setBackground(Color.WHITE);

		JPanel main = new JPanel(new BorderLayout());
		contentPane.add(main, BorderLayout.CENTER);
		main.setPreferredSize(new Dimension(1200, 900));

		JPanel information = new JPanel(new GridLayout(1, 4));
		main.add(information, BorderLayout.NORTH);
		information.setPreferredSize(new Dimension(1200, 100));
		information.setBackground(Main.THEMECOLOR);

		JLabel lblNewLabel = new JLabel("ID: " + Cafe.user.identifier);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(Main.THEMECOLOR, 10));
		information.add(lblNewLabel);
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setBackground(Main.THEMECOLOR);
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));

		JLabel lblNewLabel_1 = new JLabel("남은 시간: ");
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(Main.THEMECOLOR, 10));
		information.add(lblNewLabel_1);
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(Main.THEMECOLOR);
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));

		JLabel lblNewLabel_2 = new JLabel(String.format("%d번 방", Cafe.room.number));
		lblNewLabel_2.setBorder(BorderFactory.createLineBorder(Main.THEMECOLOR, 10));
		information.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBackground(Main.THEMECOLOR);
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));

		ImageIcon gbIcn = new ImageIcon("img/KakaoTalk_20221126_180031678_02.jpg");
		Image gbImg = gbIcn.getImage(); // ImageIcon을 Image로 변환.
		Image gbImg1 = gbImg.getScaledInstance(280, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon greenbttnIcon = new ImageIcon(gbImg1); // Image로 ImageIcon 생성

		JLabel logo = new JLabel();
		logo.setIcon(greenbttnIcon);
		logo.setBorder(BorderFactory.createLineBorder(Main.THEMECOLOR, 10));
		information.add(logo);

		JPanel newpanel = new JPanel(new BorderLayout());
		newpanel.setBackground(Color.WHITE);
		main.add(newpanel, BorderLayout.CENTER);

		DrinkOrderPanel dp = new DrinkOrderPanel();
		BoardGameOrderPanel bp = new BoardGameOrderPanel();

		JPanel buttonList = new JPanel(new GridLayout(4, 0));
		contentPane.add(buttonList, BorderLayout.EAST);
		buttonList.setPreferredSize(new Dimension(400, 900));
		buttonList.setBackground(Color.WHITE);
		buttonList.setBorder(BorderFactory.createLineBorder(Main.THEMECOLOR, 2));

		JPanel p = new JPanel();
		p.setBackground(Color.WHITE);
		p.setBorder(BorderFactory.createEmptyBorder(62, 0, 63, 0));

		JButton btnNewButton = new JButton("보드게임");
		btnNewButton.setPreferredSize(new Dimension(300, 100));
		btnNewButton.setBackground(Main.THEMECOLOR);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							newpanel.removeAll();
							bp.setVisible(true);
							newpanel.add(bp, BorderLayout.CENTER);
							newpanel.revalidate();
							newpanel.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton.setBorderPainted(false);
		btnNewButton.setFocusPainted(true);
		p.add(btnNewButton);
		buttonList.add(p);

		JPanel p2 = new JPanel();
		p2.setBackground(Color.WHITE);
		p2.setBorder(BorderFactory.createEmptyBorder(62, 0, 63, 0));

		JButton btnNewButton_2 = new JButton("음료");
		btnNewButton_2.setPreferredSize(new Dimension(300, 100));
		btnNewButton_2.setBackground(Main.THEMECOLOR);
		btnNewButton_2.setForeground(Color.WHITE);
		btnNewButton_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							newpanel.removeAll();
							dp.setVisible(true);
							newpanel.add(dp, BorderLayout.CENTER);
							newpanel.revalidate();
							newpanel.repaint();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnNewButton_2.setBorderPainted(false);
		btnNewButton_2.setFocusPainted(true);
		p2.add(btnNewButton_2);
		buttonList.add(p2);

		JPanel p3 = new JPanel();
		p3.setBackground(Color.WHITE);
		p3.setBorder(BorderFactory.createEmptyBorder(62, 0, 63, 0));

		JButton btnNewButton_1 = new JButton("결제");
		btnNewButton_1.setPreferredSize(new Dimension(300, 100));
		btnNewButton_1.setBackground(Main.THEMECOLOR);
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							PaymentFrame window = new PaymentFrame();
							window.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
				// frm.setVisible(true);
			}
		});
		btnNewButton_1.setBorderPainted(false);
		p3.add(btnNewButton_1);
		buttonList.add(p3);

		JPanel p4 = new JPanel();
		p4.setBackground(Color.WHITE);
		p4.setBorder(BorderFactory.createEmptyBorder(62, 0, 63, 0));

		JButton btnNewButton_3 = new JButton("미니게임");
		btnNewButton_3.setPreferredSize(new Dimension(300, 100));
		btnNewButton_3.setBackground(Main.THEMECOLOR);
		btnNewButton_3.setForeground(Color.WHITE);
		btnNewButton_3.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

			}
		});
		btnNewButton_3.setBorderPainted(false);
		p4.add(btnNewButton_3);
		buttonList.add(p4);

		setVisible(true);
	}

}