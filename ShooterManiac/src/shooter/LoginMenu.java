package shooter;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class LoginMenu extends JPanel {
private static final long serialVersionUID = 1L;
	
	private static Main main = new Main();
	
	public LoginMenu() {
		setBounds(0, 0, 1280, 720);
		setBorder(new EmptyBorder(5, 5, 5, 5));
		setLayout(null);
		
		
		
		JButton csButton = new JButton("Hero Selection");
		csButton.setBounds(590, 250, 120, 25);
		add(csButton);
		
		csButton.addActionListener(new ActionListener() {
		@Override
		public void actionPerformed(ActionEvent e) {
//			String[] args = {""
//			GamePanel.main(args);
		}});
		

	}
	
	
	

}
