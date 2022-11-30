package gui;

import java.awt.EventQueue;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bgc.*;
import gui.RoomSelectionFrame;
import mng.Factory;
import java.awt.Color;
import java.awt.Font;

public class LoginFrame extends JFrame {

	private JPanel contentPane;
	private JTextField tfUsername, tfPassword;
	private JButton loginBtn, registerBtn;
	private ImageIcon icon;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
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

	/**
	 * Create the frame.
	 */
	public LoginFrame() {
		// icon = new
		// ImageIcon("C:\\Users\\USER\\Desktop\\JAVA\\BoardGame\\door116_001.jpg");
		// icon = new
		// ImageIcon("C:\\Users\\USER\\Desktop\\JAVA\\BoardGame\\616de5f15a8ac2090fe457dafab8b41d.jpg");

		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		// setSize(400, 300);
		// setSize(400, 600);
		setBounds(100, 100, 821, 536);
		setLocationRelativeTo(null);
		setTitle("그린버튼 로그인 시스템");
		contentPane = new JPanel(); // {

//            public void paintComponent(Graphics g) {
		// Approach 1: Dispaly image at at full size
//                g.drawImage(icon.getImage(), 0, 0, null);
		// Approach 2: Scale image to size of component
		// Dimension d = getSize();
		// g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
		// Approach 3: Fix the image position in the scroll pane
		// Point p = scrollPane.getViewport().getViewPosition();
		// g.drawImage(icon.getImage(), p.x, p.y, null);
//                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
//                super.paintComponent(g);
//            }
//        };

		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		getContentPane().setBackground(Color.WHITE);

		ImageIcon gbIcn = new ImageIcon("img/KakaoTalk_20221126_180031678_01.jpg");
		Image gbImg = gbIcn.getImage(); // ImageIcon을 Image로 변환.
		Image gbImg1 = gbImg.getScaledInstance(360, 360, java.awt.Image.SCALE_SMOOTH);
		ImageIcon greenbttnIcon = new ImageIcon(gbImg1); // Image로 ImageIcon 생성

		JLabel gbLogo = new JLabel();
		gbLogo.setIcon(greenbttnIcon);
		gbLogo.setBounds(12, 10, 390, 477);
		getContentPane().add(gbLogo);

		ImageIcon lgIcn = new ImageIcon("img/1000997.png");
		Image lgImg = lgIcn.getImage(); // ImageIcon을 Image로 변환.
		Image lgIcn1 = lgImg.getScaledInstance(65, 65, java.awt.Image.SCALE_SMOOTH);
		ImageIcon loginIcon = new ImageIcon(lgIcn1); // Image로 ImageIcon 생성

//        JLabel lblLogin = new JLabel("username");
//        lblLogin.setFont(new Font("굴림", Font.BOLD, 21));
//        lblLogin.setForeground(Color.WHITE);
//        lblLogin.setBounds(41, 52, 104, 35);
//        contentPane.add(lblLogin);
		JLabel lblNewLabel_3 = new JLabel("아이디");
		lblNewLabel_3.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblNewLabel_3.setBounds(414, 191, 57, 15);
		getContentPane().add(lblNewLabel_3);

//        JLabel lblPassword = new JLabel("Password");
//        lblPassword.setFont(new Font("굴림", Font.BOLD, 21));
//        lblPassword.setForeground(Color.WHITE);
//        lblPassword.setBounds(41, 103, 104, 35);
//        contentPane.add(lblPassword);
		JLabel lblNewLabel_4 = new JLabel("비밀번호");
		lblNewLabel_4.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblNewLabel_4.setBounds(414, 239, 57, 15);
		getContentPane().add(lblNewLabel_4);

//        tfUsername = new JTextField();
//        tfUsername.setBounds(157, 52, 176, 35);
//        contentPane.add(tfUsername);
//        tfUsername.setColumns(10);
		tfUsername = new JTextField();
		tfUsername.setBounds(483, 188, 192, 21);
		getContentPane().add(tfUsername);
		tfUsername.setColumns(10);

		JLabel lblNewLabel_7 = new JLabel("아직 그린버튼 회원이 아니신가요?");
		lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_7.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		lblNewLabel_7.setBounds(414, 319, 370, 15);
		getContentPane().add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("그린버튼의 회원이 되어 다양한 재미를 맛보세요!");
		lblNewLabel_8.setForeground(Main.THEMECOLOR);
		lblNewLabel_8.setFont(new Font("나눔고딕", Font.PLAIN, 12));
		lblNewLabel_8.setBounds(493, 373, 261, 24);
		getContentPane().add(lblNewLabel_8);

//        registerBtn = new JButton("회원가입");
//        registerBtn.setBounds(229, 154, 104, 29);
//        contentPane.add(registerBtn);
		registerBtn = new JButton("회원가입하기");
		registerBtn.setForeground(Color.WHITE);
		registerBtn.setBackground(Main.THEMECOLOR);
		registerBtn.setBorderPainted(false);
		registerBtn.setBounds(493, 407, 291, 23);
		getContentPane().add(registerBtn);

//        loginBtn = new JButton("로그인");
//        loginBtn.setBounds(108, 154, 106, 29);
//        contentPane.add(loginBtn);
		loginBtn = new JButton("로그인");
		loginBtn.setBackground(Main.THEMECOLOR);
		loginBtn.setForeground(Color.WHITE);
		loginBtn.setBounds(687, 186, 97, 71);
		loginBtn.setBorderPainted(false);
		getContentPane().add(loginBtn);

		JLabel gbLabel1 = new JLabel("그린버튼입니다.");
		gbLabel1.setForeground(Main.THEMECOLOR);
		gbLabel1.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 31));
		gbLabel1.setBounds(414, 64, 295, 38);
		getContentPane().add(gbLabel1);

		JLabel lblNewLabel = new JLabel("서비스 이용을 위해 로그인 해주시기 바랍니다.");
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 12));
		lblNewLabel.setBounds(414, 150, 304, 15);
		getContentPane().add(lblNewLabel);

		JLabel gbLabel2 = new JLabel("어서오세요!");
		gbLabel2.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 31));
		gbLabel2.setForeground(Main.THEMECOLOR);
		gbLabel2.setBounds(414, 34, 295, 38);
		getContentPane().add(gbLabel2);

		JLabel frameDeco = new JLabel("");
		frameDeco.setIcon(new ImageIcon("img/greenery.png"));
		frameDeco.setBounds(414, 294, 370, 2);
		getContentPane().add(frameDeco);

		JLabel loginIconLbl = new JLabel("");
		loginIconLbl.setIcon(loginIcon);
		loginIconLbl.setBounds(414, 357, 87, 84);
		getContentPane().add(loginIconLbl);

