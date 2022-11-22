package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLayeredPane;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PointSelection extends JFrame {

	private JFrame frame;
	private JTextField textField;

	/**
	 * Launch the application.
	 */

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PointSelection window = new PointSelection();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public PointSelection() {
		initialize();
		frame.setVisible(true);
	}

	/**
	 * Create the application.
	 */

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();

		frame.setBounds(100, 100, 280, 330);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);

		JLabel lblNewLabel = new JLabel("마일리지 사용");
		panel.add(lblNewLabel);

		JPanel panel_2 = new JPanel();
		frame.getContentPane().add(panel_2, BorderLayout.SOUTH);

		JButton btnNewButton = new JButton("결제");
		btnNewButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				int x = Integer.parseInt(textField.getText());

				if (PaymentSelection.user.mileage < x) {
					JFrame nope = new JFrame();
					JLabel no = new JLabel("마일리지가 부족합니다.");
					nope.add(no);
					nope.setVisible(true);
				} else {
					Payment.useMileage(PaymentSelection.user, PaymentSelection.cost, x);
				}

			}
		});
		panel_2.add(btnNewButton);

		JPanel panel_1 = new JPanel();
		FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
		flowLayout.setVgap(30);
		flowLayout.setHgap(100);
		frame.getContentPane().add(panel_1, BorderLayout.CENTER);

		JLabel lblNewLabel_2_1 = new JLabel("사용가능한 마일리지");
		lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 12));

		panel_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3_1 = new JLabel("여기 정보 뜨고");

		panel_1.add(lblNewLabel_3_1);

		JLabel lblNewLabel_1_1 = new JLabel("사용할 마일리지");
		lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 12));

		panel_1.add(lblNewLabel_1_1);

		textField = new JTextField();
		textField.setColumns(10);

		panel_1.add(textField);

	}

}
