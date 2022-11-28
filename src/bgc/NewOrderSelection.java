package bgc;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JApplet;
import javax.swing.JButton;
import java.awt.BorderLayout;
import javax.swing.JTextPane;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class NewOrderSelection extends JFrame{

    //JFrame frame;

    /**
     * Launch the application.
     */
	/*public static void main(String[] args) {
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
	}*/

    /**
     * Create the application.
     */
    public NewOrderSelection() {
    	getContentPane().setBackground(new Color(255, 255, 255));
    	setForeground(new Color(255, 255, 255));
    	setBackground(new Color(255, 255, 255));
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setTitle("주문 선택");
        setSize( 450, 300);
        getContentPane().setLayout(null);
        
        JPanel newpanel = new JPanel(new BorderLayout());
        newpanel.setBounds(0, 40, 300, 240);
        newpanel.setBackground(Color.ORANGE);
        getContentPane().add(newpanel);
        
        DrinkOrderPanel dp = new DrinkOrderPanel();
        BoardGameOrderPanel bp = new BoardGameOrderPanel();

        JButton btnNewButton = new JButton("보드게임");
        btnNewButton.setBackground(new Color(133, 175, 75));
        btnNewButton.setForeground(new Color(255, 255, 255));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	newpanel.removeAll();
                bp.setVisible(true);
                newpanel.add(bp,BorderLayout.CENTER);
                newpanel.revalidate();
                newpanel.repaint();
            }
        });
        btnNewButton.setBounds(326, 93, 96, 32);
        btnNewButton.setBorderPainted(false);
        btnNewButton.setFocusPainted(true);
        getContentPane().add(btnNewButton);

        JButton btnNewButton_2 = new JButton("음료");
        btnNewButton_2.setBackground(new Color(133, 175, 75));
        btnNewButton_2.setForeground(new Color(255, 255, 255));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	newpanel.removeAll();
                dp.setVisible(true);
            	newpanel.add(dp, BorderLayout.CENTER);
            	newpanel.revalidate();
                newpanel.repaint();
            }
        });
        btnNewButton_2.setBounds(326, 135, 96, 32);
        btnNewButton_2.setBorderPainted(false);
        getContentPane().add(btnNewButton_2);

        JButton btnNewButton_1 = new JButton("결제");
        btnNewButton_1.setBackground(new Color(133, 175, 75));
        btnNewButton_1.setForeground(new Color(255, 255, 255));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                EventQueue.invokeLater(new Runnable() {
                    public void run() {
                        try {
                            PaymentSelection window = new PaymentSelection();
                            window.setVisible(true);
                            dispose();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                });
                //frm.setVisible(true);
            }
        });
        btnNewButton_1.setBounds(326, 219, 96, 32);
        btnNewButton_1.setBorderPainted(false);
        getContentPane().add(btnNewButton_1);

        JButton btnNewButton_3 = new JButton("미니게임");
        btnNewButton_3.setBackground(new Color(133, 175, 75));
        btnNewButton_3.setForeground(new Color(255, 255, 255));
        btnNewButton_3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            }
        });
        btnNewButton_3.setBounds(326, 177, 96, 32);
        btnNewButton_3.setBorderPainted(false);
        getContentPane().add(btnNewButton_3);


        JLabel lblNewLabel = new JLabel("ID: "+Cafe.userIdentifier);
        lblNewLabel.setBounds(12, 10, 158, 22);
        getContentPane().add(lblNewLabel);

        JLabel lblNewLabel_1 = new JLabel("남은 시간: ");
        lblNewLabel_1.setBounds(182, 10, 158, 22);
        getContentPane().add(lblNewLabel_1);

        JLabel lblNewLabel_2 = new JLabel("번방");
        lblNewLabel_2.setBounds(353, 10, 69, 22);
        getContentPane().add(lblNewLabel_2);

        setVisible(true);
    }

    

}