package gui;

import java.awt.EventQueue;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bgc.Cafe;
import bgc.User;

public class RegisterFrame extends JFrame {

    private JPanel contentPane;
    private JLabel lblregister;
    private JButton registerCompleteBtn;
    private JTextField tfUsername;
    private JTextField tfPassword;
    private JTextField tfAge;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    RegisterFrame registerFrame = new RegisterFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public RegisterFrame() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(430, 390);
        setLocation(1150,365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        lblregister = new JLabel("회원가입");
        Font f1 = new Font("돋움", Font.BOLD, 20); //궁서 바탕 돋움
        lblregister.setFont(f1);
        lblregister.setBounds(159, 41, 101, 20);
        contentPane.add(lblregister);

        JLabel lblUsername = new JLabel("password");
        lblUsername.setBounds(69, 163, 69, 20);
        contentPane.add(lblUsername);

        JLabel label = new JLabel("username");
        label.setBounds(69, 113, 69, 20);
        contentPane.add(label);

        JLabel lblAge = new JLabel("age");
        lblAge.setBounds(69, 210, 69, 20);
        contentPane.add(lblAge);


        tfUsername = new JTextField();
        tfUsername.setColumns(10);
        tfUsername.setBounds(159, 106, 186, 35);
        contentPane.add(tfUsername);

        tfPassword = new JTextField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(159, 156, 186, 35);
        contentPane.add(tfPassword);

        tfAge = new JTextField();
        tfAge.setColumns(10);
        tfAge.setBounds(159, 206, 186, 35);
        contentPane.add(tfAge);


        registerCompleteBtn = new JButton("회원가입완료");
        registerCompleteBtn.setBounds(206, 256, 139, 29);
        contentPane.add(registerCompleteBtn);

        setVisible(true);
        //회원가입완료 액션
        registerCompleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
                JOptionPane.showMessageDialog(null, "회원가입이 완료되었습니다.");
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
