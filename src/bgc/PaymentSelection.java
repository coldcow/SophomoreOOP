package bgc;

import java.awt.EventQueue;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.BorderLayout;

import layout.LoginFrame;
import mng.Manager;
import bgc.User;
import bgc.Order;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.table.DefaultTableModel;

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;

public class PaymentSelection extends JFrame {

	// private JFrame frame;
	static User user = Cafe.user;
	static int cost = Cafe.cost;
	private JTable table;

	/**
	 * Launch the application.
	 */

	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { PaymentSelection window = new
	 * PaymentSelection(); window.frame.setVisible(true); } catch (Exception e) {
	 * e.printStackTrace(); } } }); }
	 */

	/**
	 * Create the application.
	 */
	public PaymentSelection() {
		initialize();
		setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		// Manager<User> userManager = new Manager<>();
		// Order order = new Order(user.identifier);
		// = userManager.find("");
		if (user.age < 20) {
			cost *= 0.9;
		}
		Payment.giveMileage(user, cost);

		// frame = new JFrame();

		setBounds(100, 100, 320, 560);
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

		JPanel panel_4 = new JPanel();
		panel_4.setBounds(12, 470, 279, 41);
		panel_4.setBackground(Color.WHITE);
		getContentPane().add(panel_4);

		JButton btnNewButton = new JButton("일반 결제");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(164, 197, 120));
		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cafe.order.addOrderToFile(Main.openFile("order.txt"));
				JOptionPane.showMessageDialog(null, "결제가 완료되었습니다 감사합니다.");
				dispose();
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							LoginFrame loginFrame = new LoginFrame();

						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("마일리지 사용");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorderPainted(false);
		btnNewButton_1.setBackground(new Color(164, 197, 120));
		btnNewButton_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (user.mileage == 0) {
					JOptionPane.showMessageDialog(null, "적립된 마일리지가 없습니다.");
				} else {
					// new PointSelection();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								PointSelection window = new PointSelection();
								window.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
					dispose();
					// setVisible(false);
				}
			}
		});

		panel_4.add(btnNewButton_1);

		JPanel panel = new JPanel();
		panel.setBounds(12, 120, 279, 298);
		panel.setBackground(Color.WHITE);
		getContentPane().add(panel);
		panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));

		JLabel lblNewLabel = new JLabel("주문 내역");
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);

		String[] columnNames = { "종류", "이름", "가격" };
		DefaultTableModel tableModel = new DefaultTableModel(columnNames, 0);
		
		ArrayList<String> s = Cafe.order.orderedName;

		for (String string : s) {
			Drink drink = Cafe.drinkManager.find(string);
			if (drink != null)
				tableModel.addRow(drink.getTexts());
		}

		table = new JTable(tableModel);
		JScrollPane scroll = new JScrollPane(table);
		scroll.setPreferredSize(new Dimension(275, 260));
		panel.add(scroll, BorderLayout.CENTER);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 439, 279, 32);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_1 = new JLabel("금액");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel_1.add(lblNewLabel_1);
		JLabel lblNewLabel_2 = new JLabel(cost + "원");
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 18));
		panel_1.add(lblNewLabel_2);

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(Color.WHITE);
		panel_2.setBounds(12, 10, 280, 90);
		getContentPane().add(panel_2);

		ImageIcon icon = new ImageIcon("img/KakaoTalk_20221126_180031678_02.jpg");
		Image img = icon.getImage();
		Image changeImg = img.getScaledInstance(280, 80, Image.SCALE_SMOOTH);
		ImageIcon changeIcon = new ImageIcon(changeImg);
		JLabel lbl = new JLabel(changeIcon);

		panel_2.add(lbl);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("img/greenery.png"));
		lblNewLabel_3.setBounds(12, 109, 279, 2);
		getContentPane().add(lblNewLabel_3);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("img/greenery.png"));
		lblNewLabel_4.setBounds(12, 427, 279, 2);
		getContentPane().add(lblNewLabel_4);

	}
}