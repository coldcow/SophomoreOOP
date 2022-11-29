package layout;
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
import bgc.User;
import javax.swing.SwingConstants;
import javax.swing.UIManager;

public class JoinFrame extends JFrame {

    private JPanel contentPane;
    private JLabel lblJoin;
    private JButton joinCompleteBtn;
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
                    JoinFrame joinFrame = new JoinFrame();

                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the frame.
     */
    public JoinFrame() {
    	
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(365, 390);
        setLocation(1150,365);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        getContentPane().setBackground(new Color(255, 255, 255));
        setLocationRelativeTo(null);

        JLabel frameDeco1 = new JLabel("");
        frameDeco1.setIcon(new ImageIcon("img/greenery.png"));
        frameDeco1.setBounds(12, 71, 325, 2);
        getContentPane().add(frameDeco1);
        
        lblJoin = new JLabel("회원가입");
        lblJoin.setHorizontalAlignment(SwingConstants.CENTER);
        lblJoin.setForeground(new Color(105, 170, 70));
        Font f1 = new Font("나눔고딕", Font.BOLD, 20); //궁서 바탕 돋움
        lblJoin.setFont(f1);
        lblJoin.setBounds(125, 26, 100, 20);
        contentPane.add(lblJoin);

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


        joinCompleteBtn = new JButton("회원가입완료");
        
        joinCompleteBtn.setForeground(Color.WHITE);
        joinCompleteBtn.setFont(new Font("나눔고딕", Font.PLAIN, 16));
        joinCompleteBtn.setBorderPainted(false);
        joinCompleteBtn.setBackground(new Color(164, 197, 120));
        
        joinCompleteBtn.setBounds(173, 279, 139, 29);
        contentPane.add(joinCompleteBtn);

        setVisible(true);
        //회원가입완료 액션
        joinCompleteBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                addUser();
                UIManager UI = new UIManager();
				UI.put("OptionPane.background", Color.white);
				UI.put("Panel.background", Color.white);
				JLabel label = new JLabel("회원가입이 완료되었습니다.");
				label.setBackground(new Color(255, 255, 255));
				label.setHorizontalAlignment(SwingConstants.CENTER);
				label.setFont(new Font("나눔고딕", Font.PLAIN, 14));
				JButton button = new JButton("확인");
				button.setForeground(new Color(255, 255, 255));
				button.setBackground(new Color(133, 175, 75));
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
