import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class Room {
    static class setGUI extends JFrame {
        setGUI(){
            setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            setTitle("방선택");
            GridLayout grid = new GridLayout();
            setLayout(grid);
            this.setLayout(new FlowLayout());

            JButton btn1 = new JButton("1");
            this.add(btn1);

            JButton btn2 = new JButton("2");
            this.add(btn2);

            JButton btn3 = new JButton("3");
            this.add(btn3);

            JButton btn4 = new JButton("4");
            this.add(btn4);

            JButton btn5 = new JButton("5");
            this.add(btn5);

            JButton btn6 = new JButton("6");
            this.add(btn6);

            JButton btn7 = new JButton("7");
            this.add(btn7);

            JButton btn8 = new JButton("8");
            this.add(btn8);

            JButton btn9 = new JButton("9");
            this.add(btn9);

            JButton btn10 = new JButton("10");
            this.add(btn10);

            MyMouseListener listener = new MyMouseListener();
            btn1.addMouseListener(listener);
            btn2.addMouseListener(listener);
            btn3.addMouseListener(listener);
            btn4.addMouseListener(listener);
            btn5.addMouseListener(listener);
            btn6.addMouseListener(listener);
            btn7.addMouseListener(listener);
            btn8.addMouseListener(listener);
            btn9.addMouseListener(listener);
            btn10.addMouseListener(listener);

            setSize(500,500);
            setVisible(true);

        }
    }
}

