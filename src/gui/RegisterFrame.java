package gui;

import java.awt.Color;
import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bgc.Cafe;
import bgc.Main;
import bgc.User;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class RegisterFrame extends JFrame {

    private JPanel contentPane;
    private JLabel lblRegister;
    private JButton RegisterCompleteBtn;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JTextField tfAge;
    
    public RegisterFrame() {
    	setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(365, 390);
        setLocation(1150,365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(Color.WHITE);
        setLocationRelativeTo(null);

        JLabel frameDeco1 = new JLabel("");
        frameDeco1.setIcon(new ImageIcon("img/greenery.png"));
        frameDeco1.setBounds(12, 71, 325, 2);
        getContentPane().add(frameDeco1);
        
        lblRegister = new JLabel("회원가입");
        lblRegister.setHorizontalAlignment(SwingConstants.CENTER);
        lblRegister.setForeground(new Color(105, 170, 70));
        Font f1 = new Font("나눔고딕", Font.BOLD, 20); //궁서 바탕 돋움
        lblRegister.setFont(f1);
        lblRegister.setBounds(125, 26, 100, 20);
        contentPane.add(lblRegister);

        JLabel lblUsername = new JLabel("비밀번호");
        lblUsername.setFont(new Font("나눔고딕", Font.PLAIN, 15));
        lblUsername.setBounds(36, 163, 69, 20);
        contentPane.add(lblUsername);

        JLabel label = new JLabel("아이디");
        label.setFont(new Font("나눔고딕", Font.PLAIN, 15));
        label.setBounds(36, 113, 69, 20);
        contentPane.add(label);

        JLabel lblAge = new JLabel("나이");
        lblAge.setFont(new Font("나눔고딕", Font.PLAIN, 15));
        lblAge.setBounds(36, 213, 69, 20);
        contentPane.add(lblAge);


        tfUsername = new JTextField();
        tfUsername.setColumns(10);
        tfUsername.setBounds(126, 104, 186, 35);
        contentPane.add(tfUsername);

        tfPassword = new JTextField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(126, 155, 186, 35);
        contentPane.add(tfPassword);

        tfAge = new JTextField();
        tfAge.setColumns(10);
        tfAge.setBounds(126, 205, 186, 35);
        contentPane.add(tfAge);


        RegisterCompleteBtn = new JButton("회원가입완료");
        
        RegisterCompleteBtn.setForeground(Color.WHITE);
        RegisterCompleteBtn.setFont(new Font("나눔고딕", Font.PLAIN, 16));
        RegisterCompleteBtn.setBorderPainted(false);
        RegisterCompleteBtn.setBackground(new Color(164, 197, 120));
        
        RegisterCompleteBtn.setBounds(173, 279, 139, 29);
        contentPane.add(RegisterCompleteBtn);

        setVisible(true);
        //회원가입완료 액션
        RegisterCompleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
                UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("회원가입이 완료되었습니다.");
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
				JOptionPane.showOptionDialog(null, label, "ALERT", JOptionPane.OK_OPTION, JOptionPane.INFORMATION_MESSAGE, new ImageIcon(), buttons, buttons[0]);
                dispose();
            }
        });
    }
    public void addUser() {
        User user = new User();
        user.read(tfUsername.getText(), tfPassword.getText(), Integer.valueOf(tfAge.getText()));
        Cafe.userManager.managees.add(user);
        Cafe.userManager.writeAll(new File("user.txt"));
    }
}
