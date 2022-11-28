package bgc;

import layout.LoginFrame;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PointSelection extends JFrame {
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	public PointSelection() {
		initialize();
		setVisible(true);
	}

	private void initialize() {
		setBounds(100, 100, 320, 345);
		getContentPane().setBackground(new Color(255, 255, 255));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		getContentPane().setLayout(null);

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

		JPanel panel = new JPanel();
		panel.setBackground(Color.WHITE);
		panel.setBounds(12, 117, 280, 55);
		getContentPane().add(panel);

		JLabel lblNewLabel = new JLabel(PaymentSelection.user.identifier);
		lblNewLabel.setFont(new Font("나눔고딕", Font.BOLD, 15));
		panel.add(lblNewLabel);

		JLabel lblNewLabel_1 = new JLabel("님이 보유하신 마일리지는");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("" + PaymentSelection.user.mileage);
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.BOLD, 15));
		panel.add(lblNewLabel_2);
		JLabel lblNewLabel_3 = new JLabel("입니다.");
		lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		panel.add(lblNewLabel_3);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(Color.WHITE);
		panel_1.setBounds(12, 181, 280, 40);
		getContentPane().add(panel_1);

		JLabel lblNewLabel_4 = new JLabel("사용할 마일리지");
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		panel_1.add(lblNewLabel_4);

		textField = new JTextField();
		textField.setFont(new Font("나눔고딕", Font.PLAIN, 15));
		panel_1.add(textField);
		textField.setColumns(10);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(Color.WHITE);
		panel_3.setBounds(12, 240, 280, 59);
		getContentPane().add(panel_3);
		panel_3.setLayout(null);

		JLabel lblNewLabel_5 = new JLabel("금액 " + PaymentSelection.cost + " 원");
		lblNewLabel_5.setBounds(12, 10, 137, 39);
		lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_5.setFont(new Font("나눔고딕", Font.BOLD, 16));
		panel_3.add(lblNewLabel_5);

		JButton btnNewButton = new JButton("결제하기");
		btnNewButton.setBounds(161, 16, 105, 27);
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBorderPainted(false);
		btnNewButton.setBackground(new Color(164, 197, 120));
		btnNewButton.setFont(new Font("나눔고딕", Font.PLAIN, 16));
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = 0;
				if (!textField.getText().equals(""))
					x = Integer.parseInt(textField.getText());

				if (PaymentSelection.user.mileage < x) {
					JOptionPane.showMessageDialog(null, "마일리지가 부족합니다.");
					// dispose();
				} else {
					Payment.useMileage(PaymentSelection.user, PaymentSelection.cost, x);
					Cafe.order.addOrderToFile(Main.openFile("order.txt"));
					Cafe.userManager.writeAll(new File("user.txt"));
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

			}
		});
		panel_3.add(btnNewButton);
		
		JLabel lblNewLabel_7 = new JLabel("");
		lblNewLabel_7.setIcon(new ImageIcon("img/greenery.png"));
		lblNewLabel_7.setBounds(12, 107, 280, 2);
		getContentPane().add(lblNewLabel_7);
		
		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(new ImageIcon("img/greenery.png"));
		lblNewLabel_6.setBounds(12, 230, 280, 2);
		getContentPane().add(lblNewLabel_6);
	}
}