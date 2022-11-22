package bgc;

import java.awt.BorderLayout;
import java.awt.Font;
import java.util.Calendar;

import javax.swing.JFrame;
import javax.swing.JLabel;

//public class TimerTest extends JFrame 
//implements Runnable{
//
//	private JLabel label;
//	
//	public TimerTest() {
//		String time = getCurrentTime();
//		label = new JLabel(time);
//		label.setBounds(182, 10, 158, 22);
//		NewOrderSelection.frame.add(label);
//		setSize(300, 200);
//		Thread t1 = new Thread(this);
//		t1.start();
//		
//		String time = getCurrentTime();
//		timerLabel = new JLabel("남은 시간: ");
//		timerLabel.setBounds(182, 10, 158, 22);
//		frame.getContentPane().add(timerLabel);
//		Thread t1 = new Thread(this);
//		t1.start();
//	}
//	
//	@Override
//	public void run() {
//		while(true) {
//			try {
//				Thread.sleep(1000);
//				String time = getCurrentTime();
//				label.setText(time);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//		}
//	}
//	
//	public String getCurrentTime() {
//		Calendar c = Calendar.getInstance();
//		int hour = c.get(Calendar.HOUR_OF_DAY);
//		int min = c.get(Calendar.MINUTE);
//		int sec = c.get(Calendar.SECOND);
//		
//		String time = hour+":"+min+":"+sec;
//		return time;
//	}
//
//
//}

