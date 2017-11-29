//package com2002;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;
import java.util.Date;

public class runTest {

	public static void main(String[] args) {

		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				SqlTest frame = new SqlTest("test", new Date(11,20,2017));
				frame.setVisible(true);
			}
		});
	}
}