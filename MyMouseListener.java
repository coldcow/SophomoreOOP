import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class MyMouseListener implements MouseListener {

    @Override
    public void mouseClicked(MouseEvent e) {
        JButton button = (JButton)e.getSource();
        String str = button.getText();

            if (str.equals("1"))
                button.setBackground(Color.red);
            else if (str.equals("2"))
                button.setBackground(Color.red);
            else if (str.equals("3"))
                button.setBackground(Color.red);
            else if (str.equals("4"))
                button.setBackground(Color.red);
            else if (str.equals("5"))
                button.setBackground(Color.red);
            else if (str.equals("6"))
                button.setBackground(Color.red);
            else if (str.equals("7"))
                button.setBackground(Color.red);
            else if (str.equals("8"))
                button.setBackground(Color.red);
            else if (str.equals("9"))
                button.setBackground(Color.red);
            else
                button.setBackground(Color.red);

    }

    @Override
    public void mousePressed(MouseEvent e) {
    }
    @Override
    public void mouseReleased(MouseEvent e) {
    }
    @Override
    public void mouseEntered(MouseEvent e) {
    }
    @Override
    public void mouseExited(MouseEvent e) {
    }
}
