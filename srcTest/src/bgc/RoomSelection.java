package bgc;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import javax.swing.table.DefaultTableModel;

import mng.Factory;

public class RoomSelection extends JPanel implements ActionListener, ListSelectionListener {
	private static final long serialVersionUID = 1L;
	JTable table = null;
	JButton jb = null;
	JTextField edits[] = new JTextField[5];

	public RoomSelection() {
		// super(new BorderLayout());
		RoomTableInit();
		JPanel pane = makeRoomPane();
		add(pane); // JFrame에 jp라는 패널 추가

	}

	private JPanel makeRoomPane() {
		// TODO Auto-generated method stub
		JPanel pane = new JPanel();
		pane.setBounds(100, 100, 821, 536);
		pane.setBackground(new Color(255, 255, 255));
		//pane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("원하는 방을 선택하세요");
		lblNewLabel.setForeground(new Color(105, 170, 70));
		lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 27));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(12, 10, 781, 77);
		pane.add(lblNewLabel);
		
		JLabel frameDeco1 = new JLabel("");
		frameDeco1.setIcon(new ImageIcon("C:\\Users\\rjsdn\\Documents\\GitHub\\SophomoreOOP\\img\\greenery.png"));
		frameDeco1.setBounds(12, 81, 781, 2);
		pane.add(frameDeco1);
		
		JLabel frameDeco2 = new JLabel("");
		frameDeco2.setIcon(new ImageIcon("C:\\Users\\rjsdn\\Documents\\GitHub\\SophomoreOOP\\img\\greenery.png"));
		frameDeco2.setBounds(73, 338, 671, 2);
		pane.add(frameDeco2);

		JButton jb1 = new JButton("1");
		jb1.addActionListener(event -> {
			roomEventHandler(event);			
		});
		jb1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		jb1.setForeground(new Color(255, 255, 255));
		jb1.setBackground(new Color(133, 175, 75));
		jb1.setBorderPainted(false);
		jb1.setBounds(80, 124, 97, 35);
		pane.add(jb1); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb2 = new JButton("2");
		jb2.addActionListener(event -> {
			roomEventHandler(event);
		});
		jb2.setFont(new Font("나눔고딕", Font.BOLD, 16));
		jb2.setForeground(new Color(255, 255, 255));
		jb2.setBackground(new Color(133, 175, 75));
		jb2.setBorderPainted(false);
		jb2.setBounds(267, 124, 97,35);
		pane.add(jb2); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb3 = new JButton("3");
		jb3.addActionListener(event -> {
			roomEventHandler(event);
		});
		jb3.setFont(new Font("나눔고딕", Font.BOLD, 16));
		jb3.setBackground(new Color(133, 175, 75));
		jb3.setForeground(new Color(255, 255, 255));
		jb3.setBorderPainted(false);
		jb3.setBounds(454, 124, 97, 35);
		pane.add(jb3); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton jb4 = new JButton("4");
		jb4.addActionListener(event -> {
			roomEventHandler(event);
		});
		jb4.setFont(new Font("나눔고딕", Font.BOLD, 16));
		jb4.setForeground(new Color(255, 255, 255));
		jb4.setBackground(new Color(133, 175, 75));
		jb4.setBorderPainted(false);
		jb4.setBounds(641, 124, 97, 35);
		pane.add(jb4); // pane이라는 패널에 jb라는 버튼 추가
		
		JButton btnNewButton_4 = new JButton("5");
		btnNewButton_4.setFont(new Font("나눔고딕", Font.BOLD, 16));
		btnNewButton_4.setForeground(Color.WHITE);
		btnNewButton_4.setBorderPainted(false);
		btnNewButton_4.setBackground(new Color(133, 175, 75));
		btnNewButton_4.setBounds(80, 229, 97, 35);
		pane.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("6");
		btnNewButton_5.setFont(new Font("나눔고딕", Font.BOLD, 16));
		btnNewButton_5.setForeground(Color.WHITE);
		btnNewButton_5.setBorderPainted(false);
		btnNewButton_5.setBackground(new Color(133, 175, 75));
		btnNewButton_5.setBounds(267, 229, 97, 35);
		pane.add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("7");
		btnNewButton_6.setFont(new Font("나눔고딕", Font.BOLD, 16));
		btnNewButton_6.setForeground(Color.WHITE);
		btnNewButton_6.setBorderPainted(false);
		btnNewButton_6.setBackground(new Color(133, 175, 75));
		btnNewButton_6.setBounds(454, 229, 97, 35);
		pane.add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("8");
		btnNewButton_7.setFont(new Font("나눔고딕", Font.BOLD, 16));
		btnNewButton_7.setForeground(Color.WHITE);
		btnNewButton_7.setBorderPainted(false);
		btnNewButton_7.setBackground(new Color(133, 175, 75));
		btnNewButton_7.setBounds(641, 229, 97, 35);
		pane.add(btnNewButton_7);
		
		JLabel lblNewLabel_1 = new JLabel("1번방");
		lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(80, 179, 97, 15);
		pane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("2번방");
		lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_1.setBounds(267, 179, 97, 15);
		pane.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("3번방");
		lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_2.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_2.setBounds(454, 179, 97, 15);
		pane.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("4번방");
		lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_3.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_3.setBounds(641, 179, 97, 15);
		pane.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("5번방");
		lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_4.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_4.setBounds(80, 284, 97, 15);
		pane.add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("6번방");
		lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_5.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_5.setBounds(267, 284, 97, 15);
		pane.add(lblNewLabel_1_5);
		
		JLabel lblNewLabel_1_6 = new JLabel("7번방");
		lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_6.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_6.setBounds(454, 284, 97, 15);
		pane.add(lblNewLabel_1_6);
		
		JLabel lblNewLabel_1_7 = new JLabel("8번방");
		lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1_7.setFont(new Font("나눔고딕", Font.BOLD, 16));
		lblNewLabel_1_7.setBounds(641, 284, 97, 15);
		pane.add(lblNewLabel_1_7);
		
		JLabel lblNewLabel_2 = new JLabel("30분");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(80, 371, 97, 25);
		pane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("1시간\r\n");
		lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel_2_1.setBounds(267, 371, 97, 25);
		pane.add(lblNewLabel_2_1);
		
		JLabel lblNewLabel_2_2 = new JLabel("2시간");
		lblNewLabel_2_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_2.setBounds(454, 371, 97, 25);
		pane.add(lblNewLabel_2_2);
		
		JLabel lblNewLabel_2_3 = new JLabel("4시간");
		lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
		lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2_3.setFont(new Font("나눔고딕", Font.PLAIN, 18));
		lblNewLabel_2_3.setBounds(641, 371, 97, 25);
		pane.add(lblNewLabel_2_3);
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("");
		chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
		chckbxNewCheckBox.setBounds(113, 402, 26, 23);
		pane.add(chckbxNewCheckBox);
		
		JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
		chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_1.setBackground(Color.WHITE);
		chckbxNewCheckBox_1.setBounds(303, 402, 26, 23);
		pane.add(chckbxNewCheckBox_1);
		
		JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
		chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_2.setBackground(Color.WHITE);
		chckbxNewCheckBox_2.setBounds(490, 402, 26, 23);
		pane.add(chckbxNewCheckBox_2);
		
		JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
		chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
		chckbxNewCheckBox_3.setBackground(Color.WHITE);
		chckbxNewCheckBox_3.setBounds(677, 402, 26, 23);
		pane.add(chckbxNewCheckBox_3);
		
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
		pane.add(btnNewButton_8);
		
		// end 버튼 추가
		JButton jbEnd = new JButton("end");
