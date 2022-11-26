package layout;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import javax.swing.border.EmptyBorder;

import bgc.*;
import mng.Factory;
import java.awt.Color;
import java.awt.Font;

public class LoginFrame extends JFrame {

    private JPanel contentPane;
    private JTextField tfUsername, tfPassword;
    private JButton loginBtn, joinBtn;
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
        //icon = new ImageIcon("C:\\Users\\USER\\Desktop\\JAVA\\BoardGame\\door116_001.jpg");
        icon = new ImageIcon("C:\\Users\\USER\\Desktop\\JAVA\\BoardGame\\616de5f15a8ac2090fe457dafab8b41d.jpg");


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //setSize(400, 300);
        setSize(400, 600);
        setLocationRelativeTo(null);
        contentPane = new JPanel() {

            public void paintComponent(Graphics g) {
                // Approach 1: Dispaly image at at full size
                g.drawImage(icon.getImage(), 0, 0, null);
                // Approach 2: Scale image to size of component
                // Dimension d = getSize();
                // g.drawImage(icon.getImage(), 0, 0, d.width, d.height, null);
                // Approach 3: Fix the image position in the scroll pane
                // Point p = scrollPane.getViewport().getViewPosition();
                // g.drawImage(icon.getImage(), p.x, p.y, null);
                setOpaque(false); //그림을 표시하게 설정,투명하게 조절
                super.paintComponent(g);
            }
        };
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JLabel lblLogin = new JLabel("username");
        lblLogin.setFont(new Font("굴림", Font.BOLD, 21));
        lblLogin.setForeground(new Color(255, 255, 255));
        lblLogin.setBounds(41, 52, 104, 35);
        contentPane.add(lblLogin);

        JLabel lblPassword = new JLabel("Password");
        lblPassword.setFont(new Font("굴림", Font.BOLD, 21));
        lblPassword.setForeground(new Color(255, 255, 255));
        lblPassword.setBounds(41, 103, 104, 35);
        contentPane.add(lblPassword);

        tfUsername = new JTextField();
        tfUsername.setBounds(157, 52, 176, 35);
        contentPane.add(tfUsername);
        tfUsername.setColumns(10);

        joinBtn = new JButton("회원가입");
        joinBtn.setBounds(229, 154, 104, 29);
        contentPane.add(joinBtn);

        loginBtn = new JButton("로그인");
        loginBtn.setBounds(108, 154, 106, 29);
        contentPane.add(loginBtn);

        tfPassword = new JTextField();
        tfPassword.setColumns(10);
        tfPassword.setBounds(157, 103, 176, 35);
        contentPane.add(tfPassword);

        setVisible(true);
        //회원가입 액션
        joinBtn.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                JoinFrame frame = new JoinFrame();
            }
        });

        //로그인 액션
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
                    JOptionPane.showMessageDialog(null, "로그인 성공.");
                    Cafe.order = new Order(Cafe.user.identifier);
                    dispose();
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                RoomSelection window = new RoomSelection();
                                window.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                }
                else {
                    JOptionPane.showMessageDialog(null, "로그인 실패.");
                }
            }
        });
    }
}
