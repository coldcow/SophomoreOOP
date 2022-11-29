package gui;

import java.awt.*;

import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bgc.*;

import java.util.Timer;
import java.util.TimerTask;

public class OrderSelectionFrame extends JFrame {
	JPanel contentPane;
	String colorFocus = "0";
	JButton bgmButton = new JButton();
	JButton minigameButton = new JButton();
	JButton checkOutButton = new JButton();
	JButton drinkButton = new JButton();
	int roomTime = Cafe.time;
	
	public OrderSelectionFrame() {
		setForeground(new Color(255, 255, 255));
		setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setTitle("주문 선택");
		setSize(1600, 900);

		contentPane = new JPanel(new BorderLayout());
		setContentPane(contentPane);
		contentPane.setBackground(new Color(255, 255, 255));

		JPanel main = new JPanel(new BorderLayout());
		contentPane.add(main, BorderLayout.CENTER);
		main.setPreferredSize(new Dimension(1200, 900));

		JPanel information = new JPanel(new GridLayout(1, 4));
		main.add(information, BorderLayout.NORTH);
		information.setPreferredSize(new Dimension(1200, 100));
		information.setBackground(new Color(133, 175, 75));

		JLabel lblNewLabel = new JLabel("ID: " + Cafe.user.identifier);
		lblNewLabel.setBorder(BorderFactory.createLineBorder(new Color(133, 175, 75), 10));
		information.add(lblNewLabel);
		lblNewLabel.setForeground(new Color(255, 255, 255));
		lblNewLabel.setBackground(new Color(133, 175, 75));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));

		JLabel lblNewLabel_1 = new JLabel("남은 시간: ");
		lblNewLabel_1.setBorder(BorderFactory.createLineBorder(new Color(133, 175, 75), 10));
		information.add(lblNewLabel_1);
	       Timer timer = new Timer();
	     
	       
	        timer.scheduleAtFixedRate(new TimerTask() {
	        	int i = 1800;

	            public void run() {
	            	lblNewLabel_1.setText("남은 시간: " + getTime(i));
	                i--;

	                if (i < 0) {
	                    timer.cancel();
	                    lblNewLabel_1.setText("Time Over");
	                }
	            }
	        }, 0, 1000);
		lblNewLabel_1.setForeground(new Color(255, 255, 255));
		lblNewLabel_1.setBackground(new Color(133, 175, 75));
		lblNewLabel_1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));

		JLabel lblNewLabel_2 = new JLabel(String.format("%d번 방", Cafe.room.number));
		lblNewLabel_2.setBorder(BorderFactory.createLineBorder(new Color(133, 175, 75), 10));
		information.add(lblNewLabel_2);
		lblNewLabel_2.setForeground(new Color(255, 255, 255));
		lblNewLabel_2.setBackground(new Color(133, 175, 75));
		lblNewLabel_2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));

		ImageIcon gbIcn = new ImageIcon("img/KakaoTalk_20221126_180031678_02.jpg");
		Image gbImg = gbIcn.getImage(); // ImageIcon을 Image로 변환.
		Image gbImg1 = gbImg.getScaledInstance(280, 80, java.awt.Image.SCALE_SMOOTH);
		ImageIcon greenbttnIcon = new ImageIcon(gbImg1); // Image로 ImageIcon 생성

		JLabel logo = new JLabel();
		logo.setIcon(greenbttnIcon);
		logo.setBorder(BorderFactory.createLineBorder(new Color(133, 175, 75), 10));
		information.add(logo);

		JPanel newpanel = new JPanel(new BorderLayout());
		newpanel.setBackground(new Color(255, 255, 255));
		main.add(newpanel, BorderLayout.CENTER);

		DrinkOrderPanel dp = new DrinkOrderPanel();
		BoardGameOrderPanel bp = new BoardGameOrderPanel();

		JPanel buttonList = new JPanel(new GridLayout(4, 0));
		contentPane.add(buttonList, BorderLayout.EAST);
		buttonList.setPreferredSize(new Dimension(400, 900));
		buttonList.setBackground(new Color(255, 255, 255));
		buttonList.setBorder(BorderFactory.createLineBorder(new Color(133, 175, 75), 2));

		JPanel p = new JPanel();
		p.setBackground(new Color(255,255,255));
		p.setBorder(BorderFactory.createEmptyBorder(62, 0 , 63, 0));

		bgmButton = new JButton("보드게임");
		bgmButton.setPreferredSize(new Dimension(300, 100));
		bgmButton.setBackground(new Color(255, 255, 255));
		bgmButton.setForeground(new Color(0, 0, 0));
		bgmButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		bgmButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setButtonColor(bgmButton);
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
		//btnNewButton.setBorderPainted(false);
		bgmButton.setFocusPainted(true);
		p.add(bgmButton);
		buttonList.add(p);

		JPanel p2 = new JPanel();
		p2.setBackground(new Color(255,255,255));
		p2.setBorder(BorderFactory.createEmptyBorder(62, 0 , 63, 0));
		
		drinkButton = new JButton("음료");
		drinkButton.setPreferredSize(new Dimension(300, 100));
		drinkButton.setBackground(new Color(255, 255, 255));
		drinkButton.setForeground(new Color(0,0,0));
		drinkButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		drinkButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setButtonColor(drinkButton);
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
		//btnNewButton_2.setBorderPainted(false);
		drinkButton.setFocusPainted(true);
		p2.add(drinkButton);
		buttonList.add(p2);

		JPanel p3 = new JPanel();
		p3.setBackground(new Color(255,255,255));
		p3.setBorder(BorderFactory.createEmptyBorder(62, 0 , 63, 0));
		
		checkOutButton = new JButton("결제");
		checkOutButton.setPreferredSize(new Dimension(300, 100));
		checkOutButton.setBackground(new Color(255,255,255));
		checkOutButton.setForeground(new Color(0,0,0));
		checkOutButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		checkOutButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							setButtonColor(checkOutButton);
							PaymentSelection window = new PaymentSelection();
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
		//btnNewButton_1.setBorderPainted(false);
		p3.add(checkOutButton);
		buttonList.add(p3);

		JPanel p4 = new JPanel();
		p4.setBackground(new Color(255,255,255));
		p4.setBorder(BorderFactory.createEmptyBorder(62, 0 , 63, 0));
		
		minigameButton = new JButton("미니게임");
		minigameButton.setPreferredSize(new Dimension(300, 100));
		minigameButton.setBackground(new Color(255,255,255));
		minigameButton.setForeground(new Color(0,0,0));
		minigameButton.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 24));
		minigameButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setButtonColor(minigameButton);
			}
		});