//		jbEnd.addActionListener(new ActionListener() {
//
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				// TODO Auto-generated method stub
//				System.exit(0);
//			}
//		});
		jbEnd.addActionListener(event -> {
			System.exit(0);
		});
		
		pane.add(jbEnd); // pane이라는 패널에 jb라는 버튼 추가

		return pane;
	}

	private void roomEventHandler(ActionEvent event) {
		// TODO Auto-generated method stub
		String num = null;
		num = event.getActionCommand();
		JFrame jf = new JFrame();
		jf.setLocation(100,100);
        jf.setSize(450,300);
		
		if (num.equals("end")) {
			System.exit(0);
		}
		
		if (num.equals("1")) {
			if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		if (num.equals("2")) {
			if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		if (num.equals("3")) {
				if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		if (num.equals("4")) {
			if(Cafe.roomManager.find(num).availability == false) {
				JLabel label = new JLabel("사용할 수 없는 방입니다.");
				label.setHorizontalAlignment(SwingConstants.CENTER);
				jf.add(label);
				jf.setVisible(true);
				return;
			}
		}
		
		
		// txt 파일 확인 후 룸을 제대로 입력받았으면 파일에 입력하는 기능 추가해야함  
		// . . . 
		//new NewOrderSelection();
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					NewOrderSelection window = new NewOrderSelection();
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		setVisible(false);
	}

	void RoomTableInit() {
		Cafe.roomManager.readAll(Main.scanFile("room.txt"), new Factory<Room>() {
			public Room create() {
				return new Room();
			}
		});

	}

	

	int selectedIndex = -1;

	public void valueChanged(ListSelectionEvent e) {
		ListSelectionModel lsm = (ListSelectionModel) e.getSource();
		if (!lsm.isSelectionEmpty()) {
			selectedIndex = lsm.getMinSelectionIndex();
			moveSelectedToEdits();
		}
	}

	private void moveSelectedToEdits() {
		// TODO Auto-generated method stub

	}

	public void actionPerformed(ActionEvent e) {
		DefaultTableModel data = (DefaultTableModel) (table.getModel());
		if (e.getActionCommand().equals("end")) {
			System.exit(0);

		} else if (e.getActionCommand().equals("1번방")) {
			
		} else if (e.getActionCommand().equals("2번방")) {
			
		} else if (e.getActionCommand().equals("3번방")) {
		} else if (e.getActionCommand().equals("4번방")) {

		}
	}
}

// 버튼을 다 구현해놓고