package Test;

import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Timer;
import java.util.TimerTask;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class test2 {
	private static int WAITSECONDS = 60;  //要等待的秒数
	
	boolean isRun = true;
	public static void main(String[] args) throws Exception{
		
		
		
		JFrame frm = new JFrame("计时器");
		JPanel jp = new JPanel();
		JButton btnStart = new JButton("开始");
		btnStart.setBounds(20, 120, 100, 30);
		jp.add(btnStart);
		frm.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frm.setResizable(true);
		frm.setSize(150, 200);
		frm.setLocationRelativeTo(null);
		frm.add(jp);
		frm.setVisible(true);

		btnStart.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				
				Timer timer = new Timer();
				MyTask task = new MyTask();
				while(true) {
						timer.schedule(task, WAITSECONDS*1000, WAITSECONDS*1000);
				}
			}
		});
		
	}

}
class MyTask extends TimerTask{
	@Override
	public void run() {

		try {
			Toolkit toolkit = Toolkit.getDefaultToolkit();
			toolkit.beep();
			Thread.sleep(400);
			toolkit.beep();
			Thread.sleep(400);
			toolkit.beep();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
} 