//		btnNewButton_3.setBorderPainted(false);
		p4.add(minigameButton);
		buttonList.add(p4);

		setVisible(true);
	}
	
	private void setButtonColor(JButton btn) {
		switch(this.colorFocus) {
		case "0":
			btn.setForeground(Color.WHITE);
			btn.setBackground(new Color(133, 175, 75));
			this.colorFocus = btn.getActionCommand();
			break;
		case "보드게임":
			bgmButton.setBackground(new Color(255, 255, 255));
			bgmButton.setForeground(new Color(0, 0, 0));
			btn.setForeground(Color.WHITE);
			btn.setBackground(new Color(133, 175, 75));
			this.colorFocus = btn.getActionCommand();
			break;
		case "음료":
			drinkButton.setBackground(new Color(255, 255, 255));
			drinkButton.setForeground(new Color(0, 0, 0));
			btn.setForeground(Color.WHITE);
			btn.setBackground(new Color(133, 175, 75));
			this.colorFocus = btn.getActionCommand();
			break;
		case "미니게임":
			minigameButton.setBackground(new Color(255, 255, 255));
			minigameButton.setForeground(new Color(0, 0, 0));
			btn.setForeground(Color.WHITE);
			btn.setBackground(new Color(133, 175, 75));
			this.colorFocus = btn.getActionCommand();
			break;
		case "결제":
			checkOutButton.setBackground(new Color(255, 255, 255));
			checkOutButton.setForeground(new Color(0, 0, 0));
			btn.setForeground(Color.WHITE);
			btn.setBackground(new Color(133, 175, 75));
			this.colorFocus = btn.getActionCommand();
			break;
		}

	}
	//108분 50초
	// = 108 * 60 + 50
	private String getTime(int i) {
		String hour = ""+(i / 3600);
		String min = ""+(i / 60);
		String sec = ""+(i % 60);
	
		return hour+":"+min+":"+sec;
	}

   

}