package bgc;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;

import layout.LoginFrame;
import mng.Manager;
import bgc.User;
import bgc.Order;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.CardLayout;
import java.awt.event.ActionListener;

public class PaymentSelection extends JFrame{

    //private JFrame frame;
    static User user = Cafe.user;
    static int cost = 0;

    /**
     * Launch the application.
     */

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PaymentSelection window = new PaymentSelection();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    /**
     * Create the application.
     */
    public PaymentSelection() {
        initialize();
        setVisible(true);
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        //Manager<User> userManager = new Manager<>();
        //Order order = new Order(user.identifier);
        // = userManager.find("");
        if(user.age<20) {
            cost *= 0.9;
        }
        Payment.giveMileage(user,cost);

        //frame = new JFrame();

        setBounds(100, 100, 260, 360);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel_4 = new JPanel();
        getContentPane().add(panel_4, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("일반 결제");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                Cafe.order.addOrderToFile(Main.openFile("order.txt"));
                JOptionPane.showMessageDialog(null, "결제가 완료되었습니다 감사합니다.");
                dispose();
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
        });
        panel_4.add(btnNewButton);

        JButton btnNewButton_1 = new JButton("마일리지 사용");
        btnNewButton_1.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (user.mileage == 0) {
                    JOptionPane.showMessageDialog(null, "적립된 마일리지가 없습니다.");
                } else {
                    //new PointSelection();
                    EventQueue.invokeLater(new Runnable() {
                        public void run() {
                            try {
                                PointSelection window = new PointSelection();
                                window.setVisible(true);
                            } catch (Exception e) {
                                e.printStackTrace();
                            }
                        }
                    });
                    dispose();
                    //setVisible(false);
                }
            }
        });

        panel_4.add(btnNewButton_1);

        JPanel panel_2 = new JPanel();
        getContentPane().add(panel_2, BorderLayout.NORTH);

        JLabel lblNewLabel_1 = new JLabel("결제할 금액");
        panel_2.add(lblNewLabel_1);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.CENTER);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("여기에 대충 비용 뜨고");
        lblNewLabel.setBounds(62, 120, 120, 15);
        panel.add(lblNewLabel);
        lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
    }

}