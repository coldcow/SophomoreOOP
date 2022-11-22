package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.SwingConstants;

import mng.Manager;
import bgc.User;
import bgc.Order;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class PaymentSelection {
	
	private JFrame frame;
	static User user = new User();
	static int cost = 0; 

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PaymentSelection window = new PaymentSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PaymentSelection() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Manager<User> userManager = new Manager<>();
		Order order = new Order(user.identifier);
		user = userManager.find("");
		if(user.age<20) {
			cost *= 0.9;
		}
		Payment.giveMileage(user,cost);
		
		frame = new JFrame();

		frame.setBounds(100, 100, 260, 360);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel_4 = new JPanel();
		frame.getContentPane().add(panel_4, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("일반 결제");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				order.addOrderToFile(Main.openFile("order.txt"));

			}
		});
		panel_4.add(btnNewButton);

		JButton btnNewButton_1 = new JButton("마일리지 사용");
		btnNewButton_1.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				if (user.mileage == 0) {
					JFrame nope = new JFrame();
					JLabel no = new JLabel("적립된 마일리지가 없습니다.");
					nope.add(no);
					nope.setVisible(true);
				} else {
					new PointSelection();
					frame.setVisible(false);
				}
			}
		});

		panel_4.add(btnNewButton_1);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.NORTH);

		JLabel lblNewLabel_1 = new JLabel("결제할 금액");
		panel_2.add(lblNewLabel_1);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("여기에 대충 비용 뜨고");
		lblNewLabel.setBounds(62, 120, 120, 15);
		panel.add(lblNewLabel);
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
	}

}
