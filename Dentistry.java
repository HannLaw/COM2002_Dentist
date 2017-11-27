//package com2002;

import javax.swing.*;

public class Dentistry {
	
	public static void main(String[] args) {	
		
		/*SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				MainFrame frame = new MainFrame("Dentistry"); // MainFrame Class doesn't currently work
	    }
	});*/

		JFrame frame = new JFrame("IntroScreen");
		frame.setContentPane(new IntroScreen().splashScreen);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);
  }
}