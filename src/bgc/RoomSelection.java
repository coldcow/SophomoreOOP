package bgc;

import java.awt.Color;

import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class RoomSelection extends JFrame{
	JButton roomBtn1 = new JButton();
	JButton roomBtn2 = new JButton();
	JButton roomBtn3 = new JButton();
	JButton roomBtn4 = new JButton();
	JButton roomBtn5 = new JButton();
	JButton roomBtn6 = new JButton();
	JButton roomBtn7 = new JButton();
	JButton roomBtn8 = new JButton();
	
	
    public RoomSelection() {
        setBounds(100, 100, 821, 536);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        getContentPane().setBackground(new Color(255, 255, 255));
        getContentPane().setLayout(null);

        JLabel lblNewLabel = new JLabel("원하는 방을 선택하세요");
        lblNewLabel.setForeground(new Color(105, 170, 70));
        lblNewLabel.setFont(new Font("나눔고딕 ExtraBold", Font.PLAIN, 27));
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel.setBounds(12, 10, 781, 77);
        getContentPane().add(lblNewLabel);

        JLabel frameDeco1 = new JLabel("");
        frameDeco1.setIcon(new ImageIcon("img/greenery.png"));
        frameDeco1.setBounds(12, 81, 781, 2);
        getContentPane().add(frameDeco1);

        JLabel frameDeco2 = new JLabel("");
        frameDeco2.setIcon(new ImageIcon("img/greenery.png"));
        frameDeco2.setBounds(73, 338, 671, 2);
        getContentPane().add(frameDeco2);

        JButton roomBtn1 = new JButton("1");
        roomBtn1.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn1.setForeground(new Color (0,0,0));
        roomBtn1.setBackground(new Color(255,255,255));
        roomBtn1.setBorderPainted(true);
        roomBtn1.setBounds(80, 124, 97, 35);
        roomBtn1.addActionListener(event -> {
        	if(roomBtn1.getBackground().equals(Color.WHITE) ) {
        		roomBtn1.setForeground(Color.WHITE);
    	        roomBtn1.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn1.setForeground(Color.BLACK);
    	        roomBtn1.setBackground(new Color(255, 255, 255));
        	}
		});
        getContentPane().add(roomBtn1);

        JButton roomBtn2 = new JButton("2");
        roomBtn2.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn2.setForeground(new Color(0,0,0));
        roomBtn2.setBackground(new Color(255,255,255));
        roomBtn2.setBorderPainted(true);
        roomBtn2.setBounds(267, 124, 97,35);
        roomBtn2.addActionListener(event -> {
        	if(roomBtn2.getBackground().equals(Color.WHITE) ) {
        		roomBtn2.setForeground(Color.WHITE);
    	        roomBtn2.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn2.setForeground(Color.BLACK);
    	        roomBtn2.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn2);

        JButton roomBtn3 = new JButton("3");
        roomBtn3.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn3.setBackground(new Color(255,255,255));
        roomBtn3.setForeground(new Color(0,0,0));
        roomBtn3.setBorderPainted(true);
        roomBtn3.setBounds(454, 124, 97, 35);
        roomBtn3.addActionListener(event -> {
        	if(roomBtn3.getBackground().equals(Color.WHITE) ) {
        		roomBtn3.setForeground(Color.WHITE);
    	        roomBtn3.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn3.setForeground(Color.BLACK);
    	        roomBtn3.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn3);

        JButton roomBtn4 = new JButton("4");
        roomBtn4.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn4.setForeground(new Color(0,0,0));
        roomBtn4.setBackground(new Color(255,255,255));
        roomBtn4.setBorderPainted(true);
        roomBtn4.setBounds(641, 124, 97, 35);
        roomBtn4.addActionListener(event -> {
        	if(roomBtn4.getBackground().equals(Color.WHITE) ) {
        		roomBtn4.setForeground(Color.WHITE);
    	        roomBtn4.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn4.setForeground(Color.BLACK);
    	        roomBtn4.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn4);

        JLabel lblNewLabel_1 = new JLabel("1번방");
        lblNewLabel_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setBounds(80, 179, 97, 15);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_1_1 = new JLabel("2번방");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_1.setBounds(267, 179, 97, 15);
        getContentPane().add(lblNewLabel_1_1);

        JLabel lblNewLabel_1_2 = new JLabel("3번방");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_2.setBounds(454, 179, 97, 15);
        getContentPane().add(lblNewLabel_1_2);

        JLabel lblNewLabel_1_3 = new JLabel("4번방");
        lblNewLabel_1_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_3.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_3.setBounds(641, 179, 97, 15);
        getContentPane().add(lblNewLabel_1_3);

        JButton roomBtn5 = new JButton("5");
        roomBtn5.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn5.setForeground(Color.BLACK);
        roomBtn5.setBorderPainted(true);
        roomBtn5.setBackground(new Color(255,255,255));
        roomBtn5.setBounds(80, 229, 97, 35);
        roomBtn5.addActionListener(event -> {
        	if(roomBtn5.getBackground().equals(Color.WHITE) ) {
        		roomBtn5.setForeground(Color.WHITE);
    	        roomBtn5.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn5.setForeground(Color.BLACK);
    	        roomBtn5.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn5);

        JButton roomBtn6 = new JButton("6");
        roomBtn6.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn6.setForeground(Color.BLACK);
        roomBtn6.setBorderPainted(true);
        roomBtn6.setBackground(new Color(255,255,255));
        roomBtn6.setBounds(267, 229, 97, 35);
        roomBtn6.addActionListener(event -> {
        	if(roomBtn6.getBackground().equals(Color.WHITE) ) {
        		roomBtn6.setForeground(Color.WHITE);
    	        roomBtn6.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn6.setForeground(Color.BLACK);
    	        roomBtn6.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn6);

        JButton roomBtn7 = new JButton("7");
        roomBtn7.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn7.setForeground(Color.BLACK);
        roomBtn7.setBorderPainted(true);
        roomBtn7.setBackground(new Color(255,255,255));
        roomBtn7.setBounds(454, 229, 97, 35);
        roomBtn7.addActionListener(event -> {
        	if(roomBtn7.getBackground().equals(Color.WHITE) ) {
        		roomBtn7.setForeground(Color.WHITE);
    	        roomBtn7.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn7.setForeground(Color.BLACK);
    	        roomBtn7.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn7);

        JButton roomBtn8 = new JButton("8");
        roomBtn8.setFont(new Font("나눔고딕", Font.BOLD, 16));
        roomBtn8.setForeground(Color.BLACK);
        roomBtn8.setBorderPainted(true);
        roomBtn8.setBackground(new Color(255,255,255));
        roomBtn8.setBounds(641, 229, 97, 35);
        roomBtn8.addActionListener(event -> {
        	if(roomBtn8.getBackground().equals(Color.WHITE) ) {
        		roomBtn8.setForeground(Color.WHITE);
    	        roomBtn8.setBackground(new Color(133, 175, 75));
        	}
        	else {
        		roomBtn8.setForeground(Color.BLACK);
    	        roomBtn8.setBackground(new Color(255, 255, 255));
        	}			
		});
        getContentPane().add(roomBtn8);

        JLabel lblNewLabel_1_4 = new JLabel("5번방");
        lblNewLabel_1_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_4.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_4.setBounds(80, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_4);

        JLabel lblNewLabel_1_5 = new JLabel("6번방");
        lblNewLabel_1_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_5.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_5.setBounds(267, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_5);

        JLabel lblNewLabel_1_6 = new JLabel("7번방");
        lblNewLabel_1_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_6.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_6.setBounds(454, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_6);

        JLabel lblNewLabel_1_7 = new JLabel("8번방");
        lblNewLabel_1_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_7.setFont(new Font("나눔고딕", Font.BOLD, 16));
        lblNewLabel_1_7.setBounds(641, 284, 97, 15);
        getContentPane().add(lblNewLabel_1_7);

        JLabel lblNewLabel_2 = new JLabel("30분");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2.setBounds(80, 371, 97, 25);
        getContentPane().add(lblNewLabel_2);

        JLabel lblNewLabel_2_1 = new JLabel("1시간\r\n");
        lblNewLabel_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_1.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2_1.setBounds(267, 371, 97, 25);
        getContentPane().add(lblNewLabel_2_1);

        JLabel lblNewLabel_2_2 = new JLabel("2시간");
        lblNewLabel_2_2.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_2.setBounds(454, 371, 97, 25);
        getContentPane().add(lblNewLabel_2_2);

        JLabel lblNewLabel_2_3 = new JLabel("4시간");
        lblNewLabel_2_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_2_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2_3.setFont(new Font("나눔고딕", Font.PLAIN, 18));
        lblNewLabel_2_3.setBounds(641, 371, 97, 25);
        getContentPane().add(lblNewLabel_2_3);

        JCheckBox chckbxNewCheckBox = new JCheckBox("");
        chckbxNewCheckBox.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox.setBackground(new Color(255, 255, 255));
        chckbxNewCheckBox.setBounds(113, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox);

        JCheckBox chckbxNewCheckBox_1 = new JCheckBox("");
        chckbxNewCheckBox_1.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_1.setBackground(Color.WHITE);
        chckbxNewCheckBox_1.setBounds(303, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox_1);

        JCheckBox chckbxNewCheckBox_2 = new JCheckBox("");
        chckbxNewCheckBox_2.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_2.setBackground(Color.WHITE);
        chckbxNewCheckBox_2.setBounds(490, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox_2);

        JCheckBox chckbxNewCheckBox_3 = new JCheckBox("");
        chckbxNewCheckBox_3.setHorizontalAlignment(SwingConstants.CENTER);
        chckbxNewCheckBox_3.setBackground(Color.WHITE);
        chckbxNewCheckBox_3.setBounds(677, 402, 26, 23);
        getContentPane().add(chckbxNewCheckBox_3);

        JButton btnNewButton_8 = new JButton("다음");
        btnNewButton_8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	NewOrderSelection newOrderSelection = new NewOrderSelection();
				newOrderSelection.setVisible(true);
            }
        });
        btnNewButton_8.setForeground(Color.WHITE);
        btnNewButton_8.setFont(new Font("나눔고딕", Font.BOLD, 16));
        btnNewButton_8.setBorderPainted(false);
        btnNewButton_8.setBackground(new Color(164, 197, 120));
        btnNewButton_8.setBounds(361, 442, 97, 35);
        getContentPane().add(btnNewButton_8);
    }

    public void orderEventHandler(ActionEvent event) {
		// TODO Auto-generated method stub
		String order = null;
		order = event.getActionCommand();
		
		if (order.equals("1")) {
			//new BoardGameTableSelection();
			
		}
		
		if (order.equals("2")) {
			//new BoardGameTableSelection();
			
		}
		
		if (order.equals("3")) {
			//new BoardGameTableSelection();
			
		}
		
		if (order.equals("4")) {
			//new BoardGameTableSelection();
			
		}
		
		if (order.equals("5")) {
			//new BoardGameTableSelection();
			
		}
		
		if (order.equals("6")) {
			//new BoardGameTableSelection();
			
		}
		
		if (order.equals("7")) {
			//new BoardGameTableSelection();
			
		}
		System.out.println("11");
		if (order.equals("8")) {
			
		}

			
	}	
}
    
    
    
    
