package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Calendar;

public class NewOrderSelection extends JFrame implements Runnable{

	JFrame frame;
	JLabel timerLabel = new JLabel();
	/**
	 * Launch the application.
	 */
//	public static void main(String[] args) {
//		EventQueue.invokeLater(new Runnable() {
//			public void run() {
//				try {
//					NewOrderSelection window = new NewOrderSelection();
//					window.frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		});
//	}

	/**
	 * Create the application.
	 */
	public NewOrderSelection() {
		frame = new JFrame();
		frame.setTitle("주문 선택");
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("보드게임");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BoardGameSelection frm = new BoardGameSelection();
				frm.setVisible(true);
			}
		});
		btnNewButton.setBounds(12, 42, 145, 209);
		frame.getContentPane().add(btnNewButton);
		
		JButton btnNewButton_2 = new JButton("음료");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DrinkSelection frm = new DrinkSelection();
				frm.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(169, 42, 145, 209);
		frame.getContentPane().add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("결제");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CheckOut frm = new CheckOut();
				frm.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(326, 188, 96, 63);
		frame.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_3 = new JButton("미니게임");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton_3.setBounds(326, 42, 96, 136);
		frame.getContentPane().add(btnNewButton_3);
		
		
		JLabel lblNewLabel = new JLabel("ID: "+Cafe.userIdentifier);
		lblNewLabel.setBounds(12, 10, 158, 22);
		frame.getContentPane().add(lblNewLabel);
		
		timerLabel = new JLabel("남은 시간: ");
		timerLabel.setBounds(182, 10, 158, 22);
		frame.getContentPane().add(timerLabel);
		
		JLabel lblNewLabel_2 = new JLabel("번방");
		lblNewLabel_2.setBounds(353, 10, 69, 22);
		frame.getContentPane().add(lblNewLabel_2);
		
		
		setTimer();
		setVisible(true);
	}

	void setTimer() {
	String time = getCurrentTime();
	timerLabel = new JLabel("남은 시간: "+time);
	timerLabel.setBounds(182, 10, 158, 22);
	frame.getContentPane().add(timerLabel);
	Thread t1 = new Thread(this);
	t1.start();
	}
	
	@Override
	public void run() {
		while(true) {
			try {
				Thread.sleep(1000);
				String time = getCurrentTime();
				timerLabel.setText("남은 시간: "+time);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
	public String getCurrentTime() {
		Calendar c = Calendar.getInstance();
		int hour = c.get(Calendar.HOUR_OF_DAY);
		int min = c.get(Calendar.MINUTE);
		int sec = c.get(Calendar.SECOND);
		
		String time = hour+":"+min+":"+sec;
		return time;
	}
	
}
