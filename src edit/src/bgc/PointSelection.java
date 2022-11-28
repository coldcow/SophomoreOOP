package bgc;

import layout.LoginFrame;

import java.awt.EventQueue;

import javax.swing.*;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class PointSelection extends JFrame {

    //private JFrame frame;
    private JTextField textField;

    /**
     * Launch the application.
     */

    /*public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PointSelection window = new PointSelection();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }*/

    public PointSelection() {
        setBounds(100, 100, 280, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("마일리지 사용");
        panel.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        getContentPane().add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("결제");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(textField.getText());

                if (PaymentSelection.user.mileage < x) {
                    JOptionPane.showMessageDialog(null, "마일리지가 부족합니다.");
                    dispose();
                } else {
                    Payment.useMileage(PaymentSelection.user, PaymentSelection.cost, x);
                    Cafe.order.addOrderToFile(Main.openFile("order.txt"));
                    Cafe.userManager.writeAll(new File("user.txt"));
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

            }
        });
        panel_2.add(btnNewButton);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setVgap(30);
        flowLayout.setHgap(100);
        getContentPane().add(panel_1, BorderLayout.CENTER);

        JLabel lblNewLabel_2_1 = new JLabel("사용가능한 마일리지");
        lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 12));

        panel_1.add(lblNewLabel_2_1);

        JLabel lblNewLabel_3_1 = new JLabel("여기 정보 뜨고");

        panel_1.add(lblNewLabel_3_1);

        JLabel lblNewLabel_1_1 = new JLabel("사용할 마일리지");
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 12));

        panel_1.add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setColumns(10);

        panel_1.add(textField);

        setVisible(true);
    }

    /**
     * Create the application.
     */

    /**
     * Initialize the contents of the frame.
     */
    /*private void initialize() {
        //frame = new JFrame();

        setBounds(100, 100, 280, 330);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JPanel panel = new JPanel();
        getContentPane().add(panel, BorderLayout.NORTH);

        JLabel lblNewLabel = new JLabel("마일리지 사용");
        panel.add(lblNewLabel);

        JPanel panel_2 = new JPanel();
        getContentPane().add(panel_2, BorderLayout.SOUTH);

        JButton btnNewButton = new JButton("결제");
        btnNewButton.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int x = Integer.parseInt(textField.getText());

                if (PaymentSelection.user.mileage < x) {
                    JFrame nope = new JFrame();
                    JLabel no = new JLabel("마일리지가 부족합니다.");
                    nope.add(no);
                    nope.setVisible(true);
                } else {
                    Payment.useMileage(PaymentSelection.user, PaymentSelection.cost, x);
                }

            }
        });
        panel_2.add(btnNewButton);

        JPanel panel_1 = new JPanel();
        FlowLayout flowLayout = (FlowLayout) panel_1.getLayout();
        flowLayout.setVgap(30);
        flowLayout.setHgap(100);
        getContentPane().add(panel_1, BorderLayout.CENTER);

        JLabel lblNewLabel_2_1 = new JLabel("사용가능한 마일리지");
        lblNewLabel_2_1.setFont(new Font("굴림", Font.BOLD, 12));

        panel_1.add(lblNewLabel_2_1);

        JLabel lblNewLabel_3_1 = new JLabel("여기 정보 뜨고");

        panel_1.add(lblNewLabel_3_1);

        JLabel lblNewLabel_1_1 = new JLabel("사용할 마일리지");
        lblNewLabel_1_1.setFont(new Font("굴림", Font.BOLD, 12));

        panel_1.add(lblNewLabel_1_1);

        textField = new JTextField();
        textField.setColumns(10);

        panel_1.add(textField);

    }*/

}