package layout;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class swTest {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					swTest window = new swTest();
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
	public swTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		frame.setBounds(100, 100, 821, 536);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("서비스 이용을 위해 로그인 해주시기 바랍니다.");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		lblNewLabel.setBounds(401, 149, 304, 15);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_3 = new JLabel("아이디");
		lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(414, 191, 57, 15);
		frame.getContentPane().add(lblNewLabel_3);

//        JLabel lblPassword = new JLabel("Password");
//        lblPassword.setFont(new Font("굴림", Font.BOLD, 21));
//        lblPassword.setForeground(new Color(255, 255, 255));
//        lblPassword.setBounds(41, 103, 104, 35);
//        contentPane.add(lblPassword);
		JLabel lblNewLabel_4 = new JLabel("비밀번호");
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(414, 137, 73, 181);
		frame.getContentPane().add(lblNewLabel_4);

	}
}
