import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class Dentistry {
	
	public static void main(String[] args) {		
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new MainFrame("Dentistry"); // MainFrame Class doesn't currently work
				frame.setSize(700,500);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);

	    }
	  });
  }
}