//        tfPassword = new JTextField();
//        tfPassword.setColumns(10);
//        tfPassword.setBounds(157, 103, 176, 35);
//        contentPane.add(tfPassword);
		tfPassword = new JTextField();
		tfPassword.setBounds(483, 236, 192, 21);
		getContentPane().add(tfPassword);
		tfPassword.setColumns(10);

		setVisible(true);
		// 회원가입 액션
		registerBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				RegisterFrame frame = new RegisterFrame();
			}
		});

		// 로그인 액션
		loginBtn.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				Cafe.userManager.readAll(Main.scanFile("user.txt"), new Factory<User>() {
					public User create() {
						return new User();
					}
				});

				Cafe.user = Cafe.userManager.find(tfUsername.getText());
				if (Cafe.user != null && Cafe.user.password.equals(tfPassword.getText())) {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", Color.white);
					UI.put("Panel.background", Color.white);
					JLabel label = new JLabel("로그인에 성공하셨습니다.");
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
					JOptionPane.showOptionDialog(null, label, "메시지", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
					
					//JOptionPane.showMessageDialog(null, label, "ALERT", JOptionPane.WARNING_MESSAGE);
					// JOptionPane.showMessageDialog(null, "로그인에 성공하셨습니다.");
					Cafe.order = new Order(Cafe.user.identifier);
					dispose();
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								RoomSelectionFrame window = new RoomSelectionFrame();
								window.setVisible(true);
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				} else {
					UIManager UI = new UIManager();
					UI.put("OptionPane.background", Color.white);
					UI.put("Panel.background", Color.white);
					JLabel label = new JLabel("로그인 실패.");
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
					JOptionPane.showOptionDialog(null, label, "메시지", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
					//JOptionPane.showMessageDialog(null, "로그인 실패.");
				}
			}
		});
	}

}
